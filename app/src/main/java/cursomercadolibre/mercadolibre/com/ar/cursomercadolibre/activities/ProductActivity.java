package cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.xml.sax.helpers.AttributesImpl;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.R;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.api.API;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model.Article;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model.Attribute;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model.SearchResult;
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
    @Bind(R.id.freeShippingOk)
    ImageView freeShippingOk;
    @Bind(R.id.freeShippingNo)
    ImageView freeShippingNo;
    @Bind(R.id.attribute1)
    TextView attribute1;
    @Bind(R.id.attribute2)
    TextView attribute2;
    @Bind(R.id.attribute3)
    TextView attribute3;

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
            boolean freeShipping = extras.getBoolean("SHIPPING");
            if (freeShipping) {
                freeShippingOk.setVisibility(View.VISIBLE);
                freeShippingNo.setVisibility(View.GONE);
            } else {
                freeShippingOk.setVisibility(View.GONE);
                freeShippingNo.setVisibility(View.VISIBLE);
            }
            List<Attribute> attributes = (List<Attribute>) extras.getSerializable("ATTRIBUTES");
            if (attributes != null && attributes.size() > 0 ) {
                Log.i(TAG, String.valueOf(attributes.size()));
                attribute1.setText((attributes.get(0).getName() + ": " + attributes.get(0).getValueName()));
                attribute2.setText((attributes.get(1).getName() + ": " + attributes.get(1).getValueName()));
                attribute3.setText((attributes.get(2).getName() + ": " + attributes.get(2).getValueName()));
            }

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
