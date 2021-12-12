package ru.moore.AISUchetTehniki.repositories.spr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.moore.AISUchetTehniki.models.Entity.spr.BudgetAccount;

import java.util.List;

@Repository
public interface BudgetAccountRepository extends JpaRepository<BudgetAccount, Long> {

    List<BudgetAccount> findAllByGlobalIdOrderByCodeAsc(String globalId);

}
