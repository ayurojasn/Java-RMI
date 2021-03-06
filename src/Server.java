import java.rmi.registry.Registry;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject; 

public class Server extends ImplRMI { 
   public Server() {} 
   public static void main(String args[]) { 
      
      try { 
         // Instantiating the implementation class 
         ImplRMI obj = new ImplRMI(); 
         System.setProperty("java.rmi.server.hostname", "25.77.250.182"); //change ip hamachi
         // Exporting the object of implementation class  
         // (here we are exporting the remote object to the stub)
         InterfaceRMI stub = (InterfaceRMI) UnicastRemoteObject.exportObject(obj, 0);  
         
         // Binding the remote object (stub) in the registry 
         
         Registry registry = LocateRegistry.getRegistry(); 
         
         registry.bind("InterfaceRMI", stub); 
         //System.out.println(  System.getProperty("java.rmi.server.hostname")); 
         System.err.println("Server ready"); 
      } catch (Exception e) { 
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
} 