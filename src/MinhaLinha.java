import java.awt.Color;
import java.awt.Graphics2D;

public class MinhaLinha extends MinhaForma {
	

	
	public MinhaLinha() {
		this(0, 0, 0, 0, Color.BLACK);
	}

	public MinhaLinha(int x1, int y1, int x2, int y2, Color cor) {
		
		super(x1, y1, x2, y2, cor);

	}
	
	public void desenha(Graphics2D g) {
		
		g.setColor(getCor());
		g.drawLine(getX1(), getY1(), getX2(), getY2());
		
	}
	

	

}
