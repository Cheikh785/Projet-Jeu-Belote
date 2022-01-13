public class Joueur {
    public String nom;
    public int score;
    public int cptCartes;
    public Carte[] tabCartes;

    public Joueur(String nom) {
        this.nom = nom;
        this.score = 0;
        this.cptCartes = 0;
        tabCartes = new Carte[13];
    }

    public void ajoutCarte(Carte carte) {
        if (this.cptCartes == 13) {
            System.out.println("Le joueur a déjà 13 cartes !");
            return;
        }
        int i=0;
        while (i < this.tabCartes.length && this.tabCartes[i] != null)
            i++;
        if (i < this.tabCartes.length) {
            this.tabCartes[i] = carte;
            this.cptCartes++;
        }

    }

    public Carte jouerEnPremier() {
        int j=0;
        if (this.cptCartes == 0) {
            System.out.println("Il n'y a plus de carte à jouer pour le joueur " + this.nom);
            return null;
        }
//        Carte tmpCarte = this.tabCartes[0];
//        this.tabCartes[0] = null;
//        this.cptCartes--;
//        return tmpCarte;
//        return this.tabCartes[0];

        while (j < this.tabCartes.length && this.tabCartes[j] == null)
            j++;
        if (j < this.tabCartes.length) {
            return this.tabCartes[j];
        }
        return null;
    }

    public Carte play(int signe) {
        if (this.cptCartes > 0) {
            int i=0, k=13;
            while (i < this.tabCartes.length && this.tabCartes[i] == null)
                i++;
            if (i < this.tabCartes.length)
                k = i-1;
            else return null;

            k = 11;
            while (k < this.tabCartes.length && this.tabCartes[k].getSigne() != signe)
                k++;
            if (k < this.tabCartes.length) {
                Carte tmpCarte = this.tabCartes[i];
                this.tabCartes[i] = null;
                this.cptCartes--;
                return tmpCarte;
            } else {
                int j=0;
                while (j < this.tabCartes.length && this.tabCartes[j] == null)
                    j++;
                if (j < this.tabCartes.length) {
                    Carte tmpCarte = this.tabCartes[j];
                    this.tabCartes[j] = null;
                    this.cptCartes--;
                    return tmpCarte;
                }
                else {
                    System.out.println("Cartes épuisées !!! Toutes les cartes ont été jouées.");
                }
            }
        } else {
            System.out.println("Cartes épuisées !!! Toutes les cartes ont été jouées.");
        }
        return null;
    }

    public void tourGagnant(Carte[] cartes) {
        for (Carte carte : cartes) this.score += carte.getValeur();
    }
}


























