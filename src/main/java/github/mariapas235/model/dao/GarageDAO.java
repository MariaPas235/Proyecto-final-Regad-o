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
    private final static String FINDALL = "SELECT g.garageNumber, g.name FROM garage AS g";
    private final static String FINDBYID = "SELECT g.garageNumber, g.name FROM garage AS g WHERE g.garageNumber=?";
    private final static String DELETE = "DELETE FROM garage AS g WHERE g.garageNumber=?";

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
                }
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Garage> findAll() {
        List<Garage> result = new ArrayList<>();

        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDALL)) {
            ResultSet res = pst.executeQuery();
            while (res.next()){
                Garage g = new Garage();
                g.setGarageNumber(res.getInt("GarageNumber"));
                g.setName(res.getString("name"));
                result.add(g);
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void close() throws IOException {

    }
}
