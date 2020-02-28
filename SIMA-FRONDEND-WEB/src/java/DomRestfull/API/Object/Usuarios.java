package DomRestfull.API.Object;

import Logic.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static Logic.Utils.verifyString;
import Server.Client;
import Server.Message;
import java.util.ArrayList;

@WebServlet(name = "usuario", urlPatterns = {"/usuario"})
public class Usuarios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        menu(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        menu(request, response);
    }

    public void menu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opciones(request, response);
        } catch (Exception ex) {
            response.setStatus(400);
            response.setContentType("text/plain");
            response.getWriter().write(ex.getMessage());
        }
    }

    public void opciones(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String opcion = verifyString(request.getParameter("opcion"), "una opción");
        ArrayList<String> args = new ArrayList();
        String proccess;
        switch (opcion) {
            case "insert": {
                args.add(request.getParameter("usuario"));
                args.add(request.getParameter("contrasenna"));
                args.add(request.getParameter("id_persona"));
                proccess = "procedure";
            }
            break;
            case "update": {
                args.add(request.getParameter("id"));
                args.add(request.getParameter("usuario"));
                args.add(request.getParameter("contrasenna"));
                args.add(request.getParameter("id_persona"));
                proccess = "procedure";
            }
            break;
            case "delete": {
                args.add(request.getParameter("id"));
                proccess = "procedure";
            }
            break;
            case "query": {
                args.add(request.getParameter("id"));
                proccess = "function";
            }
            break;
            case "list": {
                proccess = "function";
            }
            break;
            default: {
                throw new Exception("Opción desconocida");
            }
        }

        response.setContentType("text/plain");
        response.getWriter().write(
                ((Usuario)Client.getClient()
                        .ejecutarConexion(new Message(this.getServletName(), proccess, opcion, args), 5000)
                        .getResponse()).getJSON().toString()
        );
    }

}
