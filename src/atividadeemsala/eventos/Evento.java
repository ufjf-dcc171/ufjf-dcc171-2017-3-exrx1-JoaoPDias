package atividadeemsala.eventos;

import java.util.Calendar;

public class Evento {

    private static int gencodigo = 0;
    private int codigo;
    private String descricao;
    private String datahora;
    private double longitude;
    private double latitude;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public static int gerarCodigo()
    {
        int cod = gencodigo;
        gencodigo++;
        return cod;
    }

    public Evento(int cod, String descricao, String datahora, double longitude, double latitude) {

        this.codigo = cod;
        this.descricao = descricao;
        this.datahora = datahora;
        this.longitude = longitude;
        this.latitude = latitude;

    }

    public Evento() {
        this.codigo = gencodigo;

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Evento " + codigo + " {Descrição: " + descricao + ",Data e Hora: " + datahora + ",Longitude: " + longitude + ",Latitude: " + latitude + '}';
    }

    
}
