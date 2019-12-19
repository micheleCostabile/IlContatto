package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ClienteBean;
import model.Model;



public class ComposizioneDAO implements Model {

	@Override
	public boolean doSave(ClienteBean product) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(int code) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object doRetrieveByKey(int code) throws SQLException {
		
		return null;
	}

	@Override
	public ArrayList<Object> doRetrieveAll(String order) throws SQLException {
		
		return null;
	}

	
	public ArrayList<ProductBean> doRetrieveAll(int cod) throws SQLException {
		ArrayList<ProductBean> lista = new ArrayList<ProductBean>();
		
		Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 ProductBean p = new ProductBean();
		 String selectSQL = "SELECT * FROM composizione WHERE IdOrdine=?";
		 try {
			 	connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setInt(1, cod);
				ResultSet rs = preparedStatement.executeQuery();
				connection.commit();
				
				while (rs.next()) {
					int x= rs.getInt("CodiceProdotto");
					int q= rs.getInt("Quantità");
					ProductDAO check = new ProductDAO();
					p=check.doRetrieveByKey(x);
					p.setQty(q);
					
					lista.add(p);
				}
				return lista;
		 } 
		 finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					DriverManagerConnectionPool.releaseConnection(connection);
				}
			}
	}

	@Override
	public ArrayList<Object> doRetrieveAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}