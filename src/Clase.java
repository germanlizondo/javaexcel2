public class Clase {

    private String horari;
    private Dia dia;
    private String nom;

    public Clase(String horari, Dia dia, String nom) {
        this.horari = horari;
        this.dia = dia;
        this.nom = nom;
    }





    public String getHorari() {
        return horari;
    }

    public void setHorari(String horari) {
        this.horari = horari;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
