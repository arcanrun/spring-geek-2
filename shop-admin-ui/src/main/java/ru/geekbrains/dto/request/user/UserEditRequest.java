package ru.geekbrains.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.dto.RoleDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEditRequest {

    private Integer id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private List<Integer> roles;
}
