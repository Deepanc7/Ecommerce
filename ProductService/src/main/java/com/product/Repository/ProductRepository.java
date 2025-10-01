package com.product.Repository;

import com.product.Entity.Category;
import com.product.Entity.Product;
import com.product.Util.HibernateUtil;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

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

    @Transactional
    public Category addCategory(Category category) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(category);
            tx.commit();
            return category;
        }
    }

}
