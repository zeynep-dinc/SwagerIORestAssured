package stepDefination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public enum URL_EnumList {
    STORE_DOMAIN_URL("https://petstore.swagger.io/v2/"),

    STORE_ORDER_URL("store/order"),
    STORE_INVENTORY_URL("store/inventory");


    @Getter
    protected String url;
}
