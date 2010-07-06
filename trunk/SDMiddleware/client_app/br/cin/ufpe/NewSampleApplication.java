package br.cin.ufpe;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.cin.ufpe.in1118.middleware.distribution.services.naming.Naming;
import br.cin.ufpe.in1118.middleware.distribution.services.naming.NamingService;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;
import br.cin.ufpe.sd.Controller;
import br.ufpe.cin.sd.model.business.entities.FileSd;

/**
 * Classe Principal do Editor de Texto Simples
 */
public class NewSampleApplication extends JFrame {
	private Controller controller = null;
	private javax.swing.JPanel jContentPane = null;
	private javax.swing.JPanel jPanel = null;
	private javax.swing.JButton jButton = null;
	private javax.swing.JButton jButton1 = null;
	private javax.swing.JButton jButton2 = null;
	private javax.swing.JScrollPane jScrollPane = null;
	private javax.swing.JTextArea jTextArea = null;
	private javax.swing.JFileChooser jFileChooser = null; // @jve:visual-info
	// decl-index=0
	// visual
	// -constraint=
	// "582,36"
	private boolean hasChanged = false; // Indica se o texto foi alterado
	private static final String title = "Cliente 2DRS"; // Titulo da

	// janela

	/**
	 * Construtor Default
	 */
	public NewSampleApplication() {
		super(); // chama super de JFrame
		initialize(); // Inicializa o Objeto
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getJPanel(), java.awt.BorderLayout.SOUTH);
			jContentPane.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
			jContentPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(
					5, 5, 5, 5));
		}
		return jContentPane;
	}

	/**
	 * Inícializa a classe
	 * 
	 * @return void
	 */
	private void initialize() {
		this.controller = new Controller();
		this.setContentPane(getJContentPane());
		this.setSize(480, 284); // Tamanho da janela
		this.setTitle(title);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() { // Listener
			public void windowClosing(java.awt.event.WindowEvent e) {
				doExit();
			}
		});

	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new javax.swing.JPanel();
			jPanel.add(getJButton(), null);
			jPanel.add(getJButton1(), null);
			jPanel.add(getJButton2(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton() {
		if (jButton == null) {
			jButton = new javax.swing.JButton();
			jButton.setText("Abrir arquivo");
			jButton.addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						loadFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new javax.swing.JButton();
			jButton1.setText("Salvar arquivo");
			jButton1.addActionListener(new java.awt.event.ActionListener() { // Listener
				// pra
				// salvar
				// arquivo
				// no
				// clique
				// do
				// botão
				public void actionPerformed(java.awt.event.ActionEvent e) {
					saveFile();
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton2
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new javax.swing.JButton();
			jButton2.setText("Sair");
			jButton2.addActionListener(new java.awt.event.ActionListener() { // Listener
				// pra
				// fechar
				// programa
				// no
				// clique
				// do
				// botão
				public void actionPerformed(java.awt.event.ActionEvent e) {
					doExit();
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private javax.swing.JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new javax.swing.JScrollPane();
			jScrollPane.setViewportView(getJTextArea());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTextArea
	 * 
	 * @return javax.swing.JTextArea
	 */
	private javax.swing.JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new javax.swing.JTextArea(20, 20);
			jTextArea.setEnabled(false);
			jTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) { // Detecta
					// modifica�
					// �ão e
					// seta tbm
					if (!hasChanged) {
						setTitle(title + " *");
						hasChanged = true;
					}
				}
			});
		}
		return jTextArea;
	}

	/**
	 * This method initializes jFileChooser
	 * 
	 * @return javax.swing.JFileChooser
	 */
	private javax.swing.JFileChooser getJFileChooser() {
		if (jFileChooser == null) {
			jFileChooser = new javax.swing.JFileChooser();
			jFileChooser.setMultiSelectionEnabled(false);
		}
		return jFileChooser;
	}

	// função que carrega o texto
	private void loadFile() throws IOException {
		NewJDialog inst = new NewJDialog(this, true, controller);
		inst.setVisible(true);

		if (inst.getArquivo() != null) { // verifica o status
			File f = Util.getFileFromBytes(inst.getArquivo().getFile(), inst
					.getArquivo().getName());

			try { // Tenta ler o arquivo para o controle de texto
				FileReader fr = new FileReader(f); // cria o FileReader com o
				// file previamente
				// selecionado
				String temp = ""; // String temporaria
				// Vai lendo um caractere por vez e concatenando em temp.
				// A função read retorna um inteiro pois pode vir -1
				// significando o fim do arquivo
				// E um char não permite negativos
				// a função read pode gerar IOException
				FileInputStream fin = new FileInputStream(f.getAbsolutePath());
				long tamanhoArquivo = fin.getChannel().size();
				String path = f.getAbsolutePath();
				// int i = fr.read();
				// while (i != -1) {
				// temp += ((char) i);
				// i = fr.read();
				// }
				temp = "Nome do Arquivo : " + f.getName() + "\nTamanho em Kb :"
						+ tamanhoArquivo + "\nPath Local :" + path;
				fr.close(); // fecha arquivo
				getJTextArea().setText(temp); // atribui temp ao controle
				setTitle(title); // seta o titulo pra remover o * se houver
				hasChanged = false; // Não alterado
			} catch (FileNotFoundException e) { // Não encontrou arquivo
				e.printStackTrace();
			} catch (IOException e) { // Algum erro na leitura
				e.printStackTrace();
			}
		}
	}

	// função que salva
	private void saveFile() {
		int state = getJFileChooser().showSaveDialog(this); // Abre dialogo pra
		// selecionar
		if (state == JFileChooser.APPROVE_OPTION) { // se selecionou
			File file = getJFileChooser().getSelectedFile(); // pega file
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println(file.exists() + "!!");
			// InputStream in = resource.openStream();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			try {
				for (int readNum; (readNum = fis.read(buf)) != -1;) {
					bos.write(buf, 0, readNum); // no doubt here is 0
					// Writes len bytes from the specified byte array
					// starting at
					// offset off to this byte array output stream.
//						System.out.println("read " + readNum + " bytes,");
				}
			} catch (IOException ex) {
				// Logger.getLogger(genJpeg.class.getName()).log(Level.SEVERE,
				// null,
				// ex);
			}
			byte[] bytes = bos.toByteArray();

			Naming naming = NamingService.getNamingInstance("localhost",
					9001);

			br.ufpe.cin.sd.controller.Controller csd = null;
			try {
				csd = (br.ufpe.cin.sd.controller.Controller) naming.lookup("controllerService");
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			FileSd filesd = new FileSd();
			filesd.setName(file.getName());
			filesd.setFile(bytes);

			csd.inserir(filesd);
		}
	}

	// Na saida verifica se quer salvar
	private void doExit() {
		if (hasChanged) {
			int state = JOptionPane.showConfirmDialog(this,
					"O Arquivo foi moficado. Quer salva antes de sair?");
			if (state == JOptionPane.YES_OPTION) {
				saveFile();
			} else if (state == JOptionPane.CANCEL_OPTION) {
				return;
			}
		}
		System.exit(0); // Sae fora =)
	}

	// Função Princial, apenas cria classe e mostra, depois os Listener
	// adicionados em Editor fazem o resto
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() { // Adiciona o
					// código run
					// abaixo a
					// thread que
					// maipula os
					// eventos
					// graficos
					public void run() {
						NewSampleApplication e = new NewSampleApplication(); // Cria
						// objeto
						e.setVisible(true); // Mostra
					}
				});

	}

} // @jve:visual-info decl-index=0 visual-constraint="20,27"
