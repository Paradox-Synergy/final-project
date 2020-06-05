package finalproject.entities;

import java.util.List;

import entities.Entity;

public class Azienda extends Entity {
	
	private String ragioneSociale;
	private String partitaIva;
	private String indirizzo;
	private String email;
	private String nTel;

	private List<Dipendente> dipendenti;

	public Azienda(int id, String ragioneSociale, String partitaIva, String indirizzo, String email, String nTel,
			List<Dipendente> dipendenti) {
		super(id);
		this.ragioneSociale = ragioneSociale;
		this.partitaIva = partitaIva;
		this.indirizzo = indirizzo;
		this.email = email;
		this.nTel = nTel;
		this.dipendenti = dipendenti;
	}

	public Azienda() {
		super();
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getnTel() {
		return nTel;
	}

	public void setnTel(String nTel) {
		this.nTel = nTel;
	}

	public List<Dipendente> getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(List<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}
	
	
}
