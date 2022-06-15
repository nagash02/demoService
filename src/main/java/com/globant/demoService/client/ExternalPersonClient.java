package com.globant.demoService.client;


import com.globant.demoService.model.ResponseData;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "postFeignClient", url = "${client.post.baseUrl}")
public interface ExternalPersonClient {

  @GetMapping("/users")
  List<ResponseData> getData();
}
