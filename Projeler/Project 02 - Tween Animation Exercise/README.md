# Tween Animation Exercise Project

**Case :**  

Tween animation alpha,scale,translate,rotate özelliklerinden tümünü kullanarak bir XML animasyon dosyası oluşturmak ve  animasyonu bir imageview üzerinde başlatmanız gerekmektedir.

**Tasks :** 

- Github repo ismi :  "Android Tween Animation Sample" olarak düzenlemeniz gerekmektedir.
- Çalışmanızı kendi github hesabınızda public repo link olarak iletmeniz talep ediliyor. 
- Repo readme boş olmamalı projenizi anlatan ingilizce kısa açıklama ve ss'leriniz ekli olmalıdır. 
- Readme alanı boş olması halinde projeniz değerlendirmeye alınmayacaktır.

**Sources :**  

https://developer.android.com/guide/topics/resources/animation-resource#Tween

# **Tween animation** :star2:


The **view animation** framework supports both tween and frame-by-frame animations, both of which can be declared in XML. **Tween animation** is an animation defined in XML that performs transitions such as rotate, fade, move, and stretch on a graphic.
The file must have a single root element: either an `<alpha>`, `<scale>`, `<translate>`, `<rotate>`, or `<set>` element that holds a group (or groups) of other animation elements.
- *Alpha:* A fade-in or fade-out animation. 
- *Scale:* A resizing animation. You can specify the center point of the image from which it grows outward (or inward) by specifying pivotX and pivotY.
- *Translate:* A vertical and/or horizontal motion.
- *Rotate:* A rotation animation.<br/>

I created a project using animation elements (alpha, <scale>, translate, rotate).
In order for us to see the animation, we need to use the property of the `<objectAnimator>` element, which allows to animate a certain property of an object for a certain period of time. `android:duration=" duration of animation in milliseconds(int)"`
  
  <p align="center"> <img src="https://user-images.githubusercontent.com/42353797/165071479-b5683a40-2b0b-4ed3-af3d-cd9bd210af05.gif" /></p>


