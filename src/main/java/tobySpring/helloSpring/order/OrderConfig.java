package tobySpring.helloSpring.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import tobySpring.helloSpring.data.JpaOrderRepository;
import tobySpring.helloSpring.payment.DataConfig;

@Configuration
@Import(DataConfig.class)
public class OrderConfig {
    @Bean
    public OrderService orderService(JpaTransactionManager jpaTransactionManager) {
        return new OrderService(orderRepository(), jpaTransactionManager);
    }

    @Bean
    public OrderRepository orderRepository() {
        return new JpaOrderRepository();
    }
}
