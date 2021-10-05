import javax.swing.*;

public class Schaffer extends JFrame {

    public Schaffer() throws InterruptedException {
        int meret = 100;
        Populacio populacio = new Populacio(meret);

        double[] generacioLegjobbja = new double[3000];
        for (int i = 0; i < 3000; i++) {
            int[] fitness = new int[meret];
            for (int j = 0; j < meret; j++) {
                fitness[j] = 0;
            }
            for (int j = 0; j < meret; j++) {
                int[] egyEgyedre = populacio.egyMegoldasDominaciaja(populacio.getEgyen(j));
                for (int l = 0; l < meret; l++) {
                    fitness[l] += egyEgyedre[l];
                }
            }
            int legjobbIndex = populacio.maxIndex(fitness);
            generacioLegjobbja[i] = populacio.getEgyen(legjobbIndex);

            int[] szulok = populacio.szulokMeghatarozasa(fitness);
            double keresztezettEgyed = populacio.keresztezes(szulok);
            double[] mutaltEgyedek = populacio.mutacio(keresztezettEgyed);

            populacio.setEgyen(0, populacio.getEgyen(szulok[0]));
            populacio.setEgyen(1, populacio.getEgyen(szulok[1]));
            for (int j = 2; j < meret; j++) {
                populacio.setEgyen(j, mutaltEgyedek[j - 2]);
            }
        }

        double[] f1 = new double[3000];
        double[] f2 = new double[3000];
        for (int i = 0; i < 3000; i++) {
            f1[i] = populacio.f1(generacioLegjobbja[i]);
            f2[i] = populacio.f2(generacioLegjobbja[i]);
        }

        setBounds(0, 0, 500, 500);
        Rajz rajz = new Rajz(3000, f1, f2);
        add(rajz);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public static void main(String[] args) throws InterruptedException {
        new Schaffer();
    }
}
