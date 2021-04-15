package ClientPackage;

import ServerPackage.*;

import javax.swing.*;

public class ClientTest {
    public static void main(String[] args) {
        Client  client1=new Client(5555);
        client1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client1.startRunning();
    }
}
