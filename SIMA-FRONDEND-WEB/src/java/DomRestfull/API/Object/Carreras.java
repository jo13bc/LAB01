package DomRestfull.API.Object;

import Logic.Carrera;
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
import java.util.stream.Collectors;

@WebServlet(name = "carrera", urlPatterns = {"/carrera"})
public class Carreras extends HttpServlet {

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
        String result;
        switch (opcion) {
            case "insert": {
                args.add(request.getParameter("codigo"));
                args.add(request.getParameter("nombre"));
                args.add(request.getParameter("titulo"));
                proccess = "procedure";
            }
            break;
            case "update": {
                args.add(request.getParameter("id"));
                args.add(request.getParameter("codigo"));
                args.add(request.getParameter("nombre"));
                args.add(request.getParameter("titulo"));
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
        if (opcion.equals("query")) {
            result = ((Carrera) Client.getClient()
                    .ejecutarConexion(new Message(this.getServletName(), proccess, opcion, args), 5000)
                    .getResponse()).getJSON().toString();
        } else {
            result = ((ArrayList<Carrera>) Client.getClient()
                    .ejecutarConexion(new Message(this.getServletName(), proccess, opcion, args), 5000)
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
