package cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.R;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.adapters.ArticlesAdapter;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model.Article;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model.Attribute;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model.Shipping;

public class SearchResultActivity extends AppCompatActivity {
    @Bind(R.id.articles)
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArticlesAdapter articlesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        ButterKnife.bind(this);

        this.layoutManager = new LinearLayoutManager(this);

        this.recyclerView.setLayoutManager(this.layoutManager);

        this.articlesAdapter = new ArticlesAdapter();
        this.recyclerView.setAdapter(this.articlesAdapter);

        List<Article> articles = new ArrayList<Article>();
//        for (int i = 0; i < 500; i++){
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            articles = (List<Article>) extras.getSerializable("RESULTS");
            for (int i = 0; i < 10 /*articles.size()*/; i++) {
                Article article = new Article();
                article.setThumbnail(articles.get(0).getThumbnail());
                article.setTitle(articles.get(0).getTitle());
                article.setPrice(articles.get(0).getPrice());
                article.setCondition(articles.get(0).getCondition());
                article.setWarranty(articles.get(0).getWarranty());
                article.setAvailableQuantity(articles.get(0).getAvailableQuantity());
                article.setShipping(articles.get(0).getShipping());
                article.setAttributes(articles.get(0).getAttributes());
                articles.add(article);
            }
        }
        this.articlesAdapter.setItems(articles);
    }
}
