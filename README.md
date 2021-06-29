
# Android View Hover [![Build Status](https://travis-ci.org/daimajia/AndroidViewHover.svg)](https://travis-ci.org/daimajia/AndroidViewHover)

In my opinion, jumping to a new activity to show your menu is a kind of wasting time and life.

So,

I think, we need a hover view, to show menu, to show messages.

## Demo

![](http://ww2.sinaimg.cn/mw690/610dc034jw1ej5iihjtl5g208z0f2npd.gif)

Watch HD in [YouTube](http://www.youtube.com/watch?v=bsDQbMTtPvM).

Download [Apk](https://github.com/daimajia/AndroidViewHover/releases/download/v1.0.0/AndroidViewHover-v1.0.0.apk)

## Usage

### Step0

Set up RenderScript

- Eclipse, please visit [official tutorial](http://developer.android.com/guide/topics/renderscript/compute.html#access-rs-apis).
- Android Studio, add 
	```groovy
	        
	        renderscriptTargetApi 19
        	renderscriptSupportMode true
	```
	in `build.gradle` `defaultConfig`, here is a [sample](https://github.com/daimajia/AndroidViewHover/blob/master/library/build.gradle#L12-L13)
	

### Step1

#### Gradle
```groovy
dependencies {