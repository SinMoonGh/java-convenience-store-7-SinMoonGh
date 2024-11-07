package store.Domain;

public enum ProductsPromotions {
    COLA("콜라", 1000, 10, "탄산2+1"),
    SODA("사이다", 1000, 8, "탄산2+1"),
    ORANGE_JUICE("오렌지주스", 1800, 9, "MD추천상품"),
    SPARKLING_WATER("탄산수", 1200, 5, "탄산2+1"),
    POTATO_CHIPS("감자칩", 1500, 5, "반짝할인"),
    CHOCOLATE_BAR("초코바", 1200, 5, "MD추천상품"),
    INSTANT_NOODLE("컵라면", 1700, 1, "MD추천상품");

    private final String name;
    private final int price;
    private final int quantity;
    private final String promotion;

    ProductsPromotions(String name, int price, int quantity, String promotion) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promotion = promotion;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPromotion() {
        return promotion;
    }
}
