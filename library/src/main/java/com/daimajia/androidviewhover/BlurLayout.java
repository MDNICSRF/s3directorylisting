
package com.daimajia.androidviewhover;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.androidviewhover.proxy.AnimationProxy;
import com.daimajia.androidviewhover.tools.Blur;
import com.daimajia.androidviewhover.tools.Util;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BlurLayout extends RelativeLayout {


    private View mHoverView;

    private boolean enableBlurBackground = true;
    private int mBlurRadius = 10;
    private ImageView mBlurImage;

    private static long DURATION = 500;

    private ArrayList<Animator> mPlayingAnimators = new ArrayList<Animator>();

    private ArrayList<Animator> mAppearingAnimators = new ArrayList<Animator>();
    private ArrayList<Animator> mDisappearingAnimators = new ArrayList<Animator>();

    private ArrayList<AppearListener> mAppearListeners = new ArrayList<AppearListener>();
    private ArrayList<DisappearListener> mDisappearListeners = new ArrayList<DisappearListener>();

    private boolean enableBackgroundZoom = false;
    private float mZoomRatio = 1.14f;

    private boolean enableTouchEvent = true;

    private Animator mHoverAppearAnimator;
    private YoYo.AnimationComposer mHoverAppearAnimationComposer;

    private Animator mHoverDisappearAnimator;
    private YoYo.AnimationComposer mHoverDisappearAnimationComposer;

    private HashMap<View, ArrayList<AnimationProxy>> mChildAppearAnimators = new HashMap<View, ArrayList<AnimationProxy>>();
    private HashMap<View, ArrayList<AnimationProxy>> mChildDisappearAnimators = new HashMap<View, ArrayList<AnimationProxy>>();

    private long mBlurDuration = DURATION;

    public enum HOVER_STATUS {
        APPEARING, APPEARED, DISAPPEARING, DISAPPEARED
    };

    private HOVER_STATUS mHoverStatus = HOVER_STATUS.DISAPPEARED;

    public BlurLayout(Context context) {
        super(context);
    }

    public BlurLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BlurLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return enableTouchEvent && gestureDetector.onTouchEvent(event);
    }

    private GestureDetector gestureDetector = new GestureDetector(getContext(), new BlurLayoutDetector());

    class BlurLayoutDetector extends GestureDetector.SimpleOnGestureListener {

        @Override