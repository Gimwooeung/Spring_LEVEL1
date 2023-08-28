package com.sparta.level1.entity;

import com.sparta.level1.dto.RequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Api {
    private Long id;
    private String title;
    private String author;
    private String pw;
    private String contents;
    private String time;

    public Api(Long id, String title, String author, String pw, String contents, String time) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pw = pw;
        this.contents = contents;
        this.time = time;
    }

    public Api(RequestDto requestDto) {
        this.id = requestDto.getId();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.author = requestDto.getAuthor();
        this.pw = requestDto.getPw();
        this.time = requestDto.getTime();
    }

    public void update(RequestDto requestDto) {
        this.id = requestDto.getId();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.author = requestDto.getAuthor();
        this.time = requestDto.getTime();
    }
}
