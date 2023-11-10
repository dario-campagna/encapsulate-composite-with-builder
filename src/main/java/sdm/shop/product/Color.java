package sdm.shop.product;

public enum Color {
    RED("red"),
    GREEN("green");

    private final String asText;

    Color(String asText) {
        this.asText = asText;
    }

    @Override
    public String toString() {
        return asText;
    }
}
