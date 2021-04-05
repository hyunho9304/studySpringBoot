package com.test.hyunho.web.dto;

import lombok.Getter ;
import lombok.RequiredArgsConstructor ;

@Getter //  선언된 모든 필드이 get 메소드 생성해준다. Like getName , getAmount
@RequiredArgsConstructor    //  final 필드가 포함된 생성자 생성해준다. 없으면 안해준다.
public class HelloResponseDto {

    private final String name ;
    private final int amount ;
}