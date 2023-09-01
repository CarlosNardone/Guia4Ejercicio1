/*
 Explicacion
 */
package universidadejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UniversidadEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            //cargar driver de conexion
            Class.forName("org.mariadb.jdbc.Driver");

            //Conexion a la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/ulp", "root", "");

            //3 alumnos ingresados
               /*   
            
            String sql = "insert into alumno (dni, apellido, nombre, fechaNacimiento, estado)"
                    + "values(56767568,'Laura','Walner', ' " + LocalDate.of(1987, Month.JULY, 11)
                   + "',true);";           
            */
               
                 //4 materias ingresadas
//            String sql = "INSERT INTO materia (nombre, año, estado) VALUES ('Ingles 2', 2 , true)";


// 3 alumnos inscritos en 2 materias cada uno.
//            String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (8, 3 ,3 )";


            //alumno dado de baja (referente de la guia principal)
//             String sql = "UPDATE alumno SET estado = false WHERE dni = 52745628";
            
             
             
             //listar todos los alumnos activos referente en la guia principal  
          //            String sql="select * from alumno where estado = true";
          
          
          //f) Listar los datos de los alumnos con calificaciones superiores a 8.
          
//          String sql = "SELECT *  "
//                  + "FROM alumno "
//                  + "JOIN inscripcion "
//                  + "ON (alumno.idAlumno = inscripcion.idAlumno)  "
//                  + "WHERE inscripcion.nota > 8 ";
          
           //g) Desinscribir un alumno de una de la materias.
           
           String sql = "DELETE FROM `inscripcion` WHERE idAlumno = 1";

          
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            
            
            //parte del listado de alumnos
            
            
//            ResultSet resultado = ps.executeQuery();
//            
//            while(resultado.next()){
//                System.out.println("Id " +resultado.getInt("idAlumno"));
//                System.out.println("DNI " +resultado.getInt("dni"));
//                System.out.println("Apellido " +resultado.getString("apellido"));
//                System.out.println("Nombre " +resultado.getString("nombre"));
//                System.out.println("Fecha de nacimiento " +resultado.getDate("fechaNacimiento"));
//                System.out.println("Nota: " +resultado.getInt("inscripcion.nota"));
//                System.out.println("------------------------------------------------------------");
//                
//            }

            

           //para ir agregando filas
           
           
            int filas = ps.executeUpdate();

            if (filas > 0) {
//                JOptionPane.showMessageDialog(null, "Alumno agregado exitosamente!");
//                  JOptionPane.showMessageDialog(null, "Alumno inscripto en la materia exitosamente!");
//                  JOptionPane.showMessageDialog(null, "Alumno dado de baja exitosamente!");
//                JOptionPane.showMessageDialog(null, "Materia agregada exitosamente!");
                JOptionPane.showMessageDialog(null, "Alumno desinscripto!");
            }


        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar driver");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error conexion" + ex.getMessage());
        }

    }

}
