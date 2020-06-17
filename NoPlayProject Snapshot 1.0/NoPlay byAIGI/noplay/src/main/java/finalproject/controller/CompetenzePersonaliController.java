package finalproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finalproject.controller.generics.JoinCrudController;
import finalproject.entities.CompetenzaPersonale;
import finalproject.repositories.CompetenzaPersonaleRepository;

@RestController
@RequestMapping({"competenze_personali"})
public class CompetenzePersonaliController extends JoinCrudController<CompetenzaPersonale, CompetenzaPersonaleRepository>{

}
