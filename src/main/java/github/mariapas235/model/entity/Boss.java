package github.mariapas235.model.entity;

import java.util.List;
import java.util.Objects;

public class Boss extends Person {
    private int IDBoss;
    private float wallet;
    private List<ForHire> forHireList;

    public Boss(String name, String email, String password, int IDBoss, float wallet) {
        super(name, email, password);
        this.IDBoss = IDBoss;
        this.wallet = wallet;
    }

    public Boss(String name, String email, String password) {
        super(name, email, password);

    }

    public Boss(String name, String email, String password, int IDBoss, float wallet, List<ForHire> forHireList) {
        super(name, email, password);
        this.IDBoss = IDBoss;
        this.wallet = wallet;
        this.forHireList = forHireList;
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

    public List<ForHire> getForHireList() {
        return forHireList;
    }

    public void setForHireList(List<ForHire> forHireList) {
        this.forHireList = forHireList;
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
                ", wallet=" + wallet +
                ", forHireList=" + forHireList +
                '}';
    }
}
