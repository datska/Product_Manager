package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "The adventures of Sherlock Holmes", 300, "Aurtur Conan Doyle");
    private Book secondBook = new Book(2, "Dumb Witness", 200, "Agatha Christie");
    private Smartphone firstSmartphone = new Smartphone(3, "12 X", 79_990, "Apple");
    private Smartphone secondSmartphone = new Smartphone(4, "13 Pro", 15_990, "Apple");

    @BeforeEach
    void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
    }

    @Test
    public void shouldGetAll() {
        Product[] expected = new Product[]{firstBook, secondBook, firstSmartphone, secondSmartphone,};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindByBookTitle() {
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("The adventures of Sherlock Holmes");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindBySmartphoneTitle() {
        Product[] expected = new Product[]{secondSmartphone};
        Product[] actual = manager.searchBy("13 Pro");
        assertArrayEquals(expected, actual);
    }

}
