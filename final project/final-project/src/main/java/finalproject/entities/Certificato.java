package finalproject.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import finalproject.entities.superclasses.JPAEntity;

@Entity
public class Certificato extends JPAEntity {
	
	private String nome;
	
	@JsonIgnoreProperties("certificato")
	@OneToMany(
			mappedBy = "certificato",
			orphanRemoval = true,
			fetch = FetchType.EAGER
			)
	private Set<CertificatoPersonale> dipendenti;

	public Certificato(int id, String nome, Set<CertificatoPersonale> dipendenti) {
		super(id);
		this.nome = nome;
		this.dipendenti = dipendenti;
	}

	public Certificato() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<CertificatoPersonale> getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(Set<CertificatoPersonale> dipendenti) {
		this.dipendenti = dipendenti;
	}
}
