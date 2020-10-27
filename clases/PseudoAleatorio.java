package clases;
import java.util.Random;

public class PseudoAleatorio {
    private Congruencia c1;
    private Congruencia c2;
    private Congruencia c3;
    public double[] vectorF,vector;
    int N;
    
    public PseudoAleatorio(int n) {
    	Random r=new Random();    	
    	N=r.nextInt(n)+1;
    	vector= new double[N];
    	vectorF=new double[N];        
        c1 = new Congruencia(2147483647,8363,13259,45646);
        c2 = new Congruencia(2147483647,94781,52859528,4420567);
        c3 = new Congruencia(2147483647,86341,33107542,33107);
        vector = new double[N];
        for(int i=0;i<vector.length;i++){
            vectorF[i]=c1.next();
            vector[i]=next(i);
        }
    }
    
    //Se generarán 3 congruenciales. El primero servirá para decidir cual de los dos siguientes usar.
    public double next(int i){
        if(vectorF[i]>0.5){
            return c2.next();
        }else{
            return c3.next();
        }
    }
    
    public int ConteoProbabilidad(double p){
    	int cont=0;
    	for(int i=0;i<vector.length;i++){
    		if(vector[i]<=p){
    			cont++;
    		}
    	}
    	return cont;
    }
    
    //En nuestro ejemplo se han pasado los tests de Frecuencias, Serie, GAP, Yule-Walker, Distancias, Autocorrelación (casi todas las celdas), 
    //Kolmogorov, Maxmin-up y Maxmin-down. Por lo que podemos afirmar que es un algoritmo aceptablemente bueno.   
    
    public Congruencia getC1() {
        return c1;
    }
    public Congruencia getC2() {
        return c2;
    }
    public Congruencia getC3() {
        return c3;
    }
        
}