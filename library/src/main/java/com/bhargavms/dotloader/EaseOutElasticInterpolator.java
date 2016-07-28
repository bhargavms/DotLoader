package com.bhargavms.dotloader;

import android.view.animation.Interpolator;

/**
 * An interpolator that eases past the final value then back towards it elastically.
 * <p/>
 * math taken from link provided in see also section.
 *
 * @see <a href="https://github.com/greensock/GreenSock-JS/blob/master/src/uncompressed/easing/EasePack.js">Greensock Github</a></a>
 */
public class EaseOutElasticInterpolator implements Interpolator {
    private static final float TWO_PI = (float) (2 * Math.PI);
    private float p1;
    private float p2;
    private float p3;

    public EaseOutElasticInterpolator(float amplitude, float period) {
        p1 = (amplitude >= 1) ? amplitude : 1;
        p2 = period <= 0 ? 0.3f : period / (amplitude >= 1 ? amplitude : 1);
        p3 = (float) (p2 / TWO_PI * (Math.asin(1 / p1)));
        p2 = TWO_PI / p2;
    }

    @Override
    public float getInterpolation(float p) {
        return (float) (p1 * Math.pow(2, -10 * p) * Math.sin((p - p3) * p2) + 1);
    }
}
