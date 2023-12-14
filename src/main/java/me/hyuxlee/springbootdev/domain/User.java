package me.hyuxlee.springbootdev.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Table(name="users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Builder
    public User(String email, String password, String auth){
        this.email = email;
        this.password = password;
    }
    @Override//권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override//사용자의 ID를 반환(고유한값)
    public String getUsername() {
        return email;
    }
    @Override//사용자의 패스워드 반환
    public String getPassword(){
        return password;
    }

    @Override//계정 만료 여부 반환
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override//계정 잠금 여부 반환
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override//패스워드의 만료 여부 반환
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override//계정 사용 가능 여부 반환
    public boolean isEnabled(){
        return true;
    }
}
