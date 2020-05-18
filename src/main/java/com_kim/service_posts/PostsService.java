package com_kim.service_posts;

import com_kim.domain.posts.PostRepository;
import com_kim.domain.posts.Posts;
import com_kim.web.dto.PostListResponseDto;
import com_kim.web.dto.PostSaveRequestDto;
import com_kim.web.dto.PostsResponseDto;
import com_kim.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

//API作成
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

    @Transactional
    public void delete (Long id) {
        Posts posts = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("存在しません！id="+id));

        postRepository.delete(posts);
    }

    // readOnly option: read速度が改善される(CUDは除く)
    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id){
        Posts entity = postRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException(("存在しません！"+id)));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostListResponseDto> findAllDesc(){
        return postRepository.findAllDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }



}
