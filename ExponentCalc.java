import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("=============================================================================");
        System.out.println(" Ce programme a pour but de calculer des nombres entiers positifs à exposant");
        System.out.println("=============================================================================");

        System.out.print("Entrez votre base : ");
        int base = scan.nextInt();
        while (base <= 0) {
            System.out.print("Nombre invalide, veuillez recommencer : ");
            base = scan.nextInt();
        }
        System.out.print("Entrez votre exposant : ");
        int exposant = scan.nextInt();
        while (exposant <= 0) {
            System.out.print("Nombre invalide, veuillez recommencer : ");
            exposant = scan.nextInt();
        }

        long resultat  = 1;

        for (int i = 0; i < exposant; ++i) {
            resultat *= base;
        }
        System.out.println("Le résultat de " + base + " exposant " + exposant + " est : " + resultat + ".");
    }
}
