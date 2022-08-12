import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(1, "Алиса в Стране чудес", 10, "Льюис Кэрролл");
    Product book1 = new Book(2, "Волшебник Изумрудного города", 500, "Александр Волков");
    Product book3 = new Book(3, "Цветик семицветик", 0, "Валентин Катаев");
    Product book4 = new Book(7, "Алиса в Зазеркалье", 800, "Льюис Кэрролл");
    Product smartphone = new Smartphone(3, "Samsung", 25000, "Galaxy S22");
    Product smartphone2 = new Smartphone(4, "Apple", 45000, "Iphon 12");

    @Test
    public void FindingElementsByName() {

        manager.add(book);
        manager.add(book1);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone);
        manager.add(smartphone2);

        Product[] expected = new Product[]{book, book4};
        Product[] actual = manager.searchBy("Алиса");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void phoneManufacturerSearch() {

        manager.add(book);
        manager.add(book1);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone);
        manager.add(smartphone2);

        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("Samsung");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNameBook() {

        manager.add(book);
        manager.add(book1);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone);
        manager.add(smartphone2);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Волшебник Изумрудного города");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAll() {

        manager.add(book);
        manager.add(book1);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone);
        manager.add(smartphone2);

        Product[] expected = new Product[]{book, book1, book3, book4, smartphone, smartphone2};
        Product[] actual = manager.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNotFound() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Серый волк");
        Assertions.assertArrayEquals(expected, actual);
    }

}