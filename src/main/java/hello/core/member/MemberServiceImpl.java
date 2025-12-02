package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 会員を登録し、検索するためには、MemberRepositoryが必要
    private final MemberRepository memberRepository = new MemoryMemberRepository(); // 実装体を選択

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
