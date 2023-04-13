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

@Controller
public class FestivalController {
    @Autowired
    private FestivalDao festivalDao;

    @RequestMapping("/add-Festival")
    public String formPourAjouterFestival(Model model) {
        return "form";
    }
    @PostMapping("/submit")
    public String ajoutDuFestival(@ModelAttribute("festival") Festival festival, Model model) {
        model.addAttribute("festival", festival);
        festivalDao.saveFestival(festival.getNom(),festival.getVille(),festival.getCp(),festival.getLieu(),festival.getDebut(),festival.getFin(),festival.getLat(),festival.getLon());
        return "redirect:/";
    }


    @GetMapping("/")
    String afficherAllDonateurs(Model model) {
        List<Festival> festivals = festivalDao.getAllFestivals();
        model.addAttribute("festivals", festivals);

                // Convertissez la liste des festivals en JSON
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
    @PostMapping("/edit-festival")
    public String editFestival(@RequestParam("id") Long id, Model model) {
        Festival festival = festivalDao.getFestivalById(id);
        model.addAttribute("festival", festival);
        return "edit";
    }
    @PostMapping("/edit/{id}")
    public String editFestival(@PathVariable("id") Long id, @ModelAttribute("festival") Festival festival, Model model) {
        model.addAttribute("festival",festival);
        festivalDao.updateFestival(id, festival.getNom(),festival.getVille(),festival.getCp(),festival.getLieu(),festival.getDebut(),festival.getFin());
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteFestival(@PathVariable("id") Long id, Model model) {
        festivalDao.deleteFestivalById(id);
        return "redirect:/";
    }
}


