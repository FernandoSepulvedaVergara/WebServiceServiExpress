package clases;

public class Comuna {
   private int idComuna;
   private String comuna;

    public Comuna(int idComuna, String comuna) {
        this.idComuna = idComuna;
        this.comuna = comuna;
    }

    public Comuna() {
        this.idComuna = 0;
        this.comuna = null;
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
}
