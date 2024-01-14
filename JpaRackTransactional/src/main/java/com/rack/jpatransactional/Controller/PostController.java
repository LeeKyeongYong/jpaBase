package com.rack.jpatransactional.Controller;


import com.rack.jpatransactional.entity.Post;
import com.rack.jpatransactional.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{id}")
    public Post showDetail(@PathVariable Long id){
        return postService.findById(id).orElse(null);
    }
}
