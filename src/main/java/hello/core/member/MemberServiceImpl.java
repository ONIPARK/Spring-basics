package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    // 会員を登録し、検索するためには、MemberRepositoryが必要
    //private final MemberRepository memberRepository = new MemoryMemberRepository(); // 実装体を選択

    private final MemberRepository memberRepository;

    @Autowired //自動依存関係を注入：ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // Test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
