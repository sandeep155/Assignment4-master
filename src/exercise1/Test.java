package exercise1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;


//creating the main frame, and stick the other panels inside
/**
 *
 * @author hp
 */
public class Test implements ActionListener,ItemListener{
    JPanel panelTop,panelBot;
    ListModel<String> model;
    static  JList<String> courseList;
    static JRadioButton  radioCS,radioBus;
    static  JComboBox<String> comboBox;
    JButton submitBtn;
    static JTextArea txtArea;
    static JCheckBox checkSC,checkVW;
    static JTextField nameField,addrField,provField,cityField,postField,phoneField,emailField;
    static  ButtonGroup btngrp ;
    static JScrollPane scrpn;
    String selectLanguage;
    public Test(String app) {
        JFrame frame = new JFrame("Student Information");
        String language[]={"Python","Java","C#"};
        BoxLayout bl = new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(bl);
        frame.setSize(800, 800);
        comboBox =new JComboBox<>(language);
        txtArea=new JTextArea();
        // Set a size to the the JTextArea
        txtArea.setPreferredSize(new Dimension(900, 100));
        frame.setPreferredSize(new Dimension(1000,700));
        panelTop = new JPanel();
        panelBot = new JPanel();
        panelTop.add(gridLayout(),  "Left to right");
        panelTop.add(midLayout(), "Left to right");
        panelTop.add(comboLaout(), "Left to right");
        submitBtn = new JButton("Submit");
        panelBot.add(submitBtn);
        panelBot.add(new JScrollPane(txtArea));
        model = new DefaultListModel<String>();
        courseList =  new JList<>(model);

        radioCS.addActionListener(this);
        radioBus.addActionListener(this);
        courseList.setSize(500,500);
        courseList.setPreferredSize(new Dimension(200,200));


        frame.add(panelTop);
        frame.add(panelBot);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        submitBtn.addActionListener(this);
        comboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem() != null) {
                    selectLanguage=comboBox.getSelectedItem().toString();
                }

            }
        });
    }
    //grid layout panel for label and textboxes section
    public static JPanel gridLayout() {
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.setSize(500, 500);
        panel.setPreferredSize(new Dimension(400, 400));
        Label labelArr[] = new Label[] { new Label("Name: "), new Label("Address: "), new Label("Province: "),
                new Label("City: "), new Label("Postal Code: "), new Label("Phone Number: "), new Label("Email: ") };
        nameField = new JTextField();
        addrField = new JTextField();
        provField = new JTextField();
        cityField = new JTextField();
        postField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();

        JTextField txtArr[] = new JTextField[] { nameField, addrField, provField, cityField, postField, phoneField,
                emailField };
        for (int i = 0; i < txtArr.length; i++) {
            panel.add(labelArr[i]);
            panel.add(txtArr[i]);
        }
        return panel;
    }
    public static JPanel comboLaout() {

        JPanel pane = new JPanel();

        pane.setLayout(new GridLayout(3,1));
        scrpn = new JScrollPane(courseList);
        radioCS = new JRadioButton("Computer Science");
        radioBus = new JRadioButton("Business");
        radioCS.setSelected(true);
        btngrp = new ButtonGroup();

        JPanel topPane = new JPanel();
        topPane.setLayout(new GridLayout(0, 2));
        JPanel innerPane = new JPanel();
        innerPane.setLayout(new GridLayout(2, 0));
        btngrp.add(radioCS);
        btngrp.add(radioBus);
        topPane.add(radioCS);
        topPane.add(radioBus);
        innerPane.add(comboBox);

        innerPane.add(scrpn);
        pane.add(topPane);
        pane.add(innerPane);
        return pane;
    }
    public static JPanel midLayout() {

        JPanel panel = new JPanel(new FlowLayout());
        checkSC = new JCheckBox("Student Council");
        checkVW = new JCheckBox("Volunteer Work");
        panel.add(checkSC);
        panel.add(checkVW);
        return panel;
    }
    public static JPanel botLayout()
    {
        JPanel panel = new JPanel(new FlowLayout());
        // Add your txtArea inside a JScrollPane.
        panel.add(new JScrollPane(txtArea));
        return panel;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String name = nameField.getText();
        String addr = addrField.getText();
        String prov = provField.getText();
        String post = postField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();

        boolean isCS = radioCS.isSelected(); // If false then Business.
        boolean isCouncil = checkSC.isSelected();
        boolean isVolunteer = checkVW.isSelected();

        ArrayList<String> courses = new ArrayList<String>();
        for(int i=0; i<courseList.getModel().getSize(); i++) {
            courses.add(courseList.getModel().getElementAt(i));
        }

        txtArea.setText(name + ", " + addr + ", " + prov + "," + post+","+ phone + "," + email+"\n");
        txtArea.append((isCS ? "Computer Science" : "Business")+"\n "+(isCouncil ? "Student Council, " : "")+(isVolunteer ? "Volunteer Work" : "")+". "+courses+"\n");
        txtArea.append(selectLanguage);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args)
    {
        new Test( "Student Information");
    }
}
