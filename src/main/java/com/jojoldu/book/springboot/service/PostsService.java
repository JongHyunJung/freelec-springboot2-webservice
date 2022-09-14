package com.jojoldu.book.springboot.service;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    // update 기능에 쿼리를 날리는 부분이 없음
    // 가능한 이유는 JPA 의 "영속성 컨텍스트" -> 엔티티를 영구 저장하는 환경(일종의 논리적 개념)
    // JPA 의 핵심 내용은 엔티티가 영속성 컨텍스트에 포함되느냐 아니냐로 갈림

    // JPA 엔티티 매니저가 활성화된 상태(기본 옵션)로 트랜잭션 안에서 DB 에서 Data 를 가져오면
    // 이 Data 는 영속성 컨텍스트가 유지된 상태
    // 이 상태에서 해당 Data 값을 변경하면 트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영
    // 즉, Entity 객체 값만 변경하면 별도로 Update 쿼리를 날릴 필요가 없음
    // 이 개념을 "더티 체킹" 이라고 함
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
