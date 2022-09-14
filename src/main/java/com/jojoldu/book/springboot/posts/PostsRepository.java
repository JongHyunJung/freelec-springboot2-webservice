package com.jojoldu.book.springboot.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository < Entity class, PK 타입>
// @Repository 추가할 필요 x
// Entity 클래스와 기본 Entity Repository 는 함께 위치해야 함

public interface PostsRepository extends JpaRepository<Posts, Long> {}