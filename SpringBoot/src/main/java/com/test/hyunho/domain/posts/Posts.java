package com.test.hyunho.domain.posts;

import lombok.Builder ;
import lombok.Getter ;
import lombok.NoArgsConstructor ;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //  lombok , 모든필드의 get 자동추가
@NoArgsConstructor  //  lombok , 기본생성자 자동추가
@Entity //  테이블 링크될 클래스 선언
public class Posts {

    @Id //  PK
    @GeneratedValue( strategy = GenerationType.IDENTITY )   //  PK 생성규칙 선언 autoIncrement
    private Long id ;   //  MYSQL 기준 LONG 이면 bigint 된다.

    @Column( length = 500 , nullable = false )
    private String title ;

    @Column( columnDefinition = "TEXT" , nullable = false )
    private String content ;

    private String author ; //  @Column 선언 안해서 기본값인 VARCHAR( 255 )

    @Builder    //  해당클래스의 빌더 패턴 클래스 생성
    public Posts( String title , String content , String author ) {
        this.title = title ;
        this.content = content ;
        this.author = author ;
    }
}