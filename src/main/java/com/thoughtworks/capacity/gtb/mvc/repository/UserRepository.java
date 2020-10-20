package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.exception.MyException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList=new ArrayList<>();

    public void register(User user) throws MyException {
        for(User u:userList){
            if(u.getUsername().equals(user.getUsername())){
                //用户已存在
                throw new MyException("user already exists");
            }
        }
        Integer id=userList.size()+1;
        user.setId(id);
        userList.add(user);
    }
}
