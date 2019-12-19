package model;

public class ClienteBean {

	
	public ClienteBean(String un, String pw, String nome, String cognome, String mail, int eta, int tipo, String city, int cap, String state, String address) {
		this.un = un;
		this.pw = pw;
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.eta= eta;
		this.tipo = tipo;
		this.city =city;
		this.address=address;
		this.cap=cap;
		this.state= state;
	}
	
	public ClienteBean(String un, String pw, String nome, String cognome, String mail, int eta, int tipo, String city, int cap, String state, String address, String cf) {
		this.un = un;
		this.pw = pw;
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.eta= eta;
		this.tipo = tipo;
		this.city =city;
		this.address=address;
		this.cap=cap;
		this.state= state;
		this.cf = cf;
	}
	

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}
	
	public void setCity(String city) {
		this.city=city;
	}

	public ClienteBean(String un, String pw) {
		this.un = un;
		this.pw = pw;
	}
	
	public ClienteBean(){}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}
	
	
	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	private String un;
	private String pw;
	private int eta;
	private String nome;
	private String cognome;
	private String mail;
	private int tipo;
	private String city;
	private String address;
	private String state;
	private int cap;
	private String cf;
	
}
