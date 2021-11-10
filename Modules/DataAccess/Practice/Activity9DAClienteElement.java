// Enum con las distintas etiquetas que componen cada cliente.
public enum Activity9DAClienteElement {
    ClIENTE("cliente") ,NOMBRE("Nombre"), EDAD("edad");
 
    private String name;
 
    private Activity9DAClienteElement(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
}
 