package hust.soict.globalict.aims.screen.manager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{

	public AddDigitalVideoDiscToStoreScreen(Store store) {
		super(store);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showAddItemScreen() {
		JTextField lengthField = new JTextField(5);
        JTextField directorField = new JTextField(5); // Field for director
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(2, 2, 2, 2);

        panel.add(new JLabel("ID:"), gbc);
        panel.add(new JLabel("Title:"), gbc);
        panel.add(new JLabel("Category:"), gbc);
        panel.add(new JLabel("Cost:"), gbc);
        panel.add(new JLabel("Length:"), gbc); // Label for length
        panel.add(new JLabel("Director:"), gbc); // Label for director

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        panel.add(idField, gbc);
        panel.add(titleField, gbc);
        panel.add(categoryField, gbc);
        panel.add(costField, gbc);
        panel.add(lengthField, gbc); // Add length field to panel
        panel.add(directorField, gbc); // Add director field to panel
        
        int result = JOptionPane.showConfirmDialog(null, panel, 
                "Enter DVD Details", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            int id = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());
            int length = Integer.parseInt(lengthField.getText()); // Get length from field
            String director = directorField.getText(); // Get director from field
            
            DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, 
            		director, length, cost); // Create a DVD object
            store.addMedia(dvd); // Add DVD to the store
            
//            if (store != null) System.out.println(store.getItemsInStore().get(0).toString());
//            else System.out.println("no");
            
            // Logic to create a DVD object and add it to the store
        }
        
        JDialog dialog = new JDialog();
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem viewStoreItem = new JMenuItem("View Store");
        viewStoreItem.addActionListener(e -> {
        	showViewStoreScreen();
        	dialog.dispose();
        });
        menu.add(viewStoreItem);
        menuBar.add(menu);

        dialog.setJMenuBar(menuBar);
        
        JOptionPane optionPane = new JOptionPane(panel, JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION);

        dialog.setContentPane(optionPane);
        
        dialog.pack();
        dialog.setVisible(true);

        
        optionPane.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                String prop = e.getPropertyName();

                if (dialog.isVisible() 
                 && (e.getSource() == optionPane)
                 && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
                    //if you were going to check something
                	Object value = optionPane.getValue();
                    if (value instanceof Integer && JOptionPane.OK_OPTION == (Integer)value) {
                    	int id = Integer.parseInt(idField.getText());
        	            String title = titleField.getText();
        	            String category = categoryField.getText();
        	            float cost = Float.parseFloat(costField.getText());
        	            int length = Integer.parseInt(lengthField.getText()); // Get length from field
        	            String director = directorField.getText(); // Get director from field
        	            
        	            DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, 
        	            		director, length, cost); // Create a DVD object
        	            store.addMedia(dvd); // Add DVD to the store

                        dialog.dispose();
                    }
                }
            }
        });
		
	}

	@Override
	public void showViewStoreScreen() {
		// TODO Auto-generated method stub
		
	}
	
}
