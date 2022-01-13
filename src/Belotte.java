import java.util.Random;

public class Belotte {
    private Carte[] cartes;
    private Joueur[] joueurs;

    public Belotte() {
        joueurs = new Joueur[4];
        joueurs[0] = new Joueur("Doudou");
        joueurs[2] = new Joueur("Fatou");
        joueurs[1] = new Joueur("Lamine");
        joueurs[3] = new Joueur("Dieynaba");

        cartes = new Carte[52];
        cartes[0] = new Carte(0, "1", 1);
        cartes[1] = new Carte(0, "2", 2);
        cartes[2] = new Carte(0, "3", 3);
        cartes[3] = new Carte(0, "4", 4);
        cartes[4] = new Carte(0, "5", 5);
        cartes[5] = new Carte(0, "6", 6);
        cartes[6] = new Carte(0, "7", 7);
        cartes[7] = new Carte(0, "8", 8);
        cartes[8] = new Carte(0, "9", 9);
        cartes[9] = new Carte(0, "10", 10);
        cartes[10] = new Carte(0, "11", 11);
        cartes[11] = new Carte(0, "12", 12);
        cartes[12] = new Carte(0, "13", 13);

        cartes[13] = new Carte(1, "1", 1);
        cartes[14] = new Carte(1, "2", 2);
        cartes[15] = new Carte(1, "3", 3);
        cartes[16] = new Carte(1, "4", 4);
        cartes[17] = new Carte(1, "5", 5);
        cartes[18] = new Carte(1, "6", 6);
        cartes[19] = new Carte(1, "7", 7);
        cartes[20] = new Carte(1, "8", 8);
        cartes[21] = new Carte(1, "9", 9);
        cartes[22] = new Carte(1, "10", 10);
        cartes[23] = new Carte(1, "11", 11);
        cartes[24] = new Carte(1, "12", 12);
        cartes[25] = new Carte(1, "13", 13);

        cartes[26] = new Carte(2, "1", 1);
        cartes[27] = new Carte(2, "2", 2);
        cartes[28] = new Carte(2, "3", 3);
        cartes[29] = new Carte(2, "4", 4);
        cartes[30] = new Carte(2, "5", 5);
        cartes[31] = new Carte(2, "6", 6);
        cartes[32] = new Carte(2, "7", 7);
        cartes[33] = new Carte(2, "8", 8);
        cartes[34] = new Carte(2, "9", 9);
        cartes[35] = new Carte(2, "10", 10);
        cartes[36] = new Carte(2, "11", 11);
        cartes[37] = new Carte(2, "12", 12);
        cartes[38] = new Carte(2, "13", 13);

        cartes[39] = new Carte(3, "1", 1);
        cartes[40] = new Carte(3, "2", 2);
        cartes[41] = new Carte(3, "3", 3);
        cartes[42] = new Carte(3, "4", 4);
        cartes[43] = new Carte(3, "5", 5);
        cartes[44] = new Carte(3, "6", 6);
        cartes[45] = new Carte(3, "7", 7);
        cartes[46] = new Carte(3, "8", 8);
        cartes[47] = new Carte(3, "9", 9);
        cartes[48] = new Carte(3, "10", 10);
        cartes[49] = new Carte(3, "11", 11);
        cartes[50] = new Carte(3, "12", 12);
        cartes[51] = new Carte(3, "13", 13);

        distributionCartes();
    }

    int[] carteAjouter = new int[52];
    int k=0;
    public void distributionCartes() {
        Random random = new Random();
        int nbRdCartes;
//        int k=0;
        boolean foo;

            for (int i = 0; i < 4; i++) {
                while (joueurs[i].cptCartes < 13) {
                    do {
                        nbRdCartes = random.nextInt(52);
                        distribuerCarte(i, nbRdCartes);
                    } while (!carteEstDans(carteAjouter, nbRdCartes));
//                    while (carteEstDans(carteAjouter, nbRdCartes)) {
//                        nbRdCartes = random.nextInt(52);
//                    }
                    distribuerCarte(i, nbRdCartes);
                }
            }
    }

//    public void distributionCartes1() {
//        for (int i = 0; i < 4; i++) {
//            int cpt=0;
//            while (k < 53) {
//                joueurs[i].ajoutCarte(cartes[k]);
//                k += 1;
//                cpt++;
//                if (cpt == 13)
//                    break;
//            }
//        }
//    }

