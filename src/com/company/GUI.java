package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    public JTextField textField;
    public JButton button0, button1, button2, button3, button4, button5, button6, button7,
           button8, button9, point_button, devide_button, multiply_button, minus_button,
           plus_button, equal_button, clear_button, delete_button;
    public int len;
    public double num1, num2, result;
    public char sign;

    GUI() {
        super("Calculator");
        setIconImage(new ImageIcon("icon.png").getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700,800);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,40,40));

        ActionListener l = new A();
        ActionListener a = new B();

        Dimension button_d = new Dimension(120,70);
        Font button_f = new Font("",Font.BOLD,40);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(650,70));
        textField.setFont(new Font("",Font.BOLD,50));
        panel.add(textField);

        button7 = new JButton("7");
        button7.setActionCommand("7");
        button7.setPreferredSize(button_d);
        button7.setFont(button_f);
        button7.addActionListener(l);
        panel.add(button7);

        button8 = new JButton("8");
        button8.setActionCommand("8");
        button8.setPreferredSize(button_d);
        button8.setFont(button_f);
        button8.addActionListener(l);
        panel.add(button8);

        button9 = new JButton("9");
        button9.setActionCommand("9");
        button9.setPreferredSize(button_d);
        button9.setFont(button_f);
        button9.addActionListener(l);
        panel.add(button9);

        devide_button = new JButton("/");
        devide_button.setPreferredSize(button_d);
        devide_button.setFont(button_f);
        devide_button.addActionListener(l);
        devide_button.addActionListener(a);
        panel.add(devide_button);

        button4 = new JButton("4");
        button4.setActionCommand("4");
        button4.setPreferredSize(button_d);
        button4.setFont(button_f);
        button4.addActionListener(l);
        panel.add(button4);

        button5 = new JButton("5");
        button5.setActionCommand("5");
        button5.setPreferredSize(button_d);
        button5.setFont(button_f);
        button5.addActionListener(l);
        panel.add(button5);

        button6 = new JButton("6");
        button6.setActionCommand("6");
        button6.setPreferredSize(button_d);
        button6.setFont(button_f);
        button6.addActionListener(l);
        panel.add(button6);

        multiply_button = new JButton("*");
        multiply_button.setPreferredSize(button_d);
        multiply_button.setFont(button_f);
        multiply_button.addActionListener(l);
        multiply_button.addActionListener(a);
        panel.add(multiply_button);

        button1 = new JButton("1");
        button1.setActionCommand("1");
        button1.setPreferredSize(button_d);
        button1.setFont(button_f);
        button1.addActionListener(l);
        panel.add(button1);

        button2 = new JButton("2");
        button2.setActionCommand("2");
        button2.setPreferredSize(button_d);
        button2.setFont(button_f);
        button2.addActionListener(l);
        panel.add(button2);

        button3 = new JButton("3");
        button3.setActionCommand("3");
        button3.setPreferredSize(button_d);
        button3.setFont(button_f);
        button3.addActionListener(l);
        panel.add(button3);

        minus_button = new JButton("-");
        minus_button.setPreferredSize(button_d);
        minus_button.setFont(button_f);
        minus_button.addActionListener(l);
        minus_button.addActionListener(a);
        panel.add(minus_button);

        point_button = new JButton(".");
        point_button.setActionCommand(".");
        point_button.setPreferredSize(button_d);
        point_button.setFont(button_f);
        point_button.addActionListener(l);
        panel.add(point_button);

        button0 = new JButton("0");
        button0.setActionCommand("0");
        button0.setPreferredSize(button_d);
        button0.setFont(button_f);
        button0.addActionListener(l);
        panel.add(button0);

        equal_button = new JButton("=");
        equal_button.setPreferredSize(button_d);
        equal_button.setFont(button_f);
        equal_button.addActionListener(e -> {
            num2 = Double.parseDouble(textField.getText().substring(len));
            sign = textField.getText().charAt(len-1);
            if (sign == '+') {
                result = num1 + num2;
            } else if (sign == '-') {
                result = num1 - num2;
            } else if (sign == '*') {
                result = num1 * num2;
            } else {
                result = num1 / num2;
            }
            textField.setText(String.valueOf(result));
        });
        panel.add(equal_button);

        plus_button = new JButton("+");
        plus_button.setPreferredSize(button_d);
        plus_button.setFont(button_f);
        plus_button.addActionListener(l);
        plus_button.addActionListener(a);
        panel.add(plus_button);

        clear_button = new JButton("Clear");
        clear_button.setPreferredSize(new Dimension(240,70));
        clear_button.setFont(button_f);
        clear_button.addActionListener(e -> textField.setText(""));
        panel.add(clear_button);

        delete_button = new JButton("Delete");
        delete_button.setPreferredSize(new Dimension(240,70));
        delete_button.setFont(button_f);
        delete_button.addActionListener(
                e -> textField.setText(textField.getText().substring(0, textField.getText().length() - 1)));
        panel.add(delete_button);

        setContentPane(panel);
    }
    public  class A implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            textField.setText(textField.getText() + e.getActionCommand());
    }
}

    public class B implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            num1 = Double.parseDouble(textField.getText());
            len = textField.getText().length()+1;
    }
}
}
