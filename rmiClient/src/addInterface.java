import java.rmi.*;
import java.awt.Color;
import java.util.LinkedList;

    
    public interface addInterface extends Remote {
 	   public int addn(int a,int b) throws RemoteException;
 	   public int minus(int a,int b) throws RemoteException;
 	   public void addLinha(int x, int y, int x2, int y2, int idquadro, int idUser) throws RemoteException;
 	   public int criarQuadro() throws RemoteException;
 	   public int entrarQuadro(int idBoard) throws RemoteException;
 	   public void sairQuadro(int idBoard,int idUser) throws RemoteException;
 	   public int getQuadroId(int index) throws RemoteException;
 	   public int getListaQuadroSize() throws RemoteException;
 	   public int getListaLinhasSize(int idQuadro) throws RemoteException;
 	   public int getLinhaXstart(int idQuadro, int index) throws RemoteException;
 	   public int getLinhaYstart(int idQuadro, int index) throws RemoteException;
 	   public int getLinhaXend(int idQuadro, int index) throws RemoteException;
 	   public int getLinhaYend(int idQuadro, int index) throws RemoteException;
 	   public Color getLinhaColor(int idQuadro, int index) throws RemoteException;
    }