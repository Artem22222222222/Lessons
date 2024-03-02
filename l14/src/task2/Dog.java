package task2;

public class Dog extends Pet {
    @Override
    public void sound() {
        System.out.println("R-r-r");
    }

    @Override
    public String meal() {
        return "meat";
    }
    public void eat(){
        sound();
        System.out.println("I am eating "+meal());
    }
}
