# ProductView

## ButterKnife
Sirve para hacer inyeccion de dependencias, es decir, brinda anotaciones para deshacernos del codigo de findViewById(), etc. Dagger es otra. Toma el xml de la actividad, la actividad y busca los atributos que se van a setear.

### En el build(app):    
compile 'com.jakewharton:butterknife:7.0.1'


### Al usarlo en el codigo
@Bind(R.id.imagen)  
ImageView imagen; //Sin el PRIVATE    


En el onCreate() o en el Constructor de la clase:  
ButterKnife.bind(this);  //inyecto la dependencia.    


Se puede hacer tambien:  
@Bind({R.id.boton, R.id.mensaje, R.id.boton})  
List<View> views;  


@OnClick(R.id.boton)  
public void funcionDeBotonClickeado(View view){ //public o protected tienen que ser.
}  


Si quiero que varios objetos tengan el mismo listener  
@OnClick({R.id.boton, R.id.mensaje, R.id.articles})  


@Nullable	//"en este atributo pone el R.id.imagen, pero si no existe pone null"  
@Bind(R.id.imagen)      


@BindString(R.String.Saludo)  //va a tener el valor que hay en el string.xml  
String saludo    


IMPORTANTE: si no voy a usar la variable mas que para hacerle el onClick, el @Onclick es suficiente sin el @Bind  


## Picasso

### En el Android_manifest.xml:
< uses-permission android:name="android.permission.INTERNET"/>

### En el build(app):
compile 'com.squareup.picasso:picasso:2.5.2'

### Al usarlo en el codigo
//triangulito de color. Rojo: saco de internet. Verde: cacheada en memoria. Azul: cacheada en disco. Solo para debugging. 
 
 Picasso.with(this)  
        .setIndicatorsEnabled(true); 

 Picasso.with(this)  
        .load("http://www.sinmordaza.com/imagesnueva/noticias/grandes/60783_empresarias.jpg")  
        .into(image);

  Picasso.placeholder(R.drawable.default_image)  
  		.error(R.drawable.imagen_si_hubo_error)
