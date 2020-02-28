package DomRestfull.API.Object;

import Logic.Usuario;
import static Logic.Utils.verifyString;
import Server.Client;
import Server.Message;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            menu(request, response);
        } catch (Exception ex) {
            response.setStatus(400);
            response.setContentType("text/plain");
            response.getWriter().write(ex.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            menu(request, response);
        } catch (Exception ex) {
            response.setStatus(400);
            response.setContentType("text/plain");
            response.getWriter().write(ex.getMessage());
        }
    }

    public void menu(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String opcion = verifyString(request.getParameter("opcion"), "una opción");
        ArrayList<String> args = new ArrayList();
        String proccess;
        switch (opcion) {
            case "login": {
                args.add(request.getParameter("usuario"));
                args.add(request.getParameter("contrasenna"));
                proccess = "function";
            }
            break;
            case "query": {
                args.add(request.getParameter("id"));
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
                        .ejecutarConexion(new Message("usuario", proccess, opcion, args), 5050)
                        .getResponse()).getJSON().toString()
        );
    }
}
