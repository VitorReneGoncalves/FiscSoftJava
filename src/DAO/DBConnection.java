package DAO;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    public void conn(){   
        try {

          OracleDataSource ods = new OracleDataSource();
          ods.setURL("jdbc:oracle:thin:@localhost:1521:XE");
          ods.setUser("System");
          ods.setPassword("tiger");

          OracleConnection ocon = (OracleConnection)ods.getConnection();
          ocon.setAutoCommit(false);

          Statement stmt = ocon.createStatement();
          ResultSet rset = stmt.executeQuery("SELECT RA,NOME FROM ALUNO");

          while(rset.next()) {
            System.out.println(rset.getInt(1) + ", " +
                               rset.getString(2));
          }

        } catch (SQLException e) {
          System.out.println(e.getMessage());
        }
    }
}
