package cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;
import com.squareup.picasso.Picasso;

import io.fabric.sdk.android.Fabric;
import java.io.Serializable;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.BuildConfig;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.R;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.api.API;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model.Article;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model.SearchResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.mainImageView)
    ImageView image;
    @Bind(R.id.editText)
    TextView query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Fabric.with(this, new Crashlytics.Builder()
                            .core(new CrashlyticsCore.Builder()
                            .disabled(BuildConfig.DEBUG)
                            .build())
                .build());

    }

    @OnClick(R.id.show)
    public void clickedButton(View view) {

        final String busqueda = query.getText().toString();

        SharedPreferences preferences = getSharedPreferences("generales", Context.MODE_PRIVATE);
        boolean seBusco = preferences.getBoolean(busqueda, false);

        if(!seBusco) {

            API.search(busqueda, new Callback<SearchResult>() {
                @Override
                public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                    if(response.isSuccessful()) {

                        SearchResult searchResult = response.body();
                        // TODO: No vienen los Attributes. Solo en el getArticle.
                        Intent intent = new Intent(MainActivity.this, SearchResultActivity.class);
                        intent.putExtra("RESULTS", (Serializable) searchResult.getResults());
                        startActivity(intent);

                        SharedPreferences.Editor editor = getSharedPreferences("generales", Context.MODE_PRIVATE).edit();
                        editor.putBoolean(busqueda, true);
                        editor.commit();

                        for(Article article : searchResult.getResults()) {
                            article.setBusqueda(busqueda);
                            article.save();
                        }

                    }
                }
                @Override
                public void onFailure(Call<SearchResult> call, Throwable t) {
                    Log.i(TAG, "onFailure");
                    t.printStackTrace();
                }
            });

        } else {
            Log.i(TAG, preferences.getString("generales",""));

            List<Article> buscados = Article.find(Article.class, "busqueda = ?", busqueda);
            Intent intent = new Intent(MainActivity.this, SearchResultActivity.class);
            intent.putExtra("RESULTS", (Serializable) buscados);
            startActivity(intent);

        }




//        API.getArticle("MLA644287324", new Callback<Article>() {
//            @Override
//            public void onResponse(Call<Article> call, Response<Article> response) {
//                if(response.isSuccessful()) {
//                    Article received = response.body();
//                    Intent intent = new Intent(MainActivity.this, SearchResultActivity.class);
//                    intent.putExtra("PICTURE", received.getThumbnail());
//                    intent.putExtra("TITLE", received.getTitle());
//                    intent.putExtra("PRICE", received.getPrice());
//                    intent.putExtra("CONDITION", received.getCondition());
//                    intent.putExtra("WARRANTY", received.getWarranty());
//                    intent.putExtra("AVAILABLE_QUANTITY", received.getAvailableQuantity());
//                    intent.putExtra("SHIPPING", received.getShipping().isFreeShipping());
//                    intent.putExtra("ATTRIBUTES", (Serializable) received.getAttributes());
//                    startActivity(intent);
//                }
//            }
//            @Override
//            public void onFailure(Call<Article> call, Throwable t) {
//                Log.i(TAG, "onFailure");
//                t.printStackTrace();
//            }
//        });
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
