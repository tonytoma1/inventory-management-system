package com.tony.inventory.management.data.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Represents the role table in the database.
 * @author Tony Toma
 */
@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private Integer roleId;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="role_id")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
