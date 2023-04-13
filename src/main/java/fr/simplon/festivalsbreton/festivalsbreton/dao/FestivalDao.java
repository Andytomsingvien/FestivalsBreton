package fr.simplon.festivalsbreton.festivalsbreton.dao;

import fr.simplon.festivalsbreton.festivalsbreton.entity.Festival;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.List;


public interface FestivalDao {
    //cf des méthodes dans le package impl, dans la classe FestivalDaoImpl (Les méthodes y sont Override).
    List<Festival> getAllFestivals();

    void saveFestival(String nom, String ville, Integer cp, String lieu, Date debut, Date fin, Double lat, Double lon);
     void updateFestival(Long id,String nom, String ville, Integer cp, String lieu, Date debut, Date fin);

    Festival getFestivalById(Long id);

    void deleteFestivalById(Long id);

}
