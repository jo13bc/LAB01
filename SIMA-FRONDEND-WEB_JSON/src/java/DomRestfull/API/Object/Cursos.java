package DomRestfull.API.Object;

import Logic.Curso;
import Logic.Instancia;
import static Logic.Utils.verifyString;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Server.Client;
import Server.Message;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.stream.Collectors;

@WebServlet(name = "curso", urlPatterns = {"/curso"})
public class Cursos extends HttpServlet {

    private final Gson gson = new Gson();

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
        Instancia object = null;
        String proccess;
        String result;
        switch (opcion) {
            case "insert":
            case "update":
            case "delete": {
                object = gson.fromJson(request.getParameter("json"), Curso.class);
                proccess = "procedure";
                Synchronizer.getSynchronizer().setChange(true);
            }
            break;
            case "query": {
                object = gson.fromJson(request.getParameter("json"), Curso.class);
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
        if (opcion.equals("query")) {
            result = ((Curso) Client.getClient()
                    .ejecutarConexion(new Message(this.getServletName(), proccess, opcion, object), 5050)
                    .getResponse()).getJSON().toString();
        } else {
            result = ((ArrayList<Curso>) Client.getClient()
                    .ejecutarConexion(new Message(this.getServletName(), proccess, opcion, object), 5050)
                    .getResponse()).stream()
                    .map((x) -> {
                        try {
                            return x.getJSON().toString();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex.getMessage());
                        }
                    })
                    .collect(Collectors.toList()).toString();
        }
        response.getWriter().write(result);
    }

}
