
package com.daimajia.androidviewhover.proxy;

import android.view.View;
import android.view.animation.Interpolator;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nineoldandroids.animation.Animator;

public class AnimationProxy implements Runnable {

    private YoYo.AnimationComposer composer = null;