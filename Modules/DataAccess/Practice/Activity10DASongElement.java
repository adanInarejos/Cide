// Enum con las distintas etiquetas que componen cada cancion
public enum Activity10DASongElement {
    CANCION("cancion") ,GRUPO("grupo") ,CATEGORIA("categoria") ,NOMBRE("nombre") ,ALBUM("album"), AÑO("año");
 
    private String name;
 
    private Activity10DASongElement(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
    
}
