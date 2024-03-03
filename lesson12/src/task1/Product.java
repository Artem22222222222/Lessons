package task1;

public class Product {
    String name;
    int cost;
    int weight;
    int count;

    public Product(String name, int cost, int weight, int count) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getCost() {
        return cost;
    }
}
