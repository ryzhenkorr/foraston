import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;

public class Starter {

    public static void main(String[] args) throws IOException {
        int port = 100;
        try {
            ServerSocket ss = new ServerSocket(port);
            JFrame frame = new Algorithms();
            frame.setVisible(true);
        } catch (SocketException e) {
            JOptionPane.showMessageDialog(null, "Application is already running");
        }
    }
}