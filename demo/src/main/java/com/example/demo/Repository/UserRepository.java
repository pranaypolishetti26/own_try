package com.example.demo.Repository;
import com.example.demo.Domain.UserLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserLogin, Integer> {
    Optional<UserLogin> findByUserName(String userName);
}