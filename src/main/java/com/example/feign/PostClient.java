package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//name은 서비스 디스커버리 사용 시 호출되는 마이크로서비스 이름에 해당.
//그렇지 않을 경우, 구체적인 네트워크 주소를 갖는 url 속성과 함께 사용된다. 
@FeignClient(name = "post-api", url = "${feign.post-api.url}")  
public interface PostClient {
  
  @GetMapping("/posts/{id}")
  Post findById(@PathVariable("id") Long id); 

}
