package finalproject.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import finalproject.entities.keys.CompositeKey;
import finalproject.entities.superclasses.JoinEntity;

@Entity
public class CertificatoPersonale extends JoinEntity {
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("id1")
	@JoinColumn(name = "id_dipendente")
	@JsonIgnoreProperties({"certificati","competenze","azienda"})
	private Dipendente dipendente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("id2")
	@JoinColumn(name = "id_certificato")
	@JsonIgnoreProperties("dipendenti")
	private Certificato certificato;
	
	private LocalDate dataScadenza;

	public CertificatoPersonale(CompositeKey id, Dipendente dipendente, Certificato certificato,
			LocalDate dataScadenza) {
		super(id);
		this.dipendente = dipendente;
		this.certificato = certificato;
		this.dataScadenza = dataScadenza;
	}

	public CertificatoPersonale() {
		super();
	}

	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	public Certificato getCertificato() {
		return certificato;
	}

	public void setCertificato(Certificato certificato) {
		this.certificato = certificato;
	}

	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
}
