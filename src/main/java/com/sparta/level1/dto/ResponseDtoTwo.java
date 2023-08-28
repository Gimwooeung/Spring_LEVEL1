package com.sparta.level1.dto;

import lombok.Getter;

@Getter
public class ResponseDtoTwo {
        private String title;
        private String author;
        private String contents;
        private String time;
    public ResponseDtoTwo(String title, String author, String contetns, String time) {
        this.title = title;
        this.author = author;
        this.contents = contetns;
        this.time = time;
    }
}
