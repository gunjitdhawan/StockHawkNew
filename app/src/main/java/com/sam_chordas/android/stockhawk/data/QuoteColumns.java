package com.sam_chordas.android.stockhawk.data;

import net.simonvt.schematic.annotation.AutoIncrement;
import net.simonvt.schematic.annotation.DataType;
import net.simonvt.schematic.annotation.NotNull;
import net.simonvt.schematic.annotation.PrimaryKey;

/**
 * Created by sam_chordas on 10/5/15.
 */
public class QuoteColumns {
    @DataType(DataType.Type.INTEGER)
    @PrimaryKey
    @AutoIncrement
    public static final String _ID = "_id";

    @DataType(DataType.Type.TEXT)
    @NotNull
    public static final String SYMBOL = "symbol";


    @DataType(DataType.Type.TEXT)
    @NotNull
    public static final String PERCENT_CHANGE = "percent_change";


    @DataType(DataType.Type.TEXT)
    @NotNull
    public static final String CHANGE = "change";


    @DataType(DataType.Type.TEXT)
    @NotNull
    public static final String BIDPRICE = "bid_price";


    @DataType(DataType.Type.TEXT)
    public static final String CREATED = "created";


    @DataType(DataType.Type.INTEGER)
    @NotNull
    public static final String ISUP = "is_up";


    @DataType(DataType.Type.INTEGER)
    @NotNull
    public static final String ISCURRENT = "is_current";

    @DataType(DataType.Type.TEXT)
    public static final String DAYS_LOW = "daylow";

    @DataType(DataType.Type.TEXT)
    public static final String DAYS_HIGH = "dayhigh";

    @DataType(DataType.Type.TEXT)
    public static final String YEAR_LOW = "yearlow";

    @DataType(DataType.Type.TEXT)
    public static final String YEAR_HIGH = "yearhigh";

    @DataType(DataType.Type.TEXT)
    public static final String DAY_RANGE = "dayrange";

    @DataType(DataType.Type.TEXT)
    public static final String FIFTY_DAY_MOVING_AVERAGE = "fdma";

    @DataType(DataType.Type.TEXT)
    public static final String TWO_HUNDRED_DAY_MOVING_AVERAGE = "thdma";

    @DataType(DataType.Type.TEXT)
    public static final String EPS_CURR_YEAR = "epscurr";

    @DataType(DataType.Type.TEXT)
    public static final String EPS_NXT_YEAR = "epsnxt";

    @DataType(DataType.Type.TEXT)
    public static final String YEAR_RANGE = "yearrange";


    @DataType(DataType.Type.TEXT)
    public static final String ONE_YR_EXP_PRICE = "OneyrTargetPrice";
}
