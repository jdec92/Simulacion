package clases;
import java.awt.Composite;
import java.util.Random;

public class Binomial {
	public double[] probabilidad;
	public double p,q;
	public int N;
	
	public Binomial(int n,double p,int xn){
		N=n;			
		probabilidad= new double[xn];		
		for(int i=0;i<xn;i++){
			PseudoAleatorio pseudo= new PseudoAleatorio(n);					
			probabilidad[i]=pseudo.ConteoProbabilidad(p);
		}		
	}
		
}
