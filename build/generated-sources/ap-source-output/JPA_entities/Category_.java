package JPA_entities;

import JPA_entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-01T14:23:05")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> name;
    public static volatile SingularAttribute<Category, Short> id;
    public static volatile ListAttribute<Category, Product> productList;

}