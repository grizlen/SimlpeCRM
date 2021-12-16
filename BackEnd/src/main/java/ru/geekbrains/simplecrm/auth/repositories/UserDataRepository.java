package ru.geekbrains.simplecrm.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.simplecrm.auth.model.entity.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
}
