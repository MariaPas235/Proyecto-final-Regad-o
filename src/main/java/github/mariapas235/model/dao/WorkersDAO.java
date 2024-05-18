package github.mariapas235.model.dao;

import github.mariapas235.model.connection.ConnectionMariaDB;
import github.mariapas235.model.entity.*;
import javafx.concurrent.Worker;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkersDAO implements DAO<Workers,String,Integer>{
    private final static String INSERT="INSERT INTO worker (name,email,password,position) VALUES (?,?,?,?)";
    private final static String UPDATE= "UPDATE worker SET position=? WHERE email=?";
    private final static String FINDALL = "SELECT w.IDWorker, w.name FROM worker AS w";
    private final static String FINDBYEMAIL = "SELECT w.email, w.password FROM worker AS w WHERE w.email=?";
    private final static String FINDBYEMAILALL= "SELECT w.IDWorker, w.name, w.email, w.password, w.position FROM worker AS w WHERE w.email=?";
    private final static String FINDBYID = "SELECT w.IDWorker, w.name FROM worker AS w WHERE w.IDWorker=?";
    private final static String DELETE = "DELETE FROM worker AS w WHERE w.IDWorker=?";
  //  private final static String

    /**
     * Inserts a new Workers entity into the database.
     * @param entity the Workers entity to insert
     * @return the inserted Workers entity
     */
    @Override
    public Workers insert(Workers entity) {
        Workers result = new Workers();
        if(entity !=null || entity.getIDWorker()>0){
            Workers w = findById(entity.getIDWorker());
            try(PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERT)) {
                pst.setString(1, entity.getName());
                pst.setString(2, entity.getEmail());
                pst.setString(3, entity.getPassword());
                pst.setString(4,entity.getPosition().name());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Updates an existing Workers entity in the database.
     * @param entity the Workers entity to update
     * @return the updated Workers entity
     */
    @Override
    public Workers update(Workers entity) {
        Workers result = entity;
        if(entity !=null || entity.getIDWorker()>0){
            try(PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(UPDATE)) {

                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Deletes a Workers entity from the database.
     * @param entity the Workers entity to delete
     * @return the deleted Workers entity
     */
    @Override
    public Workers delete(Workers entity) {
        if (entity != null || entity.getIDWorker()<0){
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
                pst.setInt(1,entity.getIDWorker());
                pst.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return entity;
    }

    /**
     * Finds a Workers entity by its ID.
     * @param key the ID of the Workers entity to find
     * @return the found Workers entity
     */
    @Override
    public Workers findById(Integer key) {
        Workers result = new Workers();
        if (key>0) {

            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYID)) {
                pst.setInt(1,key);
                ResultSet res = pst.executeQuery();
                if (res.next()){
                    result.setIDWorker(res.getInt("IDWorker"));
                    result.setName(res.getString("name"));

                    //Lazy
                    //PiecesDAO.ForHireDAO fhDAO = new PiecesDAO.ForHireDAO();
                    //result.setForHireList(fhDAO.findByIDWorker(result));
                }
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Verifies a Workers entity by its email.
     * @param key the email of the Workers entity to verify
     * @return the verified Workers entity
     */
    public Workers verify(String key)     {
        Workers result = new Workers();
        if (key!= null) {

            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYEMAIL)) {
                pst.setString(1,key);
                ResultSet res = pst.executeQuery();
                if (res.next()){
                    result.setEmail(res.getString("email"));
                    result.setPassword(res.getString("password"));
                }
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Finds a Workers entity by its email, including all details.
     * @param key the email of the Workers entity to find
     * @return the found Workers entity with all details
     */
    public Workers findByEmailAll(String key) {
        Workers result = new Workers();
        if (key!=null) {

            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYEMAILALL)) {
                pst.setString(1,key);
                ResultSet res = pst.executeQuery();
                if (res.next()){
                    result.setIDWorker(res.getInt("IDWorker"));
                    result.setName(res.getString("name"));
                    result.setEmail(res.getString("email"));
                    result.setPassword(res.getString("password"));
                    String position = res.getString("position");
                    Position p = Position.valueOf(position.toUpperCase());
                    result.setPosition((p));
                }
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Finds all Workers entities in the database.
     * @return a list of all Workers entities
     */
    @Override
    public List<Workers> findAll() {
        List<Workers> result = new ArrayList<>();

        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDALL)) {
            ResultSet res = pst.executeQuery();
            while (res.next()){
                Workers w = new Workers();
                w.setIDWorker(res.getInt("IDWorker"));
                w.setName(res.getString("name"));
                result.add(w);
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Closes the resources, currently does nothing.
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void close() throws IOException {

    }
}