package store.Domain;

import store.Utils.SearchProductName;

public class TotalPurchaseAmount {

    private final int quantity;
    private final SearchProductName searchProductName;

    public TotalPurchaseAmount(int quantity, SearchProductName searchProductName) {
        this.quantity = quantity;
        this.searchProductName = searchProductName;
    }

//    public boolean checkProductsThatBenefit(Products product) {
//        return product.getPromotion() != null;
//    }

    public int calculate() {
        int price = searchProductName.findProductName().getPrice();
        int sum = price * quantity;

        return sum;
    }
}
