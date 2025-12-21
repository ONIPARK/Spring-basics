package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //ThreadA: Aユーザー1000円注文
        statefulService1.order("userA", 1000);
        //ThreadB: Bユーザー2000円注文
        statefulService2.order("userB", 2000);

        //ThreadA: ユーザーAの注文金額検索
        int price = statefulService1.getPrice();
        //ThreadA: ユーザーAは1000円を期待したが、2000円出力
        System.out.println("price = " + price);

        assertThat(statefulService1.getPrice()).isEqualTo(2000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}