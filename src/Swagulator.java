import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Swagulator extends JFrame implements ActionListener{
	JFileChooser fc;
	JPanel g,center,a,b;
	CardLayout cdlayout=new CardLayout();
	graph test;
	JTextField input;
	JLabel title;
	int n;
	JButton enter;
	public Swagulator(){
		//JPanel
		center=new JPanel();
		b=new JPanel();
		g=new JPanel();
		a=new JPanel();
		
		//Components
		test=new graph();
		title=new JLabel("Equation:");
		input=new JTextField(10);
		fc=new JFileChooser();
		enter=new JButton("Enter");
		
		enter.addActionListener(this);
		enter.setActionCommand("Enter");
		fc.addActionListener(this);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("jpeg,jpg","jpeg","jpg");
		fc.setFileFilter(filter);
		n = JOptionPane.showConfirmDialog(null,"Would you like to upload a file?","Swagulator",JOptionPane.YES_NO_OPTION);
		
		
		center.setLayout(cdlayout);
		
		b.add(title);
		b.add(input);
		b.add(enter);
		a.add(test);
		g.add(fc);
		center.add(g,"FileChooser");
		center.add(a,"graph");
		center.add(b,"Input");
		if(n==JOptionPane.YES_OPTION) {
			cdlayout.show(center, "FileChooser");
			
		}//if
		else {
			cdlayout.show(center, "Input");
		}

		
		
		
		
		this.setTitle("Swagulator");
		this.setVisible(true);
		this.setPreferredSize(new Dimension(1440,860));
		this.pack();
		this.setContentPane(center);
		
	}//constructor


	public void actionPerformed(ActionEvent e) {
		if(n==JOptionPane.YES_OPTION) {
			System.out.println(72);
			File file=fc.getSelectedFile();
			System.out.println(file.getName());
			test.fileInit(file);
		}
		else {
			System.out.println(78);
			test.inputInit(input.getText());
			System.out.println(input.getText());
		}
		cdlayout.show(center, "graph");
		
		

	}
	public static void main(String[]args) {
		Swagulator something=new Swagulator();
	}
}//ssalc
