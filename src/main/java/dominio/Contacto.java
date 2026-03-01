package dominio;

public class Contacto {
    //Atributos
    private int id;
    private String nombre;
    private String telefono;
    private String email;

    //Constructores

    public Contacto() {
        //Ejemplo de uso: SELECT
    }

    public Contacto(int id) {
        //Ejemplo de uso: DELETE
        this.id = id;
    }
    public Contacto(String nombre, String telefono, String email){
        //Ejemplo de uso: INSERT (id autoincrementable en MySQL)
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public Contacto(int id, String nombre, String telefono, String email){
        //EJEMPLO DE USO: UPDATE
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    //Métodos Get y Set
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //Sobrecarga método ToString
    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
