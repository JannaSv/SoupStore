package com.example.demo;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.Ingredient.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Table("USER_TABLE")
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
//@RequiredArgsConstructor
public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id private Long id;
	private String username;
	private String password;
	private String fullname;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String phonenumber;
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	

	@Override
	public String getUsername() {
		return username;
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

	public User(String username2, String encode, String fullname2, String street2, String city2, String state2,
			String zip2, String phone) {
		
		this.username=username2;
		this.password=encode;
		this.city=city2;
		this.fullname=fullname2;
		this.phonenumber=phone;
		this.street=street2;
		this.state=state2;
		this.zip=zip2;
		
		
		// TODO Auto-generated constructor stub
	} 

}

