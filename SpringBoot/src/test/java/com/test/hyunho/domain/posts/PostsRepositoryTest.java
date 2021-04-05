package com.test.hyunho.domain.posts;

import org.junit.After ;
import org.junit.Test ;
import org.junit.runner.RunWith ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List ;

import static org.assertj.core.api.Assertions.assertThat ;

@RunWith( SpringRunner.class )  //  JUnit 과 SpringBoot 연결
@SpringBootTest //  h2 데이터베이스 자동 사용
public class PostsRepositoryTest {

    @Autowired  //  스프링 빈( bean ) 선언
    PostsRepository postsRepository ;

    @After  //  단위테스트시에 테스트간의 데이터 침범을 막기위해 삭제시키고 실행 같은거다.
    public void cleanup() {
        postsRepository.deleteAll() ;
    }

    @Test
    public void 게시글저장_불러오기() {
        //  given
        String title = "테스트 게시글" ;
        String content = "테스트 본문" ;

        postsRepository.save(   //  테이블 Posts insert/update 실행 id값이 이미 있는거면 update
           Posts.builder()
                .title( title )
                .content( content )
                .author( "testHyunho@gamil.com" )
                .build()
        ) ;

        //  when
        List<Posts> postsList = postsRepository.findAll() ; //  posts 테이블 모든 데이터 조회

        //  then
        Posts posts = postsList.get( 0 ) ;
        assertThat( posts.getTitle() ).isEqualTo( title ) ;
        assertThat( posts.getContent() ).isEqualTo( content ) ;

    }
}



/*
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}

 */