import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * MemeMagic Graphical User Interface
 * 
 * This class contains the graphical user interface for the Meme Magic Software
 * 
 * You will need to implement certain portions of this class, marked with
 * comments starting with "TODO" to connect it with your existing code.
 * 
 * This class provides an example layout for the GUI. You are encouraged to be
 * creative in your design. More information about Swing is online at:
 * https://docs.oracle.com/javase/tutorial/uiswing/components/componentlist.html.
 * 
 * 
 */
public class MemeMagic extends JFrame {

	/**
	 * Serialization string required by extending JFrame
	 */
	private static final long serialVersionUID = 1L;

	// ---------------------------INSTANCE VARIABLES ----------------------------------------------
	private User user;
	
	private BorderLayout panelLayout;
	private JLabel backgroundImageFileNameLabel;
	private JLabel imageDisplayLabel;
	
	private JPanel controlPanel;
	private JPanel memeViewPanel;
	private JPanel panelPane;
	
	private JTextField backgroundImageTitleField;
	private JTextField backgroundImageDestxtField;
	
	
	private String memeVerticalAlign;
	private JComboBox<String> verticalAllignCombox;
	private JTextField memeCaptionField;
	
	private String backgroundImageFilename;
	private String bImageTitle;
	private String bImageDescription;
	private String memeCaption;
	private GraphicalMeme currentMeme;
	
// -------------------------CONSTRUCTORS --------------------
	public MemeMagic() {
		this.user = new User();
	}
	

	public MemeMagic(User user) {
		this.user = user;	
	}

	
	/**
	 * Main method. This method initializes a PhotoViewer, loads images into a
	 * PhotographContainer, then initializes the Graphical User Interface.
	 * 
	 * @param args Optional command-line arguments
	 */
	public static void main(String[] args) {

		// Create a User object for this instance of Meme Magic
		User user = new User();

		// Instantiate the PhotoViewer Class
		MemeMagic myViewer = new MemeMagic(user);

		// Invoke and start the Graphical User Interface
		javax.swing.SwingUtilities.invokeLater(() -> myViewer.initialize());
	}

