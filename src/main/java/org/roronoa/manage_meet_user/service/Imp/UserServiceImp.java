package org.roronoa.manage_meet_user.service.Imp;

import lombok.RequiredArgsConstructor;
import org.roronoa.manage_meet_user.dto.AuthDto;
import org.roronoa.manage_meet_user.entity.User;
import org.roronoa.manage_meet_user.repository.RoleRepository;
import org.roronoa.manage_meet_user.repository.UserRepository;
import org.roronoa.manage_meet_user.service.IUserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImp implements IUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @Override
    public User save(User userReq) {
        var user = User.builder()
                .firstName(userReq.getFirstName())
                .lastName(userReq.getLastName())
                .email(userReq.getEmail())
                .password(passwordEncoder.encode(userReq.getPassword()))
                .role(roleRepository.findById(1).get())
                .uuid(UUID.randomUUID().toString())
                .build();
        return userRepository.save(user);
    }

    @Override
    public User getUser(String uuid) {
        return null;
    }

    @Override
    public List<User> getListUsers() {
        return null;
    }

    @Override
    public User findByEmail(AuthDto authDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authDto.getEmail(),
                        authDto.getPassword()
                )
        );
        return userRepository.findByEmail(authDto.getEmail()).orElseThrow();
    }
}