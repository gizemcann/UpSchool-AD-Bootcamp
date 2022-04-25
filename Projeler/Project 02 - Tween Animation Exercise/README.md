
# **Tween animation**


The **view animation** framework supports both tween and frame-by-frame animations, both of which can be declared in XML. **Tween animation** is an animation defined in XML that performs transitions such as rotate, fade, move, and stretch on a graphic.
The file must have a single root element: either an `<alpha>`, `<scale>`, `<translate>`, `<rotate>`, or `<set>` element that holds a group (or groups) of other animation elements.
- *Alpha:* A fade-in or fade-out animation. 
- *Scale:* A resizing animation. You can specify the center point of the image from which it grows outward (or inward) by specifying pivotX and pivotY.
- *Translate:* A vertical and/or horizontal motion.
- *Rotate:* A rotation animation.<br/>

I created a project using animation elements (alpha, <scale>, translate, rotate).
In order for us to see the animation, we need to use the property of the `<objectAnimator>` element, which allows to animate a certain property of an object for a certain period of time. `android:duration=" duration of animation in milliseconds(int)"`

![tweenAnimation](https://user-images.githubusercontent.com/42353797/165071479-b5683a40-2b0b-4ed3-af3d-cd9bd210af05.gif)
