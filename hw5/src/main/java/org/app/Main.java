package org.app;

public class Main {

    public static void main(String[] args) {
        // Отримуємо вхідні дані
        String[] data = getData();

        // Формуємо об'єкт з вхідних даних
        Product product = new Product(data[0],
                Integer.parseInt(data[1]),
                Double.parseDouble(data[2]));

        // Розраховуємо базову вартість товару
        CalcCostBase costBase = new CalcCostBase();
        double baseCost = costBase.calcCost(product);

        // Розраховуємо вартість товару, з урахуванням доставки
        CalcCostDelivery costDelivery = new CalcCostDelivery();
        double deliveryCost = costDelivery.calcCost(product);

        // Виводимо результат
        getOutput(prepareOutput(product, baseCost));
        getOutput(prepareOutput(product, deliveryCost));
    }

    // Набір вхідних даних
    public static String[] getData() {
        return new String[] {"abc", "5", "2.5"};
    }

    public static String prepareOutput(Product product, double cost){
        // Формуємо виведення
        return product + "\nCost is " +
                Constants.CURRENCY + " " + cost + ".";
    }

    public static void getOutput(String output) {
        System.out.println(output);
    }
}