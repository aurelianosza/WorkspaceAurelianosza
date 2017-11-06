package org.eclipse.wb.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import ListaDuplamente.No;

import org.eclipse.swt.widgets.List;

public class JTelaInicial {
	
	private List list;
	protected Shell shell;
	private JTelaInicialController controller;
	private ModelPrincipal model;
	private Button btnAdicionaItem;
	private Button btnNewButton_2;
	private Button btnNewButton;

	public JTelaInicial() {
		this.setModel(new ModelPrincipal(this));
		this.setController(new JTelaInicialController(model,this));
		//System.out.println("abriu");
		this.open();
	}
	
	public Button getButtonImprimier() {
		return this.btnNewButton;
	}
	
	public Button getButtonGerenciar() {
		return this.btnNewButton_2;
	}
	
	public Button getButtonAdicionar() {
		return this.btnAdicionaItem;
	}
	
	public List getList() {
		return this.list;
	}
	
	public JTelaInicialController getController() {
		return controller;
	}

	public void setController(JTelaInicialController controller) {
		this.controller = controller;
	}

	public ModelPrincipal getModel() {
		return model;
	}

	public void setModel(ModelPrincipal model) {
		this.model = model;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
/*	public static void main(String[] args) {
		try {
			JTelaInicial window = new JTelaInicial();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		shell = new Shell(display, SWT.CLOSE);
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell.setSize(820, 520);
		shell.setText("SWT Application");
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmArquivo = new MenuItem(menu, SWT.CASCADE);
		mntmArquivo.setText("Arquivo");
		
		Menu menu_1 = new Menu(mntmArquivo);
		mntmArquivo.setMenu(menu_1);
		
		MenuItem mntmNovoItem = new MenuItem(menu_1, SWT.NONE);
		mntmNovoItem.setText("Novo Item");
		
		MenuItem mntmEnviarItens = new MenuItem(menu_1, SWT.NONE);
		mntmEnviarItens.setText("Enviar Itens");
		
		btnAdicionaItem = new Button(shell, SWT.NONE);
		btnAdicionaItem.setImage(SWTResourceManager.getImage("C:\\Users\\souza\\eclipse-workspace\\TrabalhoDeEd\\src\\Sem t\u00EDtulo.png"));
		btnAdicionaItem.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		btnAdicionaItem.setBounds(546, 393, 121, 68);
		btnAdicionaItem.setText("Adiciona Item");
		
		Button btnRemover = new Button(shell, SWT.NONE);
		btnRemover.setImage(SWTResourceManager.getImage("C:\\Users\\souza\\eclipse-workspace\\TrabalhoDeEd\\src\\remover.png"));
		btnRemover.setBounds(677, 393, 115, 68);
		btnRemover.setText("Remover");
		
		list = new List(shell, SWT.BORDER);
		list.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		list.setBounds(10, 10, 513, 451);
		
		btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setBounds(546, 10, 246, 73);
		btnNewButton_2.setText("Gerenciar Encomendas");
		btnNewButton_2.setEnabled(false);
		
		btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(546, 111, 246, 68);
		btnNewButton.setText("Imprimir relatorio");
		btnNewButton.setEnabled(false);
		
		SelectionAdapter selection = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				controller.setEvent(event);
			}
		};
		
		btnNewButton.addSelectionListener(selection);
		btnAdicionaItem.addSelectionListener(selection);
		btnNewButton_2.addSelectionListener(selection);
	}

	public void bloquear() {
		this.shell.setEnabled(false);
	}
	
	public void desbloquear() {
		this.shell.setEnabled(true);
	}
	
	public void update() {
		this.btnNewButton_2.setEnabled(this.model.getListaDeDocumentos().size() > 0 ? true : false);
		this.btnNewButton.setEnabled(this.model.getHeap().getTamanho() > 0 ? true : false);
		this.list.removeAll();
		No no = this.model.getListaDeDocumentos().getInicio();
		while(no != null) {
			this.list.add(no.getInformacao().toString());
			no = no.getProximo();
		}
	}
}
