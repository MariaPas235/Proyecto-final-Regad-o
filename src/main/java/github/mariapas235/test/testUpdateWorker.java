package github.mariapas235.test;

import github.mariapas235.model.dao.WorkersDAO;
import github.mariapas235.model.entity.Position;
import github.mariapas235.model.entity.Workers;

public class testUpdateWorker {
    public static void main(String[] args) {
        WorkersDAO wDAO = new WorkersDAO();
        Workers worker = wDAO.findById(1);
        wDAO.update(worker);
    }
}
