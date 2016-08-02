package br.com.devmedia.wsclient.view;

import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.devmedia.wsclient.bean.Message;
import br.com.devmedia.wsclient.bean.User;
import br.com.devmedia.wsclient.controller.ServiceControl;

public class ChatView extends javax.swing.JFrame {

	private Message msg;

	public ChatView(String usuario) {
		super.setTitle("Chat-" + usuario);
		msg = new Message();
		msg.setUser(usuario);
		User user = new User(usuario);
		ServiceControl.addUser(user);
		initMensagens();
		initUsers();
		initComponents();
	}

	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

	public void initMensagens() {
		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(5000);
						List<Message> list = ServiceControl.getMessages();
						String mensagem = "";
						for (Message m : list) {
							// MENSAGENS DE ENTRADA E SAIDA DA SALA
							if (m.getUser().equals("")) {
								mensagem = mensagem + "-> " + m.getMessage() + "\n";
							}
							// CONVERSA ENTRE OS USUARIOS
							else {
								mensagem = mensagem + "-> " + m.getUser() + " diz: " + m.getMessage() + "\n";
							}

						}
						System.out.println("mensagem:" + mensagem);
						txtMensagens.setText(mensagem);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro ao buscar mensagens", null, WIDTH);
					}
				}

			}
		}.start();

	}

	public void initUsers() {
		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(5000);
						List<User> list = ServiceControl.getUsers();
						System.out.println("List usuario size:" + list.size());
						String usuarios = "";
						for (User u : list) {
							usuarios = usuarios + u.getName() + "\n";
						}
						System.out.println("Usuarios:" + usuarios);
						txtUsuarios.setText(usuarios);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro ao buscar mensagens", null, WIDTH);
					}
				}

			}
		}.start();
	}

	// Esse metodo é gerado pelo Netbeans
	private void initComponents() {

		scrollPaneUsuario = new javax.swing.JScrollPane();
		txtUsuarios = new javax.swing.JTextArea();
		scrollPaneMessages = new javax.swing.JScrollPane();
		txtMensagens = new javax.swing.JTextArea();
		scrollPaneEnviar = new javax.swing.JScrollPane();
		txtEnviar = new javax.swing.JTextArea();
		bntSend = new javax.swing.JButton();
		lbMessages = new javax.swing.JLabel();
		lbUsuario = new javax.swing.JLabel();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		txtUsuarios.setEditable(false);
		txtUsuarios.setColumns(20);
		txtUsuarios.setRows(5);
		scrollPaneUsuario.setViewportView(txtUsuarios);
		txtMensagens.setEditable(false);
		txtMensagens.setColumns(20);
		txtMensagens.setRows(5);
		scrollPaneMessages.setViewportView(txtMensagens);
		txtEnviar.setColumns(20);
		txtEnviar.setRows(5);
		txtEnviar.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txtEnviarKeyPressed(evt);
			}
		});
		scrollPaneEnviar.setViewportView(txtEnviar);
		bntSend.setText("Enviar");
		bntSend.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bntSendActionPerformed(evt);
			}
		});
		bntSend.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				bntSendKeyPressed(evt);
			}
		});
		lbMessages.setText("Mensagens");
		lbUsuario.setText("Usuários");
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(scrollPaneEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 424,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(bntSend))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addGap(2, 2, 2).addComponent(scrollPaneMessages,
												javax.swing.GroupLayout.PREFERRED_SIZE, 495,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(203, 203, 203).addComponent(lbMessages,
										javax.swing.GroupLayout.PREFERRED_SIZE, 88,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(scrollPaneUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addComponent(lbUsuario).addGap(38, 38, 38)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(1, 1, 1)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(lbMessages).addComponent(lbUsuario))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(scrollPaneMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 239,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(scrollPaneEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
												Short.MAX_VALUE)
										.addComponent(bntSend, javax.swing.GroupLayout.DEFAULT_SIZE, 56,
												Short.MAX_VALUE)))
						.addComponent(scrollPaneUsuario))));

		pack();
	}

	private void bntSendActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		msg.setMessage(txtEnviar.getText());
		txtEnviar.setText("");
		ServiceControl.addMessage(msg);

	}

	private void bntSendKeyPressed(java.awt.event.KeyEvent evt) {
		// TODO add your handling code here:
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			msg.setMessage(txtEnviar.getText());
			txtEnviar.setText("");
			ServiceControl.addMessage(msg);
		}
	}

	private void txtEnviarKeyPressed(java.awt.event.KeyEvent evt) {
		// TODO add your handling code here:
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			msg.setMessage(txtEnviar.getText());
			txtEnviar.setText("");
			ServiceControl.addMessage(msg);
		}
	}

	private javax.swing.JButton bntSend;
	private javax.swing.JLabel lbMessages;
	private javax.swing.JLabel lbUsuario;
	private javax.swing.JScrollPane scrollPaneUsuario;
	private javax.swing.JScrollPane scrollPaneMessages;
	private javax.swing.JScrollPane scrollPaneEnviar;
	private javax.swing.JTextArea txtEnviar;
	private javax.swing.JTextArea txtMensagens;
	private javax.swing.JTextArea txtUsuarios;

}