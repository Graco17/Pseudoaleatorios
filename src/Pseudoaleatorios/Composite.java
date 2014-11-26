

package Pseudoaleatorios;

/**
 *
 * @author Alberto
 */
public class Composite {

    private congruencial c1;
    private congruencial c2;
    private congruencial c3;

    private double [] vector;
    private int index;

    public Composite() {
        index = 0;
        c1 = new congruencial(2147483647,8363,13259,45646);
        c2 = new congruencial(2147483647,94781,52859528,4420567);
        c3 = new congruencial(2147483647,86341,33107542,33107);

        vector = new double[3000];

        for(int i=0;i<vector.length;i++){
            vector[i]=c1.next();
        }
    }
    public double next(){
        if(vector[index]>0.5){
            return c2.next();
        }else{
            return c3.next();

        }

    }

    public congruencial getC1() {
        return c1;
    }

    public congruencial getC2() {
        return c2;
    }

    public congruencial getC3() {
        return c3;
    }

    class congruencial{
       private int m;
       private int a;
       private int c;
       private int seed;
       private double prev=0;

       public congruencial(int m, int a, int c, int seed){
           this.m = m;
           this.a = a;
           this.c = c;
           this.seed = seed;
       }

       public double next(){
           prev = (a * prev + c )%m;
           return  prev/m;
       }
    }

    public static void main(String [] args){
        Composite composite = new Composite();
        for(int i=0;i<10;i++){
            System.out.println(composite.next());
        }
    }
}
