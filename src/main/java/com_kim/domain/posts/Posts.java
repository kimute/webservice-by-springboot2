package com_kim.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {
    //Spring DATA Jpa
    //PK field: @id
    //Generated Value:auto incrementのため作成
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column*:columnの詳細の設定をする時に使用
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    //@Columnを付けなくてもclassのfiledはcolumnになる
    private String author;

    //setterメソッドは使わない：混乱を防ぐため
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }



}
