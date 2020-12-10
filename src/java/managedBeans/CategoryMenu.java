package managedBeans;

import EJB_session.CategorySB;
import JPA_entities.Category;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named(value = "categoryMenu")
@ApplicationScoped
public class CategoryMenu 
{
    List<Category> categories;
    @EJB private CategorySB categorySB;
    
    @PostConstruct
    public void loadCategories()
    {
        categories = categorySB.findCategories();
    }
    public List<Category> getCategories()
    {
        return categories;
    }
}
