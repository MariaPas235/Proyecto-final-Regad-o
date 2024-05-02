package github.mariapas235.model.dao;

import github.mariapas235.model.entity.Pieces;

import java.io.IOException;
import java.util.List;

public class PiecesDAO implements DAO<Pieces,String,Integer> {
    private final static String INSERT="INSERT INTO pieces (name,category,prize,quantity) VALUES (?,?,?,?)";
    private final static String UPDATE= "UPDATE pieces SET quantity=? WHERE name=?";
    private final static String FINDALL = "SELECT p.IDPieces, p.name FROM pieces AS p";
    private final static String FINDBYID = "SELECT p.IDPieces, p.name FROM pieces AS p WHERE p.IDPieces=?";
    private final static String DELETE = "DELETE FROM pieces AS p WHERE p.IDPieces=?";
    @Override
    public Pieces insert(Pieces entity) {
        return null;
    }

    @Override
    public Pieces update(Pieces entity) {
        return null;
    }

    @Override
    public Pieces delete(Pieces entity) {
        return null;
    }

    @Override
    public Pieces findById(Integer key) {
        return null;
    }

    @Override
    public List<Pieces> findAll() {
        return null;
    }

    @Override
    public void close() throws IOException {

    }
}
