package com.rack.jpatransactional.repository;

import com.rack.jpatransactional.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
