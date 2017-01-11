package managers;
import model.Product;

import java.util.List;

/**
 * Created by mstarosta on 04.01.17.
 */
public interface ProductManager {
     List<Product> getProductsList();
     Product getProductByPK(Integer PK);
     void insertProduct(Product product);
     void updateProduct(Product product);
     void deleteProduct(Product product);
}
