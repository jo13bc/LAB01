package Server;

import java.net.*;
import java.io.*;

public class Client {

    private final String SERVER_IP;
    private Socket socket;
    private ObjectInputStream bufferObjectIn = null;
    private ObjectOutputStream bufferObjectOut = null;
    private static final Client client = new Client();

    public static Client getClient() {
        return client;
    }

    private Client(String ip) {
        SERVER_IP = ip;
    }

    private Client() {
        this("localhost");
    }

    public void levantarConexion(int port) throws Exception {
        try {
            socket = new Socket(SERVER_IP, port);
        } catch (IOException ex) {
            throw new Exception("No se logró estableser una conexión con el servidor lógico.");
        }
    }

    public void abrirFlujos() throws Exception {
        try {
            bufferObjectIn = new ObjectInputStream(socket.getInputStream());
            bufferObjectOut = new ObjectOutputStream(socket.getOutputStream());
            bufferObjectOut.flush();
        } catch (IOException e) {
            throw new Exception("Error en la apertura de flujos.");
        }
    }

    public void enviar(Object object) throws Exception {
        try {
            bufferObjectOut.writeObject(object);
            bufferObjectOut.flush();
        } catch (IOException ex) {
            throw new Exception("Fallo el envio de [" + object + "].");
        }
    }

    public void cerrarConexion() throws Exception {
        try {
            bufferObjectIn.close();
            bufferObjectOut.close();
            socket.close();
            bufferObjectIn = null;
            bufferObjectOut = null;
            socket = null;
        } catch (IOException e) {
            throw new Exception("Fallo al intentar cerrar la conexión.");
        }
    }

    public Packet ejecutarConexion(Message message, int port) throws Exception {
        Packet result = null;
        try {
            levantarConexion(port);
            abrirFlujos();
            escribirDatos(message);
            result = recibirDatos();
            cerrarConexion();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return result;
    }

    public Packet recibirDatos() throws Exception {
        Packet packet = null;
        try {
            packet = (Packet) bufferObjectIn.readObject();
            if (!packet.isStatus()) {
                throw new Exception(packet.getResponse().toString());
            }
        } catch (IOException ex) {
            throw new Exception(ex.getMessage());
        }
        return packet;
    }

    public void escribirDatos(Message message) throws Exception {
        try {
            enviar(message);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public static void mostrarTexto(String s) {
        System.out.println(s);
    }

    public String type_proccess(String opcion) throws Exception {
        String result;
        switch (opcion) {
            case "insert": {
            }
            case "delete": {
            }
            case "update": {
                result = "procedure";
            }
            break;
            default: {
                result = "function";
            }
        }
        return result;
    }
}
