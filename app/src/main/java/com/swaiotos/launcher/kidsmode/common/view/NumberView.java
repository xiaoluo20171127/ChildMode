package com.swaiotos.launcher.kidsmode.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.swaiotos.common.ui.UiUtil;

/**
 * @ Created on: 2020/2/20
 * @Author: LEGION XiaoLuo
 * @ Description:
 */
public class NumberView extends View {


    private Paint mTextPaint = new Paint();
    String mText = "default";


    public NumberView(Context context) {
        super(context);
    }

    public NumberView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NumberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    int width, height;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    public void setText(String text) {
        mText = text;
        invalidate();
    }

    /**
     * color="#000000"
     */
    public void setTextColor(String color) {
        mTextPaint.setColor(Color.parseColor(color));
        invalidate();
    }

    public void setSizeAndColor(int size,String color){
        mTextPaint.setColor(Color.parseColor(color));
        mTextPaint.setTextSize(UiUtil.div(size));
        invalidate();
    }

    public void setTextSize(int size) {
        mTextPaint.setTextSize(UiUtil.div(size));
        invalidate();
    }

    /**
     *需设置的是UiUtil.div()
     */
    public void setProperty(String text, String color, int size) {
        mText = text;
        mTextPaint.setColor(Color.parseColor(color));
        mTextPaint.setTextSize(UiUtil.div(size));
        invalidate();
    }

    public String getText(){
        return mText;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setStrokeWidth(8);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setAntiAlias(true);

        //计算baseline
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float distance = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom;
        float baseline = height / 2 + distance;
        canvas.drawText(mText, width / 2, baseline, mTextPaint);
    }
}
