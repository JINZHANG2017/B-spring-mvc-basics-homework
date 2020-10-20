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
    @Pattern(regexp = "^[0-9a-zA-Z_]{3,10}$",message = "用户名必须为3-10位数字字母或下划线")
    private String username;
    @Size(max = 12,min = 5,message = "密码必须为5-12位")
    private String password;
    @Email(message = "邮件格式必须符合要求")
    private String email;



}
