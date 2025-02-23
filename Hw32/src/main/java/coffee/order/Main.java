package coffee.order;

public class Main {
    static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Me");
        coffeeOrderBoard.add("Super man");
        coffeeOrderBoard.add("worker");
        coffeeOrderBoard.add("not me");

        coffeeOrderBoard.draw();
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver(4);
        coffeeOrderBoard.draw();

        coffeeOrderBoard.deliver(50);
    }
}
