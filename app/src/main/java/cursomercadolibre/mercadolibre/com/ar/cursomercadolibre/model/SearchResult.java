package cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jsella on 12/31/16.
 */

public class SearchResult implements Serializable{
    private List<Article> results;

    public List<Article> getResults() {
        return results;
    }

    public void setResults(List<Article> results) {
        this.results = results;
    }
}
