package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPQL : select m from Member m where m.name = ?
    //메서드 이름만으로 개발이 가능하다. 단순한 쿼리는 이렇게 메서드의 이름으로 가능하다. 마법!
    @Override
    Optional<Member> findByName(String name);
}
