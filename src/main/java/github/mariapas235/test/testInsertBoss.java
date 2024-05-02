package github.mariapas235.test;

import github.mariapas235.model.dao.BossDAO;
import github.mariapas235.model.entity.Boss;


public class testInsertBoss {
    public static void main(String[] args) {
        Boss b = new Boss("Juam","minovialamejor","1234");
        BossDAO bDAO = new BossDAO();
        bDAO.insert(b);
    }
}
