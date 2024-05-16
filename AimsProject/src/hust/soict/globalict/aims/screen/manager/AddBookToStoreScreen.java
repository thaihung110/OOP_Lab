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

import hust.soict.globalict.aims.book.Book;
import hust.soict.globalict.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store);
    }

    @Override
    public void showAddItemScreen() {
        DefaultListModel<String> authorListModel = new DefaultListModel<>();
        JList<String> authorList = new JList<>(authorListModel);
        JTextField authorField = new JTextField(5);

        JButton addAuthorButton = new JButton("Add Author");
        addAuthorButton.addActionListener(e -> {
            String authorName = authorField.getText();
            if (!authorName.isEmpty()) {
                authorListModel.addElement(authorName);
                authorField.setText("");
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
        panel.add(new JLabel("Authors:"), gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        panel.add(idField, gbc);
        panel.add(titleField, gbc);
        panel.add(categoryField, gbc);
        panel.add(costField, gbc);
        panel.add(authorField, gbc);
        panel.add(addAuthorButton, gbc);
        panel.add(new JScrollPane(authorList), gbc);

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
                    Object value = optionPane.getValue();
                    if (value instanceof Integer && JOptionPane.OK_OPTION == (Integer)value) {
                        int id = Integer.parseInt(idField.getText());
                        String title = titleField.getText();
                        String category = categoryField.getText();
                        float cost = Float.parseFloat(costField.getText());
                        List<String> authors = new ArrayList<String>();
                        for (int i = 0; i < authorListModel.size(); i++) {
                            authors.add(authorListModel.get(i));
                        }

                        Book book = new Book(id, title, category, cost, authors);
                        store.addMedia(book);

                        dialog.dispose();
                    }
                }
            }
        });
    }

	public void showViewStoreScreen() {
		// TODO Auto-generated method stub
		
	}
}