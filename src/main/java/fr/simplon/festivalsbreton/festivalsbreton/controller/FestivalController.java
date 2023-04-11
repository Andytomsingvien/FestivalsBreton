package fr.simplon.festivalsbreton.festivalsbreton.controller;

import fr.simplon.festivalsbreton.festivalsbreton.dao.FestivalDao;
import fr.simplon.festivalsbreton.festivalsbreton.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;

@Controller
public class FestivalController {
    @Autowired
    private FestivalDao festivalDao;

    @RequestMapping("/form")
    public String endPointForm(Model model) {
        return "form";
    }
    @PostMapping("/submit")
    public String ajouterFestival(@ModelAttribute("festival") Festival festival, Model model) {
        model.addAttribute("festival", festival);
        festivalDao.saveFestival(festival.getNom(),festival.getVille(),festival.getCp(),festival.getLieu(),festival.getDebut(),festival.getFin(),festival.getLat(),festival.getLon());
        return "index";
    }
}


