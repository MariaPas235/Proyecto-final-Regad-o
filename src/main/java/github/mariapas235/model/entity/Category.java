package github.mariapas235.model.entity;

public enum Category {
    HERRAMIENTAS_ELECTRICAS ("Herramientas eléctricas"),
    HERRAMIENTAS_MANUALES ("Herramientas manuales"),
    FERRETERIA ("Ferretería");

    private final String category;

    Category(String category) {
        this.category = category;
    }
}
