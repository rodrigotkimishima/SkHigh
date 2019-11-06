    import java.rmi.*;
    import java.rmi.server.*;
    import java.util.Scanner;   
    
    public class addServer {
    	   public static void main (String[] argv) {
    		   try {
    			   Scanner input = new Scanner(System.in);
    			   System.out.println("Digite a porta do servidor: ");
    			   String port = input.next();
    			   add Hello = new add();
    			   Naming.rebind("rmi://localhost/"+port, Hello);
     
    			   input.close();
    			   System.out.println("Server is ready.");
    			   }catch (Exception e) {
    				   System.out.println("Server failed: " + e);
    				}
    		   }
    }