package com.phucviet.authorizationserver.model.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl extends User implements UserDetails {

  public UserDetailsImpl(User user) {
    super(
        user.getId(),
        user.getUsername(),
        user.getPassword(),
        user.getEmail(),
        user.isEnabled(),
        user.isAccountNonExpired(),
        user.isCredentialsNonExpired(),
        user.isAccountNonLocked(),
        user.getRoles());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

    getRoles()
        .forEach(
            role -> {
              grantedAuthorities.add(new SimpleGrantedAuthority(role.getName().name()));
              role.getPermissions()
                  .forEach(
                      permission -> {
                        grantedAuthorities.add(
                            new SimpleGrantedAuthority(permission.getName().name()));
                      });
            });
    return grantedAuthorities;
  }

  @Override
  public String getPassword() {
    return super.getPassword();
  }

  @Override
  public String getUsername() {
    return super.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return super.isAccountNonExpired();
  }

  @Override
  public boolean isAccountNonLocked() {
    return super.isAccountNonLocked();
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return super.isCredentialsNonExpired();
  }

  @Override
  public boolean isEnabled() {
    return super.isEnabled();
  }
}
