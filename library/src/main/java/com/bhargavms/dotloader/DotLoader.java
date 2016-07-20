package com.bhargavms.dotloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Bhargav on 7/20/2016.
 */
public class DotLoader extends View {
    private Dot[] mDots;
    private int[] mColors;
    private int mDotRadius;

    public DotLoader(Context context) {
        super(context);
    }

    public DotLoader(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DotLoader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public DotLoader(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context c, AttributeSet attrs) {
        TypedArray a = c.getTheme().obtainStyledAttributes(attrs, R.styleable.DotLoader, 0, 0);
        try {
            float dotRadius = a.getDimension(R.styleable.DotLoader_dot_radius, 0);
        } finally {
            a.recycle();
        }
    }

    private void init(int numberOfDots, int[] colors, int dotRadius) {
        mDots = new Dot[numberOfDots];
        mDotRadius = dotRadius;
        for (int i = 0; i < numberOfDots; i++) {
            mDots[i] = new Dot(this, colors[0], dotRadius);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
