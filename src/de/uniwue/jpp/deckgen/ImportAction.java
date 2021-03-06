package de.uniwue.jpp.deckgen;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImportAction extends AbstractAction {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel frame;
    JFileChooser chooser;
    File file;
    Dominion dominion;
    boolean cardImport;
    
    ImportAction(JPanel frame, Dominion dominion, boolean cardImport) {
    	super("Import...");
        
        this.chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "XML Files", "xml", "xsd");
        chooser.setFileFilter(filter);
        this.dominion=dominion;
        this.frame = frame;
        this.cardImport=cardImport;
    }

    public void actionPerformed(ActionEvent evt) {
    	System.out.println("CardImport: " + cardImport);
        int returnVal = chooser.showOpenDialog(frame);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
           System.out.println("You chose to open this file: " +
                chooser.getSelectedFile().getName());
           	file = chooser.getSelectedFile();
        }
        try {
        	InputStream in = parseXMLFromFile(file);
			System.out.println("InputStream: " + in.available());
			
			if(cardImport){
				dominion.importCards(in);
				}
			else{
				dominion.importDecks(in);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }	

	private InputStream parseXMLFromFile(File tempFile) {
		
		InputStream tempIn=null;
		try {
			tempIn = new FileInputStream(tempFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempIn;
		
	}
    
};