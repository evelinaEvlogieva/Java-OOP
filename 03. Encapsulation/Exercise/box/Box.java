package box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        validateDimension(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        validateDimension(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        validateDimension(height, "Height");
        this.height = height;
    }


    public double calculateSurfaceArea() {
        return calculateLateralSurfaceArea() + 2 * this.length * this.width;
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    private void validateDimension(double dimension, String nameDimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException(nameDimension + " cannot be zero or negative.");
        }
    }
}
