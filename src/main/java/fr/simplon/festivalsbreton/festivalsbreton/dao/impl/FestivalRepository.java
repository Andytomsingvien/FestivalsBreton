package fr.simplon.festivalsbreton.festivalsbreton.dao.impl;

import fr.simplon.festivalsbreton.festivalsbreton.entity.Festival;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FestivalRepository extends JpaRepository<Festival, Long> {
}
