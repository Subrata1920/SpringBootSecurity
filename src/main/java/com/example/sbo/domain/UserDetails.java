package com.example.sbo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "mst_user",uniqueConstraints = @UniqueConstraint(columnNames="user_name"))
public class UserDetails implements Serializable{

	private static final long serialVersionUID = -6142358483948073924L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column
	private String name;

	@Column(name = "user_name")
	private String username;

	private String password;
	
	private String genpassword;

	@Column(name = "enabled", columnDefinition = "boolean DEFAULT true")
	private boolean enabled = true;
	
	@Column(name = "credentialexpired", columnDefinition = "boolean DEFAULT false")
	private boolean credentialexpired = false;

	@Column(name = "expired", columnDefinition = "boolean DEFAULT false")
	private boolean expired=false;

	@Column(name = "locked", columnDefinition = "boolean DEFAULT false")
	private boolean locked = false;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	public List<Role> roles;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGenpassword() {
		return genpassword;
	}

	public void setGenpassword(String genpassword) {
		this.genpassword = genpassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isCredentialexpired() {
		return credentialexpired;
	}

	public void setCredentialexpired(boolean credentialexpired) {
		this.credentialexpired = credentialexpired;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public UserDetails() {
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", genpassword=" + genpassword + ", enabled=" + enabled + ", credentialexpired=" + credentialexpired
				+ ", expired=" + expired + ", locked=" + locked + ", roles=" + roles + "]";
	}
	
	
}
