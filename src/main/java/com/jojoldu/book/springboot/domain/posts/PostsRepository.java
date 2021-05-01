package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/*
- ~batis 등에서 Dao라고 불리는 DB Layer 접근자. JPA에선 Repository 라고 부르며 인터페이스로 생성한다.
- JpaRepository<Entity 클래스, PK 타입> 을 상속하면 기본적인 CRUD 메소드가 자동 생성된다.
- @Repository 어노테이션을 추가할 필요도 없다.
- Entity클래스와 기본 Entity Repository는 함께 위치해야 한다. 밀접한 관계이기 때문이다. 따라서 도메인 패키지에서 함께 관리한다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
