package org.jboss.developer.gdao;

import java.util.Collection;

public class CategoryDAOHibernate extends GenericHibernateDAO<Category, Long> implements CategoryDAO {

    public Collection<Category> findAll(boolean onlyRootCategories) {
        if (onlyRootCategories)
            return findByCriteria(Expression.isNull("parent"));
        else
            return findAll();
    }
}