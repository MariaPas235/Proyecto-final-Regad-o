package github.mariapas235.model.entity;

public enum Position {
    SOLDADOR("Soldador"),
    PEON("Peon"),
    ELECTRICISTA("Electricista"),
    TRANSPORTISTA("Transportista");

    private final String position;

    Position(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

}
