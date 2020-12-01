package EJB_session;

import JPA_entities.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;

@Stateless
public class ProductSB 
{

    @PersistenceContext(unitName = "ols1_manualPU")
    private EntityManager em;

    public List<Product> findProducts()
    {        
        return em.createNamedQuery("Product.findAll").getResultList();
    }
    
    public void persist(Object object) 
    {
        em.persist(object);
    }
    
}
