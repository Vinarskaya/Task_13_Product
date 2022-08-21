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

    Product item1 = new Smartphone(1, "Телефон1", 55_000, "Company1");
    Product item2 = new Book(2, "Book1", 1_000, "Author1");
    Product item3 = new Book(3, "Book2", 1_500, "Author2");
    Product item4 = new Book(4, "Book3", 1_600, "Author1");
    Product item5 = new Smartphone(5, "Телефон2", 50_000, "Company2");
    Product item6 = new Smartphone(6, "Телефон3", 56_000, "Company2");
    Product item7 = new Smartphone(7, "Телефон4", 20_000, "Company3");

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
    public void shouldSearchByTextBook() {

        Product[] expected = {item2, item3, item4};
        Product[] actual = manager.searchBy("Book");

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
}
