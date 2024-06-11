package com.learning.ticketing.user;

import com.learning.ticketing.common.ApiResponse;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping
  public ResponseEntity<ApiResponse<User>> createUser(@RequestBody User user) {
    user.setRoles(Set.of(Role.CUSTOMER));
    user.setPassword(user.getPassword());
    ResponseEntity<ApiResponse<User>> responseEntity =
        new ResponseEntity<>(ApiResponse.<User>builder().data(userService.create(user)).build(), HttpStatus.CREATED);
    return responseEntity;
  }

}
