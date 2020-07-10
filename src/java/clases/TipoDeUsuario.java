package clases;

public class TipoDeUsuario {
    private int idTipoDeUsuario;
    private String tipoDeUsuario;

    public TipoDeUsuario(int idTipoDeUsuario, String tipoDeUsuario) {
        this.idTipoDeUsuario = idTipoDeUsuario;
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public TipoDeUsuario() {
        this.idTipoDeUsuario = 0;
        this.tipoDeUsuario = null;
    }

    public int getIdTipoDeUsuario() {
        return idTipoDeUsuario;
    }

    public void setIdTipoDeUsuario(int idTipoDeUsuario) {
        this.idTipoDeUsuario = idTipoDeUsuario;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }
    
    
}
