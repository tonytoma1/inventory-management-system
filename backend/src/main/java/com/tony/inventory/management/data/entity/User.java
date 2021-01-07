package com.tony.inventory.management.data.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Represents the user table in the database.
 * @author Tony Toma
 */
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name="is_account_non_expired")
    private Integer isAccountNonExpired;

    @Column(name = "is_credentials_non_expired")
    private Integer isCredentialsNonExpired;
    
    @Column(name = "is_account_non_locked")
    private Integer isAccountNonLocked;

    @Column(name = "is_enabled")
    private Integer isEnabled;

    @ManyToOne
    private Role role;

    public Role getRole() {
        return role;
    }
    
	public Integer getIsAccountNonLocked() {
		return isAccountNonLocked;
	}

	public void setIsAccountNonLocked(Integer isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}



	public void setRole(Role role) {
        this.role = role;
    }

    public Integer getIsAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setIsAccountNonExpired(Integer isAccountNonExpired) {
        this.isAccountNonExpired = isAccountNonExpired;
    }

    public Integer getIsCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setIsCredentialsNonExpired(Integer isCredentialsNonExpired) {
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
