package task1;

public class Electronic extends Product {
    String model;

    public Electronic(String name, int cost, int weight, int count, String model) {
        super(name, cost, weight, count);
        this.model = model;
    }
}
