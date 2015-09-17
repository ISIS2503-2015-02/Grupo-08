package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.BoxLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.mashape.unirest.http.exceptions.UnirestException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.http;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Index {

	private String tranviaId;

	private String estacionId;

	private String mobibusId;
	private JFrame frame;
	private http x;
	private JLabel estacionIdLabel;
	private JLabel lblMobibusidlabel;
	private JLabel lblTranviaid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index window = new Index();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Index() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		x = new http();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JPanel mobibusPanel = new JPanel();
		tabbedPane.addTab("Mobibus", null, mobibusPanel, null);
		
		JLabel lblId_1 = new JLabel("ID:");
		
		mobibusId = "1";
		lblMobibusidlabel = new JLabel(mobibusId);
		
		JButton btnReportarPosicion_1 = new JButton("Reportar posicion");
		btnReportarPosicion_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					String s =x.mobibusReportarPosicion(mobibusId);
					
					JOptionPane.showMessageDialog( frame, s, "Reportar Posicion", JOptionPane.INFORMATION_MESSAGE );
				} catch (UnirestException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnReportarOcupacion = new JButton("Reportar ocupacion");
		btnReportarOcupacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					String s =x.mobibusreportarOcupacion(mobibusId);
					
					JOptionPane.showMessageDialog( frame, s, "Reportar Ocupacion", JOptionPane.INFORMATION_MESSAGE );
				} 
				catch (UnirestException e2) 
				{
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		GroupLayout gl_mobibusPanel = new GroupLayout(mobibusPanel);
		gl_mobibusPanel.setHorizontalGroup(
			gl_mobibusPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mobibusPanel.createSequentialGroup()
					.addGap(68)
					.addGroup(gl_mobibusPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnReportarOcupacion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_mobibusPanel.createSequentialGroup()
							.addComponent(lblId_1)
							.addGap(18)
							.addComponent(lblMobibusidlabel))
						.addComponent(btnReportarPosicion_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(205, Short.MAX_VALUE))
		);
		gl_mobibusPanel.setVerticalGroup(
			gl_mobibusPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mobibusPanel.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_mobibusPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId_1)
						.addComponent(lblMobibusidlabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnReportarPosicion_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReportarOcupacion)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		mobibusPanel.setLayout(gl_mobibusPanel);
		
		JPanel estacionPanel = new JPanel();
		tabbedPane.addTab("Estacion", null, estacionPanel, null);
		
		JButton btnPrestarVcub = new JButton("Prestar Vcub");
		btnPrestarVcub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{

				String vcubID = JOptionPane.showInputDialog( frame, "Vcub ID", "Prestar Vcub", JOptionPane.QUESTION_MESSAGE );
				try 
				{
					String s =x.prestarVcub(vcubID, estacionId);
					
					JOptionPane.showMessageDialog( frame, s, "Reportar Emergencia", JOptionPane.INFORMATION_MESSAGE );
				} 
				catch (UnirestException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnRecibirVcub = new JButton("Recibir Vcub");
		btnRecibirVcub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				 String vcubID =JOptionPane.showInputDialog( frame, "Codigo:", "Recibir Vcub", JOptionPane.QUESTION_MESSAGE );
				try 
				{
					String s =x.recibirVcub(vcubID, estacionId);
					
					JOptionPane.showMessageDialog( frame, s, "Reportar Emergencia", JOptionPane.INFORMATION_MESSAGE );
				} 
				catch (UnirestException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnRegistrarVcub = new JButton("Registrar Vcub");
		btnRegistrarVcub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					String s =x.registrarVcubs(estacionId);
					JOptionPane.showMessageDialog( frame, s, "Reportar Emergencia", JOptionPane.INFORMATION_MESSAGE );
				} 
				catch (UnirestException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnPedirLlenado = new JButton("Pedir llenado");
		btnPedirLlenado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					String s = x.pedirLlenado(estacionId);
					JOptionPane.showMessageDialog( frame, s, "Reportar Emergencia", JOptionPane.INFORMATION_MESSAGE );
				} 
				catch (UnirestException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblId = new JLabel("ID:");
		estacionId = "1";
		estacionIdLabel = new JLabel(estacionId);
		GroupLayout gl_estacionPanel = new GroupLayout(estacionPanel);
		gl_estacionPanel.setHorizontalGroup(
			gl_estacionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_estacionPanel.createSequentialGroup()
					.addContainerGap(71, Short.MAX_VALUE)
					.addGroup(gl_estacionPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_estacionPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblId)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(estacionIdLabel))
						.addGroup(gl_estacionPanel.createSequentialGroup()
							.addGroup(gl_estacionPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnRecibirVcub)
								.addComponent(btnPrestarVcub))
							.addGap(31)
							.addGroup(gl_estacionPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnPedirLlenado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnRegistrarVcub))))
					.addGap(69))
		);
		gl_estacionPanel.setVerticalGroup(
			gl_estacionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_estacionPanel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_estacionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(estacionIdLabel)
						.addComponent(lblId))
					.addGap(18)
					.addGroup(gl_estacionPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_estacionPanel.createSequentialGroup()
							.addComponent(btnPrestarVcub)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRecibirVcub))
						.addGroup(gl_estacionPanel.createSequentialGroup()
							.addComponent(btnPedirLlenado)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRegistrarVcub)))
					.addContainerGap(108, Short.MAX_VALUE))
		);
		estacionPanel.setLayout(gl_estacionPanel);
		
		JPanel tranviaPanel = new JPanel();
		tabbedPane.addTab("Tranvia", null, tranviaPanel, null);
		
		JLabel lblId_2 = new JLabel("ID:");
		
		tranviaId = "1";
		lblTranviaid = new JLabel(tranviaId);
		
		JButton btnReportarEmergencia = new JButton("Reportar Emergencia");
		btnReportarEmergencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					String s =x.tranviaReportarEmergencia(tranviaId);
					System.out.println(s);
					
					JOptionPane.showMessageDialog( frame, s, "Reportar Emergencia", JOptionPane.INFORMATION_MESSAGE );
				} catch (UnirestException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnReportarPosicion = new JButton("Reportar Posicion");
		btnReportarPosicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String s = x.tranviaReportarPosicion(tranviaId);
					
					JOptionPane.showMessageDialog( frame, s, "Reportar Emergencia", JOptionPane.INFORMATION_MESSAGE );
				} catch (UnirestException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		GroupLayout gl_tranviaPanel = new GroupLayout(tranviaPanel);
		gl_tranviaPanel.setHorizontalGroup(
			gl_tranviaPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tranviaPanel.createSequentialGroup()
					.addGap(84)
					.addGroup(gl_tranviaPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnReportarPosicion)
						.addComponent(btnReportarEmergencia)
						.addGroup(gl_tranviaPanel.createSequentialGroup()
							.addComponent(lblId_2)
							.addGap(18)
							.addComponent(lblTranviaid)))
					.addContainerGap(171, Short.MAX_VALUE))
		);
		gl_tranviaPanel.setVerticalGroup(
			gl_tranviaPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tranviaPanel.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_tranviaPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId_2)
						.addComponent(lblTranviaid))
					.addGap(18)
					.addComponent(btnReportarEmergencia)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReportarPosicion)
					.addContainerGap(96, Short.MAX_VALUE))
		);
		tranviaPanel.setLayout(gl_tranviaPanel);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnConfig = new JMenu("Config");
		menuBar.add(mnConfig);
		
		JMenuItem mntmEstacion = new JMenuItem("Estacion");
		mntmEstacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				estacionId = JOptionPane.showInputDialog( frame, "Ingrese el id de su estacion vcub", "Estacion ID", JOptionPane.QUESTION_MESSAGE );
				estacionIdLabel.setText(estacionId);
				frame.repaint();
			}
		});
		mntmEstacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
			}
		});
		mnConfig.add(mntmEstacion);
		
		JMenuItem mntmTranvia = new JMenuItem("Tranvia");
		mntmTranvia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tranviaId = JOptionPane.showInputDialog( frame, "Ingrese el id de su tranvia", "Tranvia ID", JOptionPane.QUESTION_MESSAGE );
				lblTranviaid.setText(tranviaId);
				frame.repaint();
				
			}
		});
		mnConfig.add(mntmTranvia);
		
		JMenuItem mntmMobibus = new JMenuItem("Mobibus");
		mntmMobibus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mobibusId = JOptionPane.showInputDialog( frame, "Ingrese el id de su mobibus", "Mobibus ID", JOptionPane.QUESTION_MESSAGE );
				lblMobibusidlabel.setText(mobibusId);
				frame.repaint();
			}
		});
		mnConfig.add(mntmMobibus);
	}
}
