package FrameSys;
import AI.Artificial_Intelligence;
import AI.Core;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//    public static void main(String[] args){
//


public class FrameSysCore {
    private static int width = 1090;
    private static int height = 750;

    private static int TextY = 35;
    private static int spaceY = 40;
    //^

    static private int buttonsCount = 2;
    private static JFrame myFrame = new JFrame("AWS PoC");
    private static JPanel panel = new JPanel();

    private static JButton allButtons[] = new JButton[buttonsCount];
    public static JButton connect = new JButton();

    static private JTextField portInput = new JTextField();
    static private JTextField serverIpInput = new JTextField();

    static private JTextField profileNameInput = new JTextField();
    static private JTextField passwordInput = new JTextField();

    //all button's config
    //CONNECT
    private static int buttonCONNECT_x = 280;
    private static int buttonCONNECT_y = TextY + spaceY*2 + 10;
    private static int buttonCONNECT_width = 100;
    private static int buttonCONNECT_height = 25;

    //OUTPUT parameters
    private static TextArea output = new TextArea();
    private static JScrollPane sp = new JScrollPane(output);
    //^

    public static void createFrame() {
        Border etched = BorderFactory.createEtchedBorder();
        initButtons();

/////////CONNECTION
        JLabel connection = new JLabel();
        connection.setBorder(BorderFactory.createTitledBorder(etched, "Connection"));
        connection.setBounds(10, 10, 550, 180);

        JLabel serverPort = new JLabel("Server port");
        serverPort.setBounds(20, TextY, 100, 40);
        //ID.setFont(new Font(input.getFont().getName(), Font.PLAIN, 30));
        portInput.setBounds(120, TextY + 10, 130, 25);
        portInput.setText("4020");

        JLabel serverIp = new JLabel("Server Ip");
        serverIp.setBounds(20, TextY + spaceY, 100, 40);

        serverIpInput.setText("localhost");
        serverIpInput.setBorder(BorderFactory.createTitledBorder(etched, ""));
        serverIpInput.setBounds(120, TextY + spaceY + 10, 400, 25);

        JLabel profileName = new JLabel("Profile name");
        profileName.setBounds(20, TextY + spaceY*2, 100, 40);
        //ID.setFont(new Font(input.getFont().getName(), Font.PLAIN, 30));
        profileNameInput.setBounds(120, TextY + spaceY*2 + 10, 130, 25);
        profileNameInput.setText("default");


        JLabel password = new JLabel("Password");
        password.setBounds(20, TextY + spaceY*2 + 40, 160, 25);

        panel.add(portInput);
        panel.add(serverPort);
        panel.add(serverIp);
        panel.add(serverIpInput);
        panel.add(profileNameInput);
        panel.add(profileName);
        panel.add(passwordInput);
        panel.add(password);
/////////CONNECTION^



////////OUTPUT
        output.setEditable(false);
        output.setBackground(new Color(255,255,255));
        sp.setBounds(600, 40, 520, 650);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        //sp.setAutoscrolls(true);

//		sp.getVerticalScrollBar().addAdjustmentListener(
//	            e -> {
//	                if ((verticalScrollBarMaximumValue - e.getAdjustable().getMaximum()) == 0)
//	                    return;
//	                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
//
//	            });
        //sp.setPreferredSize(new Dimension(80,100));

        JLabel T4 = new JLabel("Output");
        T4.setBounds(600, 20, 100, 15);

        JButton clearOutput = new JButton("Clear");
        clearOutput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputClear();
            }
        } );
        clearOutput.setBounds(640, 14, 80, 25);

        panel.add(sp);
        panel.add(clearOutput);
        panel.add(T4);

////////OUTPUT^




////////RESOURSES
        JLabel resourses = new JLabel();
        resourses.setBorder(BorderFactory.createTitledBorder(etched, "Resourses"));
        resourses.setBounds(10, 200, 550, 490);
        panel.add(resourses);
////////RESOURSES^

        panel.setLayout(null);

        panel.add(connection);
        //panel.add(T1);
        //panel.add(T2);
        //panel.add(T3);





        //contentPane.setBorder ( new TitledBorder( new EtchedBorder(), "!@$!@$@!$!@$!@$" ) );


        myFrame.setContentPane(panel);
        myFrame.pack();
        myFrame.setVisible(true);
        myFrame.setBounds(340, 100, width, height);
        myFrame.setResizable(false);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static void initButtons() {
        ActionListener actionListener = new TestActionListener();

        for (int i = 0; i < buttonsCount; i++) {
            allButtons[i] = new JButton();
        }

        connect.setBounds(buttonCONNECT_x, buttonCONNECT_y, buttonCONNECT_width, buttonCONNECT_height);
        connect.setText("Connect");
        connect.setActionCommand("connect");
        connect.addActionListener(actionListener);
        allButtons[0] = connect;

        panel.add(connect);
    }

    public static class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            if (Core.stage != Core.standBy) {
                Artificial_Intelligence.analyzeAction(action);
            }
        }
    }

    public static void addText(String text) {
        //String was = Frame.output.getText();
        output.append(text);
//    	Frame.output.setCaretPosition(0, Frame.output.getCaretPosition());
//    	Frame.output.setCaretPosition();
//    	int selectionStart = Frame.output.getSelectionStart();
//    	System.out.println(selectionStart);
//        int selectionEnd = Frame.output.getSelectionEnd();
//        System.out.println(selectionEnd);
//    	//Frame.output.setCaretPosition(selectionEnd);
//    	Frame.output.setCaretPosition(selectionStart);
        output.setCaretPosition(0);
        output.append("\n");

//    	DefaultCaret caret = (DefaultCaret)output.getCaret();
//    	caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    public static void outputClear() {
        output.setText("");
    }

    public static void setCursor(String kind){
        switch (kind){
            case "WAIT": panel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            case "NORMAL": panel.setCursor(Cursor.getDefaultCursor());
        }

    }






    public static int getPort(){
        try {
            return Integer.parseInt(portInput.getText());
        } catch (Exception e){
            System.out.println("OMG, you wrote a very strange port: " + e.getMessage());
        }
        return -1;
    }

    public static String getServerIp(){
        try {
            return serverIpInput.getText();
        } catch (Exception e){
            System.out.println("OMG, you wrote a very strange IP address: " + e.getMessage());
        }
        return "Error";
    }


}



