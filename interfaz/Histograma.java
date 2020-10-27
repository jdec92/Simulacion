package interfaz;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.SynchronousQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Histograma extends JFrame {
	
	public static double[] vector;
	public static int intervalo;

	public Histograma(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 480);
		JPanel chartPanel = crearPanel();
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 475));
		setContentPane(chartPanel);
	}

	private static IntervalXYDataset crearDataset() {
		HistogramDataset dataset = new HistogramDataset();		
		
		double[] prueba={12,12,12,12,12,12,12,4,8};
		//dataset.addSeries("Frecuencias de la Binomial", vector,vector.length);
		dataset.addSeries("Frecuencias de la Binomial", vector,intervalo,0,intervalo);
		return dataset;
	}

	private static JFreeChart crearChart(IntervalXYDataset dataset) {
		JFreeChart chart = ChartFactory.createHistogram("Histograma Binomial", "Casos", "Numero de veces Casos", dataset, PlotOrientation.VERTICAL,true, true, false);						
		XYPlot plot = chart.getXYPlot();
		
		XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();		
		renderer.setDrawBarOutline(false);
		
		return chart;
	}

	public static JPanel crearPanel() {
		JFreeChart chart = crearChart(crearDataset());
		return new ChartPanel(chart);
	}

	public static void main(String[] args) throws IOException {
		Histograma histo = new Histograma("Histograma");
		histo.pack();
		RefineryUtilities.centerFrameOnScreen(histo);
		histo.setVisible(true);
	}
}