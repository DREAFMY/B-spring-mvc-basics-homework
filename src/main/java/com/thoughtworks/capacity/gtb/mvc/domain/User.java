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
    @Pattern(regexp = "/^[\\w]{3,10}$/", message = "must be length 6-12 number english underline")
    private String userName;
    @NotBlank(message = "password must not be blank")
    @Max(value = 12,message = "length max 12")
    @Min(value = 5,message = "length min 5")
    private String password;
    @Email(message = "email not valid")
    private String email;
}
