package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
                System.out.println("Hello world!");
                Main m = new Main();

                ArrayList<Shape> shapes = new ArrayList<>();
                shapes.add(new Shape());
                shapes.add(new Circle());
                shapes.add(new Circle());
                shapes.add(new Circle());
                System.out.println(increment(shapes));
            }

            public static String increment(ArrayList<Shape> a){
                Square b = new Square();
                Circle c = new Circle();
                int countCircle = 0;
                int countSquare = 0;
                for (int i = 0; i < a.size(); i++) {
                    if (a.get(i).getClass() == b.getClass()){
                        countSquare++;
                    }else if (a.get(i).getClass() == c.getClass()){
                        countCircle++;
                    }
                }
                if (countSquare > countCircle)
                    return "Square";
                else if (countSquare < countCircle)
                    return "Circle";
                else if (countSquare == countCircle)
                    return "null";
                else
                    return "";
            }

}

