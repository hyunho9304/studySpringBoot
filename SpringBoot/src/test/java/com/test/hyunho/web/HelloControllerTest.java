package com.test.hyunho.web;

import org.junit.Test ;
import org.junit.runner.RunWith ;                                           //  JUnit 과 스프링 연결
import org.springframework.beans.factory.annotation.Autowired ;             //  빈 사용
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest ; //  Web 컨트롤러 테스트 사용
import org.springframework.test.context.junit4.SpringRunner ;
import org.springframework.test.web.servlet.MockMvc ;                       // GET , POST 에 대한 API 테스트 가능
import org.springframework.test.web.servlet.ResultActions ;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get ;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content ;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status ;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith( SpringRunner.class )  //  JUnit 과 SpringBoot 연결
@WebMvcTest( controllers = HelloController.class )  //  Web 컨트롤러 테스트에 사용
public class HelloControllerTest {

    @Autowired  //  스프링 빈( bean ) 선언
    private MockMvc mvc ;   //  MVC 테스트 사용 , GET , POST 에 대한 API 테스트 가능

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello" ;

        mvc.perform( get("/hello" ) ) //  /hello URI 로 GET 요청
                .andExpect( status().isOk() )   //  status 번호 검증 isOk = 200
                .andExpect( content().string( hello ) ) ;   //  내용이 hello 맞는지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {

        String name = "hello" ;
        int amount = 1000 ;

        mvc.perform(
                get("/hello/dto" )
                        .param( "name" , name )
                        .param( "amount" , String.valueOf( amount ))
        )
                .andExpect( status().isOk() )
                .andExpect( jsonPath( "$.name" , is( name )))
                .andExpect( jsonPath( "$.amount" , is( amount ))) ;
    }
}


/*
import com.jojoldu.book.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }
)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                    get("/hello/dto")
                            .param("name", name)
                            .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
 */