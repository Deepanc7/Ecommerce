package com.product.Repository;

import com.product.Entity.Product;
import com.product.Util.HibernateUtil;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class ProductRepository {

    @Transactional
    public Product addProduct(Product product) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(product);
            tx.commit();
            return product;
        }
    }

}
