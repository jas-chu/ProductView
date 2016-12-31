package cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jsella on 12/30/16.
 */

public class Attribute implements Serializable {
    private String name;

    @SerializedName("value_name")
    private String valueName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }
}
