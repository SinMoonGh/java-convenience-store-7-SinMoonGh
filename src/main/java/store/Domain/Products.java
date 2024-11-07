package store.Domain;

public enum Products {
    COLA_WITH_PROMO("콜라", 1000, 10, "탄산2+1"),
    COLA("콜라", 1000, 10, null),
    SODA_WITH_PROMO("사이다", 1000, 8, "탄산2+1"),
    SODA("사이다", 1000, 7, null),
    ORANGE_JUICE("오렌지주스", 1800, 9, "MD추천상품"),
    SPARKLING_WATER("탄산수", 1200, 5, "탄산2+1"),
    WATER("물", 500, 10, null),
    VITAMIN_WATER("비타민워터", 1500, 6, null),
    POTATO_CHIPS_WITH_PROMO("감자칩", 1500, 5, "반짝할인"),
    POTATO_CHIPS("감자칩", 1500, 5, null),
    CHOCOLATE_BAR_WITH_PROMO("초코바", 1200, 5, "MD추천상품"),
    CHOCOLATE_BAR("초코바", 1200, 5, null),
    ENERGY_BAR("에너지바", 2000, 5, null),
    LUNCH_BOX("정식도시락", 6400, 8, null),
    INSTANT_NOODLE_WITH_PROMO("컵라면", 1700, 1, "MD추천상품"),
    INSTANT_NOODLE("컵라면", 1700, 10, null);

    private final String name;
    private final int price;
    private final int quantity;
    private final String promotion;

    Products(String name, int price, int quantity, String promotion) {
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
