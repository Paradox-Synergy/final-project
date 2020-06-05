package finalproject.entities;

import java.time.LocalDate;

import entities.Entity;

public class Dipendente extends Entity {

	private String nome;
	private String cognome;
	private String foto;
	private LocalDate ddn;
	private int stipendio;
	private LocalDate dataAssunzione;
	private String ruolo;
	
	private int idAzienda;
	
	public Dipendente(int id, String nome, String cognome, String foto, LocalDate ddn, int stipendio,
			LocalDate dataAssunzione, String ruolo, int idAzienda) {
		super(id);
		this.nome = nome;
		this.cognome = cognome;
		this.foto = foto;
		this.ddn = ddn;
		this.stipendio = stipendio;
		this.dataAssunzione = dataAssunzione;
		this.ruolo = ruolo;
		this.idAzienda = idAzienda;
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
	public int getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
}
