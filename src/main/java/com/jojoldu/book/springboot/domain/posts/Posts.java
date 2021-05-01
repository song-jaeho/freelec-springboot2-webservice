package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
자바빈 규약을 생각하면서 getter/setter를 무작정 생성하는 경우가 있다.
Entity 클래스에서는 Setter 메소드를 만들지 않는다.
- 해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 명확하게 구분할 수 없기 때문.
- 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야만 한다.
- 기본적으로 생성자를 통해 최종값을 채운 후 삽입하며, 이 예제에서는 @Builder를 통해 제공되는 빌더 클래스를 이용
 */
@Getter
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity // 테이블과 링크될 클래스임을 명시, 기본값으로 카멜케이스 -> 언더스코어로 매칭한다.
public class Posts extends BaseTimeEntity {

    /*
    웬만하면 Entity의 PK는 Long타입의 Auto_increment를 추천.
    주민등록번호, 복합키 등은 유니크 키로 별도로 추가하는 것을 추천.
     */
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // 빌더를 사용하면 어떤 필드에 어느 값을 채워야 할 지 명확하게 인지할 수 있다.
    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
