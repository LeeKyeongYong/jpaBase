package com.rack.jpatransactional.service;


import com.rack.jpatransactional.entity.Post;
import com.rack.jpatransactional.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    public Optional<Post> findById(Long id){
        return postRepository.findById(id);
    }

    public List<Post> findByUsername(String username) {
        //postRepository.findById(1L);
        //postRepository.findByUsername(username);
        return postRepository.findByUsername(username);
    }

    //@SneakyThrows
    public Optional<Post> findWithShareLockById(Long id) {
            //postRepository.findWithShareLockById(id);
            //Thread.sleep(1000);
            return postRepository.findWithShareLockById(id);
    }

    @SneakyThrows
    @Transactional
    public Optional<Post> findWithwriteLockById(Long id) {
        Thread.sleep(1000);
        return postRepository.findWithwriteLockById(id);
    }

    public Post modifyOptimistic(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setUsername(post.getUsername()+"!");
        return post;
    }
}
