package cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.R;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.adapters.ArticlesAdapter;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model.Article;

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
        for (int i = 0; i < 500; i++){
            Bundle extras = getIntent().getExtras();
            if(extras != null) {
                Article article = new Article();
                article.setTitle(extras.getString("TITLE"));
                article.setPrice(extras.getString("PRICE"));
                article.setThumbnail(extras.getString("PICTURE"));
                articles.add(article);
            }

        }
        this.articlesAdapter.setItems(articles);
    }
}
