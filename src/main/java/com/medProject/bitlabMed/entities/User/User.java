package com.medProject.bitlabMed.entities.User;

import com.medProject.bitlabMed.entities.Analyzes.ApplicationAnalyzes;
import com.medProject.bitlabMed.entities.BaseEntity;
import com.medProject.bitlabMed.entities.Diagnostic.AppointmentDiagnostic;
import com.medProject.bitlabMed.entities.Doctor.AppointmentDoctor;
import com.medProject.bitlabMed.entities.Doctor.Doctor;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "t_users")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity implements UserDetails {

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Permission> roles;

    @OneToMany (mappedBy = "user",fetch = FetchType.LAZY)
    private List<ApplicationAnalyzes> applicationAnalyzesList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List <AppointmentDoctor> appointmentDoctorList;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<AppointmentDiagnostic> appointmentDiagnosticsList;

    @OneToOne (mappedBy = "user")
    private Doctor doctor;


@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
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