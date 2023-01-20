package com.nrk.yathra.server.repo;

import com.nrk.yathra.server.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Integer> {
    List<Posts> findAllByUserId(int userId);
}
