package ru.geekbrains.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.model.Role;
import ru.geekbrains.model.User;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private String firstName;

    private String lastName;

    private String email;
    @Valid
    private Set<RoleDto> roles;

}
