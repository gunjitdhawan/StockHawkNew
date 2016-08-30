package com.sam_chordas.android.stockhawk.rest;

import android.content.ContentProviderOperation;
import android.database.sqlite.SQLiteConstraintException;
import android.util.Log;

import com.sam_chordas.android.stockhawk.data.QuoteColumns;
import com.sam_chordas.android.stockhawk.data.QuoteProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by sam_chordas on 10/8/15.
 */
public class Utils {

  private static String LOG_TAG = Utils.class.getSimpleName();

  public static boolean showPercent = true;
    public static String stockName = "";
    public static String stockPrice = "";


    public static void largeLog(String tag, String content) {
        if (content.length() > 4000) {
            Log.d(tag, content.substring(0, 4000));
            largeLog(tag, content.substring(4000));
        } else {
            Log.d(tag, content);
        }
    }

  public static ArrayList quoteJsonToContentVals(String JSON){
      largeLog(LOG_TAG, JSON);

    ArrayList<ContentProviderOperation> batchOperations = new ArrayList<>();
    JSONObject jsonObject = null;
    JSONArray resultsArray = null;
    try{
      jsonObject = new JSONObject(JSON);
      if (jsonObject != null && jsonObject.length() != 0){
        jsonObject = jsonObject.getJSONObject("query");
        int count = Integer.parseInt(jsonObject.getString("count"));
        if (count == 1){

          jsonObject = jsonObject.getJSONObject("results")
              .getJSONObject("quote");
            if(jsonObject.has("ChangeinPercent") && jsonObject.getString("ChangeinPercent")!=null && !jsonObject.getString("ChangeinPercent").equalsIgnoreCase("null")) {
                Log.e("ChangeinPercent", ""+jsonObject.get("ChangeinPercent"));
                batchOperations.add(buildBatchOperation(jsonObject));
            }
        } else{
          resultsArray = jsonObject.getJSONObject("results").getJSONArray("quote");

          if (resultsArray != null && resultsArray.length() != 0){
            for (int i = 0; i < resultsArray.length(); i++){
              jsonObject = resultsArray.getJSONObject(i);if(jsonObject.has("ChangeinPercent") && jsonObject.getString("ChangeinPercent")!=null && !jsonObject.getString("ChangeinPercent").equalsIgnoreCase("null")) {
                    batchOperations.add(buildBatchOperation(jsonObject));
                }
            }
          }
        }
      }
    } catch (JSONException e){
      Log.e(LOG_TAG, "String to JSON failed: " + e);
    }
    return batchOperations;
  }

  public static String truncateBidPrice(String bidPrice){

    bidPrice = String.format("%.2f", Float.parseFloat(bidPrice));

    return bidPrice;
  }

  public static String truncateChange(String change, boolean isPercentChange){
    String weight = change.substring(0,1);
    String ampersand = "";
    if (isPercentChange){
      ampersand = change.substring(change.length() - 1, change.length());
      change = change.substring(0, change.length() - 1);
    }
    change = change.substring(1, change.length());
    double round = (double) Math.round(Double.parseDouble(change) * 100) / 100;
    change = String.format("%.2f", round);
    StringBuffer changeBuffer = new StringBuffer(change);
    changeBuffer.insert(0, weight);
    changeBuffer.append(ampersand);
    change = changeBuffer.toString();
    return change;
  }

  public static ContentProviderOperation buildBatchOperation(JSONObject jsonObject){
    ContentProviderOperation.Builder builder = ContentProviderOperation.newInsert(
        QuoteProvider.Quotes.CONTENT_URI);
    try {
        //For showing first item in widget
        if(stockName.equalsIgnoreCase("")) {
            stockName = jsonObject.getString("symbol");
            stockPrice = truncateBidPrice(jsonObject.getString("Bid"));
        }
      String change = jsonObject.getString("Change");

        builder.withValue(QuoteColumns.DAYS_LOW, jsonObject.getString("DaysLow"));
        builder.withValue(QuoteColumns.DAYS_HIGH, jsonObject.getString("DaysHigh"));
        builder.withValue(QuoteColumns.DAY_RANGE, jsonObject.getString("DaysRange"));
        builder.withValue(QuoteColumns.YEAR_LOW, jsonObject.getString("YearLow"));
        builder.withValue(QuoteColumns.YEAR_HIGH, jsonObject.getString("YearHigh"));
        builder.withValue(QuoteColumns.YEAR_RANGE, jsonObject.getString("YearRange"));
        builder.withValue(QuoteColumns.FIFTY_DAY_MOVING_AVERAGE, jsonObject.getString("FiftydayMovingAverage"));
        builder.withValue(QuoteColumns.TWO_HUNDRED_DAY_MOVING_AVERAGE, jsonObject.getString("TwoHundreddayMovingAverage"));
        builder.withValue(QuoteColumns.EPS_CURR_YEAR, jsonObject.getString("PriceEPSEstimateCurrentYear"));
        builder.withValue(QuoteColumns.EPS_NXT_YEAR, jsonObject.getString("PriceEPSEstimateNextYear"));
        builder.withValue(QuoteColumns.ONE_YR_EXP_PRICE, jsonObject.getString("OneyrTargetPrice"));



      builder.withValue(QuoteColumns.SYMBOL, jsonObject.getString("symbol"));
      builder.withValue(QuoteColumns.BIDPRICE, truncateBidPrice(jsonObject.getString("Bid")));
      builder.withValue(QuoteColumns.PERCENT_CHANGE, truncateChange(
          jsonObject.getString("ChangeinPercent"), true));
      builder.withValue(QuoteColumns.CHANGE, truncateChange(change, false));
      builder.withValue(QuoteColumns.ISCURRENT, 1);
      if (change.charAt(0) == '-'){
        builder.withValue(QuoteColumns.ISUP, 0);
      }else{
        builder.withValue(QuoteColumns.ISUP, 1);
      }

    } catch (JSONException e){
      e.printStackTrace();
    }
      catch (NumberFormatException e)
      {
        e.printStackTrace();
      }
      catch (SQLiteConstraintException e)
      {
        e.printStackTrace();
      }
    return builder.build();
  }
}
