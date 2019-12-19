package model;

public class ComposizioneBean {
	
	public ComposizioneBean(int x, int cod, int iva, float prezzoOrdine, int qty) {
		this.x= x;
		this.cod= cod;
		this.iva= iva;
		this.prezzoOrdine=prezzoOrdine;
		this.qty= qty;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getPrezzoOrdine() {
		return prezzoOrdine;
	}
	public void setPrezzoOrdine(float prezzoOrdine) {
		this.prezzoOrdine = prezzoOrdine;
	}

	private int x,cod,iva,qty;
	private float prezzoOrdine;
}
