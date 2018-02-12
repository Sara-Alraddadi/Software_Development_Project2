package asgn2GUIs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

/**
 * This class is the graphical user interface for the rest of the system.
 * Currently it is a ‘dummy’ class which extends JFrame and implements Runnable
 * and ActionLister. It should contain an instance of an
 * asgn2Restaurant.PizzaRestaurant object which you can use to interact with the
 * rest of the system. You may choose to implement this class as you like,
 * including changing its class signature – as long as it maintains its core
 * responsibility of acting as a GUI for the rest of the system. You can also
 * use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Sara Alraddadi/N8779333
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {

	private PizzaRestaurant restaurant;

	private JButton btnBrowse = new JButton("Browse..");
	private JButton btnReset = new JButton("Reset");

	private JTextField txtPathLog = new JTextField(20);

	private Object columnNamesCustomer[] = { "Customer Name", "Mobile Number", "Customer Type", "Location X",
			"Location Y", "Distance from Restaurant" };
	// private TableModel tableModel =
	private JTable tableCustomer = new JTable(new DefaultTableModel(columnNamesCustomer, 0));
	private JScrollPane scrollPanelCustomer = null;

	private Object columnNamesPizza[] = { "Pizza Type", "Quantity", "Order Price", "Order Cost", "Order Profit" };
	private JTable tablePizza = new JTable(new DefaultTableModel(columnNamesPizza, 0));
	private JScrollPane scrollPanelPizza = null;

	private JLabel lbNumberCustomer = new JLabel("0");
	private JLabel lbNumberPizzaOrder = new JLabel("0");
	private JLabel lbTotalDeliveryDistance = new JLabel("0");
	private JLabel lbTotalProfit = new JLabel("0");

	/**
	 * Creates a new Pizza GUI with the specified title
	 * 
	 * @param title
	 *            - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		setTitle(title);
	}

	@Override
	public void run() {

		// init variables
		setSize(900, 500);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		restaurant = new PizzaRestaurant();

		restaurant = new PizzaRestaurant();
		btnBrowse.setActionCommand("Browse");
		btnReset.setActionCommand("Reset");
		btnBrowse.addActionListener(this);
		btnReset.addActionListener(this);

		JPanel panelButton = new JPanel();
		panelButton.add(btnBrowse);
		panelButton.add(btnReset);

		txtPathLog.setEditable(false);
		// north
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new BorderLayout());
		panelNorth.add(panelButton, BorderLayout.EAST);
		panelNorth.add(txtPathLog, BorderLayout.CENTER);

		// east
		JPanel panelEast = new JPanel();
		JPanel panelIinfo = new JPanel();
		panelIinfo.setLayout(new GridLayout(4, 2));

		panelIinfo.add(new JLabel("Number Pizza Orders       "));
		panelIinfo.add(lbNumberPizzaOrder);
		panelIinfo.add(new JLabel("Number Customer Orders    "));
		panelIinfo.add(lbNumberCustomer);
		panelIinfo.add(new JLabel("Total Delivery Distance   "));
		panelIinfo.add(lbTotalDeliveryDistance);
		panelIinfo.add(new JLabel("Total Profit              "));
		panelIinfo.add(lbTotalProfit);
		panelEast.add(panelIinfo);

		// center
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(2, 1));

		// panel customer
		JPanel panelCustomer = new JPanel();
		panelCustomer.setLayout(new BorderLayout());
		panelCustomer.setBorder(new TitledBorder("Customers"));
		tableCustomer.setFillsViewportHeight(true);
		scrollPanelCustomer = new JScrollPane(tableCustomer);

		panelCustomer.add(scrollPanelCustomer, BorderLayout.CENTER);

		// panel pizza
		JPanel panelPizza = new JPanel();
		panelPizza.setLayout(new BorderLayout());
		panelPizza.setBorder(new TitledBorder("Pizzas"));
		scrollPanelPizza = new JScrollPane(tablePizza);

		panelPizza.add(scrollPanelPizza, BorderLayout.CENTER);

		//
		panelCenter.add(panelCustomer);
		panelCenter.add(panelPizza);

		// add panels to main panel
		add(panelEast, BorderLayout.EAST);
		add(panelNorth, BorderLayout.NORTH);
		add(panelCenter, BorderLayout.CENTER);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Browse")) {
			JFileChooser fc = new JFileChooser(".");
			int returnVal = fc.showDialog(this, "Open file");

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					boolean issuccess = restaurant.processLog(fc.getSelectedFile().getPath());
					txtPathLog.setText(fc.getSelectedFile().getPath());
					if (issuccess) {
						int numberCustomer = restaurant.getNumCustomerOrders();
						//
						DefaultTableModel tableCutomerModel = (DefaultTableModel) tableCustomer.getModel();
						tableCutomerModel.setRowCount(0);
						// "Customer Name", "Mobile Number", "Customer Type",
						// "Location X",
						// "Location Y", "Distance from Restaurant"
						for (int i = 0; i < numberCustomer; i++) {
							Customer c = restaurant.getCustomerByIndex(i);
							Object[] row = { c.getName(), c.getMobileNumber(), c.getCustomerType(), c.getLocationX(),
									c.getLocationY(), c.getDeliveryDistance() };
							tableCutomerModel.addRow(row);
						}
						tableCutomerModel.fireTableDataChanged();

						// "Pizza Type", "Quantity", "Order Price", "Order
						// Cost", "Order Profit"

						DefaultTableModel tablePizzaModel = (DefaultTableModel) tablePizza.getModel();
						tablePizzaModel.setRowCount(0);
						int numberPizza = restaurant.getNumPizzaOrders();

						for (int i = 0; i < numberPizza; i++) {
							Pizza p = restaurant.getPizzaByIndex(i);
							p.calculateCostPerPizza();
							Object[] row = { p.getPizzaType(), p.getQuantity(), p.getOrderPrice(), p.getOrderCost(),
									p.getOrderProfit() };

							tablePizzaModel.addRow(row);
						}
						tablePizzaModel.fireTableDataChanged();
						//

						lbNumberCustomer.setText(String.valueOf(numberCustomer));
						lbNumberPizzaOrder.setText(String.valueOf(numberPizza));
						lbTotalDeliveryDistance.setText(String.valueOf(restaurant.getTotalDeliveryDistance()));
						lbTotalProfit.setText(String.valueOf(restaurant.getTotalProfit()));
						JOptionPane.showMessageDialog(null,
								"loaded successfully data from file '" + fc.getSelectedFile().getPath() + "'", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, fc.getSelectedFile().getPath() + " invalid.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (CustomerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (PizzaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (LogHandlerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				// This is where a real application would open the file.
				// log.append("Opening: " + file.getName() + "." + newline);
			} else {
				// log.append("Open command cancelled by user." + newline);
			}
		} else if (e.getActionCommand().equals("Reset")) {
			DefaultTableModel tableCutomerModel = (DefaultTableModel) tableCustomer.getModel();
			tableCutomerModel.setRowCount(0);
			tableCutomerModel.fireTableDataChanged();

			DefaultTableModel tablePizzaModel = (DefaultTableModel) tablePizza.getModel();
			tablePizzaModel.setRowCount(0);
			tablePizzaModel.fireTableDataChanged();

			txtPathLog.setText("");
			lbNumberCustomer.setText(String.valueOf(0));
			lbNumberPizzaOrder.setText(String.valueOf(0));
			lbTotalDeliveryDistance.setText(String.valueOf(0));
			lbTotalProfit.setText(String.valueOf(0));
			JOptionPane.showMessageDialog(null, "Reset successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

		}

	}

}
