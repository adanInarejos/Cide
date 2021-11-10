// Clase cancion con los elementos que la forman
public class Activity10DASong {

    private String grupo;
    private String categoria;
    private String nombre;
    private String album;
    private String año;
    

    public Activity10DASong(String grupo, String categoria, String nombre, String album, String año){
        this.grupo=grupo;
        this.categoria=categoria;
        this.nombre=nombre;
        this.album=album;
        this.año=año;

    }
    

    public Activity10DASong(){

    }

    public String getGrupo() {
        return grupo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAlbum() {
        return album;
    }

    public String getAno() {
        return año;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setAlbum(String album) {
        this.album = album;
    }

    public void setAño(String año) {
        this.año = año;
    }



    
}
