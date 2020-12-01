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
    private ProductSB productSB;
    List<Product> products;
    private Product product = new Product() ;
    
    
    
    public ProductMB()
    {
        
    }
    
    public List<Product> getProducts()
    {
        //return productCatalog.findProducts();
        return products;
    }
    
    public void loadProductsPreRender()
    {
        products = productSB.findProducts();
    }
    
    public void createProduct()
    {
       productSB.persistProduct(getProduct()); //ISOS product ANTI GIA getProduct()
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
