package com.learning.ticketing.user;

import com.learning.ticketing.common.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService extends BaseService<User> {
  private final UserRepository userRepository;

  public JpaRepository<User, Long> getRepository() {
    return userRepository;
  }

  public User findByEmail(String email) {
    return (userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("User not found")));
  }
}
