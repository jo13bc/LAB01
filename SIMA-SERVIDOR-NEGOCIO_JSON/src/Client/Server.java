package Client;

import Controller.Controller;
import Controller.Controller_Alumno;
import Controller.Controller_Curso;
import Controller.Controller_Profesor;
import Controller.Controller_Usuario;
import java.net.*;
import java.io.*;

public class Server {

    private final int PORT;
    private Socket socket;
    private ServerSocket server;
    private ObjectInputStream bufferObjectIn = null;
    private ObjectOutputStream bufferObjectOut = null;
    Controller controller;
    Message message;

    public Server(int port) {
        this.PORT = port;
    }

    public Server() {
        this(5000);
    }

    public void levantarConexion() {
        try {
            server = new ServerSocket(PORT);
            mostrarTexto("Esperando conexión entrante en el puerto " + String.valueOf(PORT) + "...");
            socket = server.accept();
            mostrarTexto("Conexión establecida con: " + socket.getInetAddress().getHostName() + "\n\n\n");
        } catch (Exception e) {
            mostrarTexto("Error en levantarConexion(): " + e.getMessage());
            System.exit(0);
        }
    }

    public void cerrarConexion() {
        try {
            bufferObjectIn.close();
            bufferObjectOut.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            mostrarTexto("Excepción en cerrarConexion(): " + e.getMessage());
        } finally {
            mostrarTexto("Conversación finalizada....");

        }
    }

    public void flujos() {
        try {
            bufferObjectOut = new ObjectOutputStream(socket.getOutputStream());
            bufferObjectOut.flush();
            bufferObjectIn = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            mostrarTexto("Error en la apertura de flujos");
        }
    }

    public void escribirDatos() throws Exception {
        enviar(proccess());
    }

    public void recibirDatos() throws Exception {
        try {
            message = (Message) bufferObjectIn.readObject();
            mostrarTexto(message.toString());
        } catch (IOException | ClassNotFoundException ex) {
            cerrarConexion();
            throw new Exception("Fallo al obtener el mensaje.");
        }
    }

    public void enviar(Packet packet) {
        try {
            mostrarTexto(packet.toString());
            bufferObjectOut.writeObject(packet.getObject());
            bufferObjectOut.flush();
        } catch (IOException ex) {
            mostrarTexto("Error en enviar(): " + ex.getMessage());
        }
    }

    public static void mostrarTexto(String s) {
        System.out.println(s);
    }

    public void ejecutarConexion() {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        levantarConexion();
                        flujos();
                        recibirDatos();
                        setController();
                        escribirDatos();
                    } catch (Exception ex) {
                        mostrarTexto(ex.getMessage());
                    } finally {
                        cerrarConexion();
                    }
                }
            }
        });
        hilo.start();
    }

    public void setController() throws Exception {
        controller = null;
        switch (message.getInstance().toLowerCase()) {
            case "usuario": {
                controller = new Controller_Usuario();
            }
            break;
            case "profesor": {
                controller = new Controller_Profesor();
            }
            break;
            case "alumno": {
                controller = new Controller_Alumno();
            }
            break;
            case "curso": {
                controller = new Controller_Curso();
            }
            break;
            default: {
                throw new Exception("Instancia desconocida");
            }
        }
    }

    public Packet proccess() throws Exception {
        //
        Packet result = new Packet();
        //
        switch (message.getType_process()) {
            case "function": {
                if (message.getObject() != null) {
                    result.setObject(controller.function(message.getOpcion(), message.getObject()));
                } else {
                    result.setObject(controller.function(message.getOpcion()));
                }
            }
            break;
            case "procedure": {
                controller.procedure(message.getOpcion(), message.getObject());
                result.setObject(controller.function("list"));
            }
            break;
            default: {
                throw new Exception("Proceso desconocido.");
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server s = new Server();
        s.ejecutarConexion();
    }
}
