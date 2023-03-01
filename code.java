import java.io.*;
import java.util.*;
import java.lang.Math;

class Iris{
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final String e;

    public Iris(double a, double b, double c, double d, String e){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    public double getA(){
        return a;
    }

    public double getB(){
        return b;
    }

    public double getC(){
        return c;
    }

    public double getD(){
        return d;
    }

    public String getE(){
        return e;
    }

    public String toString(){
        return a + " " + b + " " + c + " " + d + " " + e;
    }
}

public class code{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("iris.csv"));
        String line = br.readLine();
        Iris[] arr = new Iris[150];
        int i = 0;
        while(line != null){
            String[] values = line.split(",");
            arr[i] = new Iris(Double.parseDouble(values[0]), Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[3]), values[4]);
            line = br.readLine();
            i++;
        }
        br.close();
        double[] a = new double[150];
        double[] b = new double[150];
        double[] c = new double[150];
        double[] d = new double[150];
        for(int j = 0; j < 150; j++){
            a[j] = arr[j].getA();
            b[j] = arr[j].getB();
            c[j] = arr[j].getC();
            d[j] = arr[j].getD();
        }
        double[] min = new double[4];
        double[] max = new double[4];
        double[] avg = new double[4];
        double[] std = new double[4];
        min[0] = a[0];
        min[1] = b[0];
        min[2] = c[0];
        min[3] = d[0];
        max[0] = a[0];
        max[1] = b[0];
        max[2] = c[0];
        max[3] = d[0];
        avg[0] = 0;
        avg[1] = 0;
        avg[2] = 0;
        avg[3] = 0;
        std[0] = 0;
        std[1] = 0;
        std[2] = 0;
        std[3] = 0;
        for(int j = 0; j < 150; j++){
            if(a[j] < min[0]){
                min[0] = a[j];
            }
            if(b[j] < min[1]){
                min[1] = b[j];
            }
            if(c[j] < min[2]){
                min[2] = c[j];
            }
            if(d[j] < min[3]){
                min[ 3] = d[j];
            }
            if(a[j] > max[0]){
                max[0] = a[j];
            }
            if(b[j] > max[1]){
                max[1] = b[j];
            }
            if(c[j] > max[2]){
                max[2] = c[j];
            }
            if(d[j] > max[3]){
                max[3] = d[j];
            }
            avg[0] += a[j];
            avg[1] += b[j];
            avg[2] += c[j];
            avg[3] += d[j];
        }
        avg[0] /= 150;
        avg[1] /= 150;
        avg[2] /= 150;
        avg[3] /= 150;
        for(int j = 0; j < 150; j++){
            std[0] += Math.pow(a[j] - avg[0], 2);
            std[1] += Math.pow(b[j] - avg[1], 2);
            std[2] += Math.pow(c[j] - avg[2], 2);
            std[3] += Math.pow(d[j] - avg[3], 2);
        }

        std[0] = Math.sqrt(std[0] / 150);
        std[1] = Math.sqrt(std[1] / 150);
        std[2] = Math.sqrt(std[2] / 150);
        std[3] = Math.sqrt(std[3] / 150);

        System.out.println("Minimum of a: " + min[0]);
        System.out.println("Minimum of b: " + min[1]);
        System.out.println("Minimum of c: " + min[2]);
        System.out.println("Minimum of d: " + min[3]);
        System.out.println("Maximum of a: " + max[0]);
        System.out.println("Maximum of b: " + max[1]);
        System.out.println("Maximum of c: " + max[2]);
        System.out.println("Maximum of d: " + max[3]);
        System.out.println("Average of a: " + avg[0]);
        System.out.println("Average of b: " + avg[1]);
        System.out.println("Average of c: " + avg[2]);
        System.out.println("Average of d: " + avg[3]);
        System.out.println("Standard Deviation of a: " + std[0]);
        System.out.println("Standard Deviation of b: " + std[1]);
        System.out.println("Standard Deviation of c: " + std[2]);
        System.out.println("Standard Deviation of d: " + std[3]);
    }
}

