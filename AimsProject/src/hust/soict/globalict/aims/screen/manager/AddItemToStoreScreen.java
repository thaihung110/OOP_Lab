package hust.soict.globalict.aims.screen.manager;

import javax.swing.*;

import hust.soict.globalict.aims.store.Store;


public abstract class AddItemToStoreScreen {
    protected JTextField idField;
    protected JTextField titleField;
    protected JTextField categoryField;
    protected JTextField costField;
    protected Store store;
    

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        idField = new JTextField(20);
        titleField = new JTextField(20);
        categoryField = new JTextField(20);
        costField = new JTextField(20);
        
    }

    public abstract void showAddItemScreen();
    
    public abstract void showViewStoreScreen();
}


