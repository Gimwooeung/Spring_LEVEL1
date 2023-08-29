package com.sparta.level1.dto;

import lombok.Getter;

@Getter
public class RequestDto {
    private Long id;
    private String title;
    private String author;
    private String password;
    private String content;
}