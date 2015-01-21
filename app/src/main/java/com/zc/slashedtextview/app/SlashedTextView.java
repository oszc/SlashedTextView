package com.zc.slashedtextview.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 1/21/15  2:48 PM
 * Created by Justincompany.
 * 划掉价格
 */
public class SlashedTextView extends TextView {
    private static final String TAG = "SlashedTextView";
    private int mViewWidth = 0;
    private int mViewHeight = 0;
    private Paint mLinePaint;
    private Point mLeftPoint;
    private Point mRightPoint;

    public SlashedTextView(Context context) {
        super(context);
        shareConstructor(context);

    }

    public SlashedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        shareConstructor(context);
    }

    public SlashedTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        shareConstructor(context);
    }

    private void shareConstructor(Context context) {
        mLinePaint = new Paint();
        mLinePaint.setAntiAlias(true);
        mLinePaint.setColor(Color.BLUE);
        mLinePaint.setDither(true);
        mLinePaint.setStrokeWidth(5);
        mLinePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mLeftPoint = new Point();
        mRightPoint = new Point();
        setPadding(10,0,10,0);
    }

    private void setPaintColor(int color){
        mLinePaint.setColor(color);
        invalidate();
    }

    /*
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

      //      mViewWidth = MeasureSpec.getSize(widthMeasureSpec);
      //      mViewHeight = MeasureSpec.getSize(heightMeasureSpec);
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);


      //      mLeftPoint.set(0, mViewHeight / 2);
      //      mRightPoint.set(mViewWidth, mViewHeight / 2);

      //      Log.e(TAG, mViewWidth + "   :   " + mViewHeight);
        }
    */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mViewWidth = getMeasuredWidth();
        mViewHeight = getMeasuredHeight();
        mLeftPoint.set(0, mViewHeight / 2+3);
        mRightPoint.set(mViewWidth, mViewHeight / 2);
        canvas.drawLine(mLeftPoint.x, mLeftPoint.y, mRightPoint.x, mRightPoint.y, mLinePaint);
    }
}
