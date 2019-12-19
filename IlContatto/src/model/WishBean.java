package model;

public class WishBean {

	public WishBean() {
		
	}

	public String getUserUtente() {
		return UserUtente;
	}
	public void setUserUtente(String userUtente) {
		UserUtente = userUtente;
	}
	public int getCodProd() {
		return codProd;
	}
	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}
	
	String UserUtente;
	int codProd;
}
