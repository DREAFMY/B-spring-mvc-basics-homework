package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private int id;
    @NotBlank(message = "user name must not be blank")
    @Pattern(regexp = "^[\\w]{3,10}$", message = "user name must be length 3-10 number english underline")
    private String username;
    @NotBlank(message = "password must not be blank")
    @Size(min = 5, max = 12, message = "password length min 5 max 12")
    private String password;
    @Email(message = "email not valid")
    private String email;
}
