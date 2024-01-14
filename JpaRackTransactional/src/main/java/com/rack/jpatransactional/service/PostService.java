package com.rack.jpatransactional.service;


import com.rack.jpatransactional.entity.Post;
import com.rack.jpatransactional.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    public Optional<Post> findById(Long id){
        return postRepository.findById(id);
    }
}
