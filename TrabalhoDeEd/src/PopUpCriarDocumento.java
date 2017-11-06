import java.awt.Dimension;
import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PopUpCriarDocumento extends Dialog {

	protected Object result;
	protected Shell shell;
	private String mensagem;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public PopUpCriarDocumento(Shell parent, int style, String mensagem) {
		super(parent, SWT.CLOSE);
		setText(mensagem);
		this.mensagem = mensagem;
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.NONE);
		Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();
		shell.setSize(320, 180);
		shell.setText(getText());
		
		Label lblPreenchaTodosOs = new Label(shell, SWT.CLOSE);
		lblPreenchaTodosOs.setAlignment(SWT.CENTER);
		lblPreenchaTodosOs.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblPreenchaTodosOs.setBounds(34, 10, 248, 25);
		lblPreenchaTodosOs.setText(this.mensagem);
		
		Button btnOk = new Button(shell, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		btnOk.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnOk.setBounds(111, 97, 98, 45);
		btnOk.setText("OK");

	}

}
