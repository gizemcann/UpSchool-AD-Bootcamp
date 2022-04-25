# Araştırma Ödevleri:

- [Araştırma Projesi 1 - Lateinit](#1)
- [Araştırma Projesi 2 - Tools Namespace](#2)


### <a name="1"></a> Araştırma Projesi 1

- Lateinit neden kullanıyoruz?
- Lateinit kullanımından bahseder misiniz?
- Lateinit için bir örnek kullanım gösterir misiniz ?

Cevap:<br/>

Kotlinde değişken tanımlama işlemleri iki farklı anahtar kelime kullanırız: Sabit bir değer tanımlamak için *val* ;  Normal değişken tanımlamak için ise *var* kullanılır. *val* yapısı ile tanımlama yapıldıktan sonra tekrar değiştirilemez ancak *var* ile tanımlandıktan sonra istenildiğinde değeri değiştirilebilir. <br/>

Değişkenin değerini, değişkeni oluştururken vermek istemediğimiz zaman tipini belirtmemiz gerekir. Kotlinde değişkenler  *Nullable* ve *Non-Null* olmak üzere iki tanedir. Bunlar *NullPointerException’ın* önüne geçer. Bu yüzden değişkenin Nullable ya da Non-Null olduğunu en başta belirtmemiz gerekiyor. Değişken tipinin yanında **“?”** var ise bu, o değişkenin *Nullable* olduğunu belirtir.

En başta değer atama işi olmadan *lazy* ve *lateinit* kullanarak değişken tanımlayabiliriz. *Lazy*, sadece *val* değişkenlerde kullanılabilir.  **Lateinit** ise sadece *var* olan değişkenlerde kullanılır. Böyle olmasının sebebi; Bytecode seviyesinde final olarak tanımlanmaması gerekiyor, çünkü constructorda değil, sonrasında tanımlaması yapılıyor. Ayrıca lateinit, primitive tiplere uygulanamaz. Yani özetle lateinit sadece Non-Nullable ve referans tipli değişkenlerde kullanılabilir.

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


### <a name="2"></a> Araştırma Projesi 2


- Layout dizini içinde xml dosyalarımız için kullandığımız namespace nedir ?
- Neden kullanılmaktadır ?
- Nasıl kullanılmalıdır ?
- Bir adet Tools (tools namespace) attribute kullanımını gösterir misiniz ? 

Cevap:<br/>

XML Ad Alanları, öğe adı çakışmalarını önlemek için bir yöntem sağlar. Bir *XML namespace* kullanmanın sebebi, birden çok sözlük kullanılırken ve yeniden kullanılırken adlandırma çakışmalarından kaçınmaktır. XML Şeması, bir XML örneği için bir sözlük oluşturmak için kullanılır ve *namespace*  yoğun olarak kullanır.<br/>

Uygulama geliştirirken tasarım tarafında yapılan değişikliklerin çıktısını uygulamayı çalıştırmadan  *tools attribute* ile anında görebiliriz.
Kullanabilmek için root tagında  ```xmlns:tools="http://schemas.android.com/tools"```  tanımlaması yapılması gerekiyor. Bu attribute birçok yerde kullanabiliyoruz.<br/>
- Örneğin;
*TextView* tasarlarken text değeri sabit bir değer olarak kalacaksa ```android:text="Lorem text"``` şeklinde bir kullanım yapılabilir . Aynı işlem *ImageView* içinde geçerli.<br/> 
- Örneğin ;
```android:src="@drawable/sampleImg"``` yerine ```tools:src="@drawable/sampleImg"```  yazarak resmin sadece tasarım ekranında görünmesini sağlayabiliriz.<br/>

Örnek: ```tools:layout``` <br/>
Bu attribute yalnızca **<fragment>** etiketleri tarafından kullanılır ve düzenleyiciye, parçanın içindeki layout ön izlemesi tarafından çizilmesi gereken layout  hakkında bilgi verir. Aşağıda, **<fragment>** etiketine ```tools:layout=”@layout/fragment_contacts”``` eklemeden önce ve sonra ```aktivite_main.xml``` layout  önizlemeleri arasındaki farkı görebiliriz.
    
    <fragment
        android:id="@+id/home_fragment_container"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_behavior="@string/appbar_scrolling_view_behavior"
        tools:layout="@layout/fragment_contacts"/>


