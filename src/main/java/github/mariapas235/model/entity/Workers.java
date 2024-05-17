package github.mariapas235.model.entity;

import java.util.List;
import java.util.Objects;
import java.util.jar.Attributes;

public class Workers extends Person {
    private int IDWorker;

    private Position position;

    private List<ForHire> forHireList;
    public Workers(String name, String email, String password, Position position) {
        super(name, email, password);

        this.position = position;
    }

    public Workers(String name, String email, String password, int IDWorker, Position position, List<ForHire> forHireList) {
        super(name, email, password);
        this.IDWorker = IDWorker;
        this.position = position;
        this.forHireList = forHireList;
    }

    public Workers() {
    }

    public int getIDWorker() {
        return IDWorker;
    }

    public void setIDWorker(int IDWorker) {
        this.IDWorker = IDWorker;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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
        Workers workers = (Workers) o;
        return IDWorker == workers.IDWorker;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), IDWorker);
    }

    @Override
    public String toString() {
        return "Workers{" +
                "IDWorker=" + IDWorker +
                ", position=" + position +
                ", forHireList=" + forHireList +
                '}';
    }
}