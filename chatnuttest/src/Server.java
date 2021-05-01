import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Scanner scanner=new Scanner(System.in);

    public Server(){

    }
    public void start(){
        System.out.println("Server OPEN");

            try {
                openServer();
                setUpStream();

                chatting();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("CLOSE CONNECTION");
                try {
                    outputStream.close();
                    inputStream.close();
                    socket.close();
                    scanner.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


    }
    private void openServer(){
        try {
            serverSocket=new ServerSocket(1234);
            serverSocket.setReuseAddress(true);
            socket=serverSocket.accept();
            if(socket.isConnected()==true){
                System.out.println("Connected");
            }
            else
            {
                System.out.println("Disconnect");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setUpStream(){
        try {
            outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.flush();
            inputStream =new DataInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void chatting(){

        String  msg=scanner.nextLine();
        try {
            outputStream.writeUTF(msg);
        }catch (IOException e){
            e.printStackTrace();
        }

        Thread readMessage=new Thread(new Runnable() {
            @Override
            public void run() {

                    try{
                        String msg=inputStream.readUTF();
                        System.out.println("Client"+msg);
                    }catch (IOException e)
                    {
                        e.printStackTrace();
                    }

            }
        });

        readMessage.start();
        System.out.println("WTSERVER");
    }




}
