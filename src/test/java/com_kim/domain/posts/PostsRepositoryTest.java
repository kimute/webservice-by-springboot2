package com_kim.domain.posts;

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
    PostRepository postRepository;

    @After
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    public void call_posts() {
        //given 値
        String title = "test posts";
        String content = "test contents";
        //insert update query test

        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jkd@gmail.com").build());
        //when
        List<Posts> postsList = postRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_register(){
        //given
        LocalDateTime now = LocalDateTime.of(2020,5,8,0,0,0);
        postRepository.save(Posts.builder().title("title").content("content").author("author").build());

        //when
        List<Posts> postsList = postRepository.findAll();


        //when
        Posts posts = postsList.get(0);
        System.out.println(">>>>>>>>>>> createDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());
        assertThat(posts.getCreatedDate().isAfter(now));
        assertThat(posts.getModifiedDate().isAfter(now));
    }
}
