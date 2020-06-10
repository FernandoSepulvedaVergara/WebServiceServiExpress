package clases;

public class Atenciones {

private int id_atencion;
private String hora_reserva;
private String fecha_reserva;
private String usuario_rut;
private String patente;
private int id_reserva;
private String sucursal;
private int id_estado;

    public Atenciones(int id_atencion, String hora_reserva, String fecha_reserva, String usuario_rut, String patente, int id_reserva, String sucursal, int id_estado) {
        this.id_atencion = id_atencion;
        this.hora_reserva = hora_reserva;
        this.fecha_reserva = fecha_reserva;
        this.usuario_rut = usuario_rut;
        this.patente = patente;
        this.id_reserva = id_reserva;
        this.sucursal = sucursal;
        this.id_estado = id_estado;        
    }

    public Atenciones() {
    }

    public int getId_atencion() {
        return id_atencion;
    }

    public void setId_atencion(int id_atencion) {
        this.id_atencion = id_atencion;
    }

    public String getHora_reserva() {
        return hora_reserva;
    }

    public void setHora_reserva(String hora_reserva) {
        this.hora_reserva = hora_reserva;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getUsuario_rut() {
        return usuario_rut;
    }

    public void setUsuario_rut(String usuario_rut) {
        this.usuario_rut = usuario_rut;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }
}
