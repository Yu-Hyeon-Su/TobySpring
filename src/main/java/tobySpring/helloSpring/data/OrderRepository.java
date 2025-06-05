package tobySpring.helloSpring.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import tobySpring.helloSpring.order.Order;

import java.math.BigDecimal;

public class OrderRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }
}
