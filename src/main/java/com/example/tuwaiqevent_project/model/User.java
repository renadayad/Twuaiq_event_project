package com.example.tuwaiqevent_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.config.web.servlet.headers.HeadersSecurityMarker;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "username most be required")
 @Column(nullable = false,unique = true)
    private String username;

    @NotEmpty(message = "username most be required")
    @Size(min = 2,message = "password more than 2")
    private String password;

    @NotEmpty(message = "phoneNumber most be required")
    private String phoneNumber;
    @Email
    @NotEmpty(message = "email most be required")
    private String email;
    @NotEmpty(message = "Role is required")
    private String role;
  @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
  @JsonIgnore
  private Set<Event>events;

   @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
  @JsonIgnore
  private Set<Payment> payment;



@JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }
@JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
@JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
@JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
@JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
