public class Carte {
    private int signe;
    private String nom;
    private int valeur;

    public Carte(int signe, String nom, int valeur) {
        this.signe = signe;
        this.nom = nom;
        this.valeur = valeur;
    }

    public String printOut() {
        String[] tabSigne = {"Trèffle", "Carreau", "Coeur", "Pique"};
        return (this.nom + " " + tabSigne[this.signe]);
    }

    public int getSigne() {
        return signe;
    }

    public int getValeur() {
        return valeur;
    }

    public String getNom() {
        return nom;
    }
}
