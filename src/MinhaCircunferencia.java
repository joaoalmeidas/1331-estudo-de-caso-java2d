import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public class MinhaCircunferencia extends MinhaFormaComLimites{
	
	
	public MinhaCircunferencia() {
		this(0, 0, 0, 0, Color.BLACK, new BasicStroke(), false);
	}

	
	public MinhaCircunferencia(int x1, int y1, int x2, int y2, Paint cor, Stroke traco, boolean preenchido) {
		super(x1, y1, x2, y2, cor, traco, preenchido);
	}

	@Override
	public void desenha(Graphics2D g) {
		
		g.setPaint(getCor());
		g.setStroke(getTraco());
		g.drawOval(retornaXCimaEsquerda(), retornaYCimaEsquerda(), retornaAltura(), retornaLargura());
		
		if(isPreenchido() == true) {
			g.fillOval(retornaXCimaEsquerda(), retornaYCimaEsquerda(), retornaAltura(), retornaLargura());
		}
		
	}
		
	
}
