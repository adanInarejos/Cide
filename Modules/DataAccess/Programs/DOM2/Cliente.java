import java.io.Serializable;
public class Cliente implements Serializable {
    private String nombre;
    private int edad;
    public Cliente(String nombre, int edad) {
        this.nombre=nombre;
        this.edad=edad;                              
        }
    public void setNombre (String nom) { 
        this.nombre=nom;
    }
    public void setEdad (int ed) {
        this.edad=ed;
    }
               
    public String getNombre() {
        return this.nombre;
    }
	public int getEdad() {
        return this.edad;
    }
 
}
