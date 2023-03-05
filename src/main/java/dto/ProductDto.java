package dto;

import entity.Product;

public interface ProductDto {

    public void insert(Product product);
    public void update(Product product);
    public void delete(Integer id);
    public Product read(Integer id);

}
