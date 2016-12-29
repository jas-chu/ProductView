# ProductView

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
