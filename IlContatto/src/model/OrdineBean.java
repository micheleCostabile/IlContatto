package model;

import java.sql.Date;

public class OrdineBean {
	
	
	public OrdineBean() {
		
	}
	
	
	
	public OrdineBean(int cod, Date dataOrdine, float costoTot, String username,
			String cFUtente) {
		super();
		Cod = cod;
		DataOrdine = dataOrdine;
		CostoTot = costoTot;
		Username = username;
		CFUtente = cFUtente;
	}
	
	
	public OrdineBean(Date dataOrdine, float costoTot, String username,
			String cFUtente) {
		super();
		DataOrdine = dataOrdine;
		CostoTot = costoTot;
		Username = username;
		CFUtente = cFUtente;
	}

	public int getCod() {
		return Cod;
	}

	public void setCod(int cod) {
		Cod = cod;
	}

	

	public Date getDataOrdine() {
		return DataOrdine;
	}

	public void setDataOrdine(Date string) {
		DataOrdine = string;
	}

	public float getCostoTot() {
		return CostoTot;
	}

	public void setCostoTot(float costoTot) {
		CostoTot = costoTot;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getCFUtente() {
		return CFUtente;
	}

	public void setCFUtente(String cFUtente) {
		CFUtente = cFUtente;
	}

	int Cod;
	
	Date DataOrdine;
	
	float CostoTot;
	
	String Username;
	
	String CFUtente;

}