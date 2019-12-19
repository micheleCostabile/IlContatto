package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdineDAO implements Model{

	
	public void doSave(OrdineBean ordine) throws SQLException {
		 Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 String selectSQL = "INSERT INTO ordine (`Cod`, `DataOrdine`, `CostoTot`, `UsernameOrdine`, `CFutente`) VALUES (?,?,?,?,?)";

			try {
				connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setInt(1,ordine.getCod());
				preparedStatement.setDate(2,ordine.getDataOrdine());
				preparedStatement.setFloat(3,ordine.getCostoTot());
				preparedStatement.setString(4,ordine.getUsername());
				preparedStatement.setString(5,ordine.getCFUtente());
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
	
	public void insComp(ComposizioneBean composizione) throws SQLException {
		 Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 String selectSQL = "INSERT INTO composizione (`IdOrdine`, `CodiceProdotto`, `IvaOrd`, `PrezzoOrd`, `Quantità`) VALUES (?,?,?,?,?)";

			try {
				connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setInt(1,composizione.getX());
				preparedStatement.setInt(2,composizione.getCod());
				preparedStatement.setInt(3,composizione.getIva());
				preparedStatement.setFloat(4,composizione.getPrezzoOrdine());
				preparedStatement.setInt(5, composizione.getQty());
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
	
	
	
	public ArrayList<OrdineBean> getOrdiniByUser(String user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList <OrdineBean> lista = new ArrayList <OrdineBean>();
		
		String selectSQL = "SELECT * FROM ordine WHERE UsernameOrdine=? ";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1,user);
			
			ResultSet rs = preparedStatement.executeQuery();
			connection.commit();
			
			while (rs.next()) {
				OrdineBean a = new OrdineBean();
				a.setCFUtente(rs.getString("CFutente"));
				a.setCod(rs.getInt("Cod"));
				a.setCostoTot(rs.getInt("CostoTot"));
				a.setDataOrdine(rs.getDate("DataOrdine"));
				a.setUsername(rs.getString("UsernameOrdine"));
				
				connection.commit();
				
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
	
	public void decrementa(int qty, int cod) throws SQLException {
		 Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 String selectSQL = "UPDATE prodotto SET NumPezzi=? WHERE CodP= ? ";
		 ProductBean prodotto= new ProductBean();
		 ProductDAO check = new ProductDAO();
		 prodotto=check.doRetrieveByKey(cod);
		 int nP=prodotto.getPezzi()-qty;
		 
			try {
				connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setInt(1,nP);
				preparedStatement.setInt(2, cod);
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
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		OrdineBean a = new OrdineBean();
		String selectSQL = "SELECT * FROM ordine where Cod = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setInt(1,code);
			
			ResultSet rs = preparedStatement.executeQuery();
			connection.commit();
			
			if (rs.next()) {
				
				a.setCFUtente(rs.getString("CFutente"));
				a.setCod(rs.getInt("Cod"));
				a.setCostoTot(rs.getInt("CostoTot"));
				a.setDataOrdine(rs.getDate("DataOrdine"));
				a.setUsername(rs.getString("UsernameOrdine"));
				
				connection.commit();
				
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
	public ArrayList<Object> doRetrieveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> doRetrieveAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
