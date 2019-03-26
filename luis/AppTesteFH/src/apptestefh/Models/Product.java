package apptestefh.Models;

/**
 *
 * @author luiss
 */
public class Product {

    private final String name;

    private final double value;

    public Product(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name + " - R$ " + value + "\n";
    }

}
