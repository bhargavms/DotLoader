# DotLoader
[![Release](https://jitpack.io/v/bhargavms/DotLoader.svg)](https://github.com/bhargavms/DotLoader/releases/tag/1.0.0)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-DotLoader-green.svg?style=true)](https://android-arsenal.com/details/1/4032)
https://github.com/JStumpp/awesome-android
-------------------------------------------------------
#### First, the gifs!
##### I am the one with constant Dots:
![Sample Gif](assets/constant_dots.gif?raw=true)

##### You can add dots on the fly !
![Sample Gif](assets/adding_dots.gif?raw=true)

##### And maybe create some cool animations like this?
![Sample Gif](assets/loading_anim.gif?raw=true)

(This sucks but you get the idea :))

#### How to use.
##### Adding to your project
> Currently only gradle supported

Add to your project level `build.gradle`'s `allprojects` block like this
```
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
Next add to your module level (app) `build.gradle`'s dependencies block like this
> Check the [releases](https://github.com/bhargavms/DotLoader/releases) section to get the version name for the latest release (i.e the name to replace X.X.X with)

```
dependencies {
    compile 'com.github.bhargavms:DotLoader:X.X.X'
}
```

You're all set, Now you can start using the DotLoader class.

#### Simple to use!

This works like any other view in android. You use it in your xml file like this
```xml
<com.bhargavms.dotloader.DotLoader
    android:id="@+id/text_dot_loader"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:color_array="@array/dot_colors"
    app:dot_radius="4dp"
    app:number_of_dots="3"/>
```
Now I will explain the 3 custom attributes here,

`dot_radius`

This is the main metric from which all sizes are calculated, if you were to provide `wrap_content` for `layout_width` and `layout_height`. You can, of course, provide your own height, in which case the animation might look horrible. You can also provide greater width than necessary, but the dots will not spread out to take up width (trust me doesn't look good).

`number_of_dots`

By default this is 1 (looks ridiculous I know but hey it is your choice!). So just provide the input here for whatever number of dots you want. (you can have a gazzillion, if you can fit in your phone screen xD)

`color_array`

Ah this is where I made the magic happen! Provide here a reference (like I have in the code above `app:color_array="@array/dot_colors"`) to an array of colors which can be declared like so in your `colors.xml` file
```xml
<array name="dot_colors">
    <item>#03A9F4</item>
    <item>#E65100</item>
    <item>#FFBB00</item>
</array>
```
What this does is provide the DotLoader instance with a set colors through which the animation iterates over, looks neat don't you think?

##### OK Now a TIP!!
> If you plan to increase the number of dots on the fly, please remember to call `requestLayout()` on the view, OR provide enough width before hand, then you don't have to call `requestLayout()` and make things choppy

##### Increasing and decreasing the DOTS on the fly! HOW?
Now for this the DotLoader class comes with the `setNumberOfDots(int numberOfDots)` method. Use this to change the number of dots to whatever you want on the fly and see the magic happen. In the demo app, I demonstrate this by changing the number of dots after a set period using the postDelayed() method from the `View` class.
```java
dotLoader.postDelayed(new Runnable() {
    @Override
    public void run() {
        dotLoader.setNumberOfDots(5);
    }
}, 3000);
```

##### This library is heavily inspired by [this](http://codepen.io/blakemanzo/pen/OXOBaw) design of Blake Manzo
--------------------------------------------------------------------------------------
Thats it! QuestionS? ask em in the issues section!
Oh aren't I forgetting something? Ah License!

#### LICENSE
[Apache 2.0](LICENSE)
