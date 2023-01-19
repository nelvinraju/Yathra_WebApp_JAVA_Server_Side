package com.nrk.yathra.server.repo;

import com.nrk.yathra.server.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Integer> {

}
