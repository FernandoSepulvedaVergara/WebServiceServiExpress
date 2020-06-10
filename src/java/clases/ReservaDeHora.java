package clases;

public class ReservaDeHora {
    private String fecha_reserva;
    private String hora_reserva;
    private int id_sucursal;
    private String rut;
    private int id_tipo_de_servicio;
    private String patente;

    public ReservaDeHora(String fecha_reserva, String hora_reserva, int id_sucursal, String rut, int id_tipo_de_servicio, String patente) {
        this.fecha_reserva = fecha_reserva;
        this.hora_reserva = hora_reserva;
        this.id_sucursal = id_sucursal;
        this.rut = rut;
        this.id_tipo_de_servicio = id_tipo_de_servicio;
        this.patente = patente;
    }
    
    public ReservaDeHora() {
        this.fecha_reserva = null;
        this.hora_reserva = null;
        this.id_sucursal = 0;
        this.rut = null;
        this.id_tipo_de_servicio = 0;
        this.patente = null;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getHora_reserva() {
        return hora_reserva;
    }

    public void setHora_reserva(String hora_reserva) {
        this.hora_reserva = hora_reserva;
    }

    public int getSucursal() {
        return id_sucursal;
    }

    public void setSucursal(int sucursal) {
        this.id_sucursal = sucursal;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }   

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public int getId_tipo_de_servicio() {
        return id_tipo_de_servicio;
    }

    public void setId_tipo_de_servicio(int id_tipo_de_servicio) {
        this.id_tipo_de_servicio = id_tipo_de_servicio;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
}
