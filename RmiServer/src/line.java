import java.awt.Color;

public class line {
	private int xStart;
	private int xEnd;
	private int yStart;
	private int yEnd;
	private Color cor;
	static Color[] colors = {Color.blue,Color.red,Color.orange,Color.green,Color.black,Color.cyan,Color.magenta,Color.yellow,Color.pink,Color.gray};
	
	public line() {}
	
	public line(int x1,int y1,int x2, int y2, Color color){
		xStart = x1;
		yStart = y1;
		xEnd = x2;
		yEnd = y2;
		cor = color;
	}
	
	public int getXStart() {
		return this.xStart;
	}
	
	public int getYStart() {
		return this.yStart;
	}
	
	public int getXEnd() {
		return this.xEnd;
	}
	
	public int getYEnd() {
		return this.yEnd;
	}
	
	public void setXStart(int x) {
		this.xStart = x;
	}
	
	public void setYStart(int y) {
		this.yStart = y;
	}
	
	public void setXEnd(int x) {
		this.xEnd = x;
	}
	
	public void setYEnd(int y) {
		this.yEnd = y;
	}
	
	static public Color getUserCor(int idUser) {
		return colors[idUser];
	}
	
	public Color getCor() {
		return this.cor;
	}
	
	public void setCor(Color color) {
		this.cor = color;
	}
}
