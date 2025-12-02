package hello.core.member;

public interface MemberRepository {

    void save(Member member);

    // 会員のIDを検索
    Member findById(Long memberId);
}
