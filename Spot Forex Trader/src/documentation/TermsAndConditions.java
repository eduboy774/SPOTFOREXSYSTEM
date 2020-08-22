package documentation;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TermsAndConditions extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TermsAndConditions frame = new TermsAndConditions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TermsAndConditions() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
		);
		
		JLabel lblT = new JLabel("TERMS AND CONDITIONS OF USE");
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setFont(new Font("Calibri", Font.BOLD, 14));
		scrollPane.setColumnHeaderView(lblT);
		
		JTextPane txtpnRiskingLittle = new JTextPane();
		txtpnRiskingLittle.setText("(1) Risking little money apart from what is recommended may result to losing all of what you invest.\r\n\r\n(2) All deposits must be done through banking system using provided company account number, apart from that our company wont be responsible for any thing that may happen to you if you deposit somewhere else.\r\n\r\n(3) Once you deposit your money into our account, it can't be credit back to you until year round of your investment is complete.");
		scrollPane.setViewportView(txtpnRiskingLittle);
		contentPane.setLayout(gl_contentPane);
	}
}
