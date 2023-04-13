package fr.simplon.festivalsbreton.festivalsbreton.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.simplon.festivalsbreton.festivalsbreton.dao.FestivalDao;
import fr.simplon.festivalsbreton.festivalsbreton.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

/**

 Cette classe contient les méthodes pour gérer les requêtes HTTP relatives aux festivals.
 */
@Controller
public class FestivalController {
    @Autowired
    private FestivalDao festivalDao;

    /**

     Retourne le formulaire permettant d'ajouter un festival.

     @param model le modèle utilisé pour transmettre des données à la vue
     @return le nom de la vue utilisée pour afficher le formulaire
     */
    @RequestMapping("/add-Festival")
    public String formPourAjouterFestival(Model model) {
        return "form";
    }
    /**

     Ajoute un festival à la base de données en utilisant les données fournies par le formulaire.

     @param festival le festival à ajouter
     @param model le modèle utilisé pour transmettre des données à la vue
     @return le nom de la vue utilisée pour afficher la liste des festivals (index)
     */
    @PostMapping("/submit")
    public String ajoutDuFestival(@ModelAttribute("festival") Festival festival, Model model) {
        model.addAttribute("festival", festival);
        festivalDao.saveFestival(festival.getNom(), festival.getVille(), festival.getCp(), festival.getLieu(), festival.getDebut(), festival.getFin(), festival.getLat(), festival.getLon());
        return "redirect:/";
    }
    /**

     Récupère la liste des festivals en base de données, la traduit en JSON et l'ajoute au modèle pour être utilisée dans index.html.

     @param model le modèle utilisé pour transmettre des données à la vue
     @return le nom de la vue utilisée pour afficher la liste des festivals
     */
    @GetMapping("/")
    String afficherAllFestivals(Model model) {
        List<Festival> festivals = festivalDao.getAllFestivals();
        model.addAttribute("festivals", festivals);

// Convertit la liste des festivals en JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String festivalsJson = "";
        try {
            festivalsJson = objectMapper.writeValueAsString(festivals);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        model.addAttribute("festivalsJson", festivalsJson);
        return "index";
    }

    /**

     Redirige vers la page d'édition d'un festival en particulier en gardant en mémoire son identifiant.

     @param id l'identifiant du festival à éditer
     @param model le modèle utilisé pour transmettre des données à la vue
     @return le nom de la vue utilisée pour afficher le formulaire d'édition du festival
     */
    @PostMapping("/edit-festival")
    public String editFestival(@RequestParam("id") Long id, Model model) {
        Festival festival = festivalDao.getFestivalById(id);
        model.addAttribute("festival", festival);
        return "edit";
    }
    /**

     Modifie les informations d'un festival en particulier dans la base de données en utilisant les données fournies par le formulaire d'édition.

     @param id       l'identifiant du festival à éditer
     @param festival le festival avec les nouvelles informations
     @param model    le modèle utilisé pour transmettre des données à la vue
     @return le nom de la vue utilisée pour afficher la liste des festivals (index)
     */
    @PostMapping("/edit/{id}")
    public String editFestival(@PathVariable("id") Long id, @ModelAttribute("festival") Festival festival, Model model) {
        model.addAttribute("festival",festival);
        festivalDao.updateFestival(id, festival.getNom(),festival.getVille(),festival.getCp(),festival.getLieu(),festival.getDebut(),festival.getFin());
        return "redirect:/";
    }

    /**

     Supprime un festival de la base de données en utilisant son identifiant.

     @param id    l'identifiant du festival à supprimer
     @param model le modèle utilisé pour transmettre des données à la vue
     @return le nom de la vue utilisée pour afficher la liste des festivals (index)
     */
    @PostMapping("/delete/{id}")
    public String deleteFestival(@PathVariable("id") Long id, Model model) {
        festivalDao.deleteFestivalById(id);
        return "redirect:/";
    }
}


