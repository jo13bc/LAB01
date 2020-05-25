package DomRestfull.API.Object;

import Logic.Instancia;
import Logic.Usuario;
import static Logic.Utils.verifyString;
import Server.Client;
import Server.Message;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    private final Gson gson = new Gson();

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
        Instancia object = null;
        String proccess;
        switch (opcion) {
            case "login":
            case "query": {
                object = gson.fromJson(request.getParameter("json"), Usuario.class);
                proccess = "function";
            }
            break;
            default: {
                throw new Exception("Opción desconocida");
            }
        }

        response.setContentType("text/plain");
        response.getWriter().write(((Usuario) Client.getClient()
                .ejecutarConexion(new Message(this.getServletName(), proccess, opcion, object), 5000)
                .getResponse()).getJSON().toString());
    }
}
