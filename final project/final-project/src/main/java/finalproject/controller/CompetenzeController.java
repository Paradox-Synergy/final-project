package finalproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finalproject.controller.generics.GenericCrudController;
import finalproject.entities.Competenza;
import finalproject.repositories.CompetenzaRepository;

@RestController
@RequestMapping({"/dipendente/{id_dipendente}/competenze","/competenze"})
public class CompetenzeController extends GenericCrudController<Competenza, CompetenzaRepository> {

}
