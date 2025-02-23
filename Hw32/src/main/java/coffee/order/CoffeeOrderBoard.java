package coffee.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.management.Query;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CoffeeOrderBoard {
    private static final Logger logger = LogManager.getLogger(CoffeeOrderBoard.class);
    private int lastOrder = 1;
    private ArrayList<Order> orders = new ArrayList<>();
    public void add(String name){
        Order newOrder = new Order(lastOrder, name);
        orders.add(newOrder);
        lastOrder++;
        logger.info("Added order");
        logger.debug(STR."Added order: \{newOrder}");
    }
    public Order deliver(){
        Order deliveredOrder = orders.getFirst();
        orders.remove(deliveredOrder);
        logger.info("Delivered order");
        logger.debug(STR."Delivered order: \{deliveredOrder}");
        return deliveredOrder;
    }
    public Order deliver(int num){
        Optional<Order> optionalOrder = orders.stream().filter(x -> x.getNum() == num).findFirst();
        if (optionalOrder.isPresent()) {
            Order deliveredOrder = optionalOrder.get();
            orders.remove(deliveredOrder);
            logger.info("Delivered order");
            logger.debug(STR."Delivered order: \{deliveredOrder}");
            return deliveredOrder;
        }
        logger.info("Order not found");
        logger.debug(STR."Order with num: \{num} not found");
        logger.error(new NoSuchElementException("Order not found"));
        return null;
    }
    public void draw(){
        System.out.println("Num | Name");
        orders.forEach(System.out::println);
        logger.info("Printed order");
    }
}
