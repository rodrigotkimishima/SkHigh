import java.rmi.*;
import java.util.*;
import java.rmi.server.*;
import java.awt.Color;
     
    public class add extends UnicastRemoteObject
             implements addInterface {
    	  static private LinkedList<quadro> quadros = new LinkedList<quadro>();
    	  static int idQuadro = 0;
    	  static int quadrosQtd = 0;
          public add () throws RemoteException {   }
     
          public int addn(int a, int b) throws RemoteException {
        	  int result=a+b;
        	  return result;
          }
          public int minus(int a, int b) throws RemoteException {
        	  int result=a-b;
        	  return result;
          }
          public void addLinha(int x, int y, int x2, int y2, int idquadro, int idUser) throws RemoteException{
        	  Color cor = line.getUserCor(idUser);
        	  line linha = new line(x,y,x2,y2,cor);
        	  quadro board = new quadro();
        	  for(int i=0;i < quadrosQtd;i++) {
        		  board = quadros.get(i);
        		  if(board.getIdQuadro() == idquadro) {
        			  board.newLinha(linha);
        		  }
        	  }
        	  System.out.println(linha.getXStart()+" "+linha.getYStart()+" "+linha.getXEnd()+" "+linha.getYEnd()+" "+linha.getCor());        	  
          }
          public int criarQuadro() throws RemoteException{
        	  int idBoard;
        	  quadro board = new quadro(idQuadro);
        	  idBoard = idQuadro;
        	  idQuadro++;
        	  quadrosQtd++;
        	  quadros.add(board);
        	  return idBoard;
          }
          
          public int entrarQuadro(int idBoard) throws RemoteException {
        	  int idUser;
        	  quadro board = new quadro();
        	  for(int i=0;i < quadrosQtd;i++) {
        		  board = quadros.get(i);
        		  if(board.getIdQuadro() == idBoard) {
        			  idUser = board.entrarQuadro();
        			  return idUser;
        		  }
        	  }
        	  return -1;
          }
          
          public void sairQuadro(int idBoard,int idUser) throws RemoteException {
        	  quadro board = new quadro();
        	  for(int i=0;i < quadrosQtd;i++) {
        		  board = quadros.get(i);
        		  if(board.getIdQuadro() == idBoard) {
        			  board.sairQuadro(idUser);
        			  if(board.getUserQtd() == 0) {
        				  quadros.remove(i);
        				  System.out.println("Deletando Quadro\n");
        				  quadrosQtd--;
        			  }
        		  }
        	  }
          }
          public int getQuadroId(int index) throws RemoteException {
        	  quadro board = quadros.get(index);
        	  return board.getIdQuadro();
          }
          public int getListaQuadroSize() throws RemoteException {
        	  return quadros.size();
          }
          public int getListaLinhasSize(int idQuadro) throws RemoteException {
        	  for(int i=0;i < quadrosQtd;i++) {
        		  quadro board = quadros.get(i);
        		  if(board.getIdQuadro() == idQuadro) {
        			  return board.getSizeofListaLines();
        		  }
        	  }
        	  return 0;
          }
          
          public int getLinhaXstart(int idQuadro, int index) throws RemoteException {
        	  for(int i=0;i < quadrosQtd;i++) {
        		  quadro board = quadros.get(i);
        		  if(board.getIdQuadro() == idQuadro) {
        			  line linha = board.getLine(index);
        			  return linha.getXStart();
        		  }
        	  }
        	  return 0;
          }
          
          public int getLinhaYstart(int idQuadro, int index) throws RemoteException {
        	  for(int i=0;i < quadrosQtd;i++) {
        		  quadro board = quadros.get(i);
        		  if(board.getIdQuadro() == idQuadro) {
        			  line linha = board.getLine(index);
        			  return linha.getYStart();
        		  }
        	  }
        	  return 0;
          }
          
          public int getLinhaXend(int idQuadro, int index) throws RemoteException {
        	  for(int i=0;i < quadrosQtd;i++) {
        		  quadro board = quadros.get(i);
        		  if(board.getIdQuadro() == idQuadro) {
        			  line linha = board.getLine(index);
        			  return linha.getXEnd();
        		  }
        	  }
        	  return 0;
          }
          
          public int getLinhaYend(int idQuadro, int index) throws RemoteException {
        	  for(int i=0;i < quadrosQtd;i++) {
        		  quadro board = quadros.get(i);
        		  if(board.getIdQuadro() == idQuadro) {
        			  line linha = board.getLine(index);
        			  return linha.getYEnd();
        		  }
        	  }
        	  return 0;
          }
          
          public Color getLinhaColor(int idQuadro, int index) throws RemoteException {
        	  for(int i=0;i < quadrosQtd;i++) {
        		  quadro board = quadros.get(i);
        		  if(board.getIdQuadro() == idQuadro) {
        			  line linha = board.getLine(index);
        			  return linha.getCor();
        		  }
        	  }
        	  return null;
          }
}