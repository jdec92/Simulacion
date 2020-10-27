package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

public class Tabla extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static String[][] matriz;
	/**
	 * Launch the application.
	 */	
	
	

	/**
	 * Create the frame.
	 */
	public Tabla(String t) {
		setTitle(t);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String[] titulo={"Intervalo","Valor Estimado","Valor Real","Error"};		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 680, 260);
		contentPane.add(scrollPane);
		table = new JTable(matriz,titulo);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
				
	}
	
}
