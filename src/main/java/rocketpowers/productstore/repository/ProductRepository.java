package rocketpowers.productstore.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import rocketpowers.productstore.model.ProductModel;


public interface ProductRepository extends CrudRepository<ProductModel, Integer>{


    List<ProductModel>findAll();

    ProductModel findByCode(int code);

    void delete(ProductModel product);

    //ProductModel save (ProductModel product);
    <ProdMod extends ProductModel> ProdMod save (ProdMod product);
}
