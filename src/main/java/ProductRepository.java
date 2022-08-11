public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int last = tmp.length - 1;
        tmp[last] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product[] removeById(int id) {
        int length = products.length - 1;
        Product[] plusOne = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                plusOne[index] = product;
                index++;
            }
        }
        products = plusOne;
        return products;
    }
}
