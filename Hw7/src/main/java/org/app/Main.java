package org.app;

import java.util.Scanner;

public class Main {

    static double balance;

    public static void main(String[] args) {
        balance = validateAmount(getBalance(), getAmount());
    }

    private static double getBalance() {
        return 1000.00; // Наявні кошти на рахунку
    }

    private static double getAmount() {
        System.out.printf("Balance is USD %.2f.%n" +
                "Enter purchase amount, USD: ", balance);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    // Метод валідації наявних коштів
    private static double validateAmount(double balance, double withdrawal) {
        if (withdrawal > balance) {
            try {
                throw new FundsException("Insufficient funds!");
            } catch (FundsException ex) {
                System.out.println(ex.getMessage());
                return balance;
            }
        } else {
            System.out.printf("Funds are OK. Purchase paid." +
                    "%nBalance is USD %.2f", getBalance(balance, withdrawal));
            return getBalance(balance, withdrawal);
        }
    }

    // Метод розрахунку наявних коштів на рахунку
    // після зняття певної суми коштів
    private static double getBalance(double balance, double withdrawal) {
        return balance - withdrawal;
    }
}
