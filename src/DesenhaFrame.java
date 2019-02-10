import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DesenhaFrame extends JFrame{

	private final JButton botaoDesfazer;
	private final JButton botaoLimpar;
	private final JComboBox<String> listaCores;
	private final JComboBox<String> listaFormas;
	private final JCheckBox preenchido;
	
	private static final String[] nomeCores = {"Azul", "Vermelho", "Verde", "Branco", "Preto", "Amarelo", "Rosa", "Magenta", "Cinza",
			"Laranja", "Cinza Escuro", "Cinza Claro", "Ciano"};
	
	private static final Color[] cores = {Color.BLUE, Color.RED, Color.GREEN, Color.WHITE, Color.BLACK, Color.YELLOW, Color.PINK, Color.MAGENTA, 
			Color.GRAY, Color.ORANGE, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.CYAN};
	
	private static final String[] nomeFormas = {"Circunferência", "Quadrado", "Linha"};
	
	public DesenhaFrame() {
		
		super("Desenho Java");
		setLayout(new BorderLayout());
		
		JLabel status = new JLabel("Desenho");
		DesenhaPanel desenho = new DesenhaPanel(status);
		
		JPanel opcoes = new JPanel();
		opcoes.setLayout(new FlowLayout());
		
		botaoDesfazer = new JButton("Desfazer");
		botaoLimpar = new JButton("Limpar");
		listaCores = new JComboBox<String>(nomeCores);
		listaFormas = new JComboBox<String>(nomeFormas);
		preenchido = new JCheckBox("Preenchido");
		preenchido.setSelected(true);
		
		opcoes.add(botaoDesfazer);
		opcoes.add(botaoLimpar);
		opcoes.add(listaCores);
		opcoes.add(listaFormas);
		opcoes.add(preenchido);
		
		add(opcoes, BorderLayout.NORTH);
		add(desenho, BorderLayout.CENTER);
		add(status, BorderLayout.SOUTH);
		
		desenho.setPreenchido(preenchido.isSelected());
		desenho.setCorAtual(cores[listaCores.getSelectedIndex()]);
		
		if(listaFormas.getSelectedItem().toString().equals("Circunferência")) {
			
			desenho.setFormaAtual(new MinhaCircunferencia());
			
		}else if(listaFormas.getSelectedItem().toString().equals("Quadrado")) {
			
			desenho.setFormaAtual(new MeuRetangulo());
			
		}else if(listaFormas.getSelectedItem().toString().equals("Linha")) {
			
			desenho.setFormaAtual(new MinhaLinha());
			
		}
		
		botaoDesfazer.addActionListener(
				
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						desenho.limpaUltimaForma();
						
					}
					
				}
				
		);
		
		botaoLimpar.addActionListener(
				
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						desenho.limpaDesenho();
						
					}
					
				}
				
		);
		
		listaCores.addItemListener(
				
				new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent arg0) {
						
						desenho.setCorAtual(cores[listaCores.getSelectedIndex()]);
						
					}
					
				}
				
		);
		
		listaFormas.addItemListener(
				
				new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent arg0) {
						
						if(listaFormas.getSelectedIndex() == 0) {
							
							desenho.setFormaAtual(new MinhaCircunferencia());
							
						}else if(listaFormas.getSelectedIndex() == 1) {
							
							desenho.setFormaAtual(new MeuRetangulo());
							
						}else if(listaFormas.getSelectedIndex() == 2) {
							
							desenho.setFormaAtual(new MinhaLinha());
							
						}
						
					}
					
				}
				
		);
		
		preenchido.addItemListener(
		
				new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {
						
						if(preenchido.isSelected()) {
							
							desenho.setPreenchido(true);
							
						}else {
							
							desenho.setPreenchido(false);
							
						}
						
					}
					
				}	
				
		);
		

		

		
	}
	

	
}
