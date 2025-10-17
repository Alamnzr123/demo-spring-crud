package com.example.demo.repository;

import com.example.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    List<Account> findByNameContainingIgnoreCase(String name);

    List<Account> findByIndustry(String industry);

    List<Account> findByType(String type);

    @Query("SELECT a FROM Account a WHERE a.name LIKE %:keyword% OR a.industry LIKE %:keyword%")
    List<Account> searchByKeyword(@Param("keyword") String keyword);
}
