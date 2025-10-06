package org.example.Inimigo;

public class Inimigo {
    private String raca;
    private int poder;
    private String caracteristica;

    public Inimigo(String raca, int poder, String caracteristica) {
        this.raca = raca;
        this.poder = poder;
        this.caracteristica = caracteristica;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }
}