package sdm.shop.product;

public enum ProductSize {
    NOT_APPLICABLE(""),
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    private final String asText;

    ProductSize(String asText) {
        this.asText = asText;
    }

    @Override
    public String toString() {
        return asText;
    }
}
