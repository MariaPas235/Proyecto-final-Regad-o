package github.mariapas235.model.entity;

import java.util.List;
import java.util.Objects;

public class Pieces {
    private int IDPieces;
    private String name;
    private Category category;
    private float prize;
    private int quantity;
    private Garage garage;
    private Boss boss;
    private List<ForHire> forHireList;

    public Pieces(int IDPieces, String name, Category category, float prize, int quantity, Garage garage) {
        this.IDPieces = IDPieces;
        this.name = name;
        this.category = category;
        this.prize = prize;
        this.quantity = quantity;
        this.garage = garage;
    }

    public Pieces(int IDPieces, String name, Category category, float prize, int quantity, Garage garage, Boss boss) {
        this.IDPieces = IDPieces;
        this.name = name;
        this.category = category;
        this.prize = prize;
        this.quantity = quantity;
        this.garage = garage;
        this.boss = boss;
    }

    public Pieces(String name, Category category, float prize, int quantity, Garage garage, Boss boss) {
        this.name = name;
        this.category = category;
        this.prize = prize;
        this.quantity = quantity;
        this.garage = garage;
        this.boss = boss;
    }

    public Pieces(int IDPieces, String name, Category category, float prize, int quantity, Garage garage, Boss boss, List<ForHire> forHireList) {
        this.IDPieces = IDPieces;
        this.name = name;
        this.category = category;
        this.prize = prize;
        this.quantity = quantity;
        this.garage = garage;
        this.boss = boss;
        this.forHireList = forHireList;
    }

    public Pieces(){}

    public int getIDPieces() {
        return IDPieces;
    }

    public void setIDPieces(int IDPieces) {
        this.IDPieces = IDPieces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public float getPrize() {
        return prize;
    }

    public void setPrize(float prize) {
        this.prize = prize;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
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
        Pieces pieces = (Pieces) o;
        return IDPieces == pieces.IDPieces;
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDPieces);
    }

    @Override
    public String toString() {
        return "Pieces{" +
                "IDPieces=" + IDPieces +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", prize=" + prize +
                ", quantity=" + quantity +
                ", garage=" + garage +
                ", boss=" + boss +
                ", forHireList=" + forHireList +
                '}';
    }
}
