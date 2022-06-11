package com.example.tuwaiqevent_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Admin implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "username most be required")
    private String username;
    @NotEmpty(message = "username most be required")
    private String password;
    @NotEmpty(message = "Role is required")
    private String role;
   @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
   @JsonIgnore
   private Set<Event> event;


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
