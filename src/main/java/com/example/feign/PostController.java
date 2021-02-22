package com.example.feign;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostController {
  
  private final PostClient postClient; 

  @PostMapping("/feign")
  public Post feignTest() {
    System.out.println("### feignTest가 시작됨 ###");
    Post post = postClient.findById(2L);
    System.out.println("Feign을 이용한 호출 결과 : " + post.toString());

    return post; 
  }

  @PostMapping("/restTemplate")
  public Post restTempleate() {
    System.out.println("### restTempleate 시작됨 ###");
    RestTemplate restTemplate = new RestTemplate();
    Post post = restTemplate.getForObject("http://localhost:8080/posts/2", Post.class);
    System.out.println("RestTemplate을 이용한 호출 결과 : " + post.toString()); 
    return post; 
    
  }


  @GetMapping("/posts/{id}")
  public Post getPostId(@PathVariable("id") long id) {
    System.out.println("### getPostId가 시작됨 ###");
    Post post = new Post();
    post.setContents("내용");
    post.setId(3);
    post.setTitle("제목");
    return post; 
  }

}
