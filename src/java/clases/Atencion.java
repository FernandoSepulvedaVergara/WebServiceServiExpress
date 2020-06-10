package clases;

public class Atencion {
    
    private int id_atencion;
    private String fecha_atencion;
    private String hora_atencion;
    private TipoDeServicio tipo_de_servicio;
    private int id_reserva;
    private EstadoDeAtencion estado_de_atencion;
    private String patente;

    public Atencion(int id_atencion, String fecha_atencion, String hora_atencion, TipoDeServicio tipo_de_servicio, int id_reserva, EstadoDeAtencion estado_de_atencion, String patente) {
        this.id_atencion = id_atencion;
        this.fecha_atencion = fecha_atencion;
        this.hora_atencion = hora_atencion;
        this.tipo_de_servicio = tipo_de_servicio;
        this.id_reserva = id_reserva;
        this.estado_de_atencion = estado_de_atencion;
        this.patente = patente;
    }

    public Atencion() {
        this.id_atencion = 0;
        this.fecha_atencion = null;
        this.hora_atencion = null;
        this.tipo_de_servicio = null;
        this.id_reserva = 0;
        this.estado_de_atencion = null;
        this.patente = null;
    }

    public int getId_atencion() {
        return id_atencion;
    }

    public void setId_atencion(int id_atencion) {
        this.id_atencion = id_atencion;
    }

    public String getFecha_atencion() {
        return fecha_atencion;
    }

    public void setFecha_atencion(String fecha_atencion) {
        this.fecha_atencion = fecha_atencion;
    }

    public String getHora_atencion() {
        return hora_atencion;
    }

    public void setHora_atencion(String hora_atencion) {
        this.hora_atencion = hora_atencion;
    }   

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public TipoDeServicio getTipo_de_servicio() {
        return tipo_de_servicio;
    }

    public void setTipo_de_servicio(TipoDeServicio tipo_de_servicio) {
        this.tipo_de_servicio = tipo_de_servicio;
    }

    public EstadoDeAtencion getEstado_de_atencion() {
        return estado_de_atencion;
    }

    public void setEstado_de_atencion(EstadoDeAtencion estado_de_atencion) {
        this.estado_de_atencion = estado_de_atencion;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
}
