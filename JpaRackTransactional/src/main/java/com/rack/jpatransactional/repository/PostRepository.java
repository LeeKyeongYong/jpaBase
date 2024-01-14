package com.rack.jpatransactional.repository;

import com.rack.jpatransactional.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUsername(String username);
}
