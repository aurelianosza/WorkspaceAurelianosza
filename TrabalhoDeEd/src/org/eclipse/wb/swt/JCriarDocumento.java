package org.eclipse.wb.swt;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import ListaDuplamente.Lista;
import ListaDuplamente.No;
import Projeto.DocumentoDeProcesso;
import Projeto.DocumentoDeProcesso.TipoDaEncomendaEnum;
import Projeto.Pessoa;
import Projeto.Tools;

import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Spinner;

public class JCriarDocumento {

	private Shell shell;
	private Text textNomeDoRemetente;
	private Text textEndereco1Remetente;
	private Text textEndereco2Remetente;
	private Text textDddTelefoneRemetente;
	private Text textTelefoneRemetente;
	private Text textCep2Remetente;
	private Text textCep1Remetente;
	private Text textObservacoesRemetente;
	private Text textCidadeRemetente;
	private Text textNomeDoReceptor;
	private Text texteEndereco1Receptor;
	private Text txtEndereco2Receptor;
	private Text textDddTelefoneReceptor;
	private Text textTelefoneReceptor;
	private Text textCep2Receptor;
	private Text textCep1Receptor;
	private Text textObservacoesReceptor;
	private Text textCidadeReceptor;
	private Text textLarguraEncomneda;
	private Text textComprimentoEncomenda;
	private Text textAlturaEncomenda;
	private Text textObservacoesEncomenda;
	private Label lblCubagemEncomenda;
	private JCriarDocumentoController controller;
	private Button btnEncomendaSimples;
	private Button btnEncomendaExpressa;
	private Label lblEncomendaN;
	private ModelCriarDocumento model;
	private ModelPrincipal modelPrincipal;
	private List listaDeObservacoes;
	private Text textPesoEncomenda;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	/*
	 * public static void main(String[] args) { try { JCriarDocumento window = new
	 * JCriarDocumento(); window.open(); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */

	public JCriarDocumento(ModelPrincipal modelPrincipal) {
		this.modelPrincipal = modelPrincipal;
		this.modelPrincipal.getViewInicial().bloquear();
		this.model = new ModelCriarDocumento(this);
		this.controller = new JCriarDocumentoController(this, this.model);
		this.open();
	}

