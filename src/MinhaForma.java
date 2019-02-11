import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public abstract class MinhaForma {
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Paint cor;
	private Stroke traco;
	
	
	public MinhaForma() {
		this(0, 0, 0, 0, Color.BLACK, new BasicStroke());
	}
	
	public MinhaForma(int x1, int y1, int x2, int y2, Paint cor, Stroke traco) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.cor = cor;
		this.traco = traco;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public Paint getCor() {
		return cor;
	}

	public void setCor(Paint cor) {
		this.cor = cor;
	}
	
	public Stroke getTraco() {
		return traco;
	}

	public void setTraco(Stroke traco) {
		this.traco = traco;
	}

	public abstract void desenha(Graphics2D g);
	
	
	
	
}
