package ClientPackage;

import ServerPackage.*;

import javax.swing.*;

public class ClientTest2 {
    public static void main(String[] args) {
        Client  client2=new Client(6666);
        client2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client2.startRunning();
    }
}
