package com.cfa.repository;

import com.cfa.entity.Lettre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LettreRepository extends JpaRepository<Lettre, Integer> {
}
