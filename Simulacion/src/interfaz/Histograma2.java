package interfaz;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.RefineryUtilities;
import javax.swing.JTable;

public class Histograma2 extends JFrame {
	
	public static double[] vector;
	public static int intervalo,ampli;
	public static double probabilida;

	public Histograma2(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 480);
		JPanel chartPanel = crearPanel();
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 475));
		setContentPane(chartPanel);
		getContentPane().setLayout(null);

		Tabla.matriz=crearMatriz();
		Tabla t=new Tabla("Tabla Estimaciones");		
		t.setVisible(true);
						
	}

	private static IntervalXYDataset crearDataset() {
		HistogramDataset dataset = new HistogramDataset();		
		dataset.addSeries("Frecuencias de la Binomial", vector,intervalo/ampli,0,intervalo);
//		dataset.addSeries("Frecuencias de la Binomial", vector,vector.length/ampli);
		
		return dataset;
	}

	private static JFreeChart crearChart(IntervalXYDataset dataset) {
		JFreeChart chart = ChartFactory.createHistogram("Histograma Binomial", "Casos", "Numero de veces Casos", dataset, PlotOrientation.VERTICAL,true, true, false);		
	
		XYPlot plot = (XYPlot) chart.getPlot();		
		
		XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();		
		renderer.setDrawBarOutline(true);
				
	
		
		return chart;
	}

	public static JPanel crearPanel() {
		JFreeChart chart = crearChart(crearDataset());
		return new ChartPanel(chart);
	}

	
	public String[][] crearMatriz(){
		int[] paso=conteo();
		int n=intervalo/ampli;		
		int inf=0;
		int sup=0;
		int impar=n;
		if(intervalo%ampli!=0){
			impar++;
		}
		String[][] m=new String[impar][4];
		//System.out.println("Impar:"+impar+" N:"+n);
		for(int i=0;i<n;i++){			
			sup=sup+ampli;
			m[i][0]="["+inf+","+sup+"]";
			int sum=0;
			double probabilidad;
			double real=0;
			for(int j=inf;j<sup;j++){
				sum+=paso[j];
				probabilidad=factorial(j)*factorial(intervalo-j);
				probabilidad=factorial(intervalo)/probabilidad;
				probabilidad=probabilidad*Math.pow(probabilida, j)*Math.pow(1-probabilida,intervalo-j);
				real=real+probabilidad;
			}
			double estimada=(double) sum/intervalo;			
			m[i][1]=""+estimada;						
			m[i][2]=""+real;
			m[i][3]=""+(estimada-real);
			inf=sup;
		}		
		if(impar!=n){
			m[n][0]="["+intervalo+",infinito]";
			double estimada=(double) paso[intervalo]/intervalo;
			m[n][1]=""+estimada;
			double real=Math.pow(probabilida, intervalo);
			m[n][2]=""+real;
			m[n][3]=""+(estimada-real);
		}
		return m;		
	}
	public int[] conteo(){		
		int[] r=new int[intervalo+1];		
		for(int i=0;i<vector.length;i++){
			int valor=(int) vector[i];			
			r[valor]+=1;
		}
		
		return r;
	}

	public double factorial(int n){
		double res=1;
		for(int i=n;i==1;i--){
			res=res*i;
		}
		return res;
	}
	
}