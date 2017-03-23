package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
		setTitle("Lib Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnPesquisar = new JButton("Pesquisar");

		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			//	System.out.println(numeroDeColunas);
				
				
				String[] fila = new String[4];
				fila[0] = "1234";
				fila[1] = "testeTituloDoLivro";
				fila[2] = "testeNomeDoAutor";
				fila[3] = "testeNomeDaEditora";
				((DefaultTableModel) table.getModel()).addRow(fila);
				
			}
		});
		btnPesquisar.setBounds(759, 10, 137, 23);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 739, 20);
		textField.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(10, 453, 137, 23);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(157, 453, 137, 23);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(304, 453, 137, 23);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 52, 732, 383);
		contentPane.setLayout(null);
		contentPane.add(btnPesquisar);
		contentPane.add(textField);
		contentPane.add(btnCadastrar);
		contentPane.add(btnEditar);
		contentPane.add(btnDeletar);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel(); // 
		JTable table = new JTable(modelo);                  // addicionado modelo no parametro
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Titulo", "Autor", "Editora"
			}
		));
		scrollPane.setViewportView(table);
	}
}
