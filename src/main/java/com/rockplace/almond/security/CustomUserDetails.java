package com.rockplace.almond.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.rockplace.almond.domain.User;
import com.rockplace.almond.domain.UserRole;

public class CustomUserDetails extends User implements UserDetails{

	private List<UserRole> userRoles;
	
	public CustomUserDetails(User user) {
		super(user);
		this.userRoles = user.getUserRoles();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roles=StringUtils.collectionToCommaDelimitedString(userRoles);	
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
