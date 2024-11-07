package store.Domain;

public class TotalPurchaseAmount {

    private final String name;
    private final int quantity;

    public TotalPurchaseAmount(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Products findProductName(String productName) {
        for (Products product : Products.values()) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        throw new IllegalArgumentException("해당 이름의 상품을 찾을 수 없습니다: " + productName);
    }

    public boolean checkProductsThatBenefit(Products product) {
        return product.getPromotion() != null;
    }

    public int calculate() {
        int price = findProductName(name).getPrice();
        int sum = price * quantity;

        return sum;
    }
}
