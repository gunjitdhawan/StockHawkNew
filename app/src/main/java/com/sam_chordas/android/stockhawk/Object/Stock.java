package com.sam_chordas.android.stockhawk.Object;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gunjit on 07/09/16.
 */
public class Stock implements Parcelable{
    public String stockName;
    public String stockPrice;

    public Stock(Parcel in) {
        stockName = in.readString();
        stockPrice = in.readString();
    }

    public static final Creator<Stock> CREATOR = new Creator<Stock>() {
        @Override
        public Stock createFromParcel(Parcel in) {
            return new Stock(in);
        }

        @Override
        public Stock[] newArray(int size) {
            return new Stock[size];
        }
    };

    public Stock() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(stockName);
        dest.writeString(stockPrice);
    }

    @Override
    public boolean equals(Object o) {
        Stock stock = (Stock) o;
        if (stock.stockName != null) {
            if (stock.stockName.equalsIgnoreCase(stockName)) {
                return true;
            }
        }
        return false;
    }
}
