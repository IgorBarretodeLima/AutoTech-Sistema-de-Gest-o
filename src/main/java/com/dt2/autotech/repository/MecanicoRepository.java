package com.dt2.autotech.repository;

import com.dt2.autotech.entities.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {
}