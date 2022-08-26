package ru.netology.javaqa.product.manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.product.product.Product;
import ru.netology.javaqa.product.product.book.Book;
import ru.netology.javaqa.product.product.smartphone.Smartphone;
import ru.netology.javaqa.product.repo.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Smartphone item1 = new Smartphone(1, "Phone1", 55_000, "Company1");
    Book item2 = new Book(2, "Book1", 1_000, "Author1");
    Book item3 = new Book(3, "Book2", 1_500, "Author2");
    Book item4 = new Book(4, "Book3", 1_600, "Author1");
    Smartphone item5 = new Smartphone(5, "Phone2", 50_000, "Company2");
    Smartphone item6 = new Smartphone(6, "Phone3", 56_000, "Company2");
    Smartphone item7 = new Smartphone(7, "Phone4", 20_000, "Company3");

    @BeforeEach
    public void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
    }

    @Test
    public void shouldSearchByTextBookIfFewProducts() {

        Product[] expected = {item2, item3, item4};
        Product[] actual = manager.searchBy("Book");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTextBookIfOneProduct() {

        Product[] expected = {item4};
        Product[] actual = manager.searchBy("Book3");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTextBookIfZeroProduct() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Телефон5");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowProduct() {
        Product[] expected = {item1, item2, item3, item4, item5, item6};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSave() {
        manager.add(item7);

        Product[] expected = {item1, item2, item3, item4, item5, item6, item7};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveById5() {

        manager.removeById(5);
        Product[] expected = {item1, item2, item3, item4, item6};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowPriceItem6() {

        int expected = 56_000;
        int actual = manager.getPrice(item6);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowMatchesByBookNameIfTrue() {

        boolean expected = true;
        boolean actual = item2.matches("Book1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowMatchesByPhoneNameIfTrue() {

        boolean expected = true;
        boolean actual = item1.matches("Phone1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowMatchesByNameIfFalse() {

        boolean expected = false;
        boolean actual = item2.matches("Phone1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowMatchesByAuthorIsTrue() {

        boolean expected = true;
        boolean actual = item3.matches("Author2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowMatchesByManufacturerIfTrue() {

        boolean expected = true;
        boolean actual = item1.matches("Company1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowMatchesByManufacturerIfFalse() {

        boolean expected = false;
        boolean actual = item1.matches("Company2");

        Assertions.assertEquals(expected, actual);
    }
}
