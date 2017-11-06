package org.eclipse.wb.swt;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import Heap.Heap;
import Projeto.DocumentoDeProcesso;

import org.eclipse.swt.widgets.List;

public class Jrelatorio {

	protected Shell shell;
	private Heap listaDePrioridade;

	/**
	 * Launch the application.
	 * @param args
	 */
	
	public Jrelatorio(Heap listaDePrioridade) {
		this.listaDePrioridade = listaDePrioridade;
	}
	
	/*
	public static void main(String[] args) {
		try {
			Jrelatorio window = new Jrelatorio();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
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
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		shell.setBounds(((int)dimension.getWidth()/2 - 250), ((int)dimension.getHeight()/2 - 300), 500, 600);
		shell.setText("Relatorio");

		List list = new List(shell, SWT.BORDER);
		list.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		list.setBounds(10, 10, 475, 550);
		while(this.listaDePrioridade.getTamanho() != 0) {
			list.add(((DocumentoDeProcesso)listaDePrioridade.remove()).toString());
		}
	}
}
