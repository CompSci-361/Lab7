package editor;
import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
 
// An AWT program inherits from the top-level container java.awt.Frame
public class ClientWindow extends JFrame implements ActionListener {
   private JLabel lblWindow;    // Declare a Label component
   private JLabel lblFirstName;
   private JLabel lblLastName;
   private JLabel lblDepartment;
   private JLabel lblPhone;
   private JLabel lblGender;	
   private JLabel lblTitle;
   private JTextField JfirstName; // Declare a TextField component 
   private JTextField JlastName;
   private JTextField Jdepartment;
   private JTextField Jphone;
   private JRadioButton Jgender;	
   private JComboBox Jtitle;
   private JButton btnCount;   // Declare a Button component
   private String firstName;
   private String lastName;
   private String department;
   private String phone;
   private char gender;
   private int title; 
   // Constructor to setup GUI components and event handlers
   public ClientWindow () {
      setLayout(new FlowLayout());
         // "super" Frame, which is a Container, sets its layout to FlowLayout to arrange
         // the components from left-to-right, and flow to next row from top-to-bottom.
 
      lblWindow = new JLabel("Enter your information");  // construct the Label component
      add(lblWindow);                    // "super" Frame container adds Label component
      lblWindow.setAlignmentX(TOP_ALIGNMENT);
      
      lblFirstName = new JLabel("First Name");
      add(lblFirstName);
 
      JfirstName = new JTextField("0", 10); // construct the TextField component
      JfirstName.setEditable(true);       // set to read-only
      add(JfirstName);                     // "super" Frame container adds TextField component
 
      
      //btnCount = new Button("Count");   // construct the Button component
      //add(btnCount);                    // "super" Frame container adds Button component
 
      //btnCount.addActionListener(this);
         // "btnCount" is the source object that fires an ActionEvent when clicked.
         // The source add "this" instance as an ActionEvent listener, which provides
         //   an ActionEvent handler called actionPerformed().
         // Clicking "btnCount" invokes actionPerformed().
 
      setTitle("Employee Information");  // "super" Frame sets its title
      setSize(400, 400);        // "super" Frame sets its initial window size
 
      // For inspecting the Container/Components objects
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
 
      setVisible(true);         // "super" Frame shows
 
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
   }
 
   // The entry main() method
   public static void main(String[] args) {
      // Invoke the constructor to setup the GUI, by allocating an instance
      ClientWindow app = new ClientWindow();
         // or simply "new AWTCounter();" for an anonymous instance
   }
 
   // ActionEvent handler - Called back upon button-click.
   @Override
   public void actionPerformed(ActionEvent evt) {
      //++count; // Increase the counter value
      // Display the counter value on the TextField tfCount
      //tfCount.setText(count + ""); // Convert int to String
   }
}