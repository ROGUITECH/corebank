package com.rogui.oauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rogui.oauth.vo.User;

@Component
@FeignClient(name = "rogui-users-app", path = "/users")
public interface UserFeignClient {

	@GetMapping(value = "/search")
	ResponseEntity<User> findByEmail(@RequestParam String email);
}
