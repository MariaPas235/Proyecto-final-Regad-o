package github.mariapas235.model.entity;

import java.util.Objects;
import java.util.jar.Attributes;

public class Workers extends Person {
    private int IDWorker;

    private Position position;

    public Workers(String name, String email, String password, Position position) {
        super(name, email, password);

        this.position = position;
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
        return "Workers{" +super.toString()+
                "IDWorker=" + IDWorker +
                ", position=" + position +
                '}';
    }
}