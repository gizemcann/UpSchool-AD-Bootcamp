# Araştırma Ödevleri:

- [Araştırma Projesi 1 - Lateinit](#1)
- [Araştırma Projesi 2 - Tools Namespace](#2)
- [Araştırma Projesi 3 - Font family XML](#3)
- [Araştırma Projesi 4 - Property Animation](#4)


### <a name="1"></a> Araştırma Projesi 1

- Lateinit neden kullanıyoruz?
- Lateinit kullanımından bahseder misiniz?
- Lateinit için bir örnek kullanım gösterir misiniz ?

**Cevap:<br/>**

Kotlinde değişken tanımlama işlemleri iki farklı anahtar kelime kullanırız: Sabit bir değer tanımlamak için *val* ;  Normal değişken tanımlamak için ise *var* kullanılır. *val* yapısı ile tanımlama yapıldıktan sonra tekrar değiştirilemez ancak *var* ile tanımlandıktan sonra istenildiğinde değeri değiştirilebilir. <br/>

Değişkenin değerini, değişkeni oluştururken vermek istemediğimiz zaman tipini belirtmemiz gerekir. Kotlinde değişkenler  *Nullable* ve *Non-Null* olmak üzere iki tanedir. Bunlar *NullPointerException’ın* önüne geçer. Bu yüzden değişkenin Nullable ya da Non-Null olduğunu en başta belirtmemiz gerekiyor. Değişken tipinin yanında **“?”** var ise bu, o değişkenin *Nullable* olduğunu belirtir.

En başta değer atama işi olmadan *lazy* ve *lateinit* kullanarak değişken tanımlayabiliriz. *Lazy*, sadece *val* değişkenlerde kullanılabilir.  **Lateinit** ise sadece *var* olan değişkenlerde kullanılır. Böyle olmasının sebebi; Bytecode seviyesinde final olarak tanımlanmaması gerekiyor, çünkü constructorda değil, sonrasında tanımlaması yapılıyor. Ayrıca lateinit, primitive tiplere uygulanamaz. Yani özetle lateinit sadece Non-Nullable ve referans tipli değişkenlerde kullanılabilir. <br/>
```kotlin
    class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button: Button
    private  lateinit var dice: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.mybutton)
        dice = findViewById(R.id.dice)

        button.setOnClickListener {

            Toast.makeText(this, "Button Clicked.", Toast.LENGTH_LONG).show()
        }
        button.setOnClickListener (this)
    }
```

### <a name="2"></a> Araştırma Projesi 2


- Layout dizini içinde xml dosyalarımız için kullandığımız namespace nedir ?
- Neden kullanılmaktadır ?
- Nasıl kullanılmalıdır ?
- Bir adet Tools (tools namespace) attribute kullanımını gösterir misiniz ? 

**Cevap:<br/>**

XML Ad Alanları, öğe adı çakışmalarını önlemek için bir yöntem sağlar. Bir *XML namespace* kullanmanın sebebi, birden çok sözlük kullanılırken ve yeniden kullanılırken adlandırma çakışmalarından kaçınmaktır. XML Şeması, bir XML örneği için bir sözlük oluşturmak için kullanılır ve *namespace*  yoğun olarak kullanır.<br/>

Uygulama geliştirirken tasarım tarafında yapılan değişikliklerin çıktısını uygulamayı çalıştırmadan  *tools attribute* ile anında görebiliriz.
Kullanabilmek için root tagında  `xmlns:tools="http://schemas.android.com/tools"`  tanımlaması yapılması gerekiyor. Bu attribute birçok yerde kullanabiliyoruz.<br/>
- Örneğin;
*TextView* tasarlarken text değeri sabit bir değer olarak kalacaksa `android:text="Lorem text"` şeklinde bir kullanım yapılabilir . Aynı işlem *ImageView* içinde geçerli.<br/> 
- Örneğin ;
`android:src="@drawable/sampleImg"` yerine `tools:src="@drawable/sampleImg"`  yazarak resmin sadece tasarım ekranında görünmesini sağlayabiliriz.<br/>

- Örneğin; `tools:layout` <br/>
Bu attribute yalnızca **<fragment>** etiketleri tarafından kullanılır ve düzenleyiciye, parçanın içindeki layout ön izlemesi tarafından çizilmesi gereken layout  hakkında bilgi verir. Aşağıda, **<fragment>** etiketine ` tools:layout="@layout/fragment_contacts" ` eklemeden önce ve sonra *aktivite_main.xml* layout  önizlemeleri arasındaki farkı görebiliriz. 
 ```xml
<fragment
    android:id="@+id/home_fragment_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    tools:layout="@layout/fragment_contacts"/>
 ```   
### <a name="3"></a> Araştırma Projesi 3

- Font family dosyası nasıl oluşturulup kullanıyoruz?
- Neden belirttiğiniz şekilde kullanımı tercih ediyoruz?
    
    
**Cevap:<br/>**
    
####  Nasıl oluşturup kullanıyoruz?
- ***Fonts in XML***<br/> 
Projemize **font**'ları kaynak olarak eklemek için **res** klasörüne sağ tıklayıp ve **New --> Android Resource** dizinine gidiyoruz.
*New Resource Directory* penceresi görünecektir. *Resource type list* **font** olarak seçip **font** dosyamızı oluşturuyoruz. Daha sonra kendi **font** dosyalrımızı  font klasörüne ekliyoruz.<br/>  
    
- ***Font Family Oluşturma***<br/> 
**Font Folder**, sağ tıklayıp ve ** New > Font resource file** dizinine gidiyoruz. *New Resource Directory* penceresi görünecektir.
Dosya adını girerek *OK* butonuna tıklıyoruz. **New font resource**  XML'i düzenleyicide açılır.
Her yazı tipi dosyasını, stili ve ağırlık özniteliğini <font> öğesi içine alın. Aşağıdaki XML, yazı tipi kaynağı XML'sine yazı tipiyle ilgili niteliklerin eklenmesini gösterir.
```xml    
<?xml version="1.0" encoding="utf-8"?>
<font-family xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <font
        app:fontStyle="normal"
        app:fontWeight="400"
        app:font="@font/simonetta_regular" />
    <font
        app:fontStyle="italic"
        app:fontWeight="400"
        app:font="@font/simonetta_italic" />
    <font
        app:fontStyle="normal"
        app:fontWeight="700"
        app:font="@font/simonetta_black" />
    <font
        app:fontStyle="italic"
        app:fontWeight="700"
        app:font="@font/simonetta_black_italic" />
</font-family>
```

<img src="https://user-images.githubusercontent.com/42353797/164944438-aec1b81f-a621-4daa-b198-1315e7374f83.gif" >  
Oluşturulan  Font dosyasına Layout XML dosyasında kod örneğindeki gibi erişebilir.<br/> 
    
``` xml
<TextView
    android:id="@+id/first_title"
    style="@style/firstTitle"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:fontFamily="@font/simonetta"  />
```
   
 
<img src="https://user-images.githubusercontent.com/42353797/164972606-25839d11-0ff1-419b-aa11-b8cdae6decf0.gif" >  


#### Neden belirttiğiniz şekilde kullanımı tercih ediyoruz?  
- *Font Family*,*Still* ve a*Weight* ayrıntılarıyla birlikte oluşturduğumuz bir font dosya topluluğudur. Oluşturulan Font Family ile her bir Still'e ve Weight'e ayrı kaynaklar olarak başvurmak yerine tek bir birim olarak erişebilebilmesini sağlar.

    
## <a name="4"></a> Araştırma Projesi 4

- Property Animation ile ilgili olarak objectAnimator ile animator arasındaki farkı kısaca açıklayınız.
    
**Cevap:**<br/>
    
- Property Animation, arka plan rengi veya alfa değeri gibi bileşenin özelliklerini belirli bir süre boyunca değiştiren animasyon türüdür.
- **Animator** başlatılabilen, sonlandırılabilen ve kendilerine `AnimatorListeners` eklenebilen animasyonlar için temel destek sağlayan sınıflar için bir üst sınıftır.<br/>
    
    * Animator'ın bilinen doğrudan iki alt sınıfı vardır.
    1. `AnimatorSet:` Bu sınıf, belirtilen sırada bir dizi Animator nesnesi oynatır.
    2. `ValueAnimator:` Bu sınıf, animasyonlu değerleri hesaplayan ve bunları hedef nesnelere ayarlayan animasyonları çalıştırmak için basit bir zamanlama motoru sağlar.<br/> 
    
    * Animator'ün bilinen dolaylı alt sınıfı vardır.
    1.  `ObjectAnimator:` ValueAnimator'ın altsınıfıdır.Hedef nesnelerde niteliklerin canlandırılması için destek sağlar.Bu sınıfın yapıcıları, canlandırılacak olan hedef nesnenin yanı sıra canlandırılacak özelliğin adını tanımlamak için parametreler alır. Uygun set/get işlevleri daha sonra dahili olarak belirlenir ve animasyon, özelliği canlandırmak için gerektiğinde bu işlevleri çağırır.
    2.  `TimeAnimator:` Bu sınıf ise sistemdeki diğer tüm animatörlerle senkronize olan dinleyicilere basit bir geri arama mekanizması sağlar.
