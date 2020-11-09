package dao;

import connection.ConnectionDb;
import models.User;
import idao.IDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alsorc
 */
public class DaoAgenda implements IDao<User, Integer>{
    
    private ConnectionDb myConnect = ConnectionDb.getInstance();
    private String sql = "";
    private User myUser = new User();
    private List<User> myUsersData = new ArrayList();
    private transient  Connection driverPostgres;
    private transient  PreparedStatement preQuery;

    public DaoAgenda() {
           driverPostgres = ConnectionDb.getInstance().getDriver();
    }
    
    @Override
    public boolean insertRecord(User usuario) {
        try {
            sql = "INSERT INTO agenda VALUES (?,?,?);";
            preQuery = driverPostgres.prepareStatement(sql);
            preQuery.setInt(1, usuario.getId());
            preQuery.setString(2, usuario.getName());
            preQuery.setString(3, usuario.getDirection());
            
            if(preQuery.executeUpdate() > 0){
                System.out.println("Guardado con éxito");
            }else{
                System.out.println("Error al guardar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean deleteRecord(Integer v) {
        sql = "DELETE FROM agenda WHERE (clave = " + v +");";
        return myConnect.updateTable(sql);
    }

    @Override
    public boolean updateRecord(User t, Integer v) {
        sql = "UPDATE agenda SET nombre = '" + t.getName() + "', direccion = '" + t.getDirection() + "' WHERE (clave = " + v + ");"; 
        return myConnect.updateTable(sql);
    }

    @Override
    public User readOneRecord(Integer v) {
        sql = "SELECT * FROM agenda WHERE (clave = " + v + ");";
        ResultSet data = myConnect.getData(sql);
        try {
            if(data.next()){
               myUser.setId(data.getInt("clave"));
               myUser.setName(data.getString("direccion"));
               myUser.setDirection(data.getString("nombre"));
            }else{
                System.out.println("No hay registros disponibles!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myUser;
    }

    @Override
    public List<User> readRecords() {
        try {
            sql = "SELECT * FROM agenda;";
            ResultSet data = myConnect.getData(sql);
            while(data.next()){
                myUsersData.add(new User(data.getInt(1),
                        data.getString(2), 
                        data.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myUsersData;
    }
    
}
