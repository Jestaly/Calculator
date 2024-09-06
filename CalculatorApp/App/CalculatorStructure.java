package CalculatorApp.App;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import CalculatorApp.Constants.CommonConstants;

public class CalculatorStructure {

    // private String updatedText;
    private int calFieldInt = 0;
    private int charCounter = 0;

    /**
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * CALLS OUT THE PANEL
     * 
     * 
     * 
     * 
     * 
     * 
     */
    public void calculatorPanel(JPanel calPanel) {
        calPanel.setLayout(null);
        calPanel.setBackground(new Color(30, 32, 30));
        calPanel.setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
    }

    /**
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * CALLS OUT THE TEXTFIELD
     * 
     * 
     * 
     * 
     * 
     * 
     */
    public void calculatorField(JTextField calField) {
        calField.setBounds(0, 0, CommonConstants.FIELD_SIZE[0], CommonConstants.FIELD_SIZE[1]);
        calField.setBorder(null);
        calField.setBackground(new Color(60, 61, 55));
        calField.setFont(new Font("Dialog", Font.PLAIN, 50));
        calField.setForeground(new Color(255, 248, 232));
        calField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        calField.setCaretColor(new Color(60, 61, 55));
        calField.setFocusable(false);
        calField.setBorder(
                BorderFactory.createCompoundBorder(calField.getBorder(),
                        BorderFactory.createEmptyBorder(6, 18, 6, 25)));
    }

    /**
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * CALLS OUT THE MAIN BUTTONS
     * 
     * 
     * 
     * 
     * 
     * 
     */
    public void mainCalculatorButtons(JTextField calField, String[] mainButtonName, int xValue, int yValue,
            JButton mainButton) {

        mainButton.setBackground(new Color(225, 215, 183));
        mainButton.setBounds(xValue - CommonConstants.H_AND_V_VALUE, yValue - CommonConstants.GAP,
                CommonConstants.BUTTON_SIZE[0],
                CommonConstants.BUTTON_SIZE[0]);
        mainButton.setFont(new Font("Dialog", Font.PLAIN, CommonConstants.BUTTON_FONT_SIZE));
        mainButton.setBorder(null);
        mainButton.setFocusable(false);

        // MAIN BUTTON ACTIONLISTENER PROPERTIES

        mainButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    charCounter++;
                    calField.setText(String.join("", calField.getText(), mainButton.getText()));
                    calFieldInt = Integer.parseInt(calField.getText());

                } catch (Exception f) {

                    calField.setText(String.join("", Integer.toString(calFieldInt), ""));
                    charCounter = Integer.toString(calFieldInt).length();

                }

            }
        });

        // MAIN BUTTON MOUSELISTENER PROPERTIES
        mainButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (mainButton.getText().equals("C")) {

                    if (calField.getText().length() != 1 && Integer.toString(calFieldInt).length() != 1) {
                        charCounter--;
                        calField.setText(calField.getText()
                                .replace(Character.toString(calField.getText().charAt(charCounter)), ""));
                        calFieldInt = Integer.parseInt(calField.getText());
                    } else {
                        charCounter--;
                        calField.setText("");
                        calFieldInt = 0;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mainButton.setBackground(new Color(255, 248, 232));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                mainButton.setBackground(new Color(247, 238, 211));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainButton.setBackground(new Color(225, 215, 183));
            }

        });

    }

    /**
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * CALLS OUT THE CLEAR ALL BUTTON
     * 
     * 
     * 
     * 
     * 
     * 
     */
    public void clearCalculatorButton(JButton clearAllButton, JTextField calField) {

        clearAllButton.setBackground(new Color(225, 215, 183));
        clearAllButton.setBorder(null);
        clearAllButton.setFocusable(false);
        clearAllButton.setFont(new Font("Dialog", Font.PLAIN, CommonConstants.BUTTON_FONT_SIZE));
        clearAllButton.setBounds(315, 100, CommonConstants.BUTTON_SIZE[0], CommonConstants.BUTTON_SIZE[0]);

        clearAllButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                calField.setText("");
                charCounter = 0;

            }

        });
        clearAllButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                clearAllButton.setBackground(new Color(255, 248, 232));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                clearAllButton.setBackground(new Color(247, 238, 211));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                clearAllButton.setBackground(new Color(225, 215, 183));
            }

        });
    }

    /**
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * CALLS OUT THE OPERATOR BUTTONS
     * 
     * 
     * 
     * 
     * 
     * 
     */
    public void operatorCalculatorButtons(JButton operatorButton, JTextField calField) {
        operatorButton.setBackground(new Color(225, 215, 183));
        operatorButton.setFont(new Font("Dialog", Font.PLAIN, CommonConstants.BUTTON_FONT_SIZE));
        operatorButton.setBorder(null);
        operatorButton.setBounds(CommonConstants.HORIZONTAL_LIMIT, CommonConstants.V_VALUE,
                CommonConstants.BUTTON_SIZE[0],
                CommonConstants.BUTTON_SIZE[0]);
        operatorButton.setFocusable(false);
        operatorButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                calField.setText(operatorButton.getText());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                operatorButton.setBackground(new Color(255, 248, 232));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                operatorButton.setBackground(new Color(247, 238, 211));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                operatorButton.setBackground(new Color(225, 215, 183));
            }

        });
    }

    /**
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * CALLS OUT THE EQUAL BUTTON
     * 
     * 
     * 
     * 
     * 
     * 
     */
    public void equalCalculatorButton(JButton equalButton, JTextField calField) {
        equalButton.setBackground(new Color(225, 215, 183));
        equalButton.setBorder(null);
        equalButton.setFocusable(false);
        equalButton.setFont(new Font("Dialog", Font.PLAIN, CommonConstants.BUTTON_FONT_SIZE));
        equalButton.setBounds(CommonConstants.HORIZONTAL_LIMIT, CommonConstants.VERTICAL_LIMIT,
                CommonConstants.BUTTON_SIZE[0],
                CommonConstants.BUTTON_SIZE[0]);
        equalButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                calField.setText(equalButton.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                calField.setText(equalButton.getText());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                equalButton.setBackground(new Color(255, 248, 232));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                equalButton.setBackground(new Color(247, 238, 211));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                equalButton.setBackground(new Color(225, 215, 183));
            }

        });

    }

}