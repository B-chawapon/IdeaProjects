package ServerPackage;

import ClientPackage.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends JFrame{
    private JTextField  userText;
    private JTextArea   chatWindow;
    private ObjectOutputStream output;
    private ObjectInputStream   input;
    private ServerSocket    server;


    private Socket  connection;


    public Server(){
        super("Server Computer");
        userText=new JTextField();
        chatWindow=new JTextArea();
        userText.setEditable(false);
        userText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(e.getActionCommand());
            }
        });
        add(userText, BorderLayout.NORTH);
        add(new JScrollPane(chatWindow));
        setSize(300,300);
        setVisible(true);
    }
    public void startRunning(){
        try {
            server=new ServerSocket(1234);
            server.setReuseAddress(true);
            while (true){
                try {
                    waitforConnection();
                    setUpStream();
                    whileChatting();
                } catch (Exception  e){
                    e.printStackTrace();
                }finally {
                    closeObject();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void whileChatting() {
        String  message="Now connected";
        ableToType(true);
        do {
            try {
                message=(String) input.readObject();
                showMessage("\n"+message);
            }catch (Exception e){
                e.printStackTrace();
            }

        }while (!message.equals("CLIENT-END"));
    }

    private void ableToType(boolean b) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                userText.setEditable(b);
            }
        });
    }

    private void setUpStream() {
        try {
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input=new ObjectInputStream(connection.getInputStream());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void waitforConnection() {
        try{
            showMessage("WAITNG FOR CLIENT...\n");
            connection=server.accept();
            showMessage(connection.getLocalAddress() +" FromPort "+connection.getPort());
            ClientHandler clientSock=new ClientHandler(connection);
            //server=new ServerSocket(1235,4,InetAddress.getByName("25.31.245.162"));
            new Thread(clientSock).start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void showMessage(String s) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                chatWindow.append(s);
            }
        });
    }

    public void sendMessage(String str){
        try{
            output.writeObject("SERVER :"+str);
            output.flush();
            showMessage("\nSERVER :"+str);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void closeObject(){
        showMessage("Close Connection...\n");
        ableToType(false);
        try {
            output.close();
            input.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    private class ClientHandler implements Runnable {
        private final Socket clientSocket;
        public ClientHandler(Socket connection) {
            this.clientSocket=connection;

        }

        @Override
        public void run() {
            PrintWriter out=null;
            BufferedReader in=null;
            try{
                out =new PrintWriter(clientSocket.getOutputStream(),true);
                in =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String line;
                while ((line=in.readLine())!=null){
                    System.out.println("Send from client: "+line);
                    out.println(line);
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try{
                    if(out!=null){
                        out.close();
                    }
                    if(in!=null)
                        in.close();
                    clientSocket.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }


        }



    }
}
