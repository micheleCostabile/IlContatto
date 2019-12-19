package model;

public class FatturaBean {



	
	
	public FatturaBean(int x, String nc, String cn, String iva, String mail, String da,String cf) {
		this.nf= x;
		this.nc= nc;
		this.cn=cn;
		this.iva=iva;
		this.mail=mail;
		this.da= da;
		this.cf = cf;
	}
	

	public String getNc() {
		return nc;
	}
	public void setNc(String nc) {
		this.nc = nc;
	}
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	public String getIva() {
		return iva;
	}
	public void setIva(String iva) {
		this.iva = iva;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	

	public int getNf() {
		return nf;
	}


	public void setNf(int nf) {
		this.nf = nf;
	}
	

	public String getDa() {
		return da;
	}


	public void setDa(String da) {
		this.da = da;
	}
	

	public String getCf() {
		return cf;
	}


	public void setCf(String cf) {
		this.cf = cf;
	}




	private String nc;
	private String cn;
	private String iva;
	private String mail;
	private int nf;
	private String da;
	private String cf;
}
