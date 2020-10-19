package com.thoughtworks.capacity.gtb.mvc.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;

    public boolean equalsTo(User u){
        if(username.equals(u.getUsername())&&password.equals(u.getPassword())&&email.equals(u.getEmail())){
            return true;
        }
        return false;
    }

}
