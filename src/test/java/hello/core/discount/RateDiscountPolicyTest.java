package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIPは10%割引が適応される。")
    void vip_o() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        // when　
        int discount = rateDiscountPolicy.discount(member, 1000);
        // then 検証
        assertThat(discount).isEqualTo(100);
    }

    // 失敗テスト
    @Test
    @DisplayName("VIPではない場合、割引は適応されない。")
    void vip_x() {
        // given
        Member member = new Member(1L, "memberBASIC", Grade.BASIC);
        // when
        int discount = rateDiscountPolicy.discount(member, 1000);
        // then
        assertThat(discount).isEqualTo(0);
    }
}