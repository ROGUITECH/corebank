package com.rogui.oauth.vo;

import java.io.Serializable;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class User implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	private long id;
	private String nome;
	private String email;
	private String password;

	private Set<Role> roles = new HashSet<Role>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(x -> new SimpleGrantedAuthority(x.getRoleName())).collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return this.email;
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
