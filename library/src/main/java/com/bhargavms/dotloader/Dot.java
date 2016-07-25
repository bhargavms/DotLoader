package com.bhargavms.dotloader;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Bhargav on 7/20/2016.
 */
class Dot {
    private Paint mPaint;
    private int mCurrentColor;
    private int mDotRadius;
    private DotLoader mParent;
    float cx;
    float cy;

    Dot(DotLoader parent, int currentColor, int dotRadius) {
        mParent = parent;
        mCurrentColor = currentColor;
        mDotRadius = dotRadius;

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(currentColor);
        mPaint.setShadowLayer(5.5f, 6.0f, 6.0f, Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
    }

    public void setColor(int color) {
        mCurrentColor = color;
        mPaint.setColor(color);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(cx, cy, mDotRadius, mPaint);
    }
}
