package hello.core.member;

public interface MemberService {

    // 会員登録
    void join(Member member);
    // 会員検索
    Member findMember(Long memberId);
}
