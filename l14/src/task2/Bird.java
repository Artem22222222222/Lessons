package task2;

import task2.Animals;

public class Bird implements Animals {
    @Override
    public void sound() {
        System.out.println("*sings*");
    }

    @Override
    public String meal() {
        return "bread";
    }
}
