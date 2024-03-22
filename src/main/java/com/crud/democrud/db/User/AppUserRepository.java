package com.crud.democrud.db.User;

import com.crud.democrud.db.User.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

}
