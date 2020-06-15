package finalproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finalproject.controller.generics.GenericCrudController;
import finalproject.entities.Certificato;
import finalproject.repositories.CertificatoRepository;

@RestController
@RequestMapping({"/dipendente/{id_dipendente}/certificati","/certificati"})
public class CertificatiController extends GenericCrudController<Certificato, CertificatoRepository> {

}
