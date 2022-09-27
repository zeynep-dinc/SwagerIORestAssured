package stepDefination;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum URL_EnumList {
    DOMAIN_URL("https://petstore.swagger.io/v2/"),

    STORE_ORDER_URL("store/order"),
    STORE_INVENTORY_URL("store/inventory"),

    PET_URL("pet"),
    PET_FIND_STATUS("pet/findByStatus?status=");


    @Getter
    protected String url;
}
