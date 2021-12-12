package ru.moore.AISUchetTehniki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.moore.AISUchetTehniki.models.Entity.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

//    boolean existsByEmail(String email);

    Optional<Account> findByEmail(String email);

    Account findByConfirmationCode(String code);

}
