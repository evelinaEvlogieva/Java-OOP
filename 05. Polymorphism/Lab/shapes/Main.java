package shapes;

import java.util.logging.SocketHandler;

public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle(5.0, 2.0);
        Shape circle = new Circle(7.0);

        System.out.println(rectangle.calculateArea());
        System.out.println(circle.calculatePerimeter());

    }
}
