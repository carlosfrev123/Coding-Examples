import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel instructionLabel;
	private JTextField textField;
	private JLabel resultLabel;
	private JButton actionButton;
	
	public SimpleWindow() {
		instructionLabel = new JLabel("( instruction label ) type something!");
		textField = new JTextField(50);
		actionButton = new JButton("this button does nothing");
		resultLabel = new JLabel(" result Label! ");
	}
	
	public void addComponentsToPanel(Container panel) {
		JPanel panel1 = new JPanel();
		
		panel1.add(instructionLabel);
		panel.add(panel1);
		
		panel1.add(textField);
        panel.add(panel1);
        
        panel1.add(resultLabel);
		panel.add(panel1);
		
        actionButton.setActionCommand("does nothing");
        panel1.add(actionButton);
        
	}
	
	
	public static void main(String[] args) {
		WindowRunnable window = new WindowRunnable();
		javax.swing.SwingUtilities.invokeLater(window);
	}
	
	public static void showGUI() {
		SimpleWindow frame1 = new SimpleWindow();
	
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.addComponentsToPanel( frame1.getContentPane());
		frame1.pack();
		frame1.setVisible(true);
	}
	
	
}
class WindowRunnable implements Runnable {
    public void run() {
        SimpleWindow.showGUI();
    }
}

