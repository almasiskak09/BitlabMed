package com.medProject.bitlabMed.services.implementation;

import com.medProject.bitlabMed.entities.Permission;
import com.medProject.bitlabMed.entities.User;
import com.medProject.bitlabMed.repositories.PermissionRepository;
import com.medProject.bitlabMed.repositories.UserRepository;
import com.medProject.bitlabMed.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            System.out.println(user.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getPermissionName()))
                    .collect(Collectors.toList()));

        return user;
        } else {
            throw new UsernameNotFoundException("User Not Found");
        }
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
    public Boolean signUp(String email, String password, String repeatPassword, String full_name, String phone) {
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
                newUser.setFull_name(full_name);
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

