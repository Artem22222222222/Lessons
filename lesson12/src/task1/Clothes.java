package task1;

public class Clothes extends Product {
    int size;

    public Clothes(String name, int cost, int weight, int count, int size) {
        super(name, cost, weight, count);
        this.size = size;
    }
}
