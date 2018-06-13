package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.PessoaFisicaDAO;
import model.PessoaFisica;

public class App extends JFrame {

	PessoaFisica pessoaFis = new PessoaFisica();

	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME: ");

	JTextField txtEnd = new JTextField();
	JLabel end = new JLabel("ENDEREÇO: ");

	JTextField txtBairro = new JTextField();
	JLabel bairro = new JLabel("BAIRRO: ");

	JFormattedTextField txtTel = null;
	JLabel tel = new JLabel("TELEFONE: ");

	JButton btnSalvar = new JButton("Salvar");

	JButton btnImprimir = new JButton("Imprimir");

	MaskFormatter formatTel = null; // add mascara

	private JTextField txtTelefone;

	public App() {
		super("Cadastro PF");

		Container paine = this.getContentPane();

		paine.add(nome);
		paine.add(txtNome);
		nome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(90, 15, 225, 30);

		paine.add(end);
		paine.add(txtEnd);
		end.setBounds(10, 50, 70, 30);
		txtEnd.setBounds(90, 50, 225, 30);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(90, 125, 225, 25);
		getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);

		paine.add(bairro);
		paine.add(txtBairro);
		bairro.setBounds(10, 85, 70, 30);
		txtBairro.setBounds(90, 85, 225, 30);

		paine.add(tel);
		tel.setBounds(10, 125, 70, 30);

		paine.add(btnSalvar);
		btnSalvar.setBounds(50, 170, 130, 30);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pessoaFis.setNome(txtNome.getText());
				pessoaFis.setEndereco(txtEnd.getText());
				pessoaFis.setBairro(txtBairro.getText());
				pessoaFis.setTelefone(txtTelefone.getText());

				PessoaFisicaDAO.getInstance().merge(pessoaFis);
				System.out.println("Cadastro Realizado");
			}
		});

		paine.add(btnImprimir);
		btnImprimir.setBounds(200, 170, 130, 30);

		getContentPane().setLayout(null);

		this.setVisible(true);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		App cadpf = new App();
	}
}