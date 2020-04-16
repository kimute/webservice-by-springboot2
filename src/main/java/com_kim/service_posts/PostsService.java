package com_kim.service_posts;

import com_kim.domain.posts.PostRepository;
import com_kim.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private  final PostRepository postRepository;

    @Transactional
    public long save(PostSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();

    }
}
