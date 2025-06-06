package tobySpring.helloSpring.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import tobySpring.helloSpring.order.Order;
import tobySpring.helloSpring.order.OrderRepository;

public class JpaOrderRepository implements OrderRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Order order) {
        em.persist(order);
    }
}
