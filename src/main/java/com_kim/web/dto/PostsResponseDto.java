package com_kim.web.dto;

import com_kim.domain.posts.PostRepository;
import com_kim.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    // PostResponseDtoはenitityのfieldの一部を使用する為
    // 以下のように作成
    public PostsResponseDto (Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();

    }
}
