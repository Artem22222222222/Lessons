package org.example;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Cart {
    static String command;
    static String[] splitedCommand;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org/example");
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Loading is finished");
        label:
        while (true) {
            command = scanner.nextLine();
            splitedCommand = command.split(" ");
            switch (splitedCommand[0]) {
                case "add":
                    Product product = new Product(Integer.parseInt(splitedCommand[1]), splitedCommand[2], Double.parseDouble(splitedCommand[3]));
                    productRepository.addProduct(product);
                    break;
                case "delete":
                    productRepository.deleteProductById(Integer.parseInt(splitedCommand[1]));
                    break;
                case "Get":
                    System.out.println(productRepository.getAllProducts());
                    break;
                case "Stop":
                    break label;
            }

        }
    }
}
