package ru.geekbrains.service;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.dto.RoleDto;
import ru.geekbrains.dto.UserDto;
import ru.geekbrains.dto.request.user.UserEditRequest;
import ru.geekbrains.model.Role;
import ru.geekbrains.model.User;
import ru.geekbrains.repository.RoleRepository;
import ru.geekbrains.repository.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void save(UserEditRequest userEditRequest) {
        User user = new User();
        List<Integer> idList = userEditRequest.getRoles();
        log.info("idList={}", idList);

        Set<Role> roleSet = roleRepository.findAllByIdIn(idList);


        user.setId(userEditRequest.getId());
        user.setName(userEditRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userEditRequest.getPassword()));
        user.setEmail(userEditRequest.getEmail());
        user.setRoles(roleSet);
        userRepository.save(user);
    }


    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(
                        (u) -> new UserDto(
                                u.getId(),
                                u.getName(),
                                u.getPassword(),
                                u.getName(),
                                u.getName(),
                                u.getEmail(),
                                u.getRoles()
                                        .stream()
                                        .map(e -> new RoleDto(e.getId(), e.getName()))
                                        .collect(Collectors.toSet())))
                                .collect(Collectors.toList());
    }


    public UserDto findById(int id) throws NotFoundException {
        User userEntity = userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Пользователь с id=%s не найден", id)));

        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setEmail(userEntity.getEmail());
        userDto.setFirstName(userEntity.getName());
        userDto.setLastName(userEntity.getName());
        userDto.setPassword(userEntity.getPassword());
        userDto.setRoles(
                userEntity
                        .getRoles()
                        .stream()
                        .map((e) -> new RoleDto(e.getId(), e.getName())).collect(Collectors.toSet())
        );
        return userDto;
    }


    public void delete(int id) {
        //todo chec if it is not current user
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findUserByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password"));

        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles
                .stream()
                .map(
                        role ->
                                new SimpleGrantedAuthority(
                                        role.getName())).collect(Collectors.toList()
                );
    }
}
