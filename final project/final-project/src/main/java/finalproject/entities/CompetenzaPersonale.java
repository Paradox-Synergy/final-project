package finalproject.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import finalproject.entities.keys.CompositeKey;
import finalproject.entities.superclasses.JoinEntity;

@Entity
public class CompetenzaPersonale extends JoinEntity {

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("id1")
	@JoinColumn(name = "id_dipendente")
	@JsonIgnoreProperties({"certificati","competenze","azienda"})
	private Dipendente dipendente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("id2")
	@JoinColumn(name = "id_competenza")
	@JsonIgnoreProperties("dipendenti")
	private Competenza competenza;
	
	private String livello;

	public CompetenzaPersonale(CompositeKey id, Dipendente dipendente, Competenza competenza, String livello) {
		super(id);
		this.dipendente = dipendente;
		this.competenza = competenza;
		this.livello = livello;
	}

	public CompetenzaPersonale() {
		super();
	}

	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	public Competenza getCompetenza() {
		return competenza;
	}

	public void setCompetenza(Competenza competenza) {
		this.competenza = competenza;
	}

	public String getLivello() {
		return livello;
	}

	public void setLivello(String livello) {
		this.livello = livello;
	}
}