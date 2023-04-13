package fr.simplon.festivalsbreton.festivalsbreton.dao.impl;

import fr.simplon.festivalsbreton.festivalsbreton.dao.FestivalDao;
import fr.simplon.festivalsbreton.festivalsbreton.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 Cette classe implémente l'interface FestivalDao et contient les méthodes pour accéder à la base de données de festivals.
 */
@Repository
public class FestivalDaoImpl implements FestivalDao {
    @Autowired
    private FestivalRepository festivalRepository;

    /**

     Renvoie tous les festivals présents dans la base de données.
     @return une liste de festivals
     */
    @Override
    public List<Festival> getAllFestivals() {
        return festivalRepository.findAll();
    }
    /**

     Sauvegarde un nouveau festival dans la base de données en utilisant les données fournies.
     @param nom le nom du festival
     @param ville la ville où se déroule le festival
     @param cp le code postal de la ville où se déroule le festival
     @param lieu le lieu où se déroule le festival
     @param debut la date de début du festival
     @param fin la date de fin du festival
     @param lat la latitude du lieu où se déroule le festival
     @param lon la longitude du lieu où se déroule le festival
     */
    @Override
    public void saveFestival(String nom, String ville, Integer cp, String lieu, Date debut, Date fin, Double lat, Double lon) {
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
    /**

     Modifie les informations d'un festival existant dans la base de données en utilisant les données fournies.
     @param id l'identifiant du festival à modifier
     @param nom le nouveau nom du festival
     @param ville la nouvelle ville où se déroule le festival
     @param cp le nouveau code postal de la ville où se déroule le festival
     @param lieu le nouveau lieu où se déroule le festival
     @param debut la nouvelle date de début du festival
     @param fin la nouvelle date de fin du festival
     */
    @Override
    public void updateFestival(Long id, String nom, String ville, Integer cp, String lieu, Date debut, Date fin) {
        Festival festival = festivalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid festival Id:" + id));
        festival.setNom(nom);
        festival.setVille(ville);
        festival.setCp(cp);
        festival.setLieu(lieu);
        festival.setDebut(debut);
        festival.setFin(fin);
        festivalRepository.save(festival);
    }
    /**

     Renvoie le festival ayant l'identifiant spécifié.
     @param id l'identifiant du festival recherché
     @return le festival ayant l'identifiant spécifié, ou null si aucun festival ne correspond
     */
    @Override
    public Festival getFestivalById(Long id) {
        return festivalRepository.findById(id).orElse(null);
    }
    /**

     Supprime le festival ayant l'identifiant spécifié de la base de données.
     @param id l'identifiant du festival à supprimer
     */
    @Override
    public void deleteFestivalById(Long id) {
        festivalRepository.deleteById(id);
    }

}
