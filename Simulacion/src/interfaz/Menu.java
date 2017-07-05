package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jfree.data.statistics.HistogramDataset;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import clases.Binomial;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

public class Menu extends JFrame {

	private JPanel contentPane;
	public JTextField BinN;
	public JTextField BinP;
	public JTextField media;
	public JTextField cuasi;
	public JTextField Xtam;	
	private JButton graficaI;
	private JTextField ampli;
	private JLabel lblBinomial;
	private JLabel label;
	private JLabel label_1;
	private JLabel ErrorB;
	private JLabel ErrorX;
	private JPanel panel_4;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Histograma de Frecuencias", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panel.setBounds(10, 168, 368, 62);
		contentPane.add(panel);
		
		JButton graficaF = new JButton("Crear Grafica");
		graficaF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comprobarCampo()){
					Histograma.vector=crearBinomial(true);
					Histograma h=new Histograma("Frecuencia Binomial");				
					h.setVisible(true);	
				}				
			}
		});
		graficaF.setBounds(118, 25, 110, 23);
		panel.add(graficaF);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Histograma de Frecuencias Por Intervalos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panel_1.setBounds(10, 241, 368, 83);
		contentPane.add(panel_1);
		
		JLabel ErrorN = new JLabel("No es un n\u00FAmero entero");
		ErrorN.setFont(new Font("Tahoma", Font.PLAIN, 9));
		ErrorN.setForeground(Color.RED);
		ErrorN.setVisible(false);
		ErrorN.setBounds(202, 21, 156, 14);
		panel_1.add(ErrorN);
		
		graficaI = new JButton("Crear Grafica");
		graficaI.setBounds(122, 46, 117, 23);
		graficaI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int am=Integer.parseInt(ampli.getText());
					ErrorN.setVisible(false);
					if(comprobarCampo()){
						Histograma2.vector=crearBinomial(false);
						Histograma2.ampli=am;
						Histograma2 h=new Histograma2("Frecuencia Binomial por Intervalos");				
						h.setVisible(true);										
					}
				}catch (Exception e) {
					ErrorN.setVisible(true);
				}				
			}
		});
		panel_1.setLayout(null);
		panel_1.add(graficaI);
		
		JLabel lblIntroduceLaAmplitud = new JLabel("Amplitud del intervalo");
		lblIntroduceLaAmplitud.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblIntroduceLaAmplitud.setBounds(10, 21, 117, 14);
		panel_1.add(lblIntroduceLaAmplitud);
		
		ampli = new JTextField();
		ampli.setText("2");
		ampli.setBounds(137, 18, 55, 20);
		panel_1.add(ampli);
		ampli.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estimaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panel_2.setBounds(11, 103, 367, 54);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Media:");
		lblNewLabel.setBounds(55, 26, 46, 14);
		panel_2.add(lblNewLabel);
		
		media = new JTextField();
		media.setEditable(false);
		media.setBounds(102, 23, 65, 20);		
		panel_2.add(media);
		media.setColumns(10);
		
		JLabel lblCuasivarianza = new JLabel("Varianza");
		lblCuasivarianza.setBounds(177, 26, 65, 14);
		panel_2.add(lblCuasivarianza);
		
		cuasi = new JTextField();
		cuasi.setEditable(false);		
		cuasi.setBounds(237, 23, 74, 20);
		panel_2.add(cuasi);
		cuasi.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Distribuciones", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panel_3.setBounds(10, 21, 368, 83);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		lblBinomial = new JLabel("Binomial (");
		lblBinomial.setBounds(11, 24, 44, 13);
		panel_3.add(lblBinomial);
		lblBinomial.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		BinN = new JTextField();
		BinN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				if(comprobarCampo()){
					recalcular();
				}
			}
		});
		BinN.setBounds(60, 21, 86, 20);
		panel_3.add(BinN);
		BinN.setColumns(10);
		
		label = new JLabel(",");
		label.setBounds(151, 24, 3, 13);
		panel_3.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		BinP = new JTextField();
		BinP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comprobarCampo()){
					recalcular();
				}
			}
		});
		BinP.setBounds(159, 21, 86, 20);
		panel_3.add(BinP);
		BinP.setColumns(10);
		
		label_1 = new JLabel(")");
		label_1.setBounds(250, 24, 4, 13);
		panel_3.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		ErrorB = new JLabel("New label");
		ErrorB.setBounds(259, 25, 99, 11);
		panel_3.add(ErrorB);
		ErrorB.setFont(new Font("Tahoma", Font.PLAIN, 9));
		ErrorB.setVisible(false);
		ErrorB.setForeground(Color.RED);
		
		JLabel lblX = new JLabel("Tama\u00F1o Distribuci\u00F3n X");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblX.setBounds(11, 58, 126, 14);
		panel_3.add(lblX);
		
		Xtam = new JTextField();
		Xtam.setBounds(140, 55, 86, 20);
		panel_3.add(Xtam);
		Xtam.setColumns(10);			
		
		ErrorX = new JLabel("New label");
		ErrorX.setVisible(false);
		ErrorX.setForeground(Color.RED);
		ErrorX.setFont(new Font("Tahoma", Font.PLAIN, 9));
		ErrorX.setBounds(236, 58, 122, 14);
		panel_3.add(ErrorX);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Histograma Teorema Central", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panel_4.setBounds(10, 335, 368, 62);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JButton crearTeorema = new JButton("Crear Grafica");
		crearTeorema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comprobarCampo()){
					Histograma3.vector=teoremaCental();
					Histograma3 h=new Histograma3("Frecuencia de la Muestra");				
					h.setVisible(true);	
				}
			}
		});
		crearTeorema.setBounds(121, 28, 110, 23);
		panel_4.add(crearTeorema);


		
	}
	
	public double[] crearBinomial(boolean h1){
		int N=Integer.parseInt(BinN.getText());
		double p=Double.parseDouble(BinP.getText());
		int xn=Integer.parseInt(Xtam.getText());
		if(h1){
			Histograma.intervalo=N;	
		}else{
			Histograma2.intervalo=N;
			Histograma2.probabilida=p;
		}		
		double P=Double.parseDouble(BinP.getText());
		Binomial b=new Binomial(N, P,xn);		
		return b.probabilidad;
	}
	
	public double[] teoremaCental(){
		int N=Integer.parseInt(BinN.getText());
		int xn=Integer.parseInt(Xtam.getText());
		double med=Double.parseDouble(media.getText());
		double var=Double.parseDouble(cuasi.getText());
		double P=Double.parseDouble(BinP.getText());				
		Histograma3.intervalo=N;							
		Binomial b=new Binomial(N, P,xn);		
		double[] vector=b.probabilidad;
		for(int i=0;i<vector.length;i++){
			double xi=b.probabilidad[i]-med;
			vector[i]=xi/Math.abs(Math.sqrt(var));
		}
		return vector;
	}
	
	public boolean comprobarCampo(){
		boolean fin=false;
		int n=0;
		double p=0;
		int xn=0;
		try{					
			n=Integer.parseInt(BinN.getText());
			ErrorB.setVisible(false);
			try{
				p=Double.parseDouble(BinP.getText());
				ErrorB.setVisible(false);							
				try{
					ErrorX.setVisible(false);
					xn=Integer.parseInt(Xtam.getText());
					fin=true;
				}catch (Exception e) {
					ErrorX.setText("No es entero");
					ErrorX.setVisible(true);
				}
				
			}catch(Exception e){
				ErrorB.setText("P no es decimal");
				ErrorB.setVisible(true);
			}						
		}catch (Exception e) {
			ErrorB.setText("N no es entero");
			ErrorB.setVisible(true);
		}					
		return fin;
	}
	
	public void recalcular(){
		double p=Double.parseDouble(BinP.getText());
		if(p<0 || p>1){
			ErrorB.setText("Probabilidad [0,1]");
			ErrorB.setVisible(true);
		}else{
			int N=Integer.parseInt(BinN.getText());		
			double md=N*p;
			media.setText(""+md);
			double c=md*(1-p);
			cuasi.setText(""+c);	
		}	
	}
	
}

