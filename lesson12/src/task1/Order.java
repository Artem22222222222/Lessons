package task1;

public class Order {
    private Product[] products;
    private int orderSize = 10;
    private int lenOrder = 0;
    String client;
    String address;
    boolean isPaid;
    public Order(String client, String address, boolean isPaid) {
        this.client = client;
        this.address = address;
        this.isPaid = isPaid;
        this.products = new Product[orderSize];
    }



    public void add(Product product){
        if (lenOrder < orderSize) {
            products[lenOrder] = product;
            lenOrder++;
        }else {
            System.out.println("error, too many products");
        }
    }
    public void remove(String productName){
        for (int i = 0; i < lenOrder; i++) {
            if (productName.equals(products[i].getName())){
                products[i] = null;
            }
        }
        clear();
        lenOrder--;
    }
    private void clear(){
        Product[] products2;
        products2 = new Product[orderSize];
        int index = 0;
        for (int i = 0; i < products.length; i++){
            if (products[i] != null){
                products2[index] = products[i];
                index += 1;
            }
        }
        this.products = products2;
    }
    public void myOrder(){
        int sum = 0;
        if (isPaid) {
            System.out.println("Оплачено");
        }else {
            System.out.println("Не оплачено");
        }
        for (int i = 0; i < lenOrder; i++){
            System.out.println(products[i].getName());
            System.out.println("кількість: "+products[i].getCount());
            sum += products[i].getCost()*products[i].getCount();
        }
        System.out.println("Разом: "+sum);
    }
}
