package modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    //aaa-mm-dd LocalDate
    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    //Agrego Getters &Setters

    public int getId_cliente(int id) {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    //Agrego Equal & Hashcode y ToString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (id_cliente != cliente.id_cliente) return false;
        if (!nombre.equals(cliente.nombre)) return false;
        if (!apellido.equals(cliente.apellido)) return false;
        return fechaNacimiento.equals(cliente.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        int result = id_cliente;
        result = 31 * result + nombre.hashCode();
        result = 31 * result + apellido.hashCode();
        result = 31 * result + fechaNacimiento.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }

    public Cliente postCliente(Cliente cliente) {return null;};}

