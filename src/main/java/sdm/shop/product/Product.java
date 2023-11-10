package sdm.shop.product;

public class Product {
    private final String id;
    private final String name;
    private final String price;
    private final Currency currency;
    private final Color color;
    private final ProductSize size;

    public Product(String id, String name, String price, Currency currency, Color color, ProductSize size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.color = color;
        this.size = size;
    }

    public Product(String id, String name, String price, Currency currency, Color color) {
        this(id, name, price, currency, color, ProductSize.NOT_APPLICABLE);
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Color getColor() {
        return color;
    }

    public ProductSize getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!id.equals(product.id)) return false;
        if (!name.equals(product.name)) return false;
        if (!price.equals(product.price)) return false;
        if (currency != product.currency) return false;
        if (color != product.color) return false;
        return size == product.size;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + currency.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }
}
