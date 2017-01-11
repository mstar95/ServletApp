package managers;

import model.Product;

import java.util.*;

/**
 * Created by mstarosta on 04.01.17.
 */
public class ProductMemoryManagerImpl implements ProductManager
{
    private static Map<Integer,Product> products = new HashMap<Integer,Product>(0);
    private static Integer PK = 0;

    public List<Product> getProductsList() {
        return new ArrayList<Product>(products.values());
    }

    public Product getProductByPK(Integer PK) {
        Product product = products.get(PK);
        return product;
    }

    public void insertProduct(Product product)
    {
        product.setPK(PK++);
        products.put(product.getPK(),product);
    }

    public void updateProduct(Product product)
    {
        Product productToUpdate = getProductByPK(product.getPK());
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
    }

    public void deleteProduct(Product product)
    {
        products.remove(product.getPK());
    }
}
