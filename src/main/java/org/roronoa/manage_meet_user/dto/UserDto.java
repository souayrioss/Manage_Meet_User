package org.roronoa.manage_meet_user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private Integer id;
    private String uuid;
    @NotNull @NotEmpty
    private String firstName;
    @NotNull @NotEmpty
    private String lastName;
    @NotNull @NotEmpty @Email
    private String email;
    @NotNull @NotEmpty
    private String password;
    private RoleDto role;
}
