package CalculatorApp.App;

import CalculatorApp.Constants.CommonConstants;

import javax.swing.*;

public class CalculatorGui extends JFrame {

    public CalculatorGui() {
        super(CommonConstants.APP_NAME);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLocationRelativeTo(null);
        setResizable(false);
        calculatorComponents();

    }

    public void calculatorComponents() {

        CalculatorStructure calculatorStructure = new CalculatorStructure();

        /**
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * PANEL PROPERTIES
         * 
         * 
         * 
         * 
         * 
         * 
         */
        JPanel calPanel = new JPanel();
        calculatorStructure.calculatorPanel(calPanel);

        /**
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * TEXT PROPERTIES
         * 
         * 
         * 
         * 
         * 
         * 
         */
        JTextField calField = new JTextField();
        calculatorStructure.calculatorField(calField);
        calPanel.add(calField);

        /**
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * MAIN BUTTON PROPERTIES
         * 
         * 
         * 
         * 
         * 
         * 
         */
        int yValue = CommonConstants.DEFAULT;
        int xValue = CommonConstants.DEFAULT;
        String[] mainButtonName = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "C",
                "0", "." };
        int counter = CommonConstants.DEFAULT;

        for (int i = 0; i < CommonConstants.NUMBER_LAYOUT_DIMENSION[0]; i++) {
            yValue += CommonConstants.H_AND_V_VALUE;

            for (int j = 0; j < CommonConstants.NUMBER_LAYOUT_DIMENSION[1]; j++) {

                xValue += CommonConstants.H_AND_V_VALUE;

                if (xValue > CommonConstants.HORIZONTAL_LIMIT) {
                    xValue = CommonConstants.H_AND_V_VALUE;

                }

                JButton mainButton = new JButton(mainButtonName[counter++]);

                calculatorStructure.mainCalculatorButtons(calField, mainButtonName, xValue, yValue, mainButton);
                calPanel.add(mainButton);
            }

        }

        /**
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * CLEAR ALL BUTTON PROPERTIES
         * 
         * 
         * 
         * 
         * 
         * 
         */
        JButton clearAllButton = new JButton(CommonConstants.CLEAR_NAME);
        calculatorStructure.clearCalculatorButton(clearAllButton, calField);
        calPanel.add(clearAllButton);

        /**
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * OPERATOR BUTTON PROPERTIES
         * 
         * 
         * 
         * 
         * 
         * 
         */
        String[] operators = { "+", "-" };
        for (int i = 0; i < CommonConstants.OPERATOR_LAYOUT_DIMENSION[0]; i++) {
            CommonConstants.V_VALUE += CommonConstants.DEFAUL_V_VALUE;
            if (CommonConstants.V_VALUE == CommonConstants.DEFAULT_V_VALUE_OPERATOR_BUTTON) {
                CommonConstants.V_VALUE += CommonConstants.GAP;
            }
            JButton operatorButton = new JButton(operators[i]);
            calculatorStructure.operatorCalculatorButtons(operatorButton, calField);
            calPanel.add(operatorButton);
        }

        /**
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * EQUAL BUTTON PROPERTIES
         * 
         * 
         * 
         * 
         * 
         * 
         */
        JButton equalButton = new JButton(CommonConstants.EQUAL_NAME);
        calculatorStructure.equalCalculatorButton(equalButton, calField);
        calPanel.add(equalButton);

        /**
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         */
        getContentPane().add(calPanel);
    }

}
