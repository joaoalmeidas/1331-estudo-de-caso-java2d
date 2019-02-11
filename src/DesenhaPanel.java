import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DesenhaPanel extends JPanel {
	
	private MinhaForma[] formas;
	private int contagemFormas = 0;
	private int tipoForma = 0;
	private MinhaForma formaAtual;
	private Paint corAtual;
	private boolean preenchido;
	private JLabel labelStatus;
	private Stroke tracoAtual;
	
	public DesenhaPanel(JLabel labelStatus) {
		
		this.labelStatus = labelStatus;
		formas = new MinhaForma[100];
		contagemFormas = 0;
		tipoForma = 2;
		formaAtual = null;
		corAtual = Color.BLACK;
		setBackground(Color.WHITE);
		preenchido = true;
		tracoAtual = new BasicStroke();
		EventosMouse eventos = new EventosMouse();
		addMouseListener(eventos);
		addMouseMotionListener(eventos);
	}
	
	
	public MinhaForma[] getFormas() {
		return formas;
	}
	
	
	public void setFormas(MinhaForma[] formas) {
		this.formas = formas;
	}
	
	
	public int getContagemFormas() {
		return contagemFormas;
	}
	
	
	public void setContagemFormas(int contagemFormas) {
		
		if(contagemFormas < 0) {
			
			throw new IllegalArgumentException();
		}
		
		this.contagemFormas = contagemFormas;
	}
	
	
	public int getTipoForma() {
		return tipoForma;
	}
	
	
	public void setTipoForma(int tipoForma) {
		this.tipoForma = tipoForma;
	}
	
	
	public MinhaForma getFormaAtual() {
		return formaAtual;
	}
	
	
	public void setFormaAtual(MinhaForma formaAtual) {
		this.formaAtual = formaAtual;
	}
	
	
	public Paint getCorAtual() {
		return corAtual;
	}
	
	
	public void setCorAtual(Paint corAtual) {
		this.corAtual = corAtual;
	}
	
	
	public boolean isPreenchido() {
		return preenchido;
	}
	
	
	public void setPreenchido(boolean preenchido) {
		this.preenchido = preenchido;
	}
	
	
	public JLabel getLabelStatus() {
		return labelStatus;
	}
	
	
	public void setLabelStatus(JLabel labelStatus) {
		this.labelStatus = labelStatus;
	}
	
	
	public Stroke getTracoAtual() {
		return tracoAtual;
	}


	public void setTracoAtual(Stroke tracoAtual) {
		this.tracoAtual = tracoAtual;
	}


	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);               
		
		for(int i = 0; i < contagemFormas; i++) {
			
			if(getFormas()[i] != null) {
				getFormas()[i].desenha((Graphics2D)arg0);
			}
			
		}
	}
	
	public void limpaUltimaForma() {
		
		setContagemFormas(getContagemFormas() - 1);
		repaint();
		
	}
	
	public void limpaDesenho() {
		
		setContagemFormas(0);
		repaint();
		
	}
	
	
	public class EventosMouse extends MouseAdapter implements MouseMotionListener{
		
		
		
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			super.mouseDragged(e);
			
			
			
			getFormaAtual().setX2(e.getX());
			getFormaAtual().setY2(e.getY());
			
			formaAtual.desenha((Graphics2D)getGraphics());
			
			labelStatus.setText(String.format("%d, %d", e.getX(), e.getY()));
			
			repaint();
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseEntered(e);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseExited(e);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			super.mouseMoved(e);
			
			labelStatus.setText(String.format("%d, %d", e.getX(), e.getY()));
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);
			
			if(getFormaAtual() instanceof MinhaCircunferencia) {
				
				formaAtual = new MinhaCircunferencia(0, 0, 0, 0, (Color) getCorAtual(), getTracoAtual(), isPreenchido());
				setTipoForma(0);
				
			}else if(getFormaAtual() instanceof MeuRetangulo) {
				
				formaAtual = new MeuRetangulo(0, 0, 0, 0, (Color) getCorAtual(), getTracoAtual(), isPreenchido());
				setTipoForma(1);
				
			}else if(getFormaAtual() instanceof MinhaLinha) {
				
				formaAtual = new MinhaLinha(0, 0, 0, 0, (Color)getCorAtual(), getTracoAtual());
				setTipoForma(2);
				
			}else {
				
				if(getTipoForma() == 0) {
					
					formaAtual = new MinhaCircunferencia(0, 0, 0, 0, (Color) getCorAtual(), getTracoAtual(), isPreenchido());
					
				}else if(getTipoForma() == 1) {
					
					formaAtual = new MeuRetangulo(0, 0, 0, 0, (Color) getCorAtual(), getTracoAtual(), isPreenchido());
					
				}else if(getTipoForma() == 2) {
					
					formaAtual = new MinhaLinha(0, 0, 0, 0, (Color)getCorAtual(), getTracoAtual());
					
				}
				
			}
			
			
			getFormaAtual().setX1(e.getX());
			getFormaAtual().setY1(e.getY());
			getFormaAtual().setX2(e.getX());
			getFormaAtual().setY2(e.getY());
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			super.mouseReleased(e);
			
			getFormaAtual().setX2(e.getX());
			getFormaAtual().setY2(e.getY());
			
			getFormas()[contagemFormas] = getFormaAtual();
		
			setContagemFormas(getContagemFormas() + 1);

			setFormaAtual(null);
			
			repaint();
			
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			// TODO Auto-generated method stub
			super.mouseWheelMoved(e);
		}
		
		
		
	}
	
	
	
	
}
