package fr.simplon.festivalsbreton.festivalsbreton.dao.impl;

import fr.simplon.festivalsbreton.festivalsbreton.dao.FestivalDao;
import fr.simplon.festivalsbreton.festivalsbreton.dao.FestivalRepository;
import fr.simplon.festivalsbreton.festivalsbreton.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class FestivalDaoImpl implements FestivalDao {
    @Autowired
   private FestivalRepository festivalRepository;

    @Override
    public List<Festival> getAllFestivals(){
        return festivalRepository.findAll();
    }

    @Override
    public void saveFestival(String nom, String ville, Integer cp, String lieu, Date debut, Date fin, Double lat, Double lon){
        Festival festival = new Festival();
        festival.setNom(nom);
        festival.setVille(ville);
        festival.setCp(cp);
        festival.setLieu(lieu);
        festival.setDebut(debut);
        festival.setFin(fin);
        festival.setLat(lat);
        festival.setLon(lon);
        festivalRepository.save(festival);
    }
    @Override
    public void updateFestival(Long id, String nom, String ville, Integer cp, String lieu, Date debut, Date fin, Double lat, Double lon) {
        Festival festival = festivalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid festival Id:" + id));
        festival.setNom(nom);
        festival.setVille(ville);
        festival.setCp(cp);
        festival.setLieu(lieu);
        festival.setDebut(debut);
        festival.setFin(fin);
        festival.setLat(lat);
        festival.setLon(lon);
        festivalRepository.save(festival);
    }
}
