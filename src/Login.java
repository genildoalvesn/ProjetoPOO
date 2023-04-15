

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 300, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		URL url = this.getClass().getResource("/imagens/icone.png"); 
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url); 
		frame.setIconImage(iconeTitulo);
		
		JLabel label = new JLabel("Senha:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(50, 97, 63, 21);
		frame.getContentPane().add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(123, 99, 100, 19);
		frame.getContentPane().add(passwordField);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.RED);
		label_1.setBackground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(87, 189, 151, 13);
		frame.getContentPane().add(label_1);
		
		JButton button = new JButton("ok");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = new String(passwordField.getPassword());
				if (senha.equals("ifpb")) {
					frame.dispose();
					Valetinho tela = new Valetinho();
				} else {
					label_1.setText("tente novamente");
					passwordField.setText("");
					passwordField.requestFocus();
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(35, 145, 85, 21);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("sair");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(153, 145, 85, 21);
		frame.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(77, 10, 117, 77);
		frame.getContentPane().add(lblNewLabel);
		
		ImageIcon imagem = new ImageIcon(Login.class.getResource("/imagens/valet.png"));
		imagem.setImage(imagem.getImage().getScaledInstance(
			lblNewLabel.getWidth(),
			lblNewLabel.getHeight(),
			Image.SCALE_DEFAULT
		));
		lblNewLabel.setIcon(imagem);
	}
}

