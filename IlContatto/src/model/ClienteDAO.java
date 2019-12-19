package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ClienteDAO implements Model{

	

	public synchronized Object Login(ClienteBean c) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT * FROM utente WHERE username=? AND password=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, c.getUn());
			preparedStatement.setString(2, c.getPw());
			ResultSet rs = preparedStatement.executeQuery();
		
			
			if (rs.next()) {
				if(c.getUn().equals(rs.getString("Username")) && c.getPw().equals(rs.getString("Password"))) {
					c.setCognome(rs.getString("Cognome"));
					c.setNome(rs.getString("Nome"));
					c.setMail(rs.getString("Mail"));
					c.setEta(rs.getInt("Eta"));
					c.setTipo(rs.getInt("Tipo"));
					c.setAddress(rs.getString("Indirizzo"));
					c.setCap(rs.getInt("Cap"));
					c.setCity(rs.getString("Città"));
					c.setState(rs.getString("Stato"));
					c.setCf(rs.getString("CodiceFis"));
					connection.commit();
					return c;
			}
				
				else return null;	
		 
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
		
		return null;
		
		
	}

	@Override
	public boolean doSave(ClienteBean nuovo) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		
		
		String userEs= nuovo.getUn();
		String selectSQL2 = "SELECT * FROM utente WHERE (Username=?)";
		 
		 try {
				connection = DriverManagerConnectionPool.getConnection();
				preparedStatement2 = connection.prepareStatement(selectSQL2);
				preparedStatement2.setString(1,userEs);
				
				ResultSet rs = preparedStatement2.executeQuery();
				connection.commit();
							
			
			 if (rs.next()) 	return false ;		 
		 } 
		 finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					DriverManagerConnectionPool.releaseConnection(connection);
				}
			}
		 
		

		String selectSQL= "INSERT INTO utente (`Username`, `Password`, `Nome`, `Eta`, `Cognome`, `Mail`, `Tipo`, `Indirizzo`, `Stato`, `Città`, `Cap`,`CodiceFis`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, nuovo.getUn());
			preparedStatement.setString(2, nuovo.getPw());
			preparedStatement.setString(3, nuovo.getNome());
			preparedStatement.setInt(4, nuovo.getEta());
			preparedStatement.setString(5, nuovo.getCognome());
			preparedStatement.setString(6, nuovo.getMail());
			preparedStatement.setInt(7, nuovo.getTipo());
			preparedStatement.setString(8, nuovo.getAddress());
			preparedStatement.setString(9, nuovo.getState());
			preparedStatement.setString(10, nuovo.getCity());
			preparedStatement.setInt(11, nuovo.getCap());
			preparedStatement.setString(12, nuovo.getCf());
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
		
		return true;
		
	}
	
	
	public void aggiornaUtente(ClienteBean nuovo) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
