import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(1, "Алиса в Стране чудес", 10, "Льюис Кэрролл");
    Product book1 = new Book(2, "Волшебник Изумрудного города", 500, "Александр Волков");
    Product book3 = new Book(3, "Цветик семицветик", 0, "Валентин Катаев");
    Product book4 = new Book(7, "Алиса в Зазеркалье", 800, "Льюис Кэрролл");
    Product smartphone = new Smartphone(4, "galaxy S22", 25000, "Samsung");

    @Test
    public void saveElements() {

        repository.save(book);
        repository.save(book1);
        repository.save(book3);
        repository.save(book4);
        repository.save(smartphone);

        Product[] expected = {book, book1, book3, book4, smartphone};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdElements() {

        repository.save(book);
        repository.save(book1);
        repository.save(book3);
        repository.save(book4);
        repository.save(smartphone);
        repository.removeById(7);

        Product[] expected = {book, book1, book3, smartphone};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

}
