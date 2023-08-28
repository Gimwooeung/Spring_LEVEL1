package com.sparta.level1.dto;

import com.sparta.level1.entity.Api;
import lombok.Getter;

@Getter
public class ResponseDto {
    private Long id;
    private String title;
    private String author;
    private String pw;
    private String contents;
    private String time;

    public ResponseDto(Api api) {
        this.id = api.getId();
        this.title = api.getTitle();
        this.author = api.getAuthor();
        this.pw = api.getPw();
        this.contents = api.getContents();
        this.time = api.getTime();
    }
    public ResponseDto(Long id, String title, String author, String pw, String contetns, String time) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pw = pw;
        this.contents = contetns;
        this.time = time;
    }
}