    public boolean carteEstDans(int[] carteAjouter, int numCarte) {
        for (int i = 0; i < carteAjouter.length; i++) {
            if (carteAjouter[i] == numCarte) {
                return true;
            }
        }
        return false;
    }

    public void distribuerCarte(int numJoueur, int numCarte) {
            int j = 0;
            while (j < joueurs[numJoueur].tabCartes.length && joueurs[numJoueur].tabCartes[j] != cartes[numCarte])
                j++;
            if (j >= joueurs[numJoueur].tabCartes.length) {
                this.joueurs[numJoueur].ajoutCarte(this.cartes[numCarte]);
                this.carteAjouter[k] = numCarte;
                k++;
            }
    }


    public static void main(String[] args) {
        Belotte belotte = new Belotte();

        System.out.println("Liste des joueurs : ");
        for (int i=0; i < 4; i++)
            System.out.println(belotte.joueurs[i].nom);

        for (int i=0; i < belotte.joueurs.length; i++) {
            System.out.println("\nListe des cartes de : " + belotte.joueurs[i].nom);
            for (int j = 0; j < belotte.joueurs[i].tabCartes.length; j++)
                if (belotte.joueurs[i].tabCartes[j] != null)
                    belotte.joueurs[i].tabCartes[j].printOut();
            System.out.println("\n");
        }
        Joueur doudou = belotte.joueurs[0];
        Joueur fatou = belotte.joueurs[1];
        Joueur lamine = belotte.joueurs[2];
        Joueur dieynaba = belotte.joueurs[3];
        System.out.println("\n\n"+ doudou.nom + " : " +doudou.tabCartes.length + " \n" +
                                fatou.nom + " : " + fatou.cptCartes + "\n" +
                                lamine.nom + " : " + lamine.cptCartes + "\n" +
                                dieynaba.nom + " : " + dieynaba.cptCartes + "\n");

        System.out.println("\n\n *****************************On commence le jeu***************************** \n");

        int premierSigne = doudou.jouerEnPremier().getSigne();
        int j=0;

        while (doudou.cptCartes > 1) {
            Carte carteDoudou = doudou.play(premierSigne);
            Carte carteFatou = fatou.play(premierSigne);
            Carte carteLamine = lamine.play(premierSigne);
            Carte carteDieynabe = dieynaba.play(premierSigne);

            Carte[] tourCartes = new Carte[4];
            tourCartes[0] = carteDoudou;
            tourCartes[2] = carteFatou;
            tourCartes[1] = carteLamine;
            tourCartes[3] = carteDieynabe;

            int numGagnant = 0, i = 0;
            int maxValeurCarte = carteDoudou.getValeur();
            while (i < 4) {
                if (tourCartes[i].getValeur() > maxValeurCarte) {
                    if (tourCartes[i].getSigne() == premierSigne) {
                        maxValeurCarte = tourCartes[i].getValeur();
                        numGagnant = i;
                    }
                }
                i++;
            }
//            System.out.println(maxValeurCarte);
//            System.out.println(carteDoudou.getValeur());
//            System.out.println(carteFatou.getValeur());
//            System.out.println(carteLamine.getValeur());
//            System.out.println(carteDieynabe.getValeur());

            belotte.joueurs[numGagnant].tourGagnant(tourCartes);
            premierSigne = belotte.joueurs[numGagnant].jouerEnPremier().getSigne();
        }

        System.out.println("\n=================================Score finale : =================================");
        System.out.println("\n"+ doudou.nom + " : " +doudou.score + " \n" +
                fatou.nom + " : " + fatou.score + "\n" +
                lamine.nom + " : " + lamine.score + "\n" +
                dieynaba.nom + " : " + dieynaba.score + "\n");
    }
}
