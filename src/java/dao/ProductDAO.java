/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Product;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author cyclingbd007
 */
public class ProductDAO {

    public List<Product> getAllProduct() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            List<Product> list = session.createQuery("FROM Product").list();
            t.commit();
            return list;
        } catch (Exception e) {
            if (!(t == null)) {
                t.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }

    public boolean saveProduct(Product p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;

        try {
            t = session.beginTransaction();
            session.save(p);
            t.commit();
            return true;
        } catch (Exception e) {
            if (!(t == null)) {
                t.rollback();
            }
        } finally {
            session.close();
        }
        return false;
    }

    public boolean updateProduct(Product p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;

        try {
            t = session.beginTransaction();
            session.update(p);
            t.commit();
            return true;
        } catch (Exception e) {
            if (!(t == null)) {
                t.rollback();
            }
        } finally {
            session.close();
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        String hql = "delete from Product where pid = :id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;

        try {
            t = session.beginTransaction();
            Query query = session.createSQLQuery(hql);
            query.setInteger("id", id);
            query.executeUpdate();
            t.commit();
            return true;
        } catch (Exception e) {
            if (!(t == null)) {
                t.rollback();
            }
        } finally {
            session.close();
        }
        return false;
    }

    public Product getProduct(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        Product product = null;
        try {
            t = session.beginTransaction();
            product = (Product) session.get(Product.class, id);
            t.commit();
            return product;
        } catch (Exception e) {
            if (!(t == null)) {
                t.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }

}
