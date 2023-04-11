package fr.simplon.festivalsbreton.festivalsbreton.dao;

import fr.simplon.festivalsbreton.festivalsbreton.entity.Festival;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FestivalRepository extends JpaRepository<Festival, Long> {
}
