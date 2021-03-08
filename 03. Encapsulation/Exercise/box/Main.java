package box;

public class Main {
    public static void main(String[] args) {

        Box box = new Box(2, 3, 4);

        System.out.println(box.calculateLateralSurfaceArea());
        System.out.println(box.calculateSurfaceArea());
        System.out.println(box.calculateVolume());


    }
}
