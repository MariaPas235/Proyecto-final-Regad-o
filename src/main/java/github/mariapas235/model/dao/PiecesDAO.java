package github.mariapas235.model.dao;

import github.mariapas235.model.connection.ConnectionMariaDB;
import github.mariapas235.model.entity.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PiecesDAO implements DAO<Pieces, String, Integer> {
    private final static String INSERT = "INSERT INTO pieces (name,category,prize,quantity,garageNumber,IDBoss) VALUES (?,?,?,?,?,?)";
    private final static String UPDATE = "UPDATE pieces SET quantity=? WHERE name=?";
    private final static String FINDALL = "SELECT p.name, p.category,p.prize,p.quantity,p.garageNumber FROM pieces AS p";
    private final static String FINDBYNAME = "SELECT p.IDPieces,  p.name,p.category,p.prize,p.quantity,p.garageNumber FROM pieces AS p WHERE p.name=?";
    private final static String FINDBYID = "SELECT p.IDPieces,  p.name,p.category,p.prize,p.quantity,p.garageNumber FROM pieces AS p WHERE p.IDPieces=?";

    private final static String DELETE = "DELETE FROM pieces WHERE IDPieces=?";


    @Override
    public Pieces insert(Pieces entity) {

        Pieces result = entity;
        if (entity != null) {
            Pieces p = findByName(entity.getName());
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERT)) {
                pst.setString(1, entity.getName());
                String category = entity.getCategory().toString().toUpperCase();
                pst.setString(2, category);
                pst.setFloat(3, entity.getPrize());
                pst.setInt(4, entity.getQuantity());
                pst.setInt(5, entity.getGarage().getGarageNumber());
                pst.setInt(6, entity.getBoss().getIDBoss());
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
        if (entity != null) {
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(UPDATE)) {
                pst.setInt(1, entity.getQuantity());
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
        if (entity != null || entity.getIDPieces() < 0) {
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
                pst.setInt(1, entity.getIDPieces());
                pst.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return entity;
    }

    public static Pieces findByIds(Integer key) {
        return null;
    }

    public Pieces findById(Integer key) {
        Pieces result = null;
        if (key != null) {

            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYID)) {
                GarageDAO gDAO = new GarageDAO();
                pst.setInt(1, key);
                ResultSet res = pst.executeQuery();
                if (res.next()) {

                    result = new Pieces();
                    result.setIDPieces(res.getInt("IDPieces"));
                    result.setName(res.getString("name"));
                    String categoryS = res.getString("category");
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

    public Pieces findByName(String key) {
        Pieces result = null;
        if (key != null) {

            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYNAME)) {
                GarageDAO gDAO = new GarageDAO();
                pst.setString(1, key);
                ResultSet res = pst.executeQuery();
                if (res.next()) {

                    result = new Pieces();
                    result.setIDPieces(res.getInt("IDPieces"));
                    result.setName(res.getString("name"));
                    String categoryS = res.getString("category");
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
            GarageDAO GDAo = new GarageDAO();
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Pieces p = new Pieces();
                p.setName(res.getString("name"));
                String categoryS = res.getString("category");
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

    public static class ForHireDAO {
        PiecesDAO pdao = new PiecesDAO();
        private final static String INSERT = "INSERT INTO ForHire (IDPieces,take,IDWorker) VALUES (?,?,?)";
        private final static String FINDBYIDWORKER = "SELECT fh.IDPieces, fh.take, fh.back, fh.IDWorker FROM ForHire AS fh WHERE IDWorker=?";
        private final static String FINDALL = "SELECT fh.IDPieces, fh.IDWorker,fh.take,fh.back FROM ForHire AS fh";


        public ForHire insert(Pieces entity, ForHire entityForHire) {

            ForHire result2 = entityForHire;
            if (entityForHire != null) {
                Pieces p = pdao.findByName(entity.getName());
                try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERT)) {
                    entityForHire.setPieces(pdao.findByName(entity.getName()));
                    pst.setInt(1, entityForHire.getPieces().getIDPieces());
                    entityForHire.setTake(LocalDate.now().toString());
                    pst.setString(2, entityForHire.getTake());


                    String email = Session.getInstance().getUserLogged().getEmail();
                    WorkersDAO w = new WorkersDAO();
                    Workers worker = w.findByEmailAll(email);
                    pst.setInt(3, worker.getIDWorker());

                    pst.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return result2;
        }


        public ForHire findByIDWorker(Workers key) {
            ForHire result = null;
            if (key != null) {

                try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYIDWORKER)) {

                    pst.setInt(1, key.getIDWorker());
                    ResultSet res = pst.executeQuery();
                    if (res.next()) {

                        result = new ForHire();
                        PiecesDAO pDAO = new PiecesDAO();
                        result.setPieces(pDAO.findById(res.getInt("IDPieces")));
                        result.setTake(res.getString("take"));
                        result.setBack(res.getString("back"));
                        result.setWorkers((Workers) Session.getInstance().getUserLogged());


                    }

                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }

        public List<ForHire> findAllByIDWorker(Workers key) {
            List<ForHire> forhireList = new ArrayList<>();
            if (key != null && key.getIDWorker() > 0) {
                Connection conn = ConnectionMariaDB.getConnection();
                try (
                        PreparedStatement pst = conn.prepareStatement(FINDBYIDWORKER)) {
                    pst.setInt(1, key.getIDWorker());
                    try (ResultSet res = pst.executeQuery()) {
                        while (res.next()) {
                            ForHire forhire = new ForHire();
                            WorkersDAO wDao = new WorkersDAO();
                            PiecesDAO pDAO = new PiecesDAO();
                            Workers workers = wDao.findById(key.getIDWorker());

                            forhire.setWorkers(workers);
                            forhire.setPieces(pDAO.findById(res.getInt("IDPieces")));
                            forhire.setTake(res.getString("take"));
                            forhire.setBack(res.getString("back"));

                            forhireList.add(forhire);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return forhireList;
        }



public List<ForHire> findAll() {
    List<ForHire> result = new ArrayList<>();

    try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDALL)) {

        ResultSet res = pst.executeQuery();
        while (res.next()) {
            ForHire fh = new ForHire();

            PiecesDAO pDAO = new PiecesDAO();
            fh.setPieces(pDAO.findById(res.getInt("IDPieces")));
            WorkersDAO wDAO = new WorkersDAO();
            fh.setWorkers(wDAO.findById(res.getInt("IDWorker")));
            fh.setTake(res.getString("take"));
            fh.setBack(res.getString("back"));

            result.add(fh);
        }
        res.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return result;
}

public static ForHireDAO build() {
    return new ForHireDAO();
}

    }


            }
