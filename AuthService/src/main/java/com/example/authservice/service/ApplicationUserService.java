package com.example.authservice.service;


// t.me/superJavaDeveloper 14.05.2022;


//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity

import com.example.authservice.auth.PasswordEncoder;
import com.example.authservice.dto.UserDto;
import com.example.authservice.entity.User;
import com.example.authservice.entity.UserRole;
import com.example.authservice.entity.enums.ApplicationUserRole;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.repository.UserRoleRepository;
import com.example.authservice.response.CustomResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;


    public CustomResponse register(UserDto userDto) {
        String fullName = userDto.getFullName();
        if (fullName.length() < 3) {
            return new CustomResponse(false, "Fullname must be least 3 characters");
        }

        String username = userDto.getUsername();
        if (userRepository.existsByUsername(username)) {
            return new CustomResponse(false, "this username is exists");
        }

        // TODO: 18.05.2022 check username is valid globally

        String password = userDto.getPassword();
        if (password.length() < 6) {
            // TODO: 18.05.2022 add upper case,lower case,special character check
            return new CustomResponse(false, "Password must be 6 characters at least");
        }
        String checkPassword = userDto.getCheckPassword();

        if (!password.equals(checkPassword)) {
            return new CustomResponse(false, "Password must be same");
        }

//        HashSet<UserRole> roles = new HashSet<>();
        List<UserRole> roles = new ArrayList<>();
        UserRole userRole;
        if (!userRoleRepository.existsByRoleName("STUDENT")) {
            userRole = userRoleRepository.save(new UserRole("STUDENT"));
        } else {
            userRole = userRoleRepository.findByRoleName("STUDENT");
        }

        roles.add(userRole);

        User user = new User();
        user.setFullName(fullName);
        user.setUsername(username);
        user.setPassword(passwordEncoder.getEncoder().encode(password));
        user.setRoles(roles);
        User savedUser = userRepository.save(user);
// TODO: 18.05.2022 check if save user
        return new CustomResponse(true, "user registered");

    }


//    public User save(UserRegistrationDto registrationDto) {
//        User user=new User(registrationDto.getFirstName(),
//                registrationDto.getLastName(),
//                registrationDto.getEmail(),
//                passwordEncoder.encode(registrationDto.getPassword()),
//                Arrays.asList(new Role("ROLE_USER")));
//
//        return userRepository.save(user);
//    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {

        User user=userRepository.findByUsername(username).get();

        if(user==null)
        {
            throw new UsernameNotFoundException("Invalid Username or password");
        }
        return user;
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<UserRole> roles){

        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());

    }
}
