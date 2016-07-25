package com.bhargavms.dotloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Bhargav on 7/20/2016.
 */
public class DotLoader extends View {
    private Dot[] mDots;
    private int[] mColors;
    private int mDotRadius;
    private Rect mClipBounds;
    private float mCalculatedGapBetweenDotCenters;

    public DotLoader(Context context) {
        super(context);
        init(context, null);
    }

    public DotLoader(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public DotLoader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(21)
    public DotLoader(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context c, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray a = c.getTheme().obtainStyledAttributes(attrs, R.styleable.DotLoader, 0, 0);
        try {
            float dotRadius = a.getDimension(R.styleable.DotLoader_dot_radius, 0);
            int numberOfPods = a.getInteger(R.styleable.DotLoader_number_of_dots, 1);
            int resId = a.getResourceId(R.styleable.DotLoader_color_array, 0);
            int[] colors;
            if (resId == 0) {
                colors = new int[numberOfPods];
                for (int i = 0; i < numberOfPods; i++) {
                    colors[i] = 0x0;
                }
            } else {
                colors = getResources().getIntArray(resId);
            }
            init(numberOfPods, colors, (int) dotRadius);
        } finally {
            a.recycle();
        }
    }

    private void init(int numberOfDots, int[] colors, int dotRadius) {
        mClipBounds = new Rect(0, 0, 0, 0);
        mDots = new Dot[numberOfDots];
        mDotRadius = dotRadius;
        for (int i = 0; i < numberOfDots; i++) {
            mDots[i] = new Dot(this, colors[i], dotRadius);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(mClipBounds);
        int left = mClipBounds.left;
        int right = mClipBounds.right;
        int top = mClipBounds.top;
        int bottom = mClipBounds.bottom;
        for (int i = 0, size = mDots.length; i < size; i++) {
            mDots[i].draw(canvas);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;
        // desired height is 6 times the diameter of a dot.
        int desiredHeight = (mDotRadius * 2 * 6) + getPaddingTop() + getPaddingBottom();

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(desiredHeight, heightSize);
        } else {
            //Be whatever you want
            height = desiredHeight;
        }
        mCalculatedGapBetweenDotCenters = calculateGapBetweenDotCenters();
        int desiredWidth = (int) (mCalculatedGapBetweenDotCenters * mDots.length);
        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(desiredWidth, widthSize);
        } else {
            //Be whatever you want
            width = desiredWidth;
        }
        for (int i = 0, size = mDots.length; i < size; i++) {
            mDots[i].cx = (mDotRadius + i * mCalculatedGapBetweenDotCenters);
            mDots[i].cy = height - mDotRadius;
        }
        setMeasuredDimension(width, height);
    }

    private float calculateGapBetweenDotCenters() {
        return (mDotRadius * 2) + mDotRadius;
    }
}
