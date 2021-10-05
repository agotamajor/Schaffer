import java.util.Random;

public class Populacio {
    private int meret;
    private double[] egyenek;

    public Populacio(int meret) {
        this.meret = meret;
        egyenek = new double[meret];
        for (int i = 0; i < meret; i++) {
            egyenek[i] = Math.random()*20-10;
        }
    }

    public double getEgyen(int i) {
        return egyenek[i];
    }

    public void setEgyen(int i, double egyed) {
        egyenek[i] = egyed;
    }

    public int[] egyMegoldasDominaciaja(double megoldas) {
        int[] dominal = new int[meret];
        for (int i = 0; i < meret; i++) {
            dominal[i] = 0;
        }
        for (int i = 0; i < meret; i++) {
            if (f1(egyenek[i]) < f1(megoldas) && f2(egyenek[i]) < f2(megoldas)) {
                dominal[i] = 1;
            }
        }
        return dominal;
    }

    public int[] szulokMeghatarozasa(int[] fitness) {
        int[] szulok = new int[2];
        for (int i = 0; i < 2; i++) {
            int index = maxIndex(fitness);
            szulok[i] = index;
            fitness[index] = -1;
        }
        return szulok;
    }

    public double keresztezes(int[] szulok) {
        Random rand = new Random();
        int a = rand.nextInt(10);
        int b = rand.nextInt(10);
        return (egyenek[szulok[0]] * a + egyenek[szulok[1]] * b) / (a + b);
    }

    public double[] mutacio(double ertek) {
        double[] mutalt = new double[meret - 2];
        for (int i = 0; i < meret - 2; i++) {
            mutalt[i] = ertek + Math.random()*9-3;
        }
        return mutalt;
    }

    public double f1(double x) {
        return x * x;
    }

    public double f2(double x) {
        return (x - 2) * (x - 2);
    }

    public int maxIndex(int[] x) {
        int max = x[0];
        int index = 0;
        for (int i = 1; i < meret; i++) {
            if (max < x[i]) {
                index = i;
                max = x[i];
            }
        }
        return index;
    }
}
