import dto.ProductDto;
import entity.Product;
import repository.ProductDtoImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ProductDto product = new ProductDtoImpl();

        // agregar nuevo producto
        product.insert(new Product(100, "Arroz", 1.50));

        // obtener el producto con ID = 100
        Product p = product.read(3);
        System.out.println(p);
        Product p1 = product.read(100);
        System.out.println(p1);

        // eliminar el producto con ID = 100
        product.delete(100);
    }
}
