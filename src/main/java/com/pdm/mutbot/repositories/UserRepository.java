package com.pdm.mutbot.repositories;

import com.pdm.mutbot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
