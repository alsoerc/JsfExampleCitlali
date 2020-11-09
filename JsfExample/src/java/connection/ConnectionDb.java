package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alsorc
 */
public class ConnectionDb {
    
    private static ConnectionDb myInstance;
    
    private Connection connect2Db;
    
    private String url = "jdbc:postgresql://localhost:5436/usuarios";
    private String user = "postgres";
    private String password = "12334";
      private transient  Connection driverPostgres;
    
    private ConnectionDb() {       
        try {
            connect2Db = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado..!!!");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ConnectionDb getInstance(){
        if(myInstance == null){
            myInstance = new ConnectionDb();
        }
        return myInstance;
    }
    
    public String sayHello(){
        return "Hola";
    }
    
    public String sayBye(){
        return "Bye";
    }
    
    
    public Boolean updateTable(String sql){
        boolean res = false;
        try {
            Statement myStatement = connect2Db.createStatement();
            res = myStatement.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public ResultSet getData(String sql){
        ResultSet records = null;
        try {
            Statement myStatement = connect2Db.createStatement();
            records = myStatement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return records;
    }
    

    public Connection getDriver(){
        return connect2Db;
     }
    
    
    
    
    
}
