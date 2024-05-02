package github.mariapas235.model.entity;

import java.time.LocalDate;
import java.util.Objects;

public class ForHire {
    private Pieces pieces;
    private Workers workers;
    private LocalDate take;
    private LocalDate back;

    public ForHire(Pieces pieces, Workers workers, LocalDate take, LocalDate back) {
        this.pieces = pieces;
        this.workers = workers;
        this.take = take;
        this.back = back;
    }

    public ForHire() {
    }

    public Pieces getPieces() {
        return pieces;
    }

    public void setPieces(Pieces pieces) {
        this.pieces = pieces;
    }

    public Workers getWorkers() {
        return workers;
    }

    public void setWorkers(Workers workers) {
        this.workers = workers;
    }

    public LocalDate getTake() {
        return take;
    }

    public void setTake(LocalDate take) {
        this.take = take;
    }

    public LocalDate getBack() {
        return back;
    }

    public void setBack(LocalDate back) {
        this.back = back;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForHire forHire = (ForHire) o;
        return Objects.equals(pieces, forHire.pieces) && Objects.equals(workers, forHire.workers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieces, workers);
    }

    @Override
    public String toString() {
        return "ForHire{" +
                "pieces=" + pieces +
                ", workers=" + workers +
                ", take=" + take +
                ", back=" + back +
                '}';
    }
}
