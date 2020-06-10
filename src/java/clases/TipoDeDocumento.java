package clases;

public class TipoDeDocumento {
    private int id_tipo_de_documento;
    private String documento;

    public TipoDeDocumento() {
    }

    public TipoDeDocumento(int id_tipo_de_documento, String documento) {
        this.id_tipo_de_documento = id_tipo_de_documento;
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getId_tipo_de_documento() {
        return id_tipo_de_documento;
    }

    public void setId_tipo_de_documento(int id_tipo_de_documento) {
        this.id_tipo_de_documento = id_tipo_de_documento;
    }
}
