/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.mycompany.project.FormMenuPrincipal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author daya_
 */
public class CLogin {
    public void validaUsuario(JTextField usuario, JPasswordField contrasenia){
        try {
            ResultSet rs=null;
            PreparedStatement ps=null;
            Clases.CConexion objetoConexion=new Clases.CConexion();
            String consulta="select * from Usuarios where Usuarios.ingresoUsuario=(?) and Usuarios.ingresoContrasenia=(?)";
            ps=objetoConexion.estableceConexion().prepareStatement(consulta);
            String contra=String.valueOf(contrasenia.getPassword());
            ps.setString(1, usuario.getText());
            ps.setString(2, contra);
            rs=ps.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "El usuario es correcto");
                FormMenuPrincipal objetoMenu=new FormMenuPrincipal();
                objetoMenu.setVisible(true);
            }else{
                 JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
}
