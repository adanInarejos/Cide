
// Enum con las distintas etiquetas que componen cada plato.
public enum Activity8DABreakfastElement {
    FOOD("food"), NAME("name"), PRICE("price"), DESCRIPTION("description"), CALORIES("calories");
 
    private String name;
 
    private Activity8DABreakfastElement(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
}
