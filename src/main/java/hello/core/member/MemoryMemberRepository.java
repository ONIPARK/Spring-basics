package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// 実装体(データが未確定)
public class MemoryMemberRepository implements MemberRepository {

    // Repository
    private static Map<Long, Member> store = new HashMap<>(); // 同時性のため、ConcurrentHashMap

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
