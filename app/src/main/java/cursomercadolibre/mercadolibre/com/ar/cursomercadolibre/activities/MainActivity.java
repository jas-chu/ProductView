package cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.R;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.api.API;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model.Article;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.mainImageView)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.show)
    public void clickedButton(View view) {
        API.getArticle("MLA644287324", new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                if(response.isSuccessful()) {
                    Article received = response.body();
                    Intent intent = new Intent(MainActivity.this, SearchResultActivity.class);
                    intent.putExtra("PICTURE", received.getThumbnail());
                    intent.putExtra("TITLE", received.getTitle());
                    intent.putExtra("PRICE", received.getPrice());
                    intent.putExtra("CONDITION", received.getCondition());
                    intent.putExtra("WARRANTY", received.getWarranty());
                    intent.putExtra("AVAILABLE_QUANTITY", received.getAvailableQuantity());
                    intent.putExtra("SHIPPING", received.getShipping().isFreeShipping());
                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(Call<Article> call, Throwable t) {
                Log.i(TAG, "onFailure");
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

//        Picasso.with(this)
//                .setIndicatorsEnabled(true); //triangulito de color. Rojo: saco de internet. Verde: cacheada en memoria. Azul: cacheada en disco.

        Picasso.with(this)
                .load("http://www.sinmordaza.com/imagesnueva/noticias/grandes/60783_empresarias.jpg")
                .into(image);
    }

    // Entro a la pantalla sin conexion a internet
    // Hacer Progress Bar
}
