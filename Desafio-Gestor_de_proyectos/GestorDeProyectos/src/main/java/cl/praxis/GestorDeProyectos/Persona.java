package cl.praxis.GestorDeProyectos;

public class Persona {
    public String nombre;
    public String apellido;
    public int edad;

    // Constructor para inicializar los atributos
    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    // Método para mostrar la información de la persona en formato de texto
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nApellido: " + apellido + "\nEdad: " + edad;
    }
}
