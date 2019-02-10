import java.awt.Color;

public abstract class MinhaFormaComLimites extends MinhaForma {
	
	private boolean preenchido;
	
	public MinhaFormaComLimites() {
		
		this(0, 0, 0, 0, Color.BLACK, false);
		
	}

	public MinhaFormaComLimites(int x1, int y1, int x2, int y2, Color cor, boolean preenchido) {
		super(x1, y1, x2, y2, cor);
		this.preenchido = preenchido;
	}
	
	public int retornaXCimaEsquerda() {
		return getX1() < getX2() ? getX1() : getX2();
	}
	
	public int retornaYCimaEsquerda() {
		return getY1() < getY2() ? getY1() : getY2();
	}
	
	public int retornaAltura() {
		return Math.abs(getX1() - getX2());
	}
	
	public int retornaLargura() {
		return Math.abs(getY1() - getY2());
	}

	public boolean isPreenchido() {
		return preenchido;
	}

	public void setPreenchido(boolean preenchido) {
		this.preenchido = preenchido;
	}
}
