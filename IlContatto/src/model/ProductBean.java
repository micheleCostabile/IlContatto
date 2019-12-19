package model;

public class ProductBean {
	
	
	public ProductBean(int codice, int iva, int pezzi, String marca,
			String modello, String descrizione, String immagine, String nome,
			float prezzo, String tipologia, String colore) {
		super();
		this.codice = codice;
		this.iva = iva;
		this.pezzi = pezzi;
		this.marca = marca;
		this.modello = modello;
		this.descrizione = descrizione;
		this.immagine = immagine;
		this.nome = nome;
		this.prezzo = prezzo;
		this.tipologia = tipologia;
		this.colore = colore;
		
	}
	
	
	public ProductBean(int codice, int iva, int pezzi, String marca,
			String modello, String descrizione, String immagine, String nome,
			float prezzo, String tipologia, float ps, String colore ) {
		super();
		this.codice = codice;
		this.iva = iva;
		this.pezzi = pezzi;
		this.marca = marca;
		this.modello = modello;
		this.descrizione = descrizione;
		this.immagine = immagine;
		this.nome = nome;
		this.prezzo = prezzo;
		this.tipologia = tipologia;
		this.colore = colore;
		this.prezzoScontato= ps;
	}
	
	public ProductBean() {
		
	}
	
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public int getPezzi() {
		return pezzi;
	}
	public void setPezzi(int pezzi) {
		this.pezzi = pezzi;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	

	@Override
	public String toString() {
		return "ProductBean [codice=" + codice + ", iva=" + iva + ", pezzi="
				+ pezzi + ", marca=" + marca + ", modello=" + modello
				+ ", descrizione=" + descrizione + ", immagine=" + immagine
				+ ", nome=" + nome + ", prezzo=" + prezzo + "]";
	}



	
	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	

	public float getPrezzoScontato() {
		return prezzoScontato;
	}

	public void setPrezzoScontato(float prezzoScontato) {
		this.prezzoScontato = prezzoScontato;
	}

	public String getColore() {
		return colore;
	}


	public void setColore(String colore) {
		this.colore = colore;
	}
	
	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public float getSub() {
		return sub;
	}


	public void setSub(float sub) {
		this.sub = sub;
	}

	
	float prezzo;
	private float prezzoScontato, sub;
	private String colore;
	private int codice,iva,pezzi,qty;
	private String marca,modello,descrizione,immagine,nome,tipologia;

	
}
