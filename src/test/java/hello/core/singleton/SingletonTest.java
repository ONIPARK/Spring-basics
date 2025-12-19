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
}
