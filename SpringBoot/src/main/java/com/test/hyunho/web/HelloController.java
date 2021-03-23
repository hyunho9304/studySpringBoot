package com.test.hyunho.web;

import com.test.hyunho.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping ;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController ;



@RestController //  JSON 반환하는 컨트롤러 셋팅 Like @ResponseBody
public class HelloController {

    @GetMapping( "/hello" ) //  HTTP GET Like @RequestMapping( method = RequestMethod.GET )
    public String hello() {

        return "hello" ;
    }

    @GetMapping( "/hello/dto" )
    public HelloResponseDto helloDto(@RequestParam( "name" ) String name , @RequestParam( "amount" ) int amount ) {
        return new HelloResponseDto( name , amount ) ;
    }
}






//import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class HelloController {
//
//    @GetMapping("/hello")
//    public String hello() {
//        return "hello";
//    }
//
//    @GetMapping("/hello/dto")
//    public HelloResponseDto helloDto(@RequestParam("name") String name,
//                                     @RequestParam("amount") int amount) {
//        return new HelloResponseDto(name, amount);
//    }
//
//}

