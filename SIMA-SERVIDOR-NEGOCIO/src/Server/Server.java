package Server;

import Controller.Controller;
import Controller.Controller_Alumno;
import Controller.Controller_Carrera;
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
            bufferObjectIn = null;
            bufferObjectOut = null;
            socket = null;
            server = null;
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
        try {
            enviar(proccess());
        } catch (Exception ex) {
            enviar(new Packet(ex.getMessage(), false));
        }
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

    public void enviar(Packet packet) throws Exception {
        try {
            mostrarTexto(packet.toString());
            bufferObjectOut.writeObject(packet);
            bufferObjectOut.flush();
        } catch (IOException ex) {
            mostrarTexto("Error en enviar(): " + ex.getMessage());
            throw new Exception(ex.getMessage());
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
            case "carrera": {
                controller = new Controller_Carrera();
            }
            break;
            default: {
                throw new Exception("Instancia desconocida");
            }
        }
    }

    public Packet proccess() throws Exception {
        //
        Packet result;
        //
        switch (message.getType_process()) {
            case "function": {
                if (!message.getArgs().isEmpty()) {
                    result = new Packet(
                            controller.function(
                                    message.getOpcion(),
                                    message.getArgs().toArray(new String[message.getArgs().size()])
                            ),
                            true
                    );
                } else {
                    result = new Packet(
                            controller.function(
                                    message.getOpcion()
                            ),
                            true
                    );
                }
            }
            break;
            case "procedure": {
                controller.procedure(
                        message.getOpcion(),
                        message.getArgs().toArray(new String[message.getArgs().size()])
                );
                result = new Packet(
                        controller.function("list"),
                        true
                );
            }
            break;
            default: {
                throw new Exception("Proceso desconocido.");
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server primario = new Server(5000);
        Server secundario = new Server(5050);
        primario.ejecutarConexion();
        secundario.ejecutarConexion();
    }
}
