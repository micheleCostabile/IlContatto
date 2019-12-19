package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class ProductDAO implements Model {
	
	
	
	
	
	
	public boolean AddProduct(ProductBean product) throws SQLException {
		 Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 String selectSQL = "INSERT INTO prodotto (`CodP`, `Marca`, `Modello`, `PrezzoAttuale`, `IvaAttuale`, `Descrizione`, `NumPezzi`, `Immagine`, `Nome`, `Tipologia`, `Colore`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			try {
				connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setInt(1, product.getCodice());
				preparedStatement.setString(2, product.getMarca());
				preparedStatement.setString(3, product.getModello());
				preparedStatement.setFloat(4, product.getPrezzo());
				preparedStatement.setInt(5, product.getIva());
				preparedStatement.setString(6, product.getDescrizione());
				preparedStatement.setInt(7, product.getPezzi());
				preparedStatement.setString(8, product.getImmagine());
				preparedStatement.setString(9, product.getNome());
				preparedStatement.setString(10, product.getTipologia());
				preparedStatement.setString(11, product.getColore());
				preparedStatement.executeUpdate();
				connection.commit();
				return true;
				
			
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
	
	
	public boolean ModProduct(ProductBean product) throws SQLException {
		 Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 String selectSQL = "UPDATE prodotto SET Marca=?, Modello=?, PrezzoAttuale=?, IvaAttuale=?, Descrizione=?, NumPezzi=?, Immagine=?, Nome=?, Tipologia=?, PrezzoScontato=?, Colore=?  WHERE CodP= ? ";

			try {
				connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				
				preparedStatement.setString(1, product.getMarca());
				preparedStatement.setString(2, product.getModello());
				preparedStatement.setFloat(3, product.getPrezzo());
				preparedStatement.setInt(4, product.getIva());
				preparedStatement.setString(5, product.getDescrizione());
				preparedStatement.setInt(6, product.getPezzi());
				preparedStatement.setString(7, product.getImmagine());
				preparedStatement.setString(8, product.getNome());
				preparedStatement.setString(9, product.getTipologia());
				preparedStatement.setFloat(10, product.getPrezzoScontato());
				preparedStatement.setString(11, product.getColore());
				preparedStatement.setInt(12, product.getCodice());
				preparedStatement.executeUpdate();
				connection.commit();
				return true;
				
			
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
	
	
	public void aggiornaProdotto(ProductBean nuovo) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
try {
		String selectSQL= "UPDATE prodotto SET CodP = ?, Marca = ?, Modello = ?, PrezzoAttuale = ?, IvaAttuale = ?, Descrizione = ?, NumPezzi = ?, Immagine = ?, Nome = ?, Tipologia = ?, PrezzoScontato = ?, Colore = ?  WHERE (CodP = ?);";

		
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, nuovo.getCodice());
			preparedStatement.setString(2, nuovo.getMarca());
			preparedStatement.setString(3, nuovo.getModello());
			preparedStatement.setFloat(4, nuovo.getPrezzo());
			preparedStatement.setInt(5, nuovo.getIva());
			preparedStatement.setString(6, nuovo.getDescrizione());
			preparedStatement.setInt(7, nuovo.getPezzi());
			preparedStatement.setString(8, nuovo.getImmagine());
			preparedStatement.setString(9, nuovo.getNome());
			preparedStatement.setString(10, nuovo.getTipologia());
			preparedStatement.setFloat(11, nuovo.getPrezzoScontato());
			preparedStatement.setString(12, nuovo.getColore());
			preparedStatement.setInt(13, nuovo.getCodice());
			preparedStatement.executeUpdate();
			connection.commit();
			
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
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
	public boolean doDelete(int code) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductBean doRetrieveByKey(int code) throws SQLException {
		 Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 ProductBean a = new ProductBean();
		 String selectSQL = "SELECT * FROM prodotto WHERE CodP=?";
		 
		 try {
			 	connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setLong(1, code);
				ResultSet rs = preparedStatement.executeQuery();
				connection.commit();
				
				while (rs.next()) {
					
					a.setCodice(rs.getInt("CodP"));
					a.setDescrizione(rs.getString("Descrizione"));
					a.setImmagine(rs.getString("Immagine"));
					a.setIva(rs.getInt("IvaAttuale"));
					a.setMarca(rs.getString("Marca"));
					a.setModello(rs.getString("Modello"));
					a.setNome(rs.getString("Nome"));
					a.setPezzi(rs.getInt("NumPezzi"));
					a.setPrezzo(rs.getFloat("PrezzoAttuale"));
					a.setTipologia(rs.getString("Tipologia"));
					a.setColore(rs.getString("Colore"));
					a.setPrezzoScontato(rs.getFloat("PrezzoScontato"));
					
				}
				
				return a;
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
		return null;
	}

	@Override
	public ArrayList<Object> doRetrieveAll(String order)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<ProductBean> getAll() throws SQLException {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ArrayList <ProductBean> lista = new ArrayList <ProductBean>();
	
	String selectSQL = "SELECT * FROM prodotto";

	try {
		connection = DriverManagerConnectionPool.getConnection();
		preparedStatement = connection.prepareStatement(selectSQL);
		ResultSet rs = preparedStatement.executeQuery();
		connection.commit();
		
		while (rs.next()) {
			ProductBean a = new ProductBean();
			a.setCodice(rs.getInt("CodP"));
			a.setDescrizione(rs.getString("Descrizione"));
			a.setImmagine(rs.getString("Immagine"));
			a.setIva(rs.getInt("IvaAttuale"));
			a.setMarca(rs.getString("Marca"));
			a.setModello(rs.getString("Modello"));
			a.setNome(rs.getString("Nome"));
			a.setPezzi(rs.getInt("NumPezzi"));
			a.setPrezzo(rs.getFloat("PrezzoAttuale"));
			a.setTipologia(rs.getString("Tipologia"));
			a.setPrezzoScontato(rs.getFloat("PrezzoScontato"));
			
			lista.add(a);
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
	
	public ArrayList<ProductBean> getAndroid() throws SQLException{
		 Connection connection = null;
			PreparedStatement preparedStatement = null;
			ArrayList <ProductBean> lista = new ArrayList <ProductBean>();

			String selectSQL = "SELECT * FROM prodotto WHERE marca!=? and tipologia=?";

			try {
				connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1, "Apple");
				preparedStatement.setString(2, "Smartphone");
				ResultSet rs = preparedStatement.executeQuery();
				connection.commit();
				
				while (rs.next()) {
					ProductBean a = new ProductBean();
					a.setCodice(rs.getInt("CodP"));
					a.setDescrizione(rs.getString("Descrizione"));
					a.setImmagine(rs.getString("Immagine"));
					a.setIva(rs.getInt("IvaAttuale"));
					a.setMarca(rs.getString("Marca"));
					a.setModello(rs.getString("Modello"));
					a.setNome(rs.getString("Nome"));
					a.setPezzi(rs.getInt("NumPezzi"));
					a.setPrezzo(rs.getFloat("PrezzoAttuale"));
					a.setTipologia(rs.getString("Tipologia"));
					a.setPrezzoScontato(rs.getFloat("PrezzoScontato"));
					lista.add(a);
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
	
	
	public ArrayList<ProductBean> getApple() throws SQLException{
		 Connection connection = null;
			PreparedStatement preparedStatement = null;
			ArrayList <ProductBean> lista = new ArrayList <ProductBean>();

			String selectSQL = "SELECT * FROM prodotto WHERE marca=? and tipologia=?";

			try {
				connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1, "Apple");
				preparedStatement.setString(2, "Smartphone");
				ResultSet rs = preparedStatement.executeQuery();
				connection.commit();
				
				while (rs.next()) {
					ProductBean a = new ProductBean();
					a.setCodice(rs.getInt("CodP"));
					a.setDescrizione(rs.getString("Descrizione"));
					a.setImmagine(rs.getString("Immagine"));
					a.setIva(rs.getInt("IvaAttuale"));
					a.setMarca(rs.getString("Marca"));
					a.setModello(rs.getString("Modello"));
					a.setNome(rs.getString("Nome"));
					a.setPezzi(rs.getInt("NumPezzi"));
					a.setPrezzo(rs.getFloat("PrezzoAttuale"));
					a.setTipologia(rs.getString("Tipologia"));
					a.setPrezzoScontato(rs.getFloat("PrezzoScontato"));
					lista.add(a);
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
	
	
	
	public ArrayList<ProductBean> getAccessori() throws SQLException{
		 Connection connection = null;
			PreparedStatement preparedStatement = null;
			ArrayList <ProductBean> lista = new ArrayList <ProductBean>();

			String selectSQL = "SELECT * FROM prodotto WHERE tipologia=?";

			try {
				connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1, "Accessori");
				ResultSet rs = preparedStatement.executeQuery();
				connection.commit();
				
				while (rs.next()) {
					ProductBean a = new ProductBean();
					a.setCodice(rs.getInt("CodP"));
					a.setDescrizione(rs.getString("Descrizione"));
					a.setImmagine(rs.getString("Immagine"));
					a.setIva(rs.getInt("IvaAttuale"));
					a.setMarca(rs.getString("Marca"));
					a.setModello(rs.getString("Modello"));
					a.setNome(rs.getString("Nome"));
					a.setPezzi(rs.getInt("NumPezzi"));
					a.setPrezzo(rs.getFloat("PrezzoAttuale"));
					a.setTipologia(rs.getString("Tipologia"));
					a.setPrezzoScontato(rs.getFloat("PrezzoScontato"));
					lista.add(a);
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
	
	
	public ArrayList<ProductBean> getAuricolari() throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList <ProductBean> lista = new ArrayList <ProductBean>();

		String selectSQL = "SELECT * FROM prodotto WHERE tipologia=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "Auricolari");
			ResultSet rs = preparedStatement.executeQuery();
			connection.commit();
			
			while (rs.next()) {
				ProductBean a = new ProductBean();
				a.setCodice(rs.getInt("CodP"));
				a.setDescrizione(rs.getString("Descrizione"));
				a.setImmagine(rs.getString("Immagine"));
				a.setIva(rs.getInt("IvaAttuale"));
				a.setMarca(rs.getString("Marca"));
				a.setModello(rs.getString("Modello"));
				a.setNome(rs.getString("Nome"));
				a.setPezzi(rs.getInt("NumPezzi"));
				a.setPrezzo(rs.getFloat("PrezzoAttuale"));
				a.setTipologia(rs.getString("Tipologia"));
				a.setPrezzoScontato(rs.getFloat("PrezzoScontato"));
				lista.add(a);
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


	public ArrayList<ProductBean> getCovers() throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList <ProductBean> lista = new ArrayList <ProductBean>();

		String selectSQL = "SELECT * FROM prodotto WHERE tipologia=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "Cover");
			ResultSet rs = preparedStatement.executeQuery();
			connection.commit();
			
			while (rs.next()) {
				ProductBean a = new ProductBean();
				a.setCodice(rs.getInt("CodP"));
				a.setDescrizione(rs.getString("Descrizione"));
				a.setImmagine(rs.getString("Immagine"));
				a.setIva(rs.getInt("IvaAttuale"));
				a.setMarca(rs.getString("Marca"));
				a.setModello(rs.getString("Modello"));
				a.setNome(rs.getString("Nome"));
				a.setPezzi(rs.getInt("NumPezzi"));
				a.setPrezzo(rs.getFloat("PrezzoAttuale"));
				a.setTipologia(rs.getString("Tipologia"));
				a.setPrezzoScontato(rs.getFloat("PrezzoScontato"));
				lista.add(a);
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
	
	public ArrayList<ProductBean> getOfferte() throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList <ProductBean> lista = new ArrayList <ProductBean>();

		String selectSQL = "SELECT * FROM prodotto WHERE PrezzoScontato IS NOT NULL";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			connection.commit();
			
			while (rs.next()) {
				ProductBean a = new ProductBean();
				a.setCodice(rs.getInt("CodP"));
				a.setDescrizione(rs.getString("Descrizione"));
				a.setImmagine(rs.getString("Immagine"));
				a.setIva(rs.getInt("IvaAttuale"));
				a.setMarca(rs.getString("Marca"));
				a.setModello(rs.getString("Modello"));
				a.setNome(rs.getString("Nome"));
				a.setPezzi(rs.getInt("NumPezzi"));
				a.setPrezzo(rs.getFloat("PrezzoAttuale"));
				a.setTipologia(rs.getString("Tipologia"));
				a.setPrezzoScontato(rs.getFloat("PrezzoScontato"));
				lista.add(a);
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
	
	
	public ArrayList<ProductBean> searchBar(String search) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList <ProductBean> lista = new ArrayList <ProductBean>();

		String selectSQL = "SELECT * FROM prodotto";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			connection.commit();
			
			while (rs.next()) {
				if(rs.getString("Nome").toLowerCase().contains(search.toLowerCase())) {
				
					ProductBean a = new ProductBean();
					
					a.setCodice(rs.getInt("CodP"));
					a.setDescrizione(rs.getString("Descrizione"));
					a.setImmagine(rs.getString("Immagine"));
					a.setIva(rs.getInt("IvaAttuale"));
					a.setMarca(rs.getString("Marca"));
					a.setModello(rs.getString("Modello"));
					a.setNome(rs.getString("Nome"));
					a.setPezzi(rs.getInt("NumPezzi"));
					a.setPrezzo(rs.getFloat("PrezzoAttuale"));
					a.setTipologia(rs.getString("Tipologia"));
					a.setPrezzoScontato(rs.getFloat("PrezzoScontato"));
					lista.add(a);
				}
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

	
	public void deleteProduct(int codice) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String search = "SELECT * FROM composizione WHERE (`CodiceProdotto` = ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(search);
			preparedStatement.setInt(1, codice);
			ResultSet rs=preparedStatement.executeQuery();
			connection.commit();
			
			if (rs.next()) {
				String search1 = "UPDATE prodotto SET NumPezzi ='0' WHERE (CodP = ?);";
				
				
				try {
					connection = DriverManagerConnectionPool.getConnection();
					preparedStatement = connection.prepareStatement(search1);
					preparedStatement.setInt(1, codice);
					preparedStatement.executeUpdate();
					connection.commit();
					
			
					
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
			else {
				connection = null;
				PreparedStatement preparedStatement1 = null;

				String deleteSQL = "DELETE FROM prodotto WHERE (`CodP` = ?)";

				try {
					connection = DriverManagerConnectionPool.getConnection();
					preparedStatement1 = connection.prepareStatement(deleteSQL);
					preparedStatement1.setInt(1, codice);
					preparedStatement1.executeUpdate();
					connection.commit();
					
			
					
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
	public boolean doSave(ClienteBean product) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	}
