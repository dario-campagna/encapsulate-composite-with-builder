package sdm.shop.product;

public enum Currency {
    USD("USD"),
    EUR("EUR");

    private final String asText;

    Currency(String asText) {
        this.asText = asText;
    }

    @Override
    public String toString() {
        return asText;
    }
}
