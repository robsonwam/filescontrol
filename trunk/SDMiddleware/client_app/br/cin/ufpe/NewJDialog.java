package br.cin.ufpe;
import java.util.Collection;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import org.jdesktop.application.Application;

import br.cin.ufpe.sd.Arquivo;
import br.cin.ufpe.sd.Controller;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class NewJDialog extends javax.swing.JDialog {
	private JTree jTree1;
	private JButton jButton1;
	private JButton jButton2;
	private Controller controller;
	protected Arquivo arquivo;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				NewJDialog inst = new NewJDialog(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public Arquivo getArquivo(){
		return this.arquivo;
	}
	
	public NewJDialog(JFrame frame, boolean b) {
		super(frame, b);
		initGUI();
	}
	
	public NewJDialog(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	public NewJDialog(JFrame frame, boolean b,
			Controller controller) {
		super(frame, b);
		this.controller = controller;
		initGUI();
	}

	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				{
					DefaultMutableTreeNode raiz = montarArvore();

					jTree1 = new JTree(raiz);
					JScrollPane scrollPane = new JScrollPane(jTree1);

					getContentPane().add(scrollPane);
					scrollPane.setBounds(0, 0, 384, 192);
					jTree1.setBounds(0, 0, 384, 165);
					
				}
				{
					jButton1 = new JButton();
					getContentPane().add(jButton1);
					jButton1.setBounds(54, 215, 113, 23);
					jButton1.setName("jButton1");
					jButton1.addActionListener(new java.awt.event.ActionListener() { //Listener pra fechar programa no clique do botão
						public void actionPerformed(java.awt.event.ActionEvent e) {
							try {
								if(jTree1.getSelectionPath() != null){
									FileName fileName = (FileName) ((DefaultMutableTreeNode)jTree1.getSelectionPath().getLastPathComponent()).getUserObject();
									arquivo = controller.getFile(fileName.getId());
									setVisible(false);
									dispose();
								}
							} catch (Throwable e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
				}
				{
					jButton2 = new JButton();
					getContentPane().add(jButton2);
					jButton2.setBounds(192, 215, 115, 23);
					jButton2.setName("jButton2");
					jButton2.addActionListener(new java.awt.event.ActionListener() { //Listener pra fechar programa no clique do botão
						public void actionPerformed(java.awt.event.ActionEvent e) {
							try {
								setVisible(false);
								dispose();
							} catch (Throwable e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
				}
			}
			setSize(400, 300);
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private DefaultMutableTreeNode montarArvore(){ 
	    DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Files");
	    
	    String[] extensoes = {"txt"};
	    Map files = controller.getFiles(extensoes);
	    Collection<?> collection = files.keySet();
	    
	    for (Object object : collection) {
	    	
	    	FileName file = new FileName();
	    	file.setId((Integer) object);
	    	file.name = (String) files.get(object);
	    	
	    	DefaultMutableTreeNode node = new DefaultMutableTreeNode(file);
			raiz.add(node);
		}
	    
	    return raiz; 
	  }


}
