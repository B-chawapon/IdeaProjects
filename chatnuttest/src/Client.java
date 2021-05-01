import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
   private Socket socket;
   private String ipServer;
   private DataInputStream inputStream;
   private DataOutputStream outputStream;
   private Scanner scanner=new Scanner(System.in);


   public Client(){

   }
   public void start()  {
      System.out.println("Connecting... to server");

         try {
            connectToServer();
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
   private void connectToServer(){
      try{
         socket=new Socket("localhost",1234);
         if(socket.isConnected()==true) {
            System.out.println("Connected");
         }
         else{
            System.out.println("Disconnect");
         }
      }
      catch (IOException e){
         e.printStackTrace();
      }
   }

   private void setUpStream(){
      try {
         outputStream = new DataOutputStream(socket.getOutputStream());
        // outputStream.flush();
         inputStream =new DataInputStream(socket.getInputStream());
         System.out.println("setUp Now");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   private void chatting(){
      Thread sendMessage =new Thread(new Runnable() {
         @Override
         public void run() {
            while (true){
               String  msg=scanner.nextLine();
               try {
                  outputStream.writeUTF(msg);
               }catch (IOException e){
                  e.printStackTrace();
               }
            }
         }
      });
      Thread readMessage=new Thread(new Runnable() {
         @Override
         public void run() {
            while (true){
               try{
                  String msg=inputStream.readUTF();
                  System.out.println("Server"+msg);
               }catch (IOException e)
               {
                  e.printStackTrace();
               }
            }
         }
      });
      sendMessage.start();
      readMessage.start();
      System.out.println("WTSCLient");
   }

}
