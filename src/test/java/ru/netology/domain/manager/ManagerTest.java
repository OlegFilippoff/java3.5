package ru.netology.domain.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.repository.RepositoryOfProducts;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    RepositoryOfProducts repository = new RepositoryOfProducts();
    Manager manager = new Manager(repository);
    Product phone1 = new Smartphone(05, "A52", 150000, "Samsung");
    Product phone2 = new Smartphone(42, "p50", 250000, "Huawei");
    Product book1 = new Book(001, "Над пропастью во ржи", 150, "Селинджер");
    Product book2 = new Book(003,"Война миров", 200, "Уэллс");


    @Test
    void searchByTitle() {
        manager.addItem(phone1);
        manager.addItem(book2);


        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Война миров");

        assertArrayEquals(expected, actual);
    }
    @Test
    void searchByEmpty() {
        Product[] expected = {};
        Product[] actual = manager.getAll();

        assertArrayEquals(expected,actual);
    }
    @Test
    void searchByDoubleAddedItem() {
        manager.addItem(book1);
        manager.addItem(book1);
        Product[] expected = {book1, book1};
        Product[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByModel() {
        manager.addItem(phone2);
        manager.addItem(book2);


        Product[] expected = {phone2};
        Product[] actual = manager.searchBy("Huawei");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByName() {
        manager.addItem(phone2);
        manager.addItem(phone1);


        Product[] expected = {phone2};
        Product[] actual = manager.searchBy("50");

        assertArrayEquals(expected, actual);
    }
    @Test
    void searchByAuthor() {
        manager.addItem(book2);
        manager.addItem(book1);
        manager.addItem(phone1);


        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Селинджер");

        assertArrayEquals(expected, actual);
    }
}