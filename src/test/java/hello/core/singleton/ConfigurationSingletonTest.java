package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        //すべて同様インスタンスを参照している
//        MemberRepository memberRepository1 = memberService.getMemberRepository();
//        MemberRepository memberRepository2 = orderService.getMemberRepository();
//        System.out.println("memberService -> memberRepository = " + memberRepository1);
//        System.out.println("orderService -> memberRepository = " + memberRepository2);

        System.out.println("memberService -> memberRepository" + memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository" + orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);

        //同様インスタンスを参照している
        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }
}
