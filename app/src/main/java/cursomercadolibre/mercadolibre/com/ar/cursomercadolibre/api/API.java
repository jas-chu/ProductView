package cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model.Article;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model.SearchResult;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jsella on 12/30/16.
 */

public class API {

    private static MercadoLibreAPI getAPI() {

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create( gson ))
                .baseUrl("https://api.mercadolibre.com/")
                .build();

        MercadoLibreAPI service = retrofit.create(MercadoLibreAPI.class);

        return service;
    }

    public static void getArticle(String id, Callback<Article> callback) {
        getAPI().getArticle(id).enqueue(callback);
    }

    public static void search(String query, Callback<SearchResult> callback) {
        getAPI().search(query).enqueue(callback);
    }
}
