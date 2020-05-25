package Client;

import java.net.*;
import java.io.*;

public class Client {

    private final int SERVER_PORT;
    private final String SERVER_IP;
    private Socket socket;
    private ObjectInputStream bufferObjectIn = null;
    private ObjectOutputStream bufferObjectOut = null;
    private Packet packet;

    public Client(String ip, int port) {
        SERVER_IP = ip;
        SERVER_PORT = port;
        packet = new Packet();
    }

    public Client() {
        this("localhost", 5000);
    }

    public void levantarConexion() throws Exception {
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
        } catch (IOException ex) {
            throw new Exception("No se logró estableser una conexión con el servidor lógico.");
        }
    }

    public static void mostrarTexto(String s) {
        System.out.println(s);
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
        } catch (IOException e) {
            throw new Exception("Fallo al intentar cerrar la conexión.");
        }
    }

    public void ejecutarConexion(Message message) throws Exception {
        try {
            levantarConexion();
            abrirFlujos();
            escribirDatos(message);
            recibirDatos();
            cerrarConexion();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void recibirDatos() throws Exception {
        try {
            packet = new Packet();
            packet.setObject(bufferObjectIn.readObject());
        } catch (IOException ex) {
            throw new Exception("Fallo el recibir la respuesta.");
        }
    }

    public void escribirDatos(Message message) throws Exception {
        try {
            enviar(message);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
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

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }

    public static void main(String[] argumentos) {
        Client cliente = new Client();
        try {
            cliente.ejecutarConexion(new Message("usuario", "function", "list", null));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
