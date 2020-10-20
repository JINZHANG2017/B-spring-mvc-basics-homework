package com.thoughtworks.capacity.gtb.mvc.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {

    private Integer id;
    @NotNull
    @Pattern(regexp = "^[0-9a-zA-Z_]{3,10}$")
    private String username;
    @NotNull
    @Size(max = 12,min = 5)
    private String password;
    @Email
    private String email;



}
