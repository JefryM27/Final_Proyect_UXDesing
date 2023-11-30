/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.rol;
import model.rolDAO;
import java.util.List;
import javax.swing.JComboBox;

public class ctrlRol {
    // Load roles to a JComboBox
    public void loadRolesToComboBox(JComboBox<String> comboBox) {
        rolDAO rolDAO = new rolDAO();
        List<rol> roles = rolDAO.readRoles();

        comboBox.removeAllItems(); // Limpia el ComboBox
        // Add the names of roles to the JComboBox
        for (rol role : roles) {
            comboBox.addItem(role.getName());
        }
    }
    // Get the role ID by name
    public int getRoleIdByName(String roleName) {
        rolDAO rolDAO = new rolDAO();
        rol rol = rolDAO.getRolByName(roleName);
        
        if (rol != null) {
            return rol.getId();
        } else {
            // In case the role is not found, you can handle it as needed, e.g., throw an exception or return a default value.
            return -1; // Default value or error handling
        }
    }
    // Get the role name by ID
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
