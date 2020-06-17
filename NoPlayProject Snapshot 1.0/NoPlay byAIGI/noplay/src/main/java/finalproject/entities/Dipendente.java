package finalproject.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import finalproject.entities.superclasses.JPAEntity;

@Entity(name = "Dipendente")
@Table(name = "personale")
public class Dipendente extends JPAEntity {

	private String nome;
	private String cognome;
	private String foto;
	private LocalDate ddn;
	private int stipendio;
	private LocalDate dataAssunzione;
	private String ruolo;
	
	@JsonIgnoreProperties("dipendente")
	@OneToMany(
			mappedBy = "dipendente",
			orphanRemoval = true,
			fetch = FetchType.EAGER
			)
	private Set<CompetenzaPersonale> competenze;
	
	@JsonIgnoreProperties("dipendente")
	@OneToMany(
			mappedBy = "certificato",
			orphanRemoval = true,
			fetch = FetchType.EAGER
			)
	private Set<CertificatoPersonale> certificati;
	
	@JsonIgnoreProperties("dipendenti")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_azienda")
	private Azienda azienda;

	public Dipendente(int id, String nome, String cognome, String foto, LocalDate ddn, int stipendio,
			LocalDate dataAssunzione, String ruolo, Set<CompetenzaPersonale> competenze,
			Set<CertificatoPersonale> certificati, Azienda azienda) {
		super(id);
		this.nome = nome;
		this.cognome = cognome;
		this.foto = foto;
		this.ddn = ddn;
		this.stipendio = stipendio;
		this.dataAssunzione = dataAssunzione;
		this.ruolo = ruolo;
		this.competenze = competenze;
		this.certificati = certificati;
		this.azienda = azienda;
	}

	public Dipendente() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public LocalDate getDdn() {
		return ddn;
	}
	public void setDdn(LocalDate ddn) {
		this.ddn = ddn;
	}
	public int getStipendio() {
		return stipendio;
	}
	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}
	public LocalDate getDataAssunzione() {
		return dataAssunzione;
	}
	public void setDataAssunzione(LocalDate dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public Azienda getAzienda() {
		return azienda;
	}
	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}
	public Set<CompetenzaPersonale> getCompetenze() {
		return competenze;
	}
	public void setCompetenze(Set<CompetenzaPersonale> competenze) {
		this.competenze = competenze;
	}
	public Set<CertificatoPersonale> getCertificati() {
		return certificati;
	}
	public void setCertificati(Set<CertificatoPersonale> certificati) {
		this.certificati = certificati;
	}
}
