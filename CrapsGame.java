import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random generateur = new Random();

        boolean endGame = false;

        int winNum01 = 7;
        int winNum02 = 11;

        int looseNum01 = 2;
        int looseNum02 = 3;
        int looseNum03 = 12;

        int des01 = 0;
        int des02 = 0;
        int somme = 0;

        int nombreJetons = 10;
        int mise  = -1;
        int but = 0;

        System.out.println("================================");
        System.out.println("Bienvenue dans le jeu de Craps.");
        System.out.println("================================");

        while (!endGame && nombreJetons > 0) {
            System.out.println("Vous avez " + nombreJetons + " jetons.");
            System.out.print("Combien voulez-vous miser ? (0 pour arrêter ) : ");
            mise = scan.nextInt();


            while (mise < 0 || mise > nombreJetons) {
                System.out.println("Vous essayez de rouler le casino. Recommencez.");
                System.out.println("Vous avez " + nombreJetons + " jetons.");
                System.out.print("Combien voulez-vous miser ? (0 pour arrêter ) : ");
                mise = scan.nextInt();
            }


            if (mise == 0) {
                endGame = true;
                System.out.println("A bientôt !");
            }
            else {
                des01 = generateur.nextInt(6) + 1;
                des02 = generateur.nextInt(6) + 1;
                somme =  des01 + des02;

                System.out.println("Vous avez lancé " + des01 + " et " + des02 + ". La somme est " + somme + ".");

                if ((somme == winNum01 || somme == winNum02) && !endGame) {
                    System.out.println("Gagné !");
                    nombreJetons += mise;
                }
                else if ((somme == looseNum01 || somme == looseNum02 || somme == looseNum03) && !endGame) {
                    System.out.println("Perdu !");
                    nombreJetons -= mise;
                }
                else {
                    but = somme;
                    System.out.println("Votre but est " + but + ".");
                    boolean secondTour = false;

                    while (!secondTour && !endGame) {
                        des01 = generateur.nextInt(6) + 1;
                        des02 = generateur.nextInt(6) + 1;
                        somme = des01 + des02;
                        System.out.println("Vous avez lancé " + des01 + " et " + des02 + ". La somme est " + somme + ".");

                        if (somme == but) {
                            System.out.println("Gagné !");
                            nombreJetons += mise;
                            secondTour = true;
                        }
                        else if (somme == winNum01) {
                            System.out.println("Perdu !");
                            nombreJetons -= mise;
                            secondTour = true;
                        }
                    }
                }
            }
        }
        if (nombreJetons <= 0) {
            System.out.println("Vous n'avez plus de jetons. Fin du jeu !");
        }
    }
}
