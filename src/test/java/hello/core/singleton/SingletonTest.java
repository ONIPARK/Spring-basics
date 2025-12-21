package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("Springなしの純粋なDIコンテナ")
    void pureContainer() {

        AppConfig appConfig = new AppConfig();

        // 1. 照会：呼び出すたびにオブジェクトを生成
        MemberService memberService1 = appConfig.memberService();

        // 2. 照会：呼び出すたびにオブジェクトを生成
        MemberService memberService2 = appConfig.memberService();

        //参照値が異なることを確認
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("Singleton パターンを適用したオブジェクト使用")
    public void singletonServiceTest() {

        //privateでコンストラクタを防いでおいたので、コンパイルエラーが発生
        //new SingletonService();

        //1. 照会：呼び出したびに、同様オブジェクトを渡す
        SingletonService singletonService1 = SingletonService.getInstance();
        //2. 照会：呼び出したびに、同様オブジェクトを渡す
        SingletonService singletonService2 = SingletonService.getInstance();

        //参照値が同じことを確認
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        // singletonService1 == singletonService2
        assertThat(singletonService1).isSameAs(singletonService2);

        singletonService1.logic();
    }
}


