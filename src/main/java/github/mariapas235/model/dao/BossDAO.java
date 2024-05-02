package github.mariapas235.model.dao;

import github.mariapas235.model.connection.ConnectionMariaDB;
import github.mariapas235.model.entity.Boss;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BossDAO implements DAO<Boss,String, Integer>{

    private final static String INSERT="INSERT INTO boss (name,email,password) VALUES (?,?,?)";
    private final static String INSERTWALLET = "INSERT INTO boss (wallet) VALUES (?)";
    private final static String UPDATE="UPDATE boss SET wallet=? WHERE email=?)";
    private final static String FINDALL = "SELECT b.IDBoss, b.name FROM boss AS b";
    private final static String FINDBYID = "SELECT b.IDBoss, b.name FROM boss AS b WHERE b.IDBoss=?";
    private final static String DELETE = "DELETE FROM boos AS b WHERE b.IDBoss=?";

    @Override
    public Boss insert(Boss entity) {
        Boss result = entity;
        if(entity !=null || entity.getIDBoss()>0){
            Boss b = findById(entity.getIDBoss());
            try(PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERT)) {
                pst.setString(1, entity.getName());
                pst.setString(2, entity.getEmail());
                pst.setString(3, entity.getPassword());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public Boss insertWallet(Boss entity){
        Boss result = entity;
        if(entity !=null || entity.getIDBoss()>0){
            Boss b = findById(entity.getIDBoss());
            try(PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERTWALLET)) {
                pst.setFloat(1, entity.getWallet());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Boss update(Boss entity) {
        Boss result = entity;
        if(entity !=null || entity.getIDBoss()>0){
            try(PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(UPDATE)) {
                pst.setFloat(1,entity.getWallet());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    @Override
    public Boss delete(Boss entity) {
        if (entity != null || entity.getIDBoss()<0){
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
                pst.setInt(1,entity.getIDBoss());
                pst.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return entity;
    }

    @Override
    public Boss findById(Integer key) {
        Boss result = new Boss();
        if (key>0) {

            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYID)) {
                pst.setInt(1,key);
                ResultSet res = pst.executeQuery();
                if (res.next()){
                    result.setIDBoss(res.getInt("IDBoss"));
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
    public List<Boss> findAll() {
        List<Boss> result = new ArrayList<>();

        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDALL)) {
            ResultSet res = pst.executeQuery();
            while (res.next()){
                Boss b = new Boss();
                b.setIDBoss(res.getInt("IDBoss"));
                b.setName(res.getString("name"));
                result.add(b);
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
