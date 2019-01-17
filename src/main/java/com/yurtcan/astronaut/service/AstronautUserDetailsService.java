package com.yurtcan.astronaut.service;

import com.yurtcan.astronaut.model.User;
import com.yurtcan.astronaut.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AstronautUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    User user = userRepository.findByUserName(username);

    AstronautUserDetails userDetails;
    if (user != null) {
      userDetails = new AstronautUserDetails();
      userDetails.setUser(user);
    } else {
      throw new UsernameNotFoundException("Cannot find user with name: " + username);
    }
    return userDetails;
  }
}
