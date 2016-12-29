package cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.R;

public class ProductActivity extends AppCompatActivity {

    @Bind(R.id.descriptionContent)
    View viewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.descriptionButton)
    public void clickedButton(View view){
        if (viewDescription.getVisibility() == View.VISIBLE){
            viewDescription.setVisibility(View.GONE);
        } else {
            viewDescription.setVisibility(View.VISIBLE);
        }
    };
}
