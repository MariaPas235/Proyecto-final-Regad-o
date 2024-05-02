package github.mariapas235.model.entity;

import java.util.Objects;

public class Boss extends Person {
    private int IDBoss;
    private float wallet;

    public Boss(String name, String email, String password, int IDBoss, float wallet) {
        super(name, email, password);
        this.IDBoss = IDBoss;
        this.wallet = wallet;
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

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
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
        return "Boss{" +super.toString()+
                "IDBoss=" + IDBoss +
                ", wallet=" + wallet +
                '}';
    }
}
