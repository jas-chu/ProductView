package cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jsella on 12/31/16.
 */

public class SearchResult implements Serializable{
    @Expose
    private List<Article> results;

    public List<Article> getResults() {
        return results;
    }

    public void setResults(List<Article> results) {
        this.results = results;
    }
}
