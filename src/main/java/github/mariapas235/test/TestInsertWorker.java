package github.mariapas235.test;

import github.mariapas235.model.dao.WorkersDAO;
import github.mariapas235.model.entity.Position;
import github.mariapas235.model.entity.Workers;

public class TestInsertWorker {
    public static void main(String[] args) {
        Position soldador = Position.SOLDADOR;
        Workers w = new Workers("Juan","juane2@gmail.com","1234", soldador);
        WorkersDAO wDAO = new WorkersDAO();
        wDAO.insert(w);
    }
}
