import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DesenhaFrame extends JFrame{

	private final JButton botaoDesfazer;
	private final JButton botaoLimpar;
	//private final JComboBox<String> listaCores;
	private final JButton botaoPrimeiraCor;
	private final JButton botaoSegundaCor;
	private final JComboBox<String> listaFormas;
	private final JCheckBox preenchido;
	private final JCheckBox gradiente;
	private final JLabel labelTraco;
	private final JTextField fieldTraco;
	private final JLabel labelTamanhoTraco;
	private final JTextField fieldTamanhoTraco;
	private final JCheckBox checkTracado;
	private Color primeiraCor;
	private Color segundaCor;
	
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
		listaFormas = new JComboBox<String>(nomeFormas);
		preenchido = new JCheckBox("Preenchido");
		preenchido.setSelected(true);
		gradiente = new JCheckBox("Usar gradiente");
		botaoPrimeiraCor = new JButton("Primeira Cor");
		botaoSegundaCor = new JButton("Segunda Cor");
		primeiraCor = Color.BLUE;
		segundaCor = Color.GRAY;
		labelTraco = new JLabel("Largura Traço:");
		fieldTraco = new JTextField(3);
		labelTamanhoTraco = new JLabel("Tamanho Traço:");
		fieldTamanhoTraco = new JTextField(3);
		checkTracado = new JCheckBox("Tracejado");
		
		opcoes.add(botaoDesfazer);
		opcoes.add(botaoLimpar);
		opcoes.add(listaFormas);
		opcoes.add(preenchido);
		opcoes.add(gradiente);
		opcoes.add(botaoPrimeiraCor);
		opcoes.add(botaoSegundaCor);
		opcoes.add(labelTraco);
		opcoes.add(fieldTraco);
		opcoes.add(labelTamanhoTraco);
		opcoes.add(fieldTamanhoTraco);
		opcoes.add(checkTracado);
		
		add(opcoes, BorderLayout.NORTH);
		add(desenho, BorderLayout.CENTER);
		add(status, BorderLayout.SOUTH);
		
		desenho.setPreenchido(preenchido.isSelected());
		desenho.setCorAtual(Color.BLUE);
		
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
		
		botaoPrimeiraCor.addActionListener(
				
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						primeiraCor = JColorChooser.showDialog(DesenhaFrame.this, "Escolha uma cor", primeiraCor);
						
						if(primeiraCor == null) {
							primeiraCor = Color.GRAY;
						}
						
						if(gradiente.isSelected()) {
							
							desenho.setCorAtual(new GradientPaint(0, 0, primeiraCor, 50, 50, segundaCor, true));
							
						}else {
							
							desenho.setCorAtual(primeiraCor);
							
						}
						
						

						
					}
					
					
					
				});
		
		botaoSegundaCor.addActionListener(
				
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
												
						
						segundaCor = JColorChooser.showDialog(DesenhaFrame.this, "Escolha uma cor", segundaCor);
						
						if(segundaCor == null) {
							segundaCor = Color.GRAY;
						}
						
						if(gradiente.isSelected()) {
							
							desenho.setCorAtual(new GradientPaint(0, 0, primeiraCor, 50, 50, segundaCor, true));
							
						}else {
							
							desenho.setCorAtual(primeiraCor);
							
						}
						
						
					}
					
					
					
				});
		/*
		listaCores.addItemListener(
				
				new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent arg0) {
						
						desenho.setCorAtual(cores[listaCores.getSelectedIndex()]);
						
					}
					
				}
				
		);
		*/
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
		
		gradiente.addItemListener(
				
				new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {
						
						if(gradiente.isSelected()) {
							
							desenho.setCorAtual(new GradientPaint(0, 0, primeiraCor, 50, 50, segundaCor, true));
							
						}else {
							
							desenho.setCorAtual(primeiraCor);
							
						}
						
					}
					
				}	
				
		);
		
		fieldTraco.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent arg0) {
				
				float tracado[] = new float[1];
				
				if(fieldTamanhoTraco.getText().equals("")) {
					
					tracado[0] = 1;
					
				}else {
					
					tracado[0] = Integer.parseInt(fieldTamanhoTraco.getText());
					
				}
				
				
				if(fieldTraco.getText().equals("")) {
					
					if(checkTracado.isSelected()) {
						
						desenho.setTracoAtual(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, tracado, 0));
							
					}else {
						
						desenho.setTracoAtual(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
						
					}
					
					
				}else {
					
					if(checkTracado.isSelected()) {
						
						desenho.setTracoAtual(new BasicStroke(Integer.parseInt(fieldTraco.getText()), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, tracado, 0));
							
					}else {
						
						desenho.setTracoAtual(new BasicStroke(Integer.parseInt(fieldTraco.getText()), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
						
					}
					
					//desenho.setTracoAtual(new BasicStroke(Integer.parseInt(fieldTraco.getText()), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
					
				}
				
				
			}

		});
		
		fieldTamanhoTraco.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent arg0) {
				
				float tracado[] = new float[1];
				int tamanhoLinha;
				
				if(fieldTamanhoTraco.getText().equals("")) {
					
					tracado[0] = 1;
					
				}else {
					
					tracado[0] = Integer.parseInt(fieldTamanhoTraco.getText());
					
				}
				
				if(fieldTraco.getText().equals("")) {
					
					tamanhoLinha = 1;
					
				}else {
					
					tamanhoLinha = Integer.parseInt(fieldTraco.getText());
					
				}
				
				if(checkTracado.isSelected()) {
					
					
					desenho.setTracoAtual(new BasicStroke(tamanhoLinha, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, tracado, 0));
					
				}
				
				
				
			}

		});

		checkTracado.addItemListener(
				
				new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {
						
						float tracado[] = new float[1];
						int tamanho;
						
						if(fieldTamanhoTraco.getText().equals("")) {
							
							tracado[0] = 1;
							
						}else {
							
							tracado[0] = Integer.parseInt(fieldTamanhoTraco.getText());
							
						}
						
						if(fieldTraco.getText().equals("")) {
							
							tamanho = 1;
							
						}else {
							
							tamanho = Integer.parseInt(fieldTraco.getText());
							
						}
						
						if(checkTracado.isSelected()) {
							
							desenho.setTracoAtual(new BasicStroke(tamanho, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, tracado, 0));
							
						}else {
							
							desenho.setTracoAtual(new BasicStroke(tamanho, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
							
						}
						
					}
					
				}	
				
		);

		
	}
	

	
}
