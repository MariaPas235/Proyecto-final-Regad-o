package github.mariapas235.model.entity;

import java.util.List;
import java.util.Objects;

public class Pieces {
    private int IDPieces;
    private String name;
    private Category category;
    private float prize;
    private int quantity;
    private List<Garage> garages;


    public Pieces(int IDPieces, String name, Category category, float prize, int quantity, List<Garage> garages) {
        this.IDPieces = IDPieces;
        this.name = name;
        this.category = category;
        this.prize = prize;
        this.quantity = quantity;
        this.garages = garages;
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

    public List<Garage> getGarages() {
        return garages;
    }

    public void setGarages(List<Garage> garages) {
        this.garages = garages;
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
                ", garages=" + garages +
                '}';
    }
}