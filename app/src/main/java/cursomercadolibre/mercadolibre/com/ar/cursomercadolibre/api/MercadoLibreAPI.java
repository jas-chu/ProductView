package cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.api;

import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model.Article;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jsella on 12/30/16.
 */

public interface MercadoLibreAPI {

    @GET("items/{itemId}")
    Call<Article> getArticle(@Path("itemId") String id);

    // "/sites/MLA/searchUrl?q=" + query.getText();

//    @GET("sites/MLA/search") //TODO: CREO que es searchUrl
//    Call<SearchResult> search(@Query("q") String query);

}
