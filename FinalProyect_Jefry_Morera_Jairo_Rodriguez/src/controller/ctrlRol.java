package controller;

import model.rol;
import model.rolDAO;
import java.util.List;
import javax.swing.JComboBox;

public class ctrlRol {

    // Loads roles from the database and populates them into a JComboBox.
    public void loadRolesToComboBox(JComboBox<String> comboBox) {
        rolDAO rolDAO = new rolDAO();
        List<rol> roles = rolDAO.readRoles();

        comboBox.removeAllItems(); // Limpia el ComboBox
        // Add the names of roles to the JComboBox
        for (rol role : roles) {
            comboBox.addItem(role.getName());
        }
    }

    // Gets the role ID by its name.
    public int getRoleIdByName(String roleName) {
        rolDAO rolDAO = new rolDAO();
        rol rol = rolDAO.getRolByName(roleName);

        if (rol != null) {
            return rol.getId();
        } else {
           
            return -1; 
        }
    }

    //Gets the role name by its ID
    public String getRoleNameById(int roleId) {
        rolDAO rolDAO = new rolDAO();
        return rolDAO.getRoleNameById(roleId);
    }
    // Alternative method to get the role ID by name

    public int getRoleIdByName2(String roleName) {
        rolDAO rolDAO = new rolDAO();
        return rolDAO.getRoleIdByName(roleName);
    }
}
