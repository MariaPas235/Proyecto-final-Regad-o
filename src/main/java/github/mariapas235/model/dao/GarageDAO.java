package github.mariapas235.model.dao;

import github.mariapas235.model.connection.ConnectionMariaDB;
import github.mariapas235.model.entity.Boss;
import github.mariapas235.model.entity.Garage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GarageDAO implements DAO<Garage,String,Integer> {

    private final static String INSERT="INSERT INTO garage (garageNumber,name,location) VALUES (?,?,?)";
    private final static String UPDATE= "UPDATE garage SET name=? WHERE garageNumber=?";
    private final static String FINDALL = "SELECT g.garageNumber, g.name, g.location FROM garage AS g";
    private final static String FINDBYID = "SELECT g.garageNumber, g.name, g.location FROM garage AS g WHERE g.garageNumber=?";
    private final static String DELETE = "DELETE FROM garage AS g WHERE g.garageNumber=?";

    /**
     * Inserts a new Garage entity into the database.
     * @param entity the Garage entity to insert
     * @return the inserted Garage entity
     */
    @Override
    public Garage insert(Garage entity) {
        Garage result = entity;
        if(entity !=null || entity.getGarageNumber()>0){
            Garage g = findById(entity.getGarageNumber());
            try(PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERT)) {
                pst.setInt(1, entity.getGarageNumber());
                pst.setString(2, entity.getName());
                pst.setString(3, entity.getLocation());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Updates an existing Garage entity in the database.
     * @param entity the Garage entity to update
     * @return the updated Garage entity
     */
    @Override
    public Garage update(Garage entity) {
        Garage result = entity;
        if(entity !=null || entity.getGarageNumber()>0){
            try(PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(UPDATE)) {
                pst.setString(1,entity.getName());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Deletes an existing Garage entity from the database.
     * @param entity the Garage entity to delete
     * @return the deleted Garage entity
     */
    @Override
    public Garage delete(Garage entity) {
        if (entity != null || entity.getGarageNumber()<0){
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
                pst.setInt(1,entity.getGarageNumber());
                pst.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return entity;
    }


    /**
     * Finds a Garage entity by its ID.
     * @param key the ID of the Garage entity to find
     * @return the found Garage entity
     */

    @Override
    public Garage findById(Integer key) {
        Garage result = new Garage();
        if (key>0) {

            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYID)) {
                pst.setInt(1,key);
                ResultSet res = pst.executeQuery();
                if (res.next()){
                    result.setGarageNumber(res.getInt("GarageNumber"));
                    result.setName(res.getString("name"));
                    result.setLocation(res.getString("location"));
                }
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Finds all Garage entities in the database.
     * @return a list of all Garage entities
     */
    @Override
    public List<Garage> findAll() {
        List<Garage> result = new ArrayList<>();

        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDALL)) {
            ResultSet res = pst.executeQuery();
            while (res.next()){
                Garage g = new Garage();
                g.setGarageNumber(res.getInt("GarageNumber"));
                g.setName(res.getString("name"));
                g.setLocation(res.getString("location"));
                result.add(g);
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
