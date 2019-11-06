    import java.rmi.*;
    import java.util.*;
    import java.awt.event.*; 
    import java.awt.*; 
    import javax.swing.*;
    import javax.swing.event.ListSelectionEvent;
    import javax.swing.event.ListSelectionListener;
     
    public class addClient extends JFrame{
    	public static void main (String[] args) {
    		JFrame f = new JFrame("WriteBoard");
    		Scanner input = new Scanner(System.in);
    		addInterface hello;
    		System.out.println("Digite o IP do servidor: ");
    		String ip = input.next();
    		System.out.println("Digite a porta do servidor: ");
    		String port = input.next();
    		try {
    			hello = (addInterface)Naming.lookup("rmi://"+ip+"/"+port);
    			tela_inicial(hello,f);
    		}catch (Exception e) {
    			System.out.println("Client exception: " + e);
    		}
    		input.close();
    	}
    	
    	static public void tela_inicial(addInterface hello, JFrame f) {
    		
    		f.setTitle("WriteBoard");
    		JButton b, b1;
    		JPanel p = new JPanel(new BorderLayout());     	       
    		b = new JButton("Criar Quadro"); 
    		b.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent e)
    			{
    				
    				f.getContentPane().removeAll();
    				DrawLine rc = new DrawLine(hello, -1);
    				rc.display(f);    	        	  
    			}
    		});
    		
    		b1 = new JButton("Listar Quadro"); 
    		b1.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent e)
    			{
    				f.getContentPane().removeAll();
    				lista_telas(hello, f);    				
    			}
    		});
    		
    		b.setPreferredSize(new Dimension(600, 280));
    		b1.setPreferredSize(new Dimension(600, 280));
    		p.add(b, BorderLayout.NORTH); 
    		p.add(b1, BorderLayout.SOUTH);  
    		
    		p.setBackground(Color.white); 
    		
    		f.add(p);     	  
    		f.setSize(600, 600); 
    		f.setVisible(true);
    		
    	}
    	static public void lista_telas(addInterface hello, JFrame f) {
    		try {
    			DefaultListModel lista = new DefaultListModel();
    			JPanel p =new JPanel();
    			JList list;
    			int id;
    			for(int i = 0; i < hello.getListaQuadroSize(); i++) {
    				id = hello.getQuadroId(i);
    				lista.addElement((String)"Quadro "+id);
    			}
    			JButton b = new JButton("Sair da Listagem");
    	        b.setPreferredSize(new Dimension(580, 100));
    	        p.add(b, BorderLayout.NORTH);
    	        b.addActionListener(new ActionListener()
    	        {
    	          public void actionPerformed(ActionEvent e)
    	          {
    	        	  f.getContentPane().removeAll();
    	        	  tela_inicial(hello,f);
    	          }
    	        });
    	        
    	        JLabel l= new JLabel("Selecione o quadro");
    	        list = new JList();
    	        list.setModel(lista);
    	        
    	        list.addListSelectionListener(new ListSelectionListener() {
    	            public void valueChanged(ListSelectionEvent evt) {
    	              if (evt.getValueIsAdjusting())
    	                return;
    	              int index = list.getSelectedIndex();
    	              if (index != -1) {
    	            	    System.out.print(index + "\n");
    	            	    f.getContentPane().removeAll();
    	    				int id = getIdOnList(hello,index);
    	    				DrawLine rc = new DrawLine(hello, id);
    	        				rc.display(f);
    	            	}
    	             
    	            }
    	          });
    	        
    	        p.add(l);
    	        p.add(list); 
    	        
    	        f.add(p); 
    	          
    	        f.setVisible(true);
    		}catch (Exception e) {
    			System.out.println("Client exception: " + e);
    		}
    		
    	}
    	
    	static public int getIdOnList(addInterface hello,int index) {
			try {
				int id = hello.getQuadroId(index);
				return id;
			}catch (Exception e) {
    			System.out.println("Client exception: " + e);
    		}
			return -2;
    	}
    			/*int choice = 9;
    	  			
    		
    			while(choice != 3) {
    				System.out.println("Digite a acao desejada:\n 1: printar soma\n 2: printar subtracao\n 3: sair\n  4: Criar Quadro\n 5: Entrar Quadro\n Opcao: \n");
    				choice = input.nextInt();
    				if(choice == 1) {
    					int result=hello.addn(9,10);
    					System.out.println("Result is :"+result);    					
    				}
    				else if(choice == 2) {
    					int result = hello.minus(2, 3);
    					System.out.println("Result is :"+result);    					
    				}
    				else if(choice == 4|| choice == 5) {
    					if(choice == 4) {
    						idQuadro = hello.criarQuadro();
    						idUser = hello.entrarQuadro(idQuadro);
    					}
    					else {
    						System.out.println("Digite o ID do quadro desejado: ");
    						idQuadro = input.nextInt();
    						idUser = hello.entrarQuadro(idQuadro);    						
    					}
    					
    					if(idUser >= 0) {
    						int choiceBoard = 0;
    						while(choiceBoard != 2) {
    							System.out.println("Digite a acao desejada:\n 1: Desenhar nova linha\n 2: Sair do quadro");
    							choiceBoard = input.nextInt();
    							if(choiceBoard == 1) {
    								System.out.println("Digite os valores de X1 Y1 X2 Y2 respectivos: \n");
    								int x1 = input.nextInt();
    								int y1 = input.nextInt();
    								int x2 = input.nextInt();
    								int y2 = input.nextInt();
    								hello.addLinha(x1, y1, x2, y2, idQuadro, idUser);
    							}
    							else if(choiceBoard == 2) {
    								hello.sairQuadro(idQuadro,idUser);
    							}
    						}
    					}
    					else System.out.println("Quadro Inexistente!!!\n");
    				}
    				
    			}*/
    	}