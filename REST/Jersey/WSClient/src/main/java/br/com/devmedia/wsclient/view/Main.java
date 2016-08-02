package br.com.devmedia.wsclient.view;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import br.com.devmedia.wsclient.controller.ServiceControl;

public class Main extends javax.swing.JFrame {

	private String usuario;

	public Main() {
		initComponents();
		this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.getWidth() / 2)),
				((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.getHeight() / 2)));
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	// Esse metodo e gerado pelo Netbeans

	private void initComponents() {

		blUsuario = new javax.swing.JLabel();
		txtUsuario = new javax.swing.JTextField();
		bntOk = new javax.swing.JButton();
		bntSair = new javax.swing.JButton();
		lbChat = new javax.swing.JLabel();
		lbHost = new javax.swing.JLabel();
		txtHost = new javax.swing.JTextField();
		lbPorta = new javax.swing.JLabel();
		txtPorta = new javax.swing.JTextField();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		blUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		blUsuario.setText("Usuário:");
		txtUsuario.setText("Informe o usuário");
		bntOk.setText("Ok");
		bntOk.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bntOkActionPerformed(evt);
			}
		});
		bntSair.setText("Sair");
		bntSair.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bntSairActionPerformed(evt);
			}
		});
		lbChat.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lbChat.setText("Para acessar o CHAT informe um Usuário");
		lbHost.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		lbHost.setText("Host:");
		txtHost.setText("localhost");
		lbPorta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		lbPorta.setText("Porta:");
		txtPorta.setText("8080");
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout
								.createSequentialGroup().addGap(128, 128, 128).addComponent(bntOk).addGap(40, 40, 40)
								.addComponent(bntSair))
						.addGroup(layout.createSequentialGroup().addGap(24, 24, 24).addComponent(lbChat))
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(lbHost).addComponent(blUsuario))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup()
												.addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, 128,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(lbPorta)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
														javax.swing.GroupLayout.PREFERRED_SIZE)))))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addComponent(lbChat).addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbHost)
								.addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbPorta).addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(blUsuario).addComponent(txtUsuario,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(bntSair).addComponent(bntOk))
						.addContainerGap()));

		pack();
	}// </editor-fold>

	private void bntSairActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	// 15
	private void bntOkActionPerformed(java.awt.event.ActionEvent evt) {
		// Condicoes inciais que verificam a obrigatoriedade de preenchimento
		// dos campos host, porta e usuario
		if ("".equals(txtUsuario.getText())) {
			JOptionPane.showMessageDialog(rootPane, "Nome do usuário não informado", "Informe usuário", WIDTH);
		} else if ("".equals(txtHost.getText())) {
			JOptionPane.showMessageDialog(rootPane, "Nome do Host não informado.", "Informe Host", WIDTH);
		} else if ("".equals(txtPorta.getText())) {
			JOptionPane.showMessageDialog(rootPane, "Nome da Porta não informado.", "Informe Porta", WIDTH);
		} else {
			// Captura o nnome do usuario digitado e seta na variavel da
			// 'usuario' da classe.
			this.setUsuario(txtUsuario.getText());
			// SETA O HOST E A PORTA PARA CONEXAO
			ServiceControl.HOST = txtHost.getText();
			ServiceControl.PORT = txtPorta.getText();
			// inicia a janela do chat com o titulo igual ao nome do usuario
			ChatView view = new ChatView(usuario);
			// posiciona o janela no meio da tela
			view.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.getWidth() / 2)),
					((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.getHeight() / 2)));
			// seta o evento na janela que sera disparada quanda a mesma for
			// fechada.
			// A identificacao do fechamento da janela faz necessario
			// pois precisamos remover o usuario do chat
			view.addWindowListener(new WindowListener() {
				public void windowActivated(WindowEvent e) {
				}

				public void windowClosed(WindowEvent e) {
				}

				// evento disparado quando a janela for fechada. Remove o
				// usuario do chat no servidor
				public void windowClosing(WindowEvent e) {
					System.out.println("Removendo:" + usuario);
					ServiceControl.dellUser(usuario);
					System.exit(0);
				}

				public void windowDeactivated(WindowEvent e) {
				}

				public void windowDeiconified(WindowEvent e) {
				}

				public void windowIconified(WindowEvent e) {
				}

				public void windowOpened(WindowEvent e) {
				}
			});
			// abre a janela do chat
			view.setVisible(true);
			view.setResizable(false);
			// fecha a janela de login
			this.dispose();
		}
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}

	private javax.swing.JButton bntOk;
	private javax.swing.JButton bntSair;
	private javax.swing.JLabel blUsuario;
	private javax.swing.JLabel lbChat;
	private javax.swing.JLabel lbHost;
	private javax.swing.JLabel lbPorta;
	private javax.swing.JTextField txtHost;
	private javax.swing.JTextField txtPorta;
	private javax.swing.JTextField txtUsuario;
}
