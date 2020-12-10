package EJB_session;

import JPA_entities.Category;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import javax.persistence.Query;

@Stateless
public class CategorySB 
{

    @PersistenceContext(unitName = "ols1_manualPU")
    private EntityManager em;

    public List<Category> findCategories()
    {
        List<Category> cList = new ArrayList();
        
        Query query = em.createNamedQuery("Category.findAll");
        cList = query.getResultList();
        return cList;
    }
    
}
