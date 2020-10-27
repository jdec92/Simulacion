package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField BinN;					
	private JTextField BinP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setTitle("Distribución Binomial");
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		BinN = new JTextField();
		BinN.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		
		
		JLabel lblIntroduce = new JLabel("Introduce el tama\u00F1o de la Binomial");
		
		JLabel ErrorN = new JLabel("No es un n\u00FAmero entero.");		
		ErrorN.setVisible(false);
		ErrorN.setForeground(Color.RED);
		
		BinP = new JTextField();
		BinP.setText("0.5");
		BinP.setColumns(10);
		
		JLabel labelP = new JLabel("Introduce la probabilidad de la Binomial");
		
		JLabel ErrorP = new JLabel("No es un n\u00FAmero decimal");
		ErrorP.setVisible(false);
		ErrorP.setForeground(Color.RED);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblIntroduce, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(labelP, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(17)
									.addComponent(ErrorN))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(32)
									.addComponent(BinN, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(BinP, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(ErrorP)))
							.addContainerGap(87, Short.MAX_VALUE))))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(206)
					.addComponent(btnCalcular)
					.addContainerGap(230, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIntroduce)
						.addComponent(labelP))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(BinP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(BinN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ErrorP)
						.addComponent(ErrorN))
					.addGap(31)
					.addComponent(btnCalcular)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int N=0;
				double p=0;
				try{					
					N=Integer.parseInt(BinN.getText());
					ErrorN.setVisible(false);
				}catch (Exception e) {
					ErrorN.setText("No es un número entero");
					ErrorN.setVisible(true);
				}
				try{
					p=Double.parseDouble(BinP.getText());
					ErrorP.setVisible(false);
				}catch(Exception e){
					ErrorP.setText("No es un número decimal");
					ErrorP.setVisible(true);
				}				
				if(N==0 || p==0 || p<0 || p>1){
					if(N==0){
						ErrorN.setText("Completa este Campo");
						ErrorN.setVisible(true);
					}
					if(p==0){						
						ErrorP.setText("Completa este Campo");
						ErrorP.setVisible(true);
					}else{
						ErrorP.setText("Probabilidad entre [0,1]");
						ErrorP.setVisible(true);
					}
					
				}else{
					Menu m= new Menu();
					m.setTitle("Menu D.Binomial");
					m.setVisible(true);									
					m.BinN.setText(""+N);
					m.BinP.setText(""+p);
					m.Xtam.setText(""+N*2);
					double md=N*p;
					m.media.setText(""+md);
					double c=md*(1-p);
					m.cuasi.setText(""+c);
					setVisible(false);	
				}
				
				
			}
		});
		
		panel.setLayout(gl_panel);
		
		
	}
}
