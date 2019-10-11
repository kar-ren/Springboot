package com.techprimers.repository;

import com.techprimers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRespository extends JpaRepository<User, Long>{
}
