package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Model {
	public boolean doSave(ClienteBean product) throws SQLException;

	public boolean doDelete(int code) throws SQLException;

	public Object doRetrieveByKey(int code) throws SQLException;
	
	public ArrayList <Object> doRetrieveAll(String order) throws SQLException;
	
	public ArrayList <Object> doRetrieveAll() throws SQLException;
	
}
