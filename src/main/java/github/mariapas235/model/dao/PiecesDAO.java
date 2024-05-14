package github.mariapas235.model.dao;

import github.mariapas235.model.connection.ConnectionMariaDB;
import github.mariapas235.model.entity.Category;
import github.mariapas235.model.entity.Garage;
import github.mariapas235.model.entity.Pieces;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PiecesDAO implements DAO<Pieces,String,Integer>{
    private final static String INSERT="INSERT INTO pieces (name,category,prize,quantity,garageNumber,IDBoss) VALUES (?,?,?,?,?,?)";
    private final static String UPDATE= "UPDATE pieces SET quantity=? WHERE name=?";
    private final static String FINDALL = "SELECT p.name, p.category,p.prize,p.quantity,p.garageNumber FROM pieces AS p";
    private final static String FINDBYNAME = "SELECT p.IDPieces,  p.name,p.category,p.prize,p.quantity,p.garageNumber FROM pieces AS p WHERE p.name=?";
    private final static String DELETE = "DELETE FROM pieces AS p WHERE p.IDPieces=?";

    @Override
    public Pieces insert(Pieces entity) {

        Pieces result = entity;
        if(entity !=null ){
            Pieces p = findById(entity.getIDPieces());
            try(PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERT)) {
                pst.setString(1, entity.getName());
                String category = entity.getCategory().toString().toUpperCase();
                pst.setString(2, category);
                pst.setFloat(3, entity.getPrize());
                pst.setInt(4,entity.getQuantity());
                pst.setInt(5,entity.getGarage().getGarageNumber());
                pst.setInt(6,entity.getBoss().getIDBoss());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Pieces update(Pieces entity) {
        Pieces result = entity;
        if(entity !=null){
            try(PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(UPDATE)) {
                pst.setInt(1,entity.getQuantity());
                pst.setString(2, entity.getName());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Pieces delete(Pieces entity) {
        if (entity != null || entity.getIDPieces()<0){
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
                pst.setInt(1,entity.getIDPieces());
                pst.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return entity;
    }

    @Override
    public Pieces findById(Integer key) {
        return null;
    }

    public Pieces findByName(String key) {
        Pieces result=null;
        if (key!=null) {

            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYNAME)) {
                GarageDAO gDAO = new GarageDAO();
                pst.setString(1,key);
                ResultSet res = pst.executeQuery();
                if (res.next()){

                    result = new Pieces();
                    result.setIDPieces(res.getInt("IDPieces"));
                    result.setName(res.getString("name"));
                    String categoryS= res.getString("category");
                    Category category = Category.valueOf(categoryS.toUpperCase());
                    result.setCategory(category);
                    result.setPrize(res.getFloat("prize"));
                    result.setQuantity(res.getInt("quantity"));
                    result.setGarage(gDAO.findById(res.getInt("GarageNumber")));


                }

                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Pieces> findAll() {
        List<Pieces> result = new ArrayList<>();

        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDALL)) {
            GarageDAO GDAo= new GarageDAO();
            ResultSet res = pst.executeQuery();
            while (res.next()){
                Pieces p = new Pieces();
                p.setName(res.getString("name"));
                String categoryS= res.getString("category");
                Category category = Category.valueOf(categoryS.toUpperCase());
                p.setCategory(category);
                p.setGarage(GDAo.findById(res.getInt("GarageNumber")));
                p.setPrize(res.getFloat("prize"));
                p.setQuantity(res.getInt("quantity"));
                result.add(p);
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
