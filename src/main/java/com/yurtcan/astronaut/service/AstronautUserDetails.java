package com.yurtcan.astronaut.service;

import java.util.Collection;
import java.util.stream.Collectors;

import com.yurtcan.astronaut.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
public class AstronautUserDetails implements UserDetails {

  private static final long serialVersionUID = 1256711395932122675L;
  private User user;

//  @Override
//  public Collection<? extends GrantedAuthority> getAuthorities() {
//
//    return user.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role))
//            .collect(Collectors.toList());
//
//  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUserName();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
