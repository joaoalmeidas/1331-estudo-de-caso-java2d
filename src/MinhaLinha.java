import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public class MinhaLinha extends MinhaForma {
	

	
	public MinhaLinha() {
		this(0, 0, 0, 0, Color.BLACK, new BasicStroke());
	}

	public MinhaLinha(int x1, int y1, int x2, int y2, Paint cor, Stroke traco) {
		
		super(x1, y1, x2, y2, cor, traco);

	}
	
	public void desenha(Graphics2D g) {
		
		g.setPaint(getCor());
		g.setStroke(getTraco());
		g.drawLine(getX1(), getY1(), getX2(), getY2());
		
	}
	

	

}
