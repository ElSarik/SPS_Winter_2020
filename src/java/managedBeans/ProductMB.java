package managedBeans;

import EJB_session.ProductSB;
import JPA_entities.Product;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

@Named(value = "productMB")
@SessionScoped
public class ProductMB implements Serializable
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
    
    public String prepareCreateProduct()
    {
        product = new Product();
        return "createUpdateProduct";
    }
    
    public String createProduct()
    {
       productSB.persistProduct(getProduct()); //ISOS product ANTI GIA getProduct()
       return "productCatalog";
    }

    public Product getProduct() {
        return product;
    }

//    public void setProduct(Product product) {
//        this.product = product;
//    }
}