try {
		String selectSQL= "UPDATE utente SET Username = ?, Password = ?, Nome = ?, Eta = ?, Cognome = ?, Mail = ?, Tipo = ?, Indirizzo = ?, Stato = ?, Città = ?, Cap = ? WHERE (Username = ?);";

		
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, nuovo.getUn());
			preparedStatement.setString(2, nuovo.getPw());
			preparedStatement.setString(3, nuovo.getNome());
			preparedStatement.setInt(4, nuovo.getEta());
			preparedStatement.setString(5, nuovo.getCognome());
			preparedStatement.setString(6, nuovo.getMail());
			preparedStatement.setInt(7, nuovo.getTipo());
			preparedStatement.setString(8, nuovo.getAddress());
			preparedStatement.setString(9, nuovo.getState());
			preparedStatement.setString(10, nuovo.getCity());
			preparedStatement.setInt(11, nuovo.getCap());
			preparedStatement.setString(12, nuovo.getUn());
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
	

	public ArrayList<OrdineBean> getAllOrdini() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList <OrdineBean> lista = new ArrayList <OrdineBean>();
		
		String selectSQL = "SELECT * FROM ordine";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
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
	
	public ArrayList<OrdineBean> getOrdini(String c) throws SQLException{
		Connection connection = null;
		 PreparedStatement preparedStatement = null;
			ArrayList <OrdineBean> lista = new ArrayList <OrdineBean>();
		 String selectSQL = "SELECT * FROM ordine WHERE UsernameOrdine=? ORDER BY DataOrdine";
		 
		 try {
			 	connection = DriverManagerConnectionPool.getConnection();
				
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1,c);
				ResultSet rs = preparedStatement.executeQuery();
				connection.commit();
			
				
				while (rs.next()) {
					
					OrdineBean a = new OrdineBean();
					a.setCod(rs.getInt("Cod"));
					a.setDataOrdine(rs.getDate("DataOrdine"));
					a.setCostoTot(rs.getFloat("CostoTot"));
					a.setUsername(rs.getString("UsernameOrdine"));
					a.setCFUtente(rs.getString("CFutente"));
					
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
	
	public void insertPref(String u, int c) throws SQLException {
		
		boolean x=controllaPref(u,c);
		if(x==false) {
			
		
		Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 String selectSQL = "INSERT INTO preferiti (`UserUtente`, `CodProd`) VALUES (?,?)";
		 
		 try {
				connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1,u);
				preparedStatement.setInt(2, c);
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
		else removePref(u,c);
	}
	
	
	
public boolean controllaPref(String us, int cd) throws SQLException {
		
		Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 String selectSQL = "SELECT * FROM preferiti WHERE (`UserUtente` = ?) and (`CodProd` = ?)";
		 
		 try {
				connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1,us);
				preparedStatement.setInt(2, cd);
				
				ResultSet rs = preparedStatement.executeQuery();
				connection.commit();
							
			
			 if (rs.next()) 	return true ;
			 else return false;
		 
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
	
	public ArrayList<ClienteBean> getAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList <ClienteBean> lista = new ArrayList <ClienteBean>();
		
		String selectSQL = "SELECT * FROM utente";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			connection.commit();
			
			while (rs.next()) {
				ClienteBean a = new ClienteBean();
				a.setUn(rs.getString("Username"));
				a.setCognome(rs.getString("Cognome"));
				a.setNome(rs.getString("Nome"));
				a.setMail(rs.getString("Mail"));
				a.setEta(rs.getInt("Eta"));
				a.setTipo(rs.getInt("Tipo"));
				a.setAddress(rs.getString("Indirizzo"));
				a.setCap(rs.getInt("Cap"));
				a.setCity(rs.getString("Città"));
				a.setState(rs.getString("Stato"));
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
	
	
	
	public ArrayList<OrdineBean> getOrdiniByData(Date from, Date to) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList <OrdineBean> lista = new ArrayList <OrdineBean>();
		
		String selectSQL = "SELECT * FROM ordine WHERE DataOrdine BETWEEN  ?  AND  ? ";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			Date date1 = from;
			Date date2 = to;
			preparedStatement.setDate(1,date1);
			preparedStatement.setDate(2,date2);
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
	
	public void removePref(String u,int c) throws SQLException {
		Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 String selectSQL = "DELETE FROM preferiti WHERE (`UserUtente` = ?) and (`CodProd` = ?)";
		 
		 
		 try {
			 	connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1,u);
				preparedStatement.setInt(2, c);
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
	
	
public ArrayList<ProductBean> getWList(String u) {
		
		Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 ArrayList <ProductBean> lista = new ArrayList <ProductBean>();
		 String selectSQL = "SELECT * FROM preferiti WHERE UserUtente=?";
		 
		 try {
			 	connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1,u);
				ResultSet rs = preparedStatement.executeQuery();
				ProductDAO check= new ProductDAO();
				ProductBean prodotto = new ProductBean();
				
				while (rs.next()) {
					WishBean a = new WishBean();
					a.setCodProd(rs.getInt("CodProd"));
					prodotto= check.doRetrieveByKey(a.getCodProd());
					lista.add(prodotto);
					
				}
				return lista;
			} 
			
			catch(Exception e) {
				e.printStackTrace();
			}
		 return lista;
	}

	public void cambioPass(String utente, String psw) throws SQLException {
		Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 
		 String selectSQL = "UPDATE utente SET Password = ? WHERE (Username = ?)";
		try { connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, psw);
			preparedStatement.setString(2, utente);
			
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
	
	
	public boolean utenteEsistente(String user) throws SQLException {
		
		 Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 String selectSQL = "SELECT * FROM utente WHERE (Username=?)";
		 
		 try {
				connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1,user);
				
				ResultSet rs = preparedStatement.executeQuery();
				connection.commit();
							
			
			 if (rs.next()) 	return false ;
			 else return true;
		 
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
		// TODO Auto-generated method stub //dobbiamo implementare la cancellazione account
		return false;
	}

	@Override
	public ClienteBean doRetrieveByKey(int code) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> doRetrieveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> doRetrieveAll() throws SQLException {
		
		return null;
	}

}

