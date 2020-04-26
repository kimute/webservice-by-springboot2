package com_kim.service_posts;

import com_kim.domain.posts.PostRepository;
import com_kim.domain.posts.Posts;
import com_kim.web.dto.PostSaveRequestDto;
import com_kim.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private  final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();

    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("いません。id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;

    }
}
