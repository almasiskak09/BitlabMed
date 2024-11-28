package com.medProject.bitlabMed.services.implementation;

import com.medProject.bitlabMed.dtos.DoctorDto.AppointmentDoctorDto;
import com.medProject.bitlabMed.entities.User.Permission;
import com.medProject.bitlabMed.entities.User.User;
import com.medProject.bitlabMed.mappers.AppointmentDoctorMapper;
import com.medProject.bitlabMed.repositories.AppointmentDoctorRepository;
import com.medProject.bitlabMed.repositories.PermissionRepository;
import com.medProject.bitlabMed.repositories.UserRepository;
import com.medProject.bitlabMed.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AppointmentDoctorRepository appointmentDoctorRepository;

    @Autowired
    private AppointmentDoctorMapper appointmentDoctorMapper;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
       return user;
    }

        private User getCurrentUser(){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if(!(authentication instanceof AnonymousAuthenticationToken)){
                User user = (User) authentication.getPrincipal();
                return user;
            }

            return null;
        }



    @Override
    public Boolean signUp(String email, String password, String repeatPassword, String fullName, String phone) {
        User u = userRepository.findByEmail(email);

        if(u == null) {
            if(password.equals(repeatPassword)){
                List<Permission> permissions = new ArrayList<>();
                Permission simplePermission = permissionRepository.findByPermissionName("ROLE_USER");
                permissions.add(simplePermission);

                User newUser = new User();
                newUser.setEmail(email);
                newUser.setPhone(phone);
                newUser.setPassword(passwordEncoder.encode(password));
                newUser.setFullName(fullName);
                newUser.setRoles(permissions);

                userRepository.save(newUser);

                return true;
            }

            return false;
        }

        return null;
    }

    @Override
    public Boolean updatePassword(String oldPassword, String newPassword, String repeatNewPassword) {
        User currentUser = getCurrentUser();

        if(currentUser != null){
            if(passwordEncoder.matches(oldPassword, currentUser.getPassword())){
                if(newPassword.equals(repeatNewPassword)){
                    currentUser.setPassword(passwordEncoder.encode(newPassword));
                    userRepository.save(currentUser);
                    return true;
                }

                return false;
            }

            return null;
        }

        return null;
    }

    public List<User>getAllUsers(){
        return userRepository.findAll();
    }
    public User findById(Long id){
       return userRepository.findById(id).orElseThrow();

    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public Boolean addUser(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        User newUser = userRepository.save(user);
       return newUser != null;
    }
    public User updateUser(User user){
        return userRepository.save(user);
    }


}

