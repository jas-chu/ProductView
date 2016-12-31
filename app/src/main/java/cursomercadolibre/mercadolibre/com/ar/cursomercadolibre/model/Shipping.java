package cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jsella on 12/30/16.
 */

public class Shipping {
    @SerializedName("free_shipping")
    private boolean freeShipping;

    public Shipping(boolean freeShipping){
        this.freeShipping = freeShipping;
    }

    public boolean isFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }
}
