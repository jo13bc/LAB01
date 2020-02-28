package sima.servidor.logic;

import Controller.Controller_Alumno;
import Controller.Controller_Curso;
import Controller.Controller_Profesor;
import Controller.Controller_Usuario;
import Server.Server;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class SIMASERVIDORNEGOCIO {

    public static void main(String[] args) {
        //show(new Controller_Profesor(), new Controller_Alumno(), new Controller_Curso(), new Controller_Usuario());
    }

    public static void show(Controller_Profesor cp, Controller_Alumno ca, Controller_Curso cc, Controller_Usuario cu) {
//        inserts(cp, ca, cc);
        queries(cp, ca, cc, cu);
//        updates(cp, ca, cc);
//        list(cp, ca, cc, cu);
//        deletes(cp, ca, cc);
    }

    public static void inserts(Controller_Profesor cp, Controller_Alumno ca, Controller_Curso cc) {
        try {
            String[] pp1 = {"C1", "N1", "A11", "A21", "T1", "C1"};
            String[] pp2 = {"C2", "N2", "A12", "A22", "T2", "C2"};
            String[] pp3 = {"C3", "N3", "A13", "A23", "T3", "C3"};
            String[] pp4 = {"C4", "N4", "A14", "A24", "T4", "C4"};
            cp.procedure("insert", pp1);
            cp.procedure("insert", pp2);
            cp.procedure("insert", pp3);
            cp.procedure("insert", pp4);
            String[] pa1 = {"C1", "N1", "A11", "A21", "T1", "C1", "03-02-2020", "1"};
            String[] pa2 = {"C2", "N2", "A12", "A22", "T2", "C2", "03-02-2020", "1"};
            String[] pa3 = {"C3", "N3", "A13", "A23", "T3", "C3", "03-02-2020", "2"};
            String[] pa4 = {"C4", "N4", "A14", "A24", "T4", "C4", "03-02-2020", "2"};
            ca.procedure("insert", pa1);
            ca.procedure("insert", pa2);
            ca.procedure("insert", pa3);
            ca.procedure("insert", pa4);
            String[] pc1 = {"C1", "N1", "1", "5", "1", "1", "1"};
            String[] pc2 = {"C2", "N2", "2", "6", "1", "2", "1"};
            String[] pc3 = {"C3", "N3", "3", "7", "2", "1", "2"};
            String[] pc4 = {"C4", "N4", "4", "8", "2", "2", "2"};
            cc.procedure("insert", pc1);
            cc.procedure("insert", pc2);
            cc.procedure("insert", pc3);
            cc.procedure("insert", pc4);
            JOptionPane.showMessageDialog(null, "Inserciones realizadas con éxito.", "Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void updates(Controller_Profesor cp, Controller_Alumno ca, Controller_Curso cc) {
        try {
            String[] pp1 = {"1", "Cedula 1", "Nombre 1", "Primer apellido 1", "Segundo apellido 1", "Telefono 1", "Correo 1"};
            cp.procedure("update", pp1);
            String[] pa1 = {"1", "Cedula 1", "Nombre 1", "Primer apellido 1", "Segundo apellido 1", "Telefono 1", "Correo 1", "03-02-2020", "1"};
            ca.procedure("update", pa1);
            String[] pc1 = {"1", "Codi1", "Nombre 1", "1", "5", "1", "1", "1"};
            cc.procedure("update", pc1);
            JOptionPane.showMessageDialog(null, "Actualizaciones realizadas con éxito.", "Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void list(Controller_Profesor cp, Controller_Alumno ca, Controller_Curso cc, Controller_Usuario cu) {
        try {
            System.out.println("Lista de Profesores:");
            System.out.println(
                    cp.function("list").stream()
                            .map(Object::toString)
                            .collect(Collectors.joining("\n"))
            );

            System.out.println("Lista de Alumnos:");
            System.out.println(
                    ca.function("list").stream()
                            .map(Object::toString)
                            .collect(Collectors.joining("\n"))
            );

            System.out.println("Lista de Usuarios:");
            System.out.println(
                    cu.function("list").stream()
                            .map(Object::toString)
                            .collect(Collectors.joining("\n"))
            );

            System.out.println("Lista de Cursos:");
            System.out.println(
                    cc.function("list").stream()
                            .map(Object::toString)
                            .collect(Collectors.joining("\n"))
            );

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void queries(Controller_Profesor cp, Controller_Alumno ca, Controller_Curso cc, Controller_Usuario cu) {

        try {
            String[] id = {"1"};
            System.out.println("Busqueda de Profesor:");
            System.out.println(cp.function("query", id));

            System.out.println("Busqueda de Alumno:");
            System.out.println(ca.function("query", id));

            System.out.println("Busqueda de Curso:");
            System.out.println(cc.function("query", id));

            System.out.println("Busqueda de Usuario:");
            System.out.println(cu.function("query", id));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void deletes(Controller_Profesor cp, Controller_Alumno ca, Controller_Curso cc) {
        try {
            String[] pp1 = {"2"};
            String[] pp2 = {"3"};
            String[] pp3 = {"4"};
            String[] pp4 = {"5"};
            cp.procedure("delete", pp1);
            cp.procedure("delete", pp2);
            cp.procedure("delete", pp3);
            cp.procedure("delete", pp4);
            String[] pa1 = {"2"};
            String[] pa2 = {"3"};
            String[] pa3 = {"4"};
            String[] pa4 = {"5"};
            ca.procedure("delete", pa1);
            ca.procedure("delete", pa2);
            ca.procedure("delete", pa3);
            ca.procedure("delete", pa4);
            String[] pc1 = {"4"};
            String[] pc2 = {"5"};
            String[] pc3 = {"6"};
            String[] pc4 = {"7"};
            cc.procedure("delete", pc1);
            cc.procedure("delete", pc2);
            cc.procedure("delete", pc3);
            cc.procedure("delete", pc4);
            JOptionPane.showMessageDialog(null, "Eliminaciones realizadas con éxito.", "Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void login(Controller_Usuario cu) {
        try {
            String[] pr = {"Jo1234", "1234"};
            JOptionPane.showMessageDialog(null, cu.function("login", pr), "Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
