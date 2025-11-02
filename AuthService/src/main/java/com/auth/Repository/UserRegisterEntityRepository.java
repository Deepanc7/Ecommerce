package com.auth.Repository;

import com.auth.Entity.UserRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRegisterEntityRepository extends JpaRepository<UserRegisterEntity, String> {

    Optional<UserRegisterEntity> findByUsername(String username);
}
