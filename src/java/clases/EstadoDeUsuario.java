package clases;

public class EstadoDeUsuario {
   private int idEstadoDeUsuario;
   private String estadoDeUsuario;

    public EstadoDeUsuario(int idEstadoDeUsuario, String estadoDeUsuario) {
        this.idEstadoDeUsuario = idEstadoDeUsuario;
        this.estadoDeUsuario = estadoDeUsuario;
    }

    public EstadoDeUsuario() {
       this.idEstadoDeUsuario = 0;
       this.estadoDeUsuario = null;
    }

    public int getIdEstadoDeUsuario() {
        return idEstadoDeUsuario;
    }

    public void setIdEstadoDeUsuario(int idEstadoDeUsuario) {
        this.idEstadoDeUsuario = idEstadoDeUsuario;
    }

    public String getEstadoDeUsuario() {
        return estadoDeUsuario;
    }

    public void setEstadoDeUsuario(String estadoDeUsuario) {
        this.estadoDeUsuario = estadoDeUsuario;
    }   
}
