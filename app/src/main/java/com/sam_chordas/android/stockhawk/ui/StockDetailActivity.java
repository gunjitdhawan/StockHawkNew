package com.sam_chordas.android.stockhawk.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.sam_chordas.android.stockhawk.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

public class StockDetailActivity extends Activity {

    float yearLow;
    float yearHigh;
    float dayLow;
    float dayHigh;
    float epsCurr;
    float epsNext;
    float expectedOneYear;
    float currentBid;
    float fiftyDayMovingAvg;
    float twoHunDayMovingAvg;


    TextView detailTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_detail);

        yearLow = Float.valueOf(getIntent().getExtras().getString("yearLow", "0.0f"));
        yearHigh = Float.valueOf(getIntent().getExtras().getString("yearHigh", "0.0f"));
        dayLow = Float.valueOf(getIntent().getExtras().getString("dayLow", "0.0f"));
        dayHigh = Float.valueOf(getIntent().getExtras().getString("dayHigh", "0.0f"));
        expectedOneYear = Float.valueOf(getIntent().getExtras().getString("expectedOneYr", "0.0f"));
        currentBid = Float.valueOf(getIntent().getExtras().getString("curr", "0.0f"));
        fiftyDayMovingAvg = Float.valueOf(getIntent().getExtras().getString("fdma", "0.0f"));
        twoHunDayMovingAvg = Float.valueOf(getIntent().getExtras().getString("thdma", "0.0f"));
        epsCurr = Float.valueOf(getIntent().getExtras().getString("epsCurr", "0.0f"));
        epsNext = Float.valueOf(getIntent().getExtras().getString("epsNext", "0.0f"));

        String[] labels = {getResources().getString(R.string.yrLow), getResources().getString(R.string.yrHigh), getResources().getString(R.string.dayLow), getResources().getString(R.string.curr), getResources().getString(R.string.dayHigh), getResources().getString(R.string.oneYrExpec)};


        detailTv = (TextView) findViewById(R.id.stock_detail);
        detailTv.setText(getResources().getString(R.string.dayLow)+" : "+ dayLow+"\n"+
                getResources().getString(R.string.dayHigh)+" : "+ dayHigh+"\n"+
                getResources().getString(R.string.yrLow)+" : "+ yearLow+"\n"+
                getResources().getString(R.string.yrHigh)+" : "+ yearHigh+"\n"+
                getResources().getString(R.string.oneYrExpec)+" : "+ expectedOneYear+"\n"+
                getResources().getString(R.string.epsCurr)+" : "+ epsCurr+"\n"+
                getResources().getString(R.string.epsNxt)+" : "+ epsNext+"\n"+
                getResources().getString(R.string.fdma)+" : "+ fiftyDayMovingAvg+"\n"+
                getResources().getString(R.string.thdma)+" : "+ twoHunDayMovingAvg+"\n"
        );

        float[] value = {yearLow, yearHigh, dayLow, currentBid, dayHigh, expectedOneYear};

        List<PointValue> values = new ArrayList<PointValue>();
        for(int i=0;i<labels.length;i++) {
            values.add(new PointValue((float) i, value[i]).setLabel(labels[i]));
        }


        //In most cased you can call data model methods in builder-pattern-like manner.
        Line line = new Line(values).setColor(Color.BLUE).setFilled(true).setHasLabels(true);
        List<Line> lines = new ArrayList<Line>();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);


        Axis axisY = new Axis().setHasLines(true);
        data.setAxisYLeft(axisY);

        LineChartView chart = (LineChartView) findViewById(R.id.chart);
        chart.setLineChartData(data);
    }
}
