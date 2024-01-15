package com.rack.jpatransactional.Controller;


import com.rack.jpatransactional.entity.Post;
import com.rack.jpatransactional.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostController {

    private final PostService postService;

    @GetMapping("/{id}")
    public Post showDetail(@PathVariable Long id){
        return postService.findById(id).orElse(null);
    }

    @GetMapping("/findByUsername/{username}")
    public List<Post> findByUsername(@PathVariable String username){
        return postService.findByUsername(username);
    }

    @GetMapping("/findWithShareLockById/{id}")
    public Post findWithShareLockById(@PathVariable Long id){
        return postService.findWithShareLockById(id).orElse(null);
    }

    @GetMapping("/findWithShareLockById/{id}")
    public Post findWithwriteLockById(@PathVariable Long id){
        return postService.findWithwriteLockById(id).orElse(null);
    }

}


