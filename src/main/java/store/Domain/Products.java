package store.Domain;

public enum Products {

    COLA("콜라", 1000, 10, null),
    SODA("사이다", 1000, 7, null),
    WATER("물", 500, 10, null),
    ORANGE_JUICE("오렌지주스", 1800, 0, null),
    SPARKLING_WATER("탄산수", 1200, 0, null),
    VITAMIN_WATER("비타민워터", 1500, 6, null),
    POTATO_CHIPS("감자칩", 1500, 5, null),
    CHOCOLATE_BAR("초코바", 1200, 5, null),
    ENERGY_BAR("에너지바", 2000, 5, null),
    LUNCH_BOX("정식도시락", 6400, 8, null),
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
