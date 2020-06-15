package finalproject.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import finalproject.entities.superclasses.JPAEntity;

@Entity
public class Competenza extends JPAEntity {
	
	private String nome;
	
	@JsonIgnoreProperties("competenza")
	@OneToMany(
			mappedBy = "competenza",
			orphanRemoval = true,
			fetch = FetchType.EAGER
			)
	private Set<CompetenzaPersonale> dipendenti;

	public Competenza(int id, String nome, Set<CompetenzaPersonale> dipendenti) {
		super(id);
		this.nome = nome;
		this.dipendenti = dipendenti;
	}

	public Competenza() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<CompetenzaPersonale> getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(Set<CompetenzaPersonale> dipendenti) {
		this.dipendenti = dipendenti;
	}
}
