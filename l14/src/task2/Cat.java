package task2;

public class Cat extends Pet {
    @Override
    public void sound() {
        System.out.println("Mr");
    }

    @Override
    public String meal() {
        return "milk";
    }
    public void eat(){
        sound();
        System.out.println("I am eating "+meal());
    }
}
