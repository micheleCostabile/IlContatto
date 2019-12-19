package model;

import java.util.ArrayList;

public class CarrelloBean {

	public CarrelloBean() {
		
		this.carrello = new ArrayList <ProductBean>();
	}
	
	
	public CarrelloBean(ArrayList <ProductBean> carrello) {
		this.carrello = carrello;
	}
	
	
	public ArrayList<ProductBean> getCarrello() {
		return carrello;
	}

	public void setCarrello(ArrayList<ProductBean> carrello) {
		this.carrello = carrello;
	}

	ArrayList <ProductBean> carrello;
	
}
