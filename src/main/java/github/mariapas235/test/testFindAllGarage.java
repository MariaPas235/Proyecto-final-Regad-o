package github.mariapas235.test;

import github.mariapas235.model.dao.GarageDAO;
import github.mariapas235.model.dao.PiecesDAO;

public class testFindAllGarage {
    public static void main(String[] args) {
        GarageDAO gDAO = new GarageDAO();
        gDAO.findAll();
        System.out.println(gDAO.findAll().toString());
    }
}
