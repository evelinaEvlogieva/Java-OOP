import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InstockTest {
    private static final String[] LABELS = {"D", "C", "B", "A", "E"};


    private Instock instock;
    private static final Product PRODUCT = new Product("Cosmos", 3.14, 2);

    @Before
    public void setUp() {
        this.instock = new Instock();
    }

    @Test
    public void getCountShouldReturnZeroInEmptyStock() {
        int count = instock.getCount();
        assertEquals(0, count);
    }

    @Test
    public void addingProductsShouldIncreaseCount() {
        this.instock.add(PRODUCT);
        assertEquals(1, instock.getCount());
    }

    @Test
    public void containsShouldReturnTrueWhenProductIsPresen() {
        this.instock.add(PRODUCT);
        assertTrue(this.instock.contains(PRODUCT));
    }

    @Test
    public void containsShouldReturnFalseWhenProductIsPresen() {
        this.instock.add(PRODUCT);
        assertFalse(this.instock.contains(new Product("Luna", 3.14, 2)));
    }

    @Test
    public void findShouldReturnCorrectProductAccordingToInsertionOreder() {
        fillWithRandomProducts();
        int order = LABELS.length / 2;
        Product returnedProduct = this.instock.find(order);
        assertEquals(LABELS[order], returnedProduct.getLabel());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findWithInvalidIndexShouldThrowExeption() {
        fillWithRandomProducts();
        this.instock.find(LABELS.length);
    }

    private void fillWithRandomProducts() {
        for (int i = 0; i < LABELS.length; i++) {
            this.instock.add(new Product(LABELS[i], 12.50, i));
        }
    }

    @Test
    public void changeQuantityShouldChangeQuantity() {
        this.instock.add(PRODUCT);
        this.instock.changeQuantity(PRODUCT.getLabel(), 69);
        assertEquals(69, PRODUCT.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeQuantityShouldThrowExceptionWhenTheProductIsInvalid() {
        this.instock.add(PRODUCT);
        this.instock.changeQuantity(PRODUCT.getLabel() + "123", 69);
    }

    @Test
    public void findByLabelShouldReturnTheProductWithGivenLabel() {
        this.instock.add(PRODUCT);
        Product byLabel = this.instock.findByLabel(PRODUCT.getLabel());
        assertEquals(byLabel, PRODUCT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByLabelShouldThrowExeptionWhenTheLabelIsInvalid() {
        this.instock.add(PRODUCT);
        this.instock.findByLabel(PRODUCT.getLabel() + "123");

    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnEmptyCollectionWithOutOfRangeArgument() {
        fillWithRandomProducts();
        Iterable<Product> products = this.instock.findFirstByAlphabeticalOrder(LABELS.length + 1);
        int count = 0;
        for (Product product : products) {
            count++;
        }
        assertEquals(0, count);
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnCorrectCountOfProducts() {
        fillWithRandomProducts();
        Iterable<Product> products = this.instock.findFirstByAlphabeticalOrder(LABELS.length);
        int count = 0;
        for (Product product : products) {
            count++;
        }
        assertEquals(LABELS.length, count);
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnElementsInCorrectOrder(){
        fillWithRandomProducts();
        Iterable<Product> products = this.instock.findFirstByAlphabeticalOrder(LABELS.length);

        Arrays.sort(LABELS);

        String[] arr = new String[LABELS.length];
        int index = 0;
        for (Product product : products) {
            arr[index++] = product.getLabel();
        }

        assertArrayEquals(LABELS, arr);
    }


}