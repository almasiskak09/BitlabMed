package com.medProject.bitlabMed.entities.User;

import com.medProject.bitlabMed.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Getter
@Setter
@Table(name = "t_permission")
public class Permission extends BaseEntity implements GrantedAuthority {

    @Column(name = "permissionName")
    private String permissionName;

    @Override
    public String getAuthority() {
        return permissionName;
    }
}
