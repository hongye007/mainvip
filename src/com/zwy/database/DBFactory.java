package com.zwy.database;

public class DBFactory {
	private DBHandler dbHandler;
	public DBHandler getDBHandler()
	{
		if(dbHandler==null){
			dbHandler = new DBHandler();
		}
		
		return dbHandler;
	}
}
