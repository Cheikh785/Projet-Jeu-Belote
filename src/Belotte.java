import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;

public class Belotte {
    private final Carte[] cartes;
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
        for (int j : carteAjouter) {
            if (j == numCarte) {
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
        System.out.println("\n\n****************************************************************** JEU BELOTTE | VERSION 1.0 **************************************************************");
        System.out.println("\n\t\t\t\t\t\t\t\t\t <-DÉBUT->");
        Belotte belotte = new Belotte();

        System.out.println("\tListe des joueurs : ");
        System.out.print("\t");
        for (int i=0; i < 4; i++)
            System.out.print(belotte.joueurs[i].nom + "\t-\t");

        System.out.println("\n");
        for (int i=0; i < belotte.joueurs.length; i++) {
            System.out.println("\tListe des cartes de " + belotte.joueurs[i].nom);
            for (int j = 0; j < belotte.joueurs[i].tabCartes.length; j++) {
                System.out.print("\t");
                if (belotte.joueurs[i].tabCartes[j] != null) {
                    System.out.print(belotte.joueurs[i].tabCartes[j].printOut());
                    System.out.print(" - ");
                }
            }
            System.out.println("\n");
        }
        Joueur doudou = belotte.joueurs[0];
        Joueur fatou = belotte.joueurs[1];
        Joueur lamine = belotte.joueurs[2];
        Joueur dieynaba = belotte.joueurs[3];

        System.out.println("\n\n********************************************************************** ON COMMENCE **********************************************************************");

        int premierSigne = doudou.jouerEnPremier().getSigne();
        int j=0, numGagnant=0;

        while (doudou.cptCartes > 1) {
            int maxValeurCarte = belotte.joueurs[numGagnant].jouerEnPremier().getValeur();

            Carte carteDoudou = doudou.play(premierSigne);
            Carte carteFatou = fatou.play(premierSigne);
            Carte carteLamine = lamine.play(premierSigne);
            Carte carteDieynabe = dieynaba.play(premierSigne);

            Carte[] tourCartes = new Carte[4];
            tourCartes[0] = carteDoudou;
            tourCartes[1] = carteFatou;
            tourCartes[2] = carteLamine;
            tourCartes[3] = carteDieynabe;

            int i = 0;
            while (i < 4) {
                if (tourCartes[i].getSigne() == premierSigne) {
                    if (tourCartes[i].getValeur() >= maxValeurCarte) {
                        numGagnant = i;
                    }
                }
                i++;
            }
            belotte.joueurs[numGagnant].tourGagnant(tourCartes);
            premierSigne = belotte.joueurs[numGagnant].jouerEnPremier().getSigne();

            System.out.println("\n\t" + doudou.nom + " a joué la carte : " + carteDoudou.printOut());
            System.out.println("\t" + fatou.nom + " a joué la carte : " + carteFatou.printOut());
            System.out.println("\t" + lamine.nom + " a joué la carte : " + carteLamine.printOut());
            System.out.println("\t" + dieynaba.nom + " a joué la carte : " + carteDieynabe.printOut());

            System.out.println("\n\t   -Le gagnant de ce tour est " + belotte.joueurs[numGagnant].nom + ". Il a " + belotte.joueurs[numGagnant].score + " points maintenant. \n\n\n");
        }

        Joueur gagnantFinale = belotte.joueurs[0];
        for (int i = 0; i < 4; i++) {
            if (belotte.joueurs[i].score >= gagnantFinale.score) {
                gagnantFinale = belotte.joueurs[i];
            }
        }

        System.out.println("\n\t\t\t\t\t\t ================================= Score finale =================================");
        System.out.println("\t\t\t\t\t\t|");
        System.out.println("\t\t\t\t\t\t|\t\t\t\t" + doudou.nom + " : " +doudou.score + " \n" +
                "\t\t\t\t\t\t|\t\t\t\t" + fatou.nom + " : " + fatou.score + "\n" +
                "\t\t\t\t\t\t|\t\t\t\t" + lamine.nom + " : " + lamine.score + "\n" +
                "\t\t\t\t\t\t|\t\t\t\t" + dieynaba.nom + " : " + dieynaba.score);
        System.out.println("\t\t\t\t\t\t|");
        System.out.println("\t\t\t\t\t\t ================================================================================");

        System.out.println("\n\t\t\t\t\t\t\t| Le gagnant de cette partie est " + gagnantFinale.nom + " avec " + gagnantFinale.score + " points |");

        System.out.println("\n\n\n \t\t\t\t\t\t\t\t\t\t<-Fin->");
        System.out.println("\n\n****************************************************************** JEU BELOTTE | VERSION 1.0 **************************************************************");
    }
}
