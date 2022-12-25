/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daya_
 */
public class ListarProductos {
       Clases.CConexion objetoConexion= new Clases.CConexion();
       Connection cn=objetoConexion.estableceConexion();
       
       public void MostrarTable(JTable tabla){
           DefaultTableModel modelo=new DefaultTableModel();
           modelo.addColumn("No");
           modelo.addColumn("Producto");
           modelo.addColumn("Cantidad");
           modelo.addColumn("Precio Unitario");
           modelo.addColumn("Total");
           String consultasql="SELECT * FROM producto";
           Statement st;
           try {
               st=cn.createStatement();
               ResultSet rs=st.executeQuery(consultasql);
               while(rs.next()){
                   Object [] lista={rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDouble(5)};
                   modelo.addRow(lista);
               }
               tabla.setModel(modelo);             
           } catch (Exception e) {
               System.out.println("Error al listar productos"+e);
           }
           
       }
}
