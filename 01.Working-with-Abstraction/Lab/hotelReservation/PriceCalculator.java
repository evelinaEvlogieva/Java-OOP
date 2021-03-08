package hotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private Discount discount;

    public PriceCalculator(double pricePerDay, int numberOfDays, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discount = discount;
    }

    public double calculatePrice() {
        int multiplier = this.season.getValue();
        double discountMultiplier = this.discount.getValue() / 100.0;

        double priceBeforeDiscount = this.numberOfDays * this.pricePerDay * multiplier;
        double discountedAmount = priceBeforeDiscount * discountMultiplier;

        return priceBeforeDiscount - discountedAmount;
    }
}
