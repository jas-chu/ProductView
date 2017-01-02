package cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model;

import com.google.gson.annotations.Expose;

/**
 * Created by jsella on 12/30/16.
 */

public class Picture {
    @Expose
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
