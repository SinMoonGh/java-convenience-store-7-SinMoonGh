package store.Utils;

import store.Domain.Products;
import store.Domain.ProductsPromotions;
import store.Domain.Promotions;

public class Inquiry {

    private final String name;

    public Inquiry(String name) {
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

    public Promotions findPromotion() {
        String promotion = findPromotionsProductName().getPromotion();

        for (Promotions promotionValue : Promotions.values()) {
            if (promotionValue.name().equals(promotion)) {
                return promotionValue;
            }
        }
        throw new IllegalArgumentException("해당 이벤트를 찾을 수 없습니다: " + promotion);
    }
}
