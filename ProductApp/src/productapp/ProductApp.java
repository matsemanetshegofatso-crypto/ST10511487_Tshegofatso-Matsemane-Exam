/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productapp;

import java.awt.GridLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Student
 */
public class ProductApp extends JFrame{
    // The mattress products available in the combo box
    private static final String[] PRODUCTS = {
        "Cozy Nights Monarch",
        "Restonic Barbados",
        "Sealy Phuket"
    };

    // Name of the file the sale details are saved to
    private static final String FILE_NAME = "data.txt";

    // GUI components that are used in more than one method
    private final JTextField txtCustomerName = new JTextField();
    private final JComboBox<String> cmbProduct = new JComboBox<>(PRODUCTS);
    private final JTextField txtPrice = new JTextField();

    /**
     * Constructor: builds the form, the menu and the button
     */
    public ProductApp() {
        setTitle("Product App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createMenu();
        createForm();

        pack();                      // size the window to fit the components
        setLocationRelativeTo(null); // centre the window on the screen
    }

    /**
     * Builds the menu bar: File > Exit and Tools > Process / Clear
     */
    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));   // close the application
        fileMenu.add(exitItem);

        // Tools menu
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        processItem.addActionListener(e -> processSale());  // same logic as the button
        clearItem.addActionListener(e -> clearForm());
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    /**
     * Builds the form: labels, text boxes, combo box and the Process button
     */
    private void createForm() {
        // 4 rows x 2 columns with a 10 pixel gap between components
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnProcess = new JButton("PROCESS");
        btnProcess.addActionListener(e -> processSale());

        panel.add(new JLabel("Customer Name:"));
        panel.add(txtCustomerName);
        panel.add(new JLabel("Select Product:"));
        panel.add(cmbProduct);
        panel.add(new JLabel("Enter Price:"));
        panel.add(txtPrice);
        panel.add(new JLabel(""));   // empty cell so the button sits under the text boxes
        panel.add(btnProcess);

        add(panel);
    }

    /**
     * Process logic (used by the PROCESS button AND the Tools > Process menu item).
     * Captures the input, validates it, calculates the amounts,
     * shows them in a message box and saves them to data.txt.
     */
    private void processSale() {
        // 1. Capture the input
        String customerName = txtCustomerName.getText().trim();
        String product = (String) cmbProduct.getSelectedItem();

        // 2. Validate the customer name
        if (customerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the customer name.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Validate the price (must be a positive number)
        double price;
        try {
            price = Double.parseDouble(txtPrice.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for the price.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (price <= 0) {
            JOptionPane.showMessageDialog(this, "The price must be greater than zero.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 4. Calculate the amounts (declared as the interface type)
        IProductCalculations calc = new ProductCalculations(price);
        double vat = calc.GetVat();
        double commission = calc.GetCommission();
        double total = calc.GetTotal();

        // 5. Show the results in a message box
        String message = "Customer Name: " + customerName + "\n"
                + "Product: " + product + "\n"
                + "VAT: R " + vat + "\n"
                + "COMMISSION: R " + commission + "\n"
                + "TOTAL: R " + total;
        JOptionPane.showMessageDialog(this, message);

        // 6. Save the details to data.txt
        saveToFile(customerName, product, vat, commission, total);
    }

    /**
     * Saves the sale details to data.txt.
     * The file is opened in append mode (true) so earlier sales are not overwritten.
     */
    private void saveToFile(String customerName, String product,
                            double vat, double commission, double total) {
        // try-with-resources closes the file automatically
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            writer.println("DATA LOG");
            writer.println("*********************************");
            writer.println("Customer Name: " + customerName);
            writer.println("Product: " + product);
            writer.println("VAT: R " + vat);
            writer.println("COMMISSION: R " + commission);
            writer.println("TOTAL: R " + total);
            writer.println("*********************************");
            writer.println();   // blank line between records
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save to " + FILE_NAME,
                    "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Clears the text boxes and resets the combo box to the first item
     */
    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    /**
     * Main method: starts the application
     */
    public static void main(String[] args) {
        // Swing components should be created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}
