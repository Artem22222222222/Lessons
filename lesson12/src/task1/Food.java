package task1;

public class Food extends Product {
    int expirationDate;

    public Food(String name, int cost, int weight, int count, int expirationDate) {
        super(name, cost, weight, count);
        this.expirationDate = expirationDate;
    }
}
