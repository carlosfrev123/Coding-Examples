
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ActionWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel instructionLabel;
	private JTextField textField;
	private JLabel resultLabel;
	private JButton actionButton;
	
	public ActionWindow() {
		instructionLabel = new JLabel("Enter a numeric value of kilometers you would like to convert to miles");
		textField = new JTextField(50);
		actionButton = new JButton(" CONVERT ");
		resultLabel = new JLabel("Result");
	}
	
	public void addComponentsToPanel(Container panel) {
		JPanel panel1 = new JPanel();
		
		panel1.add(instructionLabel);
		panel.add(panel1);
		
		panel1.add(textField);
        panel.add(panel1);
        
        panel1.add(resultLabel);
		panel.add(panel1);
		
       
        //---------------
        class convertButtonListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("result")) {
					int tfValue = Integer.parseInt(textField.getText());
					int milesValue = (int) (tfValue/1.609344);
					   
					resultLabel.setText("= "+ milesValue +" miles");
				}
			
				// TODO Auto-generated method stub
			}
        }
        actionButton.setActionCommand("result");
        
        
        convertButtonListener listener1 = new convertButtonListener();
        actionButton.addActionListener(listener1);
        panel1.add(actionButton);
        panel.add(panel1);
     
	}
    
	
	public static void main(String[] args) {
		WindowRunnable windowRun = new WindowRunnable();
		javax.swing.SwingUtilities.invokeLater(windowRun);
	}
	
	public static void showGUI() {
		ActionWindow winframe1 = new ActionWindow();
		winframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winframe1.addComponentsToPanel( winframe1.getContentPane());
		winframe1.pack();
		winframe1.setVisible(true);
	}
	
	
}
class WindowRunnable implements Runnable {
    public void run() {
        ActionWindow.showGUI();
    }
}

