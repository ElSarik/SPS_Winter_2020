package managedBeans;

import EJB_session.ProductSB;
import JPA_entities.Category;
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
    private Product product; //= new Product() ;
//    private Product currentProduct;
    private Short categoryID;
    
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
    
    public String deleteProduct(Product p)
    {
//        currentProduct = p;
        productSB.removeProduct(p);
        return "productCatalog";
    }
    
    public String updateProduct()
    {
        Category category = new Category();
        category.setId(categoryID);
        product.setCategory(category);
        
        productSB.updateProduct(product);
        product = null;
        return "productCatalog";
    }
    
    public String prepareUpdateProduct(Product p)
    {
        this.product = p;
        categoryID = product.getCategory().getId();
        return "updateProduct";
    }
    
    public String prepareCreateProduct()
    {
        product = new Product();
        return "createUpdateProduct";
    }
    
    public String createProduct()
    {
        Category category = new Category();
        category.setId(categoryID);
        product.setCategory(category);
        productSB.persistProduct(product); //ISOS product ANTI GIA getProduct()
        return "productCatalog";
    }

    public Product getProduct() {
        return product;
    }

    public Short getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Short categoryID) {
        this.categoryID = categoryID;
    }
}
