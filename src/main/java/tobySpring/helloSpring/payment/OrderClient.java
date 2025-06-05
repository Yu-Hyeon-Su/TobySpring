package tobySpring.helloSpring.payment;


import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import tobySpring.helloSpring.data.OrderRepository;
import tobySpring.helloSpring.order.Order;
import tobySpring.helloSpring.order.OrderConfig;
import tobySpring.helloSpring.order.OrderService;

import java.math.BigDecimal;

public class OrderClient {
    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(OrderConfig.class);
        OrderService orderService = beanFactory.getBean(OrderService.class);

        Order order = orderService.createOrder("0100", BigDecimal.TEN);
        System.out.println(order);
    }
}
