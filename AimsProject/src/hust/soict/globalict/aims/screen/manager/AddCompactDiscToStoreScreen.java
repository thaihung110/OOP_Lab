package hust.soict.globalict.aims.screen.manager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import hust.soict.globalict.aims.disc.Track;
import hust.soict.globalict.aims.disc.CompactDisc.CompactDisc;
import hust.soict.globalict.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{

	public AddCompactDiscToStoreScreen(Store store) {
		super(store);
	}

	@Override
	public void showAddItemScreen() {
		JTextField artistField = new JTextField(5);
        JTextField directorField = new JTextField(5); // Field for director
        DefaultListModel<String> trackListModel = new DefaultListModel<>();
        JList<String> trackList = new JList<>(trackListModel);
        JTextField trackTitleField = new JTextField(5);
        JTextField trackLengthField = new JTextField(5);
        
        JButton addTrackButton = new JButton("Add Track");
        
        // Logic to add tracks to the list
        addTrackButton.addActionListener(e -> {
            String trackTitle = trackTitleField.getText();
            String trackLengthStr = trackLengthField.getText();
            if (!trackTitle.isEmpty() && !trackLengthStr.isEmpty()) {
                int trackLength = Integer.parseInt(trackLengthStr);
                trackListModel.addElement(trackTitle + " - " + trackLength + " mins");
                trackTitleField.setText("");
                trackLengthField.setText("");
            }
        });
        
        
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
        panel.add(new JLabel("Artist:"), gbc);
        panel.add(new JLabel("Director:"), gbc); // Label for director
        panel.add(new JLabel("Tracks:"), gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        panel.add(idField, gbc);
        panel.add(titleField, gbc);
        panel.add(categoryField, gbc);
        panel.add(costField, gbc);
        panel.add(artistField, gbc);
        panel.add(directorField, gbc); // Add director field to panel
        panel.add(trackTitleField, gbc);
        panel.add(trackLengthField, gbc);
        panel.add(addTrackButton, gbc);
        panel.add(new JScrollPane(trackList), gbc);
        
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
        	            String artist = artistField.getText();
        	            String director = directorField.getText(); // Get director from field
        	            List<Track> tracks = new ArrayList<>();
        	            for (int i = 0; i < trackListModel.size(); i++) {
        	                String[] trackInfo = trackListModel.get(i).split(" - ");
        	                tracks.add(new Track(trackInfo[0], Integer.parseInt(trackInfo[1].replace(" mins", ""))));
        	            }
        	            
        	            CompactDisc cd = new CompactDisc(title, category, director, cost, artist, tracks); 
        	            store.addMedia(cd);

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
