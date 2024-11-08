package store.Utils;

import store.Domain.Products;
import store.Domain.ProductsPromotions;

public class SearchProductName {

    private final String name;

    public SearchProductName(String name) {
        this.name = name;
    }

    public Products findProductName() {
        for (Products product : Products.values()) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        throw new IllegalArgumentException("해당 이름의 상품을 찾을 수 없습니다: " + name);
    }

    public ProductsPromotions findPromotionsProductName() {
        for (ProductsPromotions product : ProductsPromotions.values()) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        throw new IllegalArgumentException("해당 이름의 상품을 찾을 수 없습니다: " + name);
    }
}
