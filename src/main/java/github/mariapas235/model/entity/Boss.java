package github.mariapas235.model.entity;

import java.util.List;
import java.util.Objects;

public class Boss extends Person {
    private int IDBoss;



    public Boss(String name, String email, String password, int IDBoss) {
        super(name, email, password);
        this.IDBoss = IDBoss;

    }

    public Boss(String name, String email, String password) {
        super(name, email, password);

    }



    public Boss() {
    }

    public int getIDBoss() {
        return IDBoss;
    }

    public void setIDBoss(int IDBoss) {
        this.IDBoss = IDBoss;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Boss boss = (Boss) o;
        return IDBoss == boss.IDBoss;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), IDBoss);
    }

    @Override
    public String toString() {
        return "Boss{" +
                "IDBoss=" + IDBoss +
                '}';
    }
}