	/**
     * Initialize all the GUI components.  This method will be called by
     * SwingUtilities when the application is started.
     */
    private void initialize() {

        // Tell Java to exit the program when the window is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Tell Java to title the window to Meme Magic
        this.setTitle("Meme Magic");

        // We will use border layout on the main panel, since it is much easier for organizing panels.
        panelLayout = new BorderLayout();
        panelPane = new JPanel(panelLayout);
        panelPane.setBackground(Color.pink);
        

        // Create a label to display the full image.
        imageDisplayLabel = new JLabel();
        imageDisplayLabel.setHorizontalAlignment(JLabel.CENTER);
        imageDisplayLabel.setPreferredSize(new Dimension(550, 550));

        // Create a panel on which to display the full image
        memeViewPanel = new JPanel(new BorderLayout());
        memeViewPanel.setPreferredSize(new Dimension(550, 550));
        memeViewPanel.add(imageDisplayLabel, BorderLayout.CENTER);
        memeViewPanel.setBackground(Color.PINK);


        // Create a panel on which to display the controls for building a Meme
        controlPanel = new JPanel(new BorderLayout());
        
        
        
        
        
        

        

     // --------------------BACKGROUNDIMAGE PANEL --------------------------------------------------------------
        JPanel backgroundImagePanel = new JPanel(new BorderLayout());
        backgroundImagePanel.setBackground(Color.CYAN);
        backgroundImagePanel.setBorder(BorderFactory.createTitledBorder("Background Image"));
        
        JPanel backgroundImageFilePanel = new JPanel();
        JPanel backgroundImageTitlePanel = new JPanel();
        JPanel backgroundImageDesPanel = new JPanel();
        
      
        
        // Label
        JLabel backgroundImageFileLabel = new JLabel("Filename: ");
        backgroundImageFileLabel.setPreferredSize(new Dimension(100, 20));
        backgroundImageFilePanel.add(backgroundImageFileLabel);
        
        // Button
        JButton backgroundImageButton = new JButton("Browse");
        // BROWSE BUTTON LISTENER
        backgroundImageButton.addActionListener(new OpenButtonListener());
        backgroundImageFilePanel.add(backgroundImageButton);
        backgroundImageButton.setPreferredSize(new Dimension(85, 20));
        
        
        // Label that will contain the filename of the image
        backgroundImageFileNameLabel = new JLabel("<choose>");
        backgroundImageFilePanel.add(backgroundImageFileNameLabel);
        backgroundImageFileNameLabel.setPreferredSize(new Dimension(265, 20));
       
        
        JLabel backgroundImageTitleLabel = new JLabel("Title: ");
        backgroundImageTitleLabel.setPreferredSize(new Dimension(100, 20));
        backgroundImageTitlePanel.add(backgroundImageTitleLabel);
        
        backgroundImageTitleField = new JTextField();
        backgroundImageTitleField.setPreferredSize(new Dimension(370, 20));
        backgroundImageTitlePanel.add(backgroundImageTitleField);
        
        JLabel backgroundImageDesLabel = new JLabel("Description: ");
        backgroundImageDesLabel.setPreferredSize(new Dimension(100, 20));
        backgroundImageDesPanel.add(backgroundImageDesLabel);
        
        backgroundImageDestxtField = new JTextField();
        backgroundImageDestxtField.setPreferredSize(new Dimension(370, 20));
        backgroundImageDesPanel.add(backgroundImageDestxtField);
        
        
        // output to frame window
        backgroundImagePanel.add(backgroundImageFilePanel, BorderLayout.NORTH);
        backgroundImagePanel.add(backgroundImageTitlePanel, BorderLayout.CENTER);
        backgroundImagePanel.add(backgroundImageDesPanel, BorderLayout.SOUTH);
       
        
        
      
        
        //--------------MEME PANEL--------------------------------------------------
        JPanel memeImagePanel = new JPanel(new BorderLayout());
        memeImagePanel.setBackground(Color.YELLOW);
        memeImagePanel.setBorder(BorderFactory.createTitledBorder("Meme Options"));
        
        JPanel memeCaptionPanel = new JPanel();
        JPanel verticalAllignPanel = new JPanel();
        
        
        
        JLabel memeCaptionLabel = new JLabel("Caption: ");
        memeCaptionLabel.setPreferredSize(new Dimension(100, 20));
        memeCaptionPanel.add(memeCaptionLabel);
        
        memeCaptionField = new JTextField();
        memeCaptionField.setPreferredSize(new Dimension(370, 20));
        memeCaptionPanel.add(memeCaptionField);
        
        JLabel vAllignLabel = new JLabel("Vertical Allign: ");
        vAllignLabel.setPreferredSize(new Dimension(100, 20));
        verticalAllignPanel.add(vAllignLabel);
        
        
        String[] vAlignOptions = {"top", "middle", "bottom"};
        verticalAllignCombox = new JComboBox<String>(vAlignOptions);
        verticalAllignCombox.setPreferredSize(new Dimension(370, 20));
        verticalAllignPanel.add(verticalAllignCombox);
        
        
     // output to frame window
        memeImagePanel.add(memeCaptionPanel, BorderLayout.NORTH);
        memeImagePanel.add(verticalAllignPanel, BorderLayout.CENTER);

        
        // ---------------------------BUTTONS! -----------------------------------------------------------
        
        
        JPanel buttonPanel = new JPanel(new BorderLayout());
     // Generate Meme button
        JPanel generateButtonPanel = new JPanel();
        JButton genButton = new JButton("Generate Meme");
        generateButtonPanel.add(genButton);
        genButton.setPreferredSize(new Dimension(200, 50));
        genButton.addActionListener(new GenMemeButtonListener());
     
        // Save Meme Button
        JPanel saveButtonPanel = new JPanel();
        JButton saveButton = new JButton("Save Meme");
        saveButtonPanel.add(saveButton);
        saveButton.setPreferredSize(new Dimension(200, 50));
        saveButton.addActionListener(new SaveButtonListener());
        
        // ADD BUTTONS TO buttonPanel
        buttonPanel.add(generateButtonPanel, BorderLayout.WEST);
        buttonPanel.add(saveButtonPanel, BorderLayout.CENTER);
        
        
        
        //----------------------------------------------------------- ADDING SUB PANNELS TO WINDOW (ORGAINZING PANNELS)--------------------------------------------------------------
        controlPanel.add(backgroundImagePanel, BorderLayout.NORTH);
        controlPanel.add(memeImagePanel, BorderLayout.CENTER);
        controlPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        
        
        // Add all the panels to the main display based on BorderLayout
        controlPanel.setPreferredSize(new Dimension(500,570));
        panelPane.add(controlPanel, BorderLayout.WEST);
        panelPane.add(memeViewPanel, BorderLayout.CENTER);

        // Add the panelPane to the contentPane of the Frame (Window)
        this.getContentPane().add(panelPane);

        // Set the preferred size and show the main application window
        this.setPreferredSize(new Dimension(1150, 570));
        this.pack();
        this.setVisible(true);
    }

