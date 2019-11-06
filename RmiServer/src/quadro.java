import java.util.*;
public class quadro {
	private int idquadro;
	int[] userId = {0,0,0,0,0,0,0,0,0,0};
	int userQtd = 0;
	private LinkedList<line> linhas = new LinkedList<line>();
	
	public quadro() {	}
	
	public quadro(int id) {
		idquadro = id;
	}
	
	public void newLinha(line linha) {
		linhas.add(linha);
	}
	
	public line getLinha(LinkedList<line> linha,int index) {
		line pontos = new line();
		pontos = linha.get(index);
		return pontos;
	}
	
	public int getUserQtd() {
		return this.userQtd;
	}
	
	public int getIdQuadro() {
		return this.idquadro;
	}
	
	public int entrarQuadro() {
		int id;
		if(userQtd < 10) {
			for(int i=0; i<10; i++) {
				if(userId[i] == 0) {
					userId[i] = 1;
					id = i;
					userQtd++;
					return id;
				}			
			}
		}
		return 20;
	}
	
	public void sairQuadro(int id) {
		userId[id] = 0;
		userQtd--;
	}
	
	public int getSizeofListaLines() {
		return this.linhas.size();
	}
	
	public line getLine(int index) {
		return this.linhas.get(index);
	}
}
