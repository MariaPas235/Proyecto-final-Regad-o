package github.mariapas235.model.entity;

public enum Category {
    HERRAMIENTAS_ELECTRICAS ("Herramientas_eléctricas"),
    HERRAMIENTAS_MANUALES ("Herramientas_manuales"),
    FERRETERIA ("Ferretería");

    private final String category;

    Category(String category) {
        this.category = category;
    }
}