	public void open() {
		Display display = Display.getDefault();
		shell = new Shell(display, SWT.NONE);
		shell.setLayout(null);
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		shell.setBounds((int) ((dimension.getWidth() / 2) - 360), ((int) ((dimension.getHeight() / 2) - 240)), 720,
				480);

		lblEncomendaN = new Label(shell, SWT.HORIZONTAL | SWT.SHADOW_NONE);
		lblEncomendaN.setBounds(10, 23, 279, 33);
		lblEncomendaN.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblEncomendaN.setAlignment(SWT.CENTER);
		lblEncomendaN.setText("Encomenda n\u00B0 : " + DocumentoDeProcesso.geraCodigo());

		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setBounds(10, 79, 695, 350);

		TabItem tbtmDadosDoRemetente = new TabItem(tabFolder, SWT.NONE);
		tbtmDadosDoRemetente.setText("Dados do Remetente");

		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmDadosDoRemetente.setControl(composite);

		Label label = new Label(composite, SWT.NONE);
		label.setText("Nome\r\n");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		label.setBounds(10, 10, 140, 26);

		textNomeDoRemetente = new Text(composite, SWT.BORDER);
		textNomeDoRemetente.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		textNomeDoRemetente.setBounds(10, 42, 331, 31);

		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setText("Endere\u00E7o (linha 1)");
		label_1.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		label_1.setBounds(356, 10, 140, 26);

		textEndereco1Remetente = new Text(composite, SWT.BORDER);
		textEndereco1Remetente.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		textEndereco1Remetente.setBounds(356, 42, 321, 31);

		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setText("Endere\u00E7o (linha 2)");
		label_2.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		label_2.setBounds(356, 91, 140, 21);

		textEndereco2Remetente = new Text(composite, SWT.BORDER);
		textEndereco2Remetente.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		textEndereco2Remetente.setBounds(356, 118, 321, 31);

		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setText("Telefone");
		label_3.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		label_3.setBounds(78, 79, 81, 21);

		textDddTelefoneRemetente = new Text(composite, SWT.BORDER);
		textDddTelefoneRemetente.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		textDddTelefoneRemetente.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		textDddTelefoneRemetente.setBounds(10, 102, 48, 31);

		textTelefoneRemetente = new Text(composite, SWT.BORDER);
		textTelefoneRemetente.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		textTelefoneRemetente.setBounds(78, 102, 263, 31);

		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setText("DDD");
		label_4.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		label_4.setBounds(10, 79, 48, 21);

		Label label_5 = new Label(composite, SWT.NONE);
		label_5.setText("CEP");
		label_5.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		label_5.setBounds(356, 241, 140, 26);

		textCep2Remetente = new Text(composite, SWT.BORDER);
		textCep2Remetente.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		textCep2Remetente.setBounds(613, 268, 64, 31);

		Label label_6 = new Label(composite, SWT.NONE);
		label_6.setText("-");
		label_6.setFont(SWTResourceManager.getFont("Segoe UI", 25, SWT.NORMAL));
		label_6.setBounds(591, 258, 22, 31);

		textCep1Remetente = new Text(composite, SWT.BORDER);
		textCep1Remetente.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		textCep1Remetente.setBounds(356, 268, 227, 31);

		Label label_7 = new Label(composite, SWT.NONE);
		label_7.setText("Observa\u00E7\u00F5es");
		label_7.setBounds(10, 139, 81, 15);

		textObservacoesRemetente = new Text(composite, SWT.BORDER | SWT.MULTI);
		textObservacoesRemetente.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		textObservacoesRemetente.setBounds(10, 160, 331, 152);

		Label lblCidade = new Label(composite, SWT.NONE);
		lblCidade.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblCidade.setBounds(356, 155, 81, 26);
		lblCidade.setText("Cidade");

		textCidadeRemetente = new Text(composite, SWT.BORDER);
		textCidadeRemetente.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		textCidadeRemetente.setBounds(356, 191, 316, 31);
		composite.setTabList(new Control[] { textNomeDoRemetente, textDddTelefoneRemetente, textTelefoneRemetente,
				textObservacoesRemetente, textEndereco1Remetente, textEndereco2Remetente, textCidadeRemetente,
				textCep1Remetente, textCep2Remetente });

		TabItem tbtmDadosDoReceptor = new TabItem(tabFolder, SWT.NONE);
		tbtmDadosDoReceptor.setText("Dados do Receptor");

		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmDadosDoReceptor.setControl(composite_1);

		Label label_8 = new Label(composite_1, SWT.NONE);
		label_8.setText("Nome\r\n");
		label_8.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		label_8.setBounds(10, 10, 140, 26);

		textNomeDoReceptor = new Text(composite_1, SWT.BORDER);
		textNomeDoReceptor.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		textNomeDoReceptor.setBounds(10, 42, 331, 31);

		Label label_9 = new Label(composite_1, SWT.NONE);
		label_9.setText("Endere\u00E7o (linha 1)");
		label_9.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		label_9.setBounds(356, 10, 140, 26);

		texteEndereco1Receptor = new Text(composite_1, SWT.BORDER);
		texteEndereco1Receptor.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		texteEndereco1Receptor.setBounds(356, 42, 321, 31);

		Label label_10 = new Label(composite_1, SWT.NONE);
		label_10.setText("Endere\u00E7o (linha 2)");
		label_10.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		label_10.setBounds(356, 91, 140, 21);

		txtEndereco2Receptor = new Text(composite_1, SWT.BORDER);
		txtEndereco2Receptor.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		txtEndereco2Receptor.setBounds(356, 118, 321, 31);

		Label label_11 = new Label(composite_1, SWT.NONE);
		label_11.setText("Telefone");
		label_11.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		label_11.setBounds(78, 79, 81, 21);

		textDddTelefoneReceptor = new Text(composite_1, SWT.BORDER);
		textDddTelefoneReceptor.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		textDddTelefoneReceptor.setBounds(10, 102, 48, 31);

		textTelefoneReceptor = new Text(composite_1, SWT.BORDER);
		textTelefoneReceptor.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		textTelefoneReceptor.setBounds(78, 102, 263, 31);

		Label label_12 = new Label(composite_1, SWT.NONE);
		label_12.setText("DDD");
		label_12.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		label_12.setBounds(10, 79, 48, 21);

		Label label_13 = new Label(composite_1, SWT.NONE);
		label_13.setText("CEP");
		label_13.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		label_13.setBounds(356, 241, 140, 26);

		textCep2Receptor = new Text(composite_1, SWT.BORDER);
		textCep2Receptor.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		textCep2Receptor.setBounds(613, 268, 64, 31);

		Label label_14 = new Label(composite_1, SWT.NONE);
		label_14.setText("-");
		label_14.setFont(SWTResourceManager.getFont("Segoe UI", 25, SWT.NORMAL));
		label_14.setBounds(591, 258, 22, 31);

		textCep1Receptor = new Text(composite_1, SWT.BORDER);
		textCep1Receptor.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		textCep1Receptor.setBounds(356, 268, 227, 31);

		Label label_15 = new Label(composite_1, SWT.NONE);
		label_15.setText("Observa\u00E7\u00F5es");
		label_15.setBounds(10, 139, 81, 15);

		textObservacoesReceptor = new Text(composite_1, SWT.BORDER | SWT.MULTI);
		textObservacoesReceptor.setBounds(10, 160, 331, 152);

		Label label_16 = new Label(composite_1, SWT.NONE);
		label_16.setText("Cidade");
		label_16.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		label_16.setBounds(356, 155, 81, 26);

		textCidadeReceptor = new Text(composite_1, SWT.BORDER);
		textCidadeReceptor.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		textCidadeReceptor.setBounds(356, 191, 316, 31);
		composite_1.setTabList(new Control[] { textNomeDoReceptor, textDddTelefoneReceptor, textTelefoneReceptor,
				textObservacoesReceptor, texteEndereco1Receptor, txtEndereco2Receptor, textCidadeReceptor,
				textCep1Receptor, textCep2Receptor });

		TabItem tbtmDadosDaEncomenda = new TabItem(tabFolder, SWT.NONE);
		tbtmDadosDaEncomenda.setText("Dados da Encomenda\r\n");

		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		tbtmDadosDaEncomenda.setControl(composite_2);

		Label label_17 = new Label(composite_2, SWT.NONE);
		label_17.setText("Peso (g)");
		label_17.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		label_17.setBounds(10, 10, 88, 24);

		Label label_18 = new Label(composite_2, SWT.NONE);
		label_18.setText("Largura (cm)");
		label_18.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		label_18.setBounds(10, 144, 112, 24);

		textLarguraEncomneda = new Text(composite_2, SWT.BORDER);
		textLarguraEncomneda.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		textLarguraEncomneda.setBounds(10, 174, 88, 31);

		Label label_19 = new Label(composite_2, SWT.NONE);
		label_19.setText("Altura (cm)");
		label_19.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		label_19.setBounds(10, 77, 112, 24);

		Label label_20 = new Label(composite_2, SWT.NONE);
		label_20.setText("Comprimento (cm)");
		label_20.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		label_20.setBounds(10, 211, 158, 24);

		textComprimentoEncomenda = new Text(composite_2, SWT.BORDER);
		textComprimentoEncomenda.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		textComprimentoEncomenda.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		textComprimentoEncomenda.setBounds(10, 241, 88, 31);

		textAlturaEncomenda = new Text(composite_2, SWT.BORDER);
		textAlturaEncomenda.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		textAlturaEncomenda.setBounds(10, 107, 88, 31);

		Label lblCubagemkgm = new Label(composite_2, SWT.NONE);
		lblCubagemkgm.setText("Cubagem (Kg/m3)\r\n");
		lblCubagemkgm.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblCubagemkgm.setBounds(221, 10, 164, 24);

		lblCubagemEncomenda = new Label(composite_2, SWT.CENTER);
		lblCubagemEncomenda.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblCubagemEncomenda.setBounds(230, 37, 138, 41);
		lblCubagemEncomenda.setText("0.00");

		Label lblObservaes = new Label(composite_2, SWT.NONE);
		lblObservaes.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblObservaes.setBounds(455, 10, 122, 22);
		lblObservaes.setText("Observa\u00E7\u00F5es");

		textObservacoesEncomenda = new Text(composite_2, SWT.BORDER);
		textObservacoesEncomenda.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		textObservacoesEncomenda.setBounds(452, 38, 225, 31);

		Button btnAdicionarObservacoesEncomenda = new Button(composite_2, SWT.NONE);
		btnAdicionarObservacoesEncomenda.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		btnAdicionarObservacoesEncomenda.setBounds(455, 76, 138, 41);
		btnAdicionarObservacoesEncomenda.setText("Adicionar");

		Composite composite_3 = new Composite(composite_2, SWT.NONE);
		composite_3.setBounds(230, 194, 138, 78);

		btnEncomendaSimples = new Button(composite_3, SWT.RADIO);
		btnEncomendaSimples.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		btnEncomendaSimples.setBounds(10, 10, 103, 22);
		btnEncomendaSimples.setSelection(true);
		btnEncomendaSimples.setText("Simples");

		Button btnEncomendaExpressa = new Button(composite_3, SWT.RADIO);
		btnEncomendaExpressa.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		btnEncomendaExpressa.setBounds(10, 38, 103, 25);
		btnEncomendaExpressa.setText("Expressa");

		Label lblTipoDeEncomenda = new Label(composite_2, SWT.NONE);
		lblTipoDeEncomenda.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblTipoDeEncomenda.setBounds(221, 157, 178, 24);
		lblTipoDeEncomenda.setText("Tipo de encomenda");

		listaDeObservacoes = new List(composite_2, SWT.BORDER | SWT.V_SCROLL);
		listaDeObservacoes.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		listaDeObservacoes.setBounds(455, 123, 222, 189);

		textPesoEncomenda = new Text(composite_2, SWT.BORDER);
		textPesoEncomenda.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		textPesoEncomenda.setBounds(10, 37, 88, 34);
		composite_2.setTabList(new Control[] { textAlturaEncomenda, textLarguraEncomneda, textComprimentoEncomenda,
				textObservacoesEncomenda, btnAdicionarObservacoesEncomenda });

		Button btnCancelar = new Button(shell, SWT.NONE);
		btnCancelar.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnCancelar.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnCancelar.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		btnCancelar.setBounds(555, 435, 150, 35);
		btnCancelar.setText("Cancelar");

		Button btnConfirmar = new Button(shell, SWT.NONE);
		btnConfirmar.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnConfirmar.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnConfirmar.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btnConfirmar.setBounds(399, 435, 150, 35);
		btnConfirmar.setText("CRIAR");

		org.eclipse.swt.events.KeyAdapter key = new org.eclipse.swt.events.KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				controller.keyPressed(event);
			}
		};
		
		
		textAlturaEncomenda.addKeyListener(key);
		textComprimentoEncomenda.addKeyListener(key);
		textLarguraEncomneda.addKeyListener(key);
		
		SelectionAdapter selection = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				controller.setEvent(event);
			}
		};
		
		textAlturaEncomenda.addSelectionListener(selection);
		textComprimentoEncomenda.addSelectionListener(selection);
		textLarguraEncomneda.addSelectionListener(selection);

		btnAdicionarObservacoesEncomenda.addSelectionListener(selection);
		btnCancelar.addSelectionListener(selection);
		btnConfirmar.addSelectionListener(selection);

	}

	public ModelPrincipal getModelPrincipal() {
		return this.modelPrincipal;
	}

	public Shell getShell() {
		return this.shell;
	}

	public Text getTextNomeDoRemetente() {
		return textNomeDoRemetente;
	}

	public void setTextNomeDoRemetente(Text textNomeDoRemetente) {
		this.textNomeDoRemetente = textNomeDoRemetente;
	}

	public Text getTextEndereco1Remetente() {
		return textEndereco1Remetente;
	}

	public void setTextEndereco1Remetente(Text textEndereco1Remetente) {
		this.textEndereco1Remetente = textEndereco1Remetente;
	}

	public Text getTextEndereco2Remetente() {
		return textEndereco2Remetente;
	}

	public void setTextEndereco2Remetente(Text textEndereco2Remetente) {
		this.textEndereco2Remetente = textEndereco2Remetente;
	}

	public Text getTextDddTelefoneRemetente() {
		return textDddTelefoneRemetente;
	}

	public void setTextDddTelefoneRemetente(Text textDddTelefoneRemetente) {
		this.textDddTelefoneRemetente = textDddTelefoneRemetente;
	}

	public Text getTextTelefoneRemetente() {
		return textTelefoneRemetente;
	}

	public void setTextTelefoneRemetente(Text textTelefoneRemetente) {
		this.textTelefoneRemetente = textTelefoneRemetente;
	}

	public Text getTextCep2Remetente() {
		return textCep2Remetente;
	}

	public void setTextCep2Remetente(Text textCep2Remetente) {
		this.textCep2Remetente = textCep2Remetente;
	}

	public Text getTextCep1Remetente() {
		return textCep1Remetente;
	}

	public void setTextCep1Remetente(Text textCep1Remetente) {
		this.textCep1Remetente = textCep1Remetente;
	}

	public Text getTextObservacoesRemetente() {
		return textObservacoesRemetente;
	}

	public void setTextObservacoesRemetente(Text textObservacoesRemetente) {
		this.textObservacoesRemetente = textObservacoesRemetente;
	}

	public Text getTextCidadeRemetente() {
		return textCidadeRemetente;
	}

	public void setTextCidadeRemetente(Text textCidadeRemetente) {
		this.textCidadeRemetente = textCidadeRemetente;
	}

	public Text getTextNomeDoReceptor() {
		return textNomeDoReceptor;
	}

	public void setTextNomeDoReceptor(Text textNomeDoReceptor) {
		this.textNomeDoReceptor = textNomeDoReceptor;
	}

	public Text getTexteEndereco1Receptor() {
		return texteEndereco1Receptor;
	}

	public void setTexteEndereco1Receptor(Text texteEndereco1Receptor) {
		this.texteEndereco1Receptor = texteEndereco1Receptor;
	}

	public Text getTxtEndereco2Receptor() {
		return txtEndereco2Receptor;
	}

	public void setTxtEndereco2Receptor(Text txtEndereco2Receptor) {
		this.txtEndereco2Receptor = txtEndereco2Receptor;
	}

	public Text getTextDddTelefoneReceptor() {
		return textDddTelefoneReceptor;
	}

	public void setTextDddTelefoneReceptor(Text textDddTelefoneReceptor) {
		this.textDddTelefoneReceptor = textDddTelefoneReceptor;
	}

	public Text getTextTelefoneReceptor() {
		return textTelefoneReceptor;
	}

	public void setTextTelefoneReceptor(Text textTelefoneReceptor) {
		this.textTelefoneReceptor = textTelefoneReceptor;
	}

	public Text getTextCep2Receptor() {
		return textCep2Receptor;
	}

	public void setTextCep2Receptor(Text textCep2Receptor) {
		this.textCep2Receptor = textCep2Receptor;
	}

	public Text getTextCep1Receptor() {
		return textCep1Receptor;
	}

	public void setTextCep1Receptor(Text textCep1Receptor) {
		this.textCep1Receptor = textCep1Receptor;
	}

	public Text getTextObservacoesReceptor() {
		return textObservacoesReceptor;
	}

	public void setTextObservacoesReceptor(Text textObservacoesReceptor) {
		this.textObservacoesReceptor = textObservacoesReceptor;
	}

	public Text getTextCidadeReceptor() {
		return textCidadeReceptor;
	}

	public void setTextCidadeReceptor(Text textCidadeReceptor) {
		this.textCidadeReceptor = textCidadeReceptor;
	}

	public Text getTextPesoEncomenda() {
		return textPesoEncomenda;
	}

	public void setTextPesoEncomenda(Text textPesoEncomenda) {
		this.textPesoEncomenda = textPesoEncomenda;
	}

	public Text getTextLarguraEncomneda() {
		return textLarguraEncomneda;
	}

	public void setTextLarguraEncomneda(Text textLarguraEncomneda) {
		this.textLarguraEncomneda = textLarguraEncomneda;
	}

	public Text getTextComprimentoEncomenda() {
		return textComprimentoEncomenda;
	}

	public void setTextComprimentoEncomenda(Text textComprimentoEncomenda) {
		this.textComprimentoEncomenda = textComprimentoEncomenda;
	}

	public Text getTextAlturaEncomenda() {
		return textAlturaEncomenda;
	}

	public void setTextAlturaEncomenda(Text textAlturaEncomenda) {
		this.textAlturaEncomenda = textAlturaEncomenda;
	}

	public Text getTextObservacoesEncomenda() {
		return textObservacoesEncomenda;
	}

	public void setTextObservacoesEncomenda(Text textObservacoesEncomenda) {
		this.textObservacoesEncomenda = textObservacoesEncomenda;
	}

	public Button getBtnEncomendaSimples() {
		return this.btnEncomendaSimples;
	}

	public Button getBtnEncomendaExpressa() {
		return this.btnEncomendaExpressa;
	}

	public List getListaDeInformacoes() {
		return this.listaDeObservacoes;
	}

	public float getPeso() {
		String peso = this.textPesoEncomenda.getText();
		try {
			return peso == null ? 0 : Integer.parseInt(peso) / 1000;
		}catch (Exception exception) {
			return 0;
		}
		
	}

	private String getCubagem() {
		try {
			String altura = Tools.revomeCaractereLetra(this.getTextAlturaEncomenda().getText());
			String largura = Tools.revomeCaractereLetra(this.getTextLarguraEncomneda().getText());
			String comprimento = Tools.revomeCaractereLetra(this.getTextComprimentoEncomenda().getText());

			return Float.toString(
					(Integer.parseInt(altura)/100) * (Integer.parseInt(comprimento)/100) * (Integer.parseInt(largura)/100) * 300);

		} catch (Exception excecao) {
			return "0";
		}
	}

	public String getNumeroDaEncomenda() {
		String numero = "";
		for (int i = 15; i <= 23; i++) {
			numero = numero + Character.toString((char) this.lblEncomendaN.getText().charAt(i));
		}
		return numero;
	}

	public boolean validar() {
		if (this.getTextNomeDoReceptor().getText() == null || this.getTextNomeDoReceptor().getText().equals(""))
			return false;
		if (this.getTextNomeDoRemetente().getText() == null || this.getTextNomeDoRemetente().getText().equals(""))
			return false;
		if (this.getPeso() < 0)
			return false;
		return true;
	}

	private void limpar() {
		this.getTextAlturaEncomenda().setText("");
		this.getTextCep1Receptor().setText("");
		this.getTextCep1Remetente().setText("");
		this.getTextCep2Receptor().setText("");
		this.getTextCep2Remetente().setText("");
		this.getTextCidadeReceptor().setText("");
		this.getTextCidadeRemetente().setText("");
		this.getTextComprimentoEncomenda().setText("");
		this.getTextDddTelefoneReceptor().setText("");
		this.getTextDddTelefoneRemetente().setText("");
		this.getTexteEndereco1Receptor().setText("");
		this.getTextEndereco1Remetente().setText("");
		this.getTextEndereco2Remetente().setText("");
		this.getTextLarguraEncomneda().setText("");
		this.getTextNomeDoReceptor().setText("");
		this.getTextNomeDoRemetente().setText("");
		this.getTextObservacoesEncomenda().setText("");
		this.getTextPesoEncomenda().setText("");
		this.getTextTelefoneReceptor().setText("");
		this.getTextTelefoneRemetente().setText("");
	}

	public void adicionaInformacao() {
		if (!this.model.getListaDeInformacoes().getInicio().getInformacao().toString().equals(""))
			this.getListaDeInformacoes().add(this.model.getListaDeInformacoes().getInicio().getInformacao().toString());
	}

	public void update() {
		this.lblCubagemEncomenda.setText(this.getCubagem());
	}
}
