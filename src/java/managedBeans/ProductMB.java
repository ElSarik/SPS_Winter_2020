package managedBeans;

import EJB_session.ProductSB;
import JPA_entities.Product;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "productMB")
@RequestScoped
public class ProductMB 
{
    @EJB
    private ProductSB productCatalog;
    List<Product> products;
    
    public List<Product> getProducts()
    {
        //return productCatalog.findProducts();
        return products;
    }
    public void loadProductsPreRender()
    {
        products = productCatalog.findProducts();
    }
}
