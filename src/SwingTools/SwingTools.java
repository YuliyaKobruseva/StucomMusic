/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingTools;

import controller.Manager;
import exceptions.ManagerException;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.enums.TypeDifficultyLevel;
import model.enums.TypeGenre;
import model.enums.TypeInstrument;

/**
 *
 * @author Yuli
 */
public class SwingTools {

    private static SwingTools swingTools;

    public static SwingTools getSwingTools() {
        if (swingTools == null) {
            swingTools = new SwingTools();
        }
        return swingTools;
    }

    /**
     * Methos to generate a comboBox
     * @param comboBox 
     * @param typeComboBox type of comboBox
     */
    public void generateSelect(JComboBox<String> comboBox, String typeComboBox) {
        switch (typeComboBox) {
            case "genre":
                for (TypeGenre genre : TypeGenre.values()) {
                    comboBox.addItem(genre.toString());
                }
                break;
            case "instrument":
                for (TypeInstrument genre : TypeInstrument.values()) {
                    comboBox.addItem(genre.toString());
                }
                break;
            case "level":
                for (TypeDifficultyLevel level : TypeDifficultyLevel.values()) {
                    comboBox.addItem(level.toString());
                }
                break;
            case "user":
                Manager.getManager().getUsers().forEach((user) -> {
                    comboBox.addItem(user.getName());
                });
            default:
                break;
        }
    }

    /**
     * Method to set icon of app
     * @param dialog
     * @param frame
     */
    public void setIcon(JDialog dialog, JFrame frame) {
        if (dialog == null) {
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconLogin.png")));
        } else {
            dialog.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconLogin.png")));
        }
    }

    /**
     * Method to generate table
     * @param newTable
     * @param typeTable type of table
     */
    public void createTable(JTable newTable, String typeTable) throws ManagerException {
        ArrayList<String> columns = new ArrayList<>();
        ArrayList<String> rows = new ArrayList<>();
        if (typeTable.equalsIgnoreCase("level")) {
            for (TypeDifficultyLevel level : TypeDifficultyLevel.values()) {
                columns.add(level.toString());
                rows.add(Manager.getManager().quantityScores(typeTable, level.toString()));
            }
        } else if (typeTable.equalsIgnoreCase("instrument")) {
            for (TypeInstrument instrument : TypeInstrument.values()) {
                columns.add(instrument.toString());
                rows.add(Manager.getManager().quantityScores(typeTable, instrument.toString()));
            }
        } else if (typeTable.equalsIgnoreCase("genre")) {
            for (TypeGenre genre : TypeGenre.values()) {
                columns.add(genre.toString());
                rows.add(Manager.getManager().quantityScores(typeTable, genre.toString()));
            }
        }
        DefaultTableModel model = new DefaultTableModel(null, columns.toArray());
        model.addRow(rows.toArray());
        newTable.setModel(model);
        newTable.setEnabled(false);
    }

    /**
     * Method to show button that was selected
     * @param buttonSelected
     * @param buttonGroup
     */
    public void setSelectedButtonText(String buttonSelected, ButtonGroup buttonGroup) {
        for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = (AbstractButton) buttons.nextElement();
            if (button.getText().equalsIgnoreCase(buttonSelected)) {
                button.setSelected(true);
            }
        }
    }

    /**
     * Method to get name of the selected button
     * @param buttonGroup
     * @return name of button
     */
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = (AbstractButton) buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
}