	// --------------------------- BROWSE BUTTON LISTENER -----------------------------------
	private class OpenButtonListener implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent evt) {
			JFileChooser chooser2 = new JFileChooser();
			chooser2.setDialogTitle("Choose a Background Image");
			chooser2.setFileFilter(new FileNameExtensionFilter("JPEG Images", "jpg", "jpeg"));
			int returnVal = chooser2.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				backgroundImageFilename = chooser2.getSelectedFile().getAbsolutePath();
				backgroundImageFileNameLabel.setText(backgroundImageFilename);
			}

		}
	}

	// ---------------------------------------------- SAVE MEME BUTTON LISTENER ------------------------------------------------------------
	private class SaveButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent evt) {
			JFileChooser chooser2 = new JFileChooser();
			chooser2.setDialogTitle("Save Meme");
			chooser2.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));
			int returnVal = chooser2.showSaveDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String destinationFile = chooser2.getSelectedFile().getAbsolutePath();
				
				// save image as png
				try {
                    ImageIO.write(currentMeme.compileMeme(), "PNG", new File(destinationFile));
                    
                 // write image Error handling
                } catch (IOException saveError1) {
                    System.out.println("Save Error");
                    saveError1.printStackTrace();
                } catch (Exception saveError2) {
                    JFrame errorwindow = new JFrame("Save Error");
                    JOptionPane.showMessageDialog(errorwindow, "Error saving", "Error", JOptionPane.ERROR_MESSAGE);
                    saveError2.printStackTrace();
                } 

            }

        }
			
	}
	
	// ---------------------------------------------- GENERATE MEME BUTTON LISTENER ------------------------------------------------------------

    private class GenMemeButtonListener implements ActionListener {

        

		@Override
        public void actionPerformed(ActionEvent e) {
            
            
			// BackgroundImage 
            bImageTitle = backgroundImageTitleField.getText();
            if (bImageTitle == null) {
                bImageTitle = "";
            }
            bImageDescription = backgroundImageDestxtField.getText();
            if (bImageDescription == null) {
                bImageDescription = "";
            }
            BackgroundImage bImage1 = new BackgroundImage(backgroundImageFilename, bImageTitle, bImageDescription);
            
            // Meme
            memeCaption = memeCaptionField.getText();
            memeVerticalAlign = (String) verticalAllignCombox.getSelectedItem();
            
            if (memeCaption == null) {
                memeCaption = "";
            }
            
            currentMeme = new GraphicalMeme(bImage1, memeCaption, user);
            
            // MEME DISPLAY 
            try {
               
                currentMeme.setCaptionVerticalAlign(memeVerticalAlign);
                BufferedImage image = currentMeme.compileMeme();
                imageDisplayLabel.setIcon(new ImageIcon(image));
                memeViewPanel.repaint();
                
            // ---------------------CATCH ERRORS  ----------------------------------
            } catch (IOException genError1) {
                System.out.println("Error");
                genError1.printStackTrace();
            } catch (Exception genError2) {
                JFrame errorFrame = new JFrame(" generate meme Error");
                JOptionPane.showMessageDialog(errorFrame, "background image error", "Error", JOptionPane.ERROR_MESSAGE);
                genError2.printStackTrace();
            }   
        }     
    }
}


	

