package com.medProject.bitlabMed.services;
import com.medProject.bitlabMed.dtos.DoctorDto.AppointmentDoctorDto;
import com.medProject.bitlabMed.entities.User.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
    Boolean signUp(String email, String password, String repeatPassword, String fullName, String phone);
    Boolean updatePassword(String oldPassword, String newPassword, String repeatNewPassword);

    List<User> getAllUsers();
    User findById(Long id);
    void deleteById(Long id);
    Boolean addUser(User user);
    User updateUser(User user);
 }
