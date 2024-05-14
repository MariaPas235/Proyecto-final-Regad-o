package github.mariapas235.test;

import github.mariapas235.model.dao.PiecesDAO;

public class testFindAllPiece {
    public static void main(String[] args) {
        PiecesDAO p = new PiecesDAO();
        p.findAll();
        System.out.println(p.findAll().toString());
    }
}
