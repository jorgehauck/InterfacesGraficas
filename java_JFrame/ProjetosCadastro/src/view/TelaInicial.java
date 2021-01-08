package view;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import dados.Dados;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.TextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Scrollbar;

public class TelaInicial extends JFrame {
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaInicial() throws ParseException {
		
		ArrayList<Dados> dados = new ArrayList<>();
		
		setTitle("Cadastrar Contatos");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Jos\u00E9 Jorge Hauck Jr\\Downloads\\internet-42583_1280.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 482);
		getContentPane().setLayout(null);
		
		TextArea txtTextArea = new TextArea();
		txtTextArea.setEditable(false);
		txtTextArea.setBounds(10, 236, 617, 189);
		getContentPane().add(txtTextArea);
		
		JLabel lblNewLabel = new JLabel("Nome Completo: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 26, 126, 32);
		getContentPane().add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(135, 32, 323, 24);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o: ");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEndereo.setBounds(10, 71, 89, 32);
		getContentPane().add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(86, 77, 372, 24);
		getContentPane().add(txtEndereco);
		
		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTelefone.setBounds(10, 115, 89, 32);
		getContentPane().add(lblTelefone);
		
		txtTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(82, 121, 232, 24);
		getContentPane().add(txtTelefone);
		
		
		JButton btnCadastar = new JButton("Cadastar Contato");
		btnCadastar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = txtNome.getText();
				String endereco = txtEndereco.getText();
				String telefone = txtTelefone.getText();
				dados.add(new Dados(nome,endereco,telefone));
				txtNome.setText("");
				txtEndereco.setText("");
				txtTelefone.setText("");
				JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!", "Mensagem",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCadastar.setIcon(new ImageIcon("C:\\Users\\Jos\u00E9 Jorge Hauck Jr\\Downloads\\salve- (1).png"));
		btnCadastar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastar.setBounds(21, 183, 156, 32);
		getContentPane().add(btnCadastar);
		
		JButton btnExibir = new JButton("Exibir Dados");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = txtNome.getText();
				String endereco = txtEndereco.getText();
				String telefone = txtTelefone.getText();
				for(Dados d: dados)
				{
					txtTextArea.append(d.toString());
				}
				txtNome.setText("");
				txtEndereco.setText("");
				txtTelefone.setText("");
				
			}
		});
		btnExibir.setIcon(new ImageIcon("C:\\Users\\Jos\u00E9 Jorge Hauck Jr\\Downloads\\prancheta.png"));
		btnExibir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExibir.setBounds(252, 183, 156, 32);
		getContentPane().add(btnExibir);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon("C:\\Users\\Jos\u00E9 Jorge Hauck Jr\\Downloads\\sair.png"));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Obrigado!","Mensagem",JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBounds(474, 183, 156, 32);
		getContentPane().add(btnSair);
	}
}
