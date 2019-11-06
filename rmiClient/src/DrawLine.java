import java.rmi.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;
import java.util.*;

public class DrawLine extends JPanel {
	private Color color = Color.white;
    private MouseHandler mouseHandler = new MouseHandler();
    static int idUser,quadro;
    int index = 0;
    static addInterface hello;
    static Color[] colors = {Color.blue,Color.red,Color.orange,Color.green,Color.black,Color.cyan,Color.magenta,Color.yellow,Color.pink,Color.gray};
    LinesComponent linhas = new LinesComponent();

    
    public DrawLine(addInterface rmi,int idQuadro) {
    	hello = rmi;
    	try {
    	if(idQuadro < 0) {
    		idQuadro = hello.criarQuadro();
			idUser = hello.entrarQuadro(idQuadro);
    	}
    	else {
    		idUser = hello.entrarQuadro(idQuadro);
    	}
    	quadro = idQuadro;
    	}catch (Exception e) {
    		System.out.println("Client exception: " + e);
    	}
    	this.setPreferredSize(new Dimension(580, 580));
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }
    GeneralPath path = new GeneralPath();
    
    private boolean drawing = false;

    public DrawLine() {
        this.setPreferredSize(new Dimension(580, 580));
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
	    
        for(Linha linha : linhas.lines) {
        	g2d.setColor(linha.color);
	        g2d.drawLine(linha.x1, linha.y1, linha.x2, linha.y2);
        	
        	
        }
        /*	g2d.setColor(getColor());
	        g2d.setRenderingHint(
	                RenderingHints.KEY_ANTIALIASING,
	                RenderingHints.VALUE_ANTIALIAS_ON);
	        g2d.setStroke(new BasicStroke(8,
	                BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        if (path!=null) {
            g2d.draw(path);
        }*/
    }
    public Color getColor() {
    	return	color;
    }
    
    public void setColor(Color color) {
    	this.color = color;
    }

    private class MouseHandler extends MouseAdapter {
    	int x=0,y=0,x2=0,y2=0;
        @Override
        public void mousePressed(MouseEvent e) {
            Point p = e.getPoint();
                if(drawing != true) {
                	path.moveTo(p.x, p.y);
                	drawing = true;
                	x = p.x;
                	y = p.y;
                }
                else {
                	path.lineTo(p.x, p.y);
                	drawing = false;
                	x2 = p.x;
                	y2 = p.y;
                	linhas.addLine(x, y, x2, y2, colors[idUser]);
                	try {                	
                	hello.addLinha(x, y, x2, y2, quadro, idUser);
                	refreshPanel(hello, quadro);
                	}catch(Exception er) {
                		System.out.println("Client exception: " + er);
                	}
                }
                repaint();
            }

        }

    public void display(JFrame f) {
    	refreshPanel(hello,quadro);
    	Color cor = line.getUserCor(idUser);
    	setColor(cor);
        f.setTitle("WriteBoard - Quadro");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton b = new JButton("Sair do Quadro");
        b.setPreferredSize(new Dimension(580, 100));
        this.add(b, BorderLayout.NORTH);
        b.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
        	  f.getContentPane().removeAll();
        	  try {
        		  hello.sairQuadro(quadro, idUser);        		  
        	  }catch(Exception er) {
          		System.out.println("Client exception: " + er);
          	}
        	  addClient.tela_inicial(hello,f);
          }
        });
        
        this.setBackground(Color.white); 
        f.add(this);
        f.pack();
        f.setVisible(true);
    }
    
    public void refreshPanel(addInterface hello,int idQuadro) {
    	int listSize;
    	Color corlinha;
    	try {
    		listSize = hello.getListaLinhasSize(idQuadro);
    		for(int i=index; i < listSize; i++) {
    			corlinha = hello.getLinhaColor(idQuadro, i);
    			setColor(corlinha);
    			System.out.println(corlinha);
    			linhas.addLine(hello.getLinhaXstart(idQuadro, i), hello.getLinhaYstart(idQuadro, i), hello.getLinhaXend(idQuadro, i), hello.getLinhaYend(idQuadro, i), corlinha);
    			index++;
    		}
    	}catch(Exception er) {
      		System.out.println("Client exception: " + er);
      	}
    }

}