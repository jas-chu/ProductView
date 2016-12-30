package cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

public class ProductActivity extends AppCompatActivity {

    private static final String TAG = ProductActivity.class.getSimpleName();

    @Bind(R.id.descriptionContent)
    View viewDescription;

    @Bind(R.id.product)
    ImageView imageProduct;

    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.price)
    TextView price;
    @Bind(R.id.usedOrNew)
    TextView usedOrNew;
    @Bind(R.id.warranty)
    TextView warranty;
    @Bind(R.id.available)
    TextView available;

    private String imageURL = "http://www.sinmordaza.com/imagesnueva/noticias/grandes/60783_empresarias.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);
        loadData();

    }

    public void loadData(){
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            imageURL = extras.getString("PICTURE");
            title.setText(extras.getString("TITLE"));
            price.setText(("Precio: $" + extras.getString("PRICE")));
            usedOrNew.setText(extras.getString("CONDITION"));
            warranty.setText(("Garantía: " + extras.getString("WARRANTY")));
            available.setText(("Disponible: " + extras.getString("AVAILABLE_QUANTITY")));
        }
    }

    @Override
    public void onResume(){
        super.onResume();
//        Picasso.with(this)
//                .setIndicatorsEnabled(true); //triangulito de color. Rojo: saco de internet. Verde: cacheada en memoria. Azul: cacheada en disco.
        Picasso.with(this)
                .load(imageURL)
                .into(imageProduct);
    }

    @OnClick(R.id.descriptionButton)
    public void clickedButton(View view){
        if (viewDescription.getVisibility() == View.VISIBLE){
            viewDescription.setVisibility(View.GONE);
        } else {
            viewDescription.setVisibility(View.VISIBLE);
        }
    }

}
