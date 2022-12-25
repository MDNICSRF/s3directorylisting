
package com.daimajia.androidviewhover.proxy;

import android.view.View;
import android.view.animation.Interpolator;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nineoldandroids.animation.Animator;

public class AnimationProxy implements Runnable {

    private YoYo.AnimationComposer composer = null;
    private Animator animator = null;

    private long delay;
    private long duration;
    private boolean invisibleWhenDelaying;
    private View targetView;
    private Interpolator interpolator;

    private long startTime = -1;

    private AnimationProxy(View hoverView, int resId, Techniques technique, long duration, long delay, boolean invisibleWhenDelaying, Interpolator interpolator, Animator.AnimatorListener... listeners){
        if(hoverView == null)
            throw new IllegalStateException("Hover view is null");

        View child = hoverView.findViewById(resId);

        if(child == null)
            throw new IllegalStateException("Can not find the child view");

        if(duration < 0)
            throw new IllegalArgumentException("Duration can not be less than 0");

        if(delay < 0)
            throw new IllegalArgumentException("Delay can not be less than 0");

        this.composer = YoYo.with(technique).duration(duration).delay(delay).interpolate(interpolator);

        this.targetView = child;
        this.interpolator = interpolator;
        this.delay = delay;
        this.duration = duration;
        this.invisibleWhenDelaying = invisibleWhenDelaying;
