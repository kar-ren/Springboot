package com.techprimers.service;

import com.techprimers.model.User;
import com.techprimers.repository.UserJpaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserJpaRespository userJpaRespository;


    @Override
    public void deleteUser(Long id) {
        userJpaRespository.delete(id);
    }

    public User findById(Long id){
        User user = userJpaRespository.findOne(id);
        if (user == null){new RuntimeException();}
        return user;
   }

    @Override
    public User save(User user){
        user = userJpaRespository.save(user);
        if (user == null) {
            new RuntimeException();
        }
        return user;
   }

    @Override
   public List<User> findAll() {
       List<User> list = userJpaRespository.findAll();
        if (list == null){
            new RuntimeException();
        }
        return list;
   }

    @Override
    public User update(User user, Long id) {
        User userupdate = userJpaRespository.findOne(id);
        if (userupdate != null) {
            userupdate.setFirstname(user.getFirstname());
            userupdate.setLastname(user.getLastname());
            userupdate.setOccupation(user.getOccupation());
            userupdate.setProfilepicture(user.getProfilepicture());
            userJpaRespository.save(userupdate);
        }else{
            new RuntimeException();
        }
        return userupdate;
    }
}
