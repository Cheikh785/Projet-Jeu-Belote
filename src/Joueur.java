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
//        while (j < this.tabCartes.length && this.tabCartes[j] == null)
//            j++;
//        if (j < this.tabCartes.length) {
//            return this.tabCartes[j];
//        }
        int indexMaxCarteTab = maxTab(this.tabCartes);
        if (indexMaxCarteTab != -1) {
            return this.tabCartes[indexMaxCarteTab];
        }
        return null;
    }

    public Carte play(int signe, int val) {
        if (this.cptCartes > 0) {
            int k=0, maxIndex = -1;
            for (int i = 0; i < this.tabCartes.length; i++) {
                if (tabCartes[i] != null) {
                    if (this.tabCartes[i].getSigne() == signe && this.tabCartes[i].getValeur() > val) {
                        maxIndex = i;
                        if (this.tabCartes[i].getValeur() == 13)
                            break;
                    }
                }
            }
            if (maxIndex != -1) {
                Carte carteTmp = this.tabCartes[maxIndex];
                this.tabCartes[maxIndex] = null;
                this.cptCartes--;
                return carteTmp;
            }

            int minIndex = minTab(this.tabCartes);
            if (minIndex != -1) {
                Carte carteTmp = this.tabCartes[minIndex];
                this.tabCartes[minIndex] = null;
                this.cptCartes--;
                return carteTmp;
            }
        } else {
            System.out.println("Cartes épuisées !!! Toutes les cartes ont été jouées.");
        }
        return null;
    }

    public int minTab(Carte[] tab) {
        if (tab.length > 0 ) {
            int min = 13, pos = 0;
            for (int i = 1; i < tab.length; i++) {
                if (tab[i] != null) {
                    if (tab[i].getValeur() < min) {
                        min = tab[i].getValeur();
                        pos = i;
                    }
                }
            }
            return pos;
        }
        return -1;
    }

    public int maxTab(Carte[] tab) {
        if (tab.length > 0) {
            int max = 0, pos = 0;
            for (int i = 0; i < tab.length; i++) {
                if (tab[i] != null) {
                    if (tab[i].getValeur() > max) {
                        max = tab[i].getValeur();
                        pos = i;
                    }
                }
            }
            return pos;
        }
        return -1;
    }

    public Carte firstPlay(int signe) {
        int maxIndex = -1, maxVal = 0;
        for (int i = 0; i < this.tabCartes.length; i++) {
            if (tabCartes[i] != null) {
                if (this.tabCartes[i].getSigne() == signe && this.tabCartes[i].getValeur() > maxVal) {
                    maxVal = this.tabCartes[i].getValeur();
                    maxIndex = i;
                    if (this.tabCartes[i].getValeur() == 13)
                        break;
                }
            }
        }
        if (maxIndex != -1) {
            Carte carteTmp = this.tabCartes[maxIndex];
            this.tabCartes[maxIndex] = null;
            this.cptCartes--;
            return carteTmp;
        }
        return null;
    }

    public void tourGagnant(Carte[] cartes) {
        for (Carte carte : cartes) this.score += carte.getValeur();
    }
}


























