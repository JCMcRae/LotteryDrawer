package com.cystech.lotteryDrawer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import com.cystech.lottery.Lottery;

public class LotteryDrawer {

	protected Shell shell;
	private Text contestant;
	private String error = "Enter A Name";
	private Color opaque = new Color(null, 0,0,0,0);
	private Button select;
	private Label num;
	private Label title;
	private Label winner;
	private Lottery lottery = new Lottery();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LotteryDrawer window = new LotteryDrawer();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
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
		shell = new Shell();
		shell.setSize(400, 300);
		shell.setText("CYS Lottery");
		
		Label contName = new Label(shell, SWT.NONE);
		contName.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		contName.setBounds(10, 201, 125, 20);
		contName.setText("Contestant Name:");
		contName.setBackground(opaque);
		
		contestant = new Text(shell, SWT.NONE);
		contestant.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		contestant.setBounds(144, 201, 230, 20);
		contestant.setBackground(opaque);
		
		Button add = new Button(shell, SWT.NONE);
		add.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		add.setBounds(10, 227, 60, 25);
		add.setText("Add");
		add.setBackground(opaque);
		
		select = new Button(shell, SWT.NONE);
		select.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		select.setBounds(76, 227, 60, 25);
		select.setText("Select");
		select.setBackground(opaque);
		
		num = new Label(shell, SWT.NONE);
		num.setBounds(254, 227, 120, 15);
		num.setText(lottery.size() + " Contestants Entered");
		
		title = new Label(shell, SWT.NONE);
		title.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		title.setAlignment(SWT.CENTER);
		title.setBounds(10, 10, 364, 20);
		title.setText("CYS LOTTERY");
		title.setBackground(opaque);
		
		winner = new Label(shell, SWT.CENTER);
		winner.setFont(SWTResourceManager.getFont("Segoe UI", 40, SWT.NORMAL));
		winner.setBounds(10, 42, 364, 150);
		winner.setBackground(opaque);
		
		add.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(contestant.getText().isEmpty()){
					contestant.setText(error);
				}else{
					String name = contestant.getText();
					lottery.add(name);
					num.setText(lottery.size() + " Contestants Entered");
					contestant.setText("");
				}
			}
			
		});
		
		select.addSelectionListener(new SelectionListener(){


			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				winner.setText(lottery.choose());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});

	}
}
