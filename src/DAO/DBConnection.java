package DAO;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    
    public OracleConnection Conn (){
        
         try {

          OracleDataSource ods = new OracleDataSource();
          ods.setURL("jdbc:oracle:thin:@localhost:1521:XE");
          ods.setUser("System");
          ods.setPassword("tiger");

          OracleConnection ocon = (OracleConnection)ods.getConnection();
          return ocon;

        } catch (SQLException e) 
        {
          System.out.println(e.getMessage());
          return null; 
        }
    }
    
     
    public List<String> GetStringList(String table,String field,String Condition){   
        try {
          
          OracleConnection ocon = Conn();
          ocon.setAutoCommit(false);

          Statement stmt = ocon.createStatement();
          ResultSet rset = stmt.executeQuery("SELECT " + field + " FROM " + table + " " + Condition);
            
          List<String> values = new ArrayList<String>();
          
          while(rset.next()) {
            values.add(rset.getString(1));
          }
          return values;
        } 
        catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
        }
    }
    
     public List<String> GetStringList(String field,String table){   
        try {
          
          OracleConnection ocon = Conn();
          ocon.setAutoCommit(false);

          Statement stmt = ocon.createStatement();
         
          ResultSet rset = stmt.executeQuery("SELECT " + field + " FROM " + table);
          
          List<String> values = new ArrayList<String>();
          
          while(rset.next()) {
            values.add(rset.getString(1));
          }
          return values;
        } 
        catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
        }
    }
}
