import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton,subButton,mulButton,divButton;
    JButton decimalButton, equButton, delButton, clrButton;
    JPanel panel;
    JRadioButton on,off;
    ButtonGroup group;
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    ImageIcon icon = new ImageIcon("cal.png");
    Font myFont = new Font("DejaVu Sans Mono", Font.BOLD, 30);

    // Constructor

    Calculator(){
        //Frame 

        frame = new JFrame("Calculator");
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setResizable(false);

        //TextField
        textfield = new JTextField();
        textfield.setBounds(50, 20,300, 40);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        //RadioButton
        on = new JRadioButton("On");
        on.setBounds(20, 70, 70, 30);
        on.setFocusable(false);
        on.addActionListener(this);
        on.setBackground(Color.darkGray);
        on.setForeground(Color.WHITE);

        off = new JRadioButton("Off");
        off.setSelected(true);
        off.setFocusable(false);
        off.setBounds(10, 70, 70, 30);
        off.addActionListener(this);
        off.setBackground(Color.darkGray);
        off.setForeground(Color.WHITE);


        
        
        group = new ButtonGroup();
        group.add(on);
        group.add(off);
        


        //Buttons Functions 
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("\u00F7");
        decimalButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");

        //Added buttons to array so that we can interate
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;


        for (JButton but1 : functionButtons) {
            
            but1.addActionListener(this);
            but1.setFont(myFont);
            but1.setFocusable(false);
            but1.setBackground(Color.yellow);
            but1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        }
        
        for(int i = 0; i<10; i++){

            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setBackground(new Color(100,124,144));
            numberButton[i].setFont(myFont);
            numberButton[i].setBorder(BorderFactory.createRaisedBevelBorder());
            numberButton[i].setFocusable(false);

        }


        delButton.setBounds(50, 430, 145, 50);
        delButton.setBackground(Color.lightGray);
        clrButton.setBounds(205, 430, 145, 50);
        clrButton.setBackground(Color.lightGray);

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.setBounds(50, 60, 60,60);
        p.setBackground(Color.darkGray);
        p.setForeground(Color.darkGray);
        p.add(on);
        p.add(off);

        panel = new JPanel();
        panel.setBounds(50 , 120 , 300 , 300 );
        panel.setLayout(new GridLayout(4, 4,10,10));
        panel.setBackground(Color.gray);

        //Adding Numbers and Functions to Panel
        //!st ROW AND COLUMN
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(functionButtons[0]);
        
        //2nd ROW AND COLUMN
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(functionButtons[1]);

        //3rd ROW AND COLUMN
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(functionButtons[2]);

        //4th ROW AND COLUMN
        panel.add(functionButtons[4]);
        panel.add(numberButton[0]);
        panel.add(functionButtons[5]);
        panel.add(functionButtons[3]);

        
        
        

        

        frame.getContentPane().setBackground(Color.darkGray);
        frame.add(p);
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        // frame.add(on);
        // frame.add(off);
        
        disable();
        frame.setVisible(true); 

    }


    public static void main(String[] args) {
        Calculator c = new Calculator();
        
    }

    public void enable(){
        textfield.setEnabled(true);
        for(int i = 0; i<8;i++){
            functionButtons[i].setEnabled(true);
        }
        for(int i = 0; i<10; i++){
            numberButton[i].setEnabled(true);
        }
    }
    public void disable(){
        textfield.setEnabled(false);
        for(int i = 0; i<8;i++){
            functionButtons[i].setEnabled(false);
        }
        for(int i = 0; i<10; i++){
            numberButton[i].setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == on){
            enable();
        }

        if(e.getSource() == off){
            disable();
        }
        
        for(int i = 0; i<10; i++){
            if(e.getSource() == numberButton[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decimalButton){
            textfield.setText(textfield.getText().concat("."));
        }

        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }

        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }

        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = 'x';
            textfield.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        

        }
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textfield.getText());

            switch(operator){
                case '+' :
                    result = num1 + num2;
                    break;

                case '-' :
                    result = num1 - num2;
                    break;
                
                case 'x': 
                    result = num1*num2;
                    break;

                case '/' :
                if(num2 == 0){
                    textfield.setText("Error");
                    return;
                }
                result = num1/num2;
                break;


            }

            textfield.setText(String.valueOf(result));
            num1 = result; // this will update num1
            num2 = 0;
            operator = ' ';
            return;
            
        }
        if(e.getSource() == clrButton){
                textfield.setText("");
            }
        if(e.getSource() == delButton){
            String string = textfield.getText();
            textfield.setText("");
                for(int i = 0; i<string.length() - 1; i++)
                {
                    textfield.setText(textfield.getText() + string.charAt(i));
                }
        }

    }
}
