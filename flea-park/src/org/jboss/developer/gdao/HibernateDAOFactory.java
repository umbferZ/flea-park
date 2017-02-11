package org.jboss.developer.gdao;

import org.hibernate.classic.Session;


public class HibernateDAOFactory extends DAOFactory {

    public ItemDAO getItemDAO() {
        return (ItemDAO) instantiateDAO(ItemDAOHibernate.class);
    }

    public CategoryDAO getCategoryDAO() {
        return (CategoryDAO) instantiateDAO(CategoryDAOHibernate.class);
    }

    public CommentDAO getCommentDAO() {
        return (CommentDAO) instantiateDAO(CommentDAOHibernate.class);
    }

    public ShipmentDAO getShipmentDAO() {
        return (ShipmentDAO) instantiateDAO(ShipmentDAOHibernate.class);
    }

    private GenericHibernateDAO instantiateDAO(Class daoClass) {
        try {
            GenericHibernateDAO dao = (GenericHibernateDAO) daoClass.newInstance();
            dao.setSession(getCurrentSession());
            return dao;
        } catch (Exception ex) {
            throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
        }
    }

    // You could override this if you don't want HibernateUtil for lookup
    protected Session getCurrentSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    // Inline concrete DAO implementations with no business-related data access
    // methods.
    // If we use public static nested classes, we can centralize all of them in
    // one source file.

    public static class CommentDAOHibernate extends GenericHibernateDAO<Comment, Long> implements CommentDAO {}

    public static class ShipmentDAOHibernate extends GenericHibernateDAO<Shipment, Long> implements ShipmentDAO {}

}