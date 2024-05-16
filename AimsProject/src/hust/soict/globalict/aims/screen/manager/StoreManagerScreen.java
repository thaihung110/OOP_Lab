package hust.soict.globalict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import hust.soict.globalict.aims.book.Book;
import hust.soict.globalict.aims.disc.Playable;
import hust.soict.globalict.aims.disc.Track;
import hust.soict.globalict.aims.disc.CompactDisc.CompactDisc;
import hust.soict.globalict.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Media;
import hust.soict.globalict.aims.store.Store;


public class StoreManagerScreen extends JFrame{
	private static Store store = new Store();
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		
		JMenuItem viewStoreItem = new JMenuItem("View store");
		viewStoreItem.addActionListener(e -> showViewStoreScreen());
        menu.add(viewStoreItem);
		
		JMenu smUpdateStore = new JMenu("Update Store");
		
		AddBookToStoreScreen addBookScreen = new AddBookToStoreScreen(store);
		JMenuItem addBookItem = new JMenuItem("Add Book");
		addBookItem.addActionListener(e -> addBookScreen.showAddItemScreen());
        smUpdateStore.add(addBookItem);
		
        AddCompactDiscToStoreScreen addCDScreen = new AddCompactDiscToStoreScreen(store);
        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> addCDScreen.showAddItemScreen());
        smUpdateStore.add(addCDItem);
        
        
        AddDigitalVideoDiscToStoreScreen addDVDScreen = new AddDigitalVideoDiscToStoreScreen(store);
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> addDVDScreen.showAddItemScreen());
        smUpdateStore.add(addDVDItem);
        
		menu.add(smUpdateStore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	private void showViewStoreScreen() {
        // Logic to display the View Store Screen
		// Remove the current panel
	    getContentPane().removeAll();
	    getContentPane().repaint();

	    // Add the header and center panels
	    Container cp = getContentPane();
	    cp.setLayout(new BorderLayout());
	    cp.add(createNorth(), BorderLayout.NORTH);
	    cp.add(createCenter(), BorderLayout.CENTER);

	    // Refresh the JFrame
	    revalidate();
	    repaint();
		
    }
	
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	private JPanel createCenter() {
		
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        
        if (mediaInStore.size() < 9) {
        	for (Media media : mediaInStore) {
        		MediaStore cell = new MediaStore(media);
        		center.add(cell);
        	}
        }
        
        else {
        	for (int i = 0; i < 9; i++) {
        		MediaStore cell = new MediaStore(mediaInStore.get(i));
        		center.add(cell);
        	}
        }
        
        return center;
    }
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
        new StoreManagerScreen(store);
	}
	
}
