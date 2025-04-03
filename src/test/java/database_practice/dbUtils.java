package database_practice;

import java.sql.*;


public class dbUtils {

    private static final String DB_URL = "";
    private static final String DB_USR = "";
    private static final String DB_PWD = "";
    private static Connection getConnections(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            System.out.println("Successfully connected ");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    private static void executeQuery(String query){
        try (Connection connection = getConnections();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)
        ){
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for(int i =0;i<columnCount;i++){
                System.out.println(metaData.getColumnName(i)+" "+resultSet.getString(i)+" |");
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


}
