package test;

//�������� �۾� â�� ������ �ִ� Ŭ����(JdbcMainFrame)

//SQL API�� ����ϱ� ����
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*; // �������� ���α׷����� �ϱ�����
import javax.swing.table.*; // JTable�� ����ϱ� ����
import javax.swing.text.*;

public class JdbcMainFrame extends JFrame implements ActionListener, MouseListener {
	// �����ͺ��̽� ���ؼ� ������ ������ �ִ� ��ü���� ����
	Connection conn = null;
	
	// Frame���� �Է��� ����� ǥ�����ִ� �Ʒ��� JTable
	// JTable�� �����ϱ� ���� ���� ������ �� ������Ʈ ����
	String data[][] = new String[0][5]; // ������ ���� ����
	String title[] = {"����ȣ", "�̸�", "�ֹι�ȣ", "�̸���", "�޴���", "����", "�ּ�"}; // Ÿ��Ʋ
	
	String data1[][] = new String[0][5];
	String title1[] = {"�����ȣ", "���ȣ", "����ȣ", "���೯¥"};
	
	String data2[][] = new String[0][5];
	String title2[] = {"���ȣ", "���", "�ο�", "�������"};
	
	// JTable�� ����ϸ� �������� �߰��� ������ ������� �ٽ� ������ �ϱ� ������ DefaultTableModel ���
	DefaultTableModel model = new DefaultTableModel(data, title) {  // �𵨰�ü ����
		public boolean isCellEditalbe(int r, int c) { // �� ���� �Ұ����ϰ� ó��
			return false;
		}
	};
	
	// JTable�� ����ϸ� �������� �߰��� ������ ������� �ٽ� ������ �ϱ� ������ DefaultTableModel ���
	DefaultTableModel model1 = new DefaultTableModel(data1, title1) {  // �𵨰�ü ����
		public boolean isCellEditalbe(int r, int c) { // �� ���� �Ұ����ϰ� ó��
			return false;
		}
	};
	
	// JTable�� ����ϸ� �������� �߰��� ������ ������� �ٽ� ������ �ϱ� ������ DefaultTableModel ���
	DefaultTableModel model2 = new DefaultTableModel(data2, title2) {  // �𵨰�ü ����
		public boolean isCellEditalbe(int r, int c) { // �� ���� �Ұ����ϰ� ó��
			return false;
		}
	};
	//-----------------------------------------------------------------
	
	// SelectDialog�� ���� ����ʵ� �߰�
	SelectDialog sdialog = new SelectDialog(this, "�˻�â", false);
	
	// ������Ʈ ��ü ����
	private JPanel contentPane;
	private JMenuBar jMenuBar1 = new JMenuBar();
	private JMenu jMenuFile = new JMenu();
	private JMenuItem jMenuFileExit = new JMenuItem();
	private JMenu jMenuHelp = new JMenu();
	private JMenuItem jMenuHelpAbout = new JMenuItem();
	private JPanel jPanel1 = new JPanel();
	private JLabel jLabel1 = new JLabel();
	private JTextField idTF = new JTextField();
	private JTextField nameTF = new JTextField();
	private JPasswordField pwdTF = new JPasswordField();
	private JTextField jumin1TF = new JTextField();
	private JTextField jumin2 = new JTextField();
	private JTextField emailTF = new JTextField();
	private JTextField phoneTF = new JTextField();
	private JTextField addrTF = new JTextField();
	private ButtonGroup buttonGroup1 = new ButtonGroup();
	private ButtonGroup buttonGroup2 = new ButtonGroup(); // ���� ��� ��ư �׷�
	private JLabel jLabel2 = new JLabel();
	private JLabel jLabel3 = new JLabel();
	private JLabel jLabel4 = new JLabel();
	private JLabel jLabel5 = new JLabel();
	private JLabel jLabel6 = new JLabel();
	private JLabel jLabel7 = new JLabel();
	private JPanel jPanel2 = new JPanel();
	private TitledBorder titledBorder1;
	private JRadioButton male = new JRadioButton();
	private JRadioButton female = new JRadioButton();
	private JRadioButton Agrade = new JRadioButton();
	private JRadioButton Bgrade = new JRadioButton();
	
	private JLabel jLabel9 = new JLabel();
	private JPanel jPanel3 = new  JPanel(); // 1��° ���̺� �г�
	private JPanel jPanel4 = new JPanel();
	private JPanel jPanel5 = new JPanel();
	private JPanel jPanel6 = new JPanel(); // ���� ������ �Է¹޴� ������Ʈ�� ��� �г�
	private JPanel jPanel7 = new JPanel(); // 2��° ���̺� �г�
	private JPanel jPanel8 = new JPanel(); // 3��° ���̺� �г�
	
	private JButton insertB = new JButton(); // �Է¹�ư
	private JButton updateB = new JButton(); // ������ư
	private JButton deleteB = new JButton(); // ������ư
	private JButton selectB = new JButton(); // �˻���ư
	private JButton reservB = new JButton(); // �����ư
	private JButton cancelB = new JButton(); // ���� ���
	private JButton registB = new JButton(); // ����
	private JButton NregistB = new JButton(); // �����
	
	private BorderLayout borderLayout1 = new BorderLayout(); // 1,2 ��° JTable�� ����
	private BorderLayout borderLayout2 = new BorderLayout(); // 3 ��° JTable�� ����
	
	private JScrollPane sp = new JScrollPane(); // ù ��° JTable�� ������ ��ũ����
	private JScrollPane sp1 = new JScrollPane(); // �� ��° JTable�� ������ ��ũ����
	private JScrollPane sp2 = new JScrollPane(); // �� ��° JTable�� ������ ��ũ����
	
	// JTable ��ü ����
	private JTable table = new JTable(model);
	private JTable table1 = new JTable(model1);
	private JTable table2 = new JTable(model2);
	
	
	// �����ϴ� ������� GUI����
	private JLabel jLabel10 = new JLabel(); // �����ȣ
	private JLabel jLabel11 = new JLabel(); // ����ȣ
	private JLabel jLabel12 = new JLabel(); // ���ȣ
	private JLabel jLabel13 = new JLabel(); // ���೯¥
	
	private JTextField reservTF = new JTextField();
	private JTextField roomTF = new JTextField();
	private JTextField cusTF = new JTextField();
	private JTextField dateTF = new JTextField();
	
	// ���� ������ ����ִ� GUI����
	private JLabel jLabel14 = new JLabel(); // ���ȣ
	private JLabel jLabel15 = new JLabel(); // ���
	private JLabel jLabel16 = new JLabel(); // ����ο�
	private JLabel jLabel17 = new JLabel(); // ���� ����
	
	private JTextField rnTF = new JTextField();
	private JTextField psbTF = new JTextField();
	private JTextField statTF = new JTextField("FALSE"); // �������, �⺻��� FALSE
	
	//-----------------------------------------------------------------
	
	//Construct the frame, ������
	public JdbcMainFrame() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			jbInit2();
			jbInit1();
			jbInit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		// �̺�Ʈ �ڵ鷯�� ����ϴ� �ҽ�
		this.insertB.addActionListener(this); // �Է�	
		this.table.addMouseListener(this); // ���̺�
		this.table1.addMouseListener(this); // ���̺�1
		this.selectB.addActionListener(this); // �˻�
		this.reservB.addActionListener(this); // ����
		this.deleteB.addActionListener(this); // ����
		this.cancelB.addActionListener(this); // �������
		this.updateB.addActionListener(this); // ����
		this.registB.addActionListener(this); // ����
		this.NregistB.addActionListener(this); // �����
		
	}
	
	// 3��° ���̺��� ��� �ִ� �޼ҵ�
	// Component initialization
	private void jbInit2() throws Exception {
		contentPane = (JPanel)this.getContentPane();
		contentPane.setLayout(null);

		jPanel8.setBorder(BorderFactory.createRaisedBevelBorder());
		jPanel8.setBounds(new Rectangle(830, 243, 220, 287));
		jPanel8.setLayout(borderLayout2);
		
		table2.setBackground(Color.lightGray);
		table2.setBorder(BorderFactory.createEtchedBorder());
		
		jPanel8.add(sp2, BorderLayout.CENTER);
		sp2.getViewport().add(table2, null);
		contentPane.add(jPanel8, null);
		
		table2.getColumnModel().getColumn(0).setPreferredWidth(30); // ���ȣ
		table2.getColumnModel().getColumn(1).setPreferredWidth(30); // ����
		table2.getColumnModel().getColumn(2).setPreferredWidth(30); // ����ο�
		table2.getColumnModel().getColumn(3).setPreferredWidth(50); // ����ο�

		table2.setShowHorizontalLines(false); // ���� ���� �Ⱥ��̰� ó��
		table2.setShowVerticalLines(false); // ���� ���� �Ⱥ��̰� ó��
		table2.setSelectionBackground(Color.orange);
		table2.setSelectionForeground(Color.blue);
		table2.setRowMargin(0);
		table2.setIntercellSpacing(new Dimension(0,0));
		table2.setRequestFocusEnabled(false); // Ư�� ���� ��Ŀ�� ���� �ȵǰ� ó��
		
		table2.setSelectionMode(0); // 0:���ϼ���, 1:���߼���, -2:���þ���
		
		table2.getTableHeader().setReorderingAllowed(false); // �������
		table2.getTableHeader().setMaximumSize(new Dimension(110,0));
		table2.getTableHeader().setMinimumSize(new Dimension(10,0));
		table2.setAlignmentX(JTable.CENTER_ALIGNMENT); // ����
		table2.setAlignmentY(JTable.CENTER_ALIGNMENT);
	}
	
	// 2��° ���̺��� ��� �ִ� �޼ҵ�
	//Component initialization
	private void jbInit1() throws Exception {
		contentPane = (JPanel)this.getContentPane();
		contentPane.setLayout(null);

		jPanel7.setBorder(BorderFactory.createRaisedBevelBorder());
		jPanel7.setBounds(new Rectangle(4, 430, 822, 100));
		jPanel7.setLayout(borderLayout1);
		
		table1.setBackground(Color.lightGray);
		table1.setBorder(BorderFactory.createEtchedBorder());
		
		contentPane.add(jPanel7, null);
		
		jPanel7.add(sp1, BorderLayout.CENTER);
		sp1.getViewport().add(table1, null);
		
		table1.getColumnModel().getColumn(0).setPreferredWidth(30); // �����ȣ
		table1.getColumnModel().getColumn(1).setPreferredWidth(30); // ���ȣ
		table1.getColumnModel().getColumn(2).setPreferredWidth(80); // ����ȣ
		table1.getColumnModel().getColumn(3).setPreferredWidth(80); // ���೯¥
		
		table1.setShowHorizontalLines(false); // ���� ���� �Ⱥ��̰� ó��
		table1.setShowVerticalLines(false); // ���� ���� �Ⱥ��̰� ó��
		table1.setSelectionBackground(Color.orange);
		table1.setSelectionForeground(Color.blue);
		table1.setRowMargin(0);
		table1.setIntercellSpacing(new Dimension(0,0));
		table1.setRequestFocusEnabled(false); // Ư�� ���� ��Ŀ�� ���� �ȵǰ� ó��
		
		table1.setSelectionMode(0); // 0:���ϼ���, 1:���߼���, -2:���þ���
		
		table1.getTableHeader().setReorderingAllowed(false); // �������
		table1.getTableHeader().setMaximumSize(new Dimension(110,0));
		table1.getTableHeader().setMinimumSize(new Dimension(10,0));
		table1.setAlignmentX(JTable.CENTER_ALIGNMENT); // ����
		table1.setAlignmentY(JTable.CENTER_ALIGNMENT);
	}
	
	// ù ��° ���̺��� ����ִ� �޼ҵ�
	//Component initialization
	private void jbInit() throws Exception {
		
		contentPane = (JPanel)this.getContentPane();
		titledBorder1 = new TitledBorder("����");
		contentPane.setLayout(null); // ��ġ������ ����
		this.setSize(new Dimension(1070, 600)); // 825, 595
		this.setTitle("ȣ�� ��/���� ���� Program ");
		
		// �޴�����
		jMenuFile.setText("File");
		jMenuFileExit.setText("Exit");
		// �̺�Ʈ ó��
		jMenuFileExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuFileExit_actionPerformed(e);
			}
		});
		jMenuHelp.setText("Help");
		jMenuHelpAbout.setText("About");
		// �̺�Ʈ ó��
		jMenuHelpAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuHelpAbout_actionPerformed(e);
			}
		});
		
		//-------------------------------------------------------------
		// ������Ʈ �����ӿ� ��ġ �� �Ӽ� ����
		jPanel1.setBackground(new Color(131, 158, 200));
		jPanel1.setBorder(BorderFactory.createRaisedBevelBorder());
		jPanel1.setBounds(new Rectangle(4, 4, 560, 235));
		jPanel1.setLayout(null); // ��ġ������ ����
		jLabel1.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel1.setText("����ȣ");
		jLabel1.setBounds(new Rectangle(22, 21, 60, 18));
		
		// �Է�â�� JTextField�� ��ġ ����
		idTF.setBounds(new Rectangle(76, 18, 78, 23));
		nameTF.setBounds(new Rectangle(75, 79, 80, 23));
		pwdTF.setBounds(new Rectangle(75, 49, 80, 23));
		jumin1TF.setBounds(new Rectangle(75, 108, 52, 23));
		jumin2.setBounds(new Rectangle(131, 108, 57, 23));
		emailTF.setBounds(new Rectangle(75, 137, 171, 23));
		phoneTF.setBounds(new Rectangle(75, 166, 169, 23));
		addrTF.setBounds(new Rectangle(75, 195, 472, 23));
		
		// JTextField ���� �ִ� JLabel �̸� ���� �� ��ġ ����
		jLabel2.setBounds(new Rectangle(21, 51, 55, 18));
		jLabel2.setText("��й�ȣ");
		jLabel2.setFont(new java.awt.Font("Monosapced", 0, 12));
		jLabel3.setBounds(new Rectangle(43, 82, 29, 18));
		jLabel3.setText("�̸�");
		jLabel3.setFont(new java.awt.Font("Monosapced", 0, 12));
		jLabel4.setBounds(new Rectangle(19, 108, 55, 18));
		jLabel4.setText("�ֹι�ȣ");
		jLabel4.setFont(new java.awt.Font("Monosapced", 0, 12));
		jLabel5.setBounds(new Rectangle(31, 140, 41, 18));
		jLabel5.setText("�̸���");
		jLabel5.setFont(new java.awt.Font("Monosapced", 0, 12));
		jLabel6.setBounds(new Rectangle(7, 169, 60, 18));
		jLabel6.setText("�޴�����ȣ");
		jLabel6.setFont(new java.awt.Font("Monosapced", 0, 12));
		jLabel7.setBounds(new Rectangle(42, 197, 29, 18));
		jLabel7.setText("�ּ�");
		jLabel7.setFont(new java.awt.Font("Monosapced", 0, 12));
		jPanel2.setBorder(titledBorder1);
		jPanel2.setOpaque(false);
		jPanel2.setBounds(new Rectangle(291, 8, 121, 58));
		jPanel2.setLayout(null);
		
		// ����, ���� ���� ��ư ��ġ ����
		male.setOpaque(false);
		male.setText("����");
		male.setBounds(new Rectangle(12, 24, 51, 18));
		
		female.setOpaque(false);
		female.setText("����");
		female.setBounds(new Rectangle(65, 20, 48, 27));
		
		jPanel3.setBorder(BorderFactory.createRaisedBevelBorder());
		jPanel3.setBounds(new Rectangle(4, 243, 822, 180));
		jPanel3.setLayout(borderLayout1);
		
		jPanel4.setBackground(new Color(177, 151, 255));
		jPanel4.setBorder(BorderFactory.createRaisedBevelBorder());
		jPanel4.setBounds(new Rectangle(565, 5, 99, 235));
		jPanel4.setLayout(null);
		
		insertB.setBounds(new Rectangle(6, 7, 87, 35));
		insertB.setOpaque(false);
		insertB.setText("��       ��");
		updateB.setText("��       ��");
		updateB.setBounds(new Rectangle(6, 45, 88, 35));
		updateB.setOpaque(false);
		deleteB.setText("��       ��");
		deleteB.setBounds(new Rectangle(5, 84, 90, 35));
		deleteB.setOpaque(false);
		selectB.setText("��       ��");
		selectB.setBounds(new Rectangle(6, 123, 89, 35));
		selectB.setOpaque(false);
		reservB.setText("��       ��");
		reservB.setBounds(new Rectangle(40, 150, 90, 35));
		reservB.setOpaque(false);
		cancelB.setText("�������");
		cancelB.setBounds(new Rectangle(40, 190, 90, 35));
		cancelB.setOpaque(false);
		registB.setText("����");
		registB.setBounds(new Rectangle(55, 150, 110, 35));
		registB.setOpaque(false);
		NregistB.setText("�����");
		NregistB.setBounds(new Rectangle(55, 190, 110, 35));
		NregistB.setOpaque(false);
		contentPane.setBackground(UIManager.getColor("textHighlight"));
		
		jPanel5.setBackground(new Color(131, 158, 200));
		jPanel5.setBorder(BorderFactory.createRaisedBevelBorder());
		jPanel5.setOpaque(false);
		jPanel5.setBounds(new Rectangle(666, 6, 160, 234));
		jPanel5.setLayout(null);
		
		table.setBackground(Color.lightGray);
		table.setBorder(BorderFactory.createEtchedBorder());

		jMenuFile.add(jMenuFileExit);
		jMenuHelp.add(jMenuHelpAbout);
		jMenuBar1.add(jMenuFile);
		jMenuBar1.add(jMenuHelp);
		
		contentPane.add(jPanel1, null);
		jPanel2.add(male, null);
		jPanel2.add(female, null);
		jPanel1.add(jLabel9, null);
		jPanel1.add(jumin2, null);
		
		jPanel4.add(insertB, null);
		jPanel4.add(updateB, null);
		jPanel4.add(deleteB, null);
		jPanel4.add(selectB, null);
		contentPane.add(jPanel6, null);
		contentPane.add(jPanel5, null);
		contentPane.add(jPanel3, null);
		contentPane.add(jPanel4, null);
		
		jPanel3.add(sp, BorderLayout.CENTER);
		sp.getViewport().add(table, null);
		
		jPanel1.add(idTF, null);
		jPanel1.add(pwdTF, null);
		jPanel1.add(nameTF, null);
		jPanel1.add(jumin1TF, null);
		jPanel1.add(emailTF, null);
		jPanel1.add(phoneTF, null);
		jPanel1.add(addrTF, null);
		jPanel1.add(jLabel7, null);
		jPanel1.add(jLabel5, null);
		jPanel1.add(jLabel1, null);
		jPanel1.add(jLabel2, null);
		jPanel1.add(jLabel3, null);
		jPanel1.add(jLabel4, null);
		jPanel1.add(jLabel6, null);
		jPanel1.add(jPanel2, null);
		this.setJMenuBar(jMenuBar1);
		buttonGroup1.add(male);
		buttonGroup1.add(female);

		// ������� �г�
		jLabel10.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel10.setText("�����ȣ");
		jLabel10.setBounds(new Rectangle(10, 22, 55, 18));
		jLabel11.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel11.setText("���ȣ");
		jLabel11.setBounds(new Rectangle(10, 52, 55, 18));
		jLabel12.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel12.setText("����ȣ");
		jLabel12.setBounds(new Rectangle(10, 82, 55, 18));
		jLabel13.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel13.setText("���೯¥");
		jLabel13.setBounds(new Rectangle(10, 112, 55, 18));
		
		reservTF.setBounds(new Rectangle(75, 18, 78, 23));
		roomTF.setBounds(new Rectangle(75, 49, 80, 23));
		cusTF.setBounds(new Rectangle(75, 79, 80, 23));
		dateTF.setBounds(new Rectangle(75, 109, 80, 23));
		
		jPanel5.add(reservTF, null);
		jPanel5.add(roomTF, null);
		jPanel5.add(cusTF, null);
		jPanel5.add(dateTF, null);
		jPanel5.add(jLabel10, null);
		jPanel5.add(jLabel11, null);
		jPanel5.add(jLabel12, null);
		jPanel5.add(jLabel13, null);
		jPanel5.add(reservB, null);
		jPanel5.add(cancelB, null);
		
		// ���� ���� �г�
		jPanel6.setBackground(new Color(131, 158, 200));
		jPanel6.setBorder(BorderFactory.createRaisedBevelBorder());
		jPanel6.setBounds(new Rectangle(830, 6, 220, 234));
		jPanel6.setLayout(null); // ��ġ������ ����
		
		Agrade.setOpaque(false);
		Agrade.setText("A");
		Agrade.setBounds(new Rectangle(75, 49, 51, 18));
		
		Bgrade.setOpaque(false);
		Bgrade.setText("B");
		Bgrade.setBounds(new Rectangle(110, 49, 51, 18));
		
		buttonGroup2.add(Agrade);
		buttonGroup2.add(Bgrade);
		
		jLabel14.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel14.setText("���ȣ");
		jLabel14.setBounds(new Rectangle(15, 22, 55, 18));
		jLabel15.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel15.setText("���");
		jLabel15.setBounds(new Rectangle(15, 52, 55, 18));
		jLabel16.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel16.setText("����ο�");
		jLabel16.setBounds(new Rectangle(15, 82, 55, 18));
		jLabel17.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel17.setText("�������");
		jLabel17.setBounds(new Rectangle(15, 112, 55, 18));
		
		rnTF.setBounds(new Rectangle(75, 18, 100, 23));
		psbTF.setBounds(new Rectangle(75, 79, 100, 23));
		statTF.setBounds(new Rectangle(75, 110, 100, 23));
		
		jPanel6.add(Agrade, null);
		jPanel6.add(Bgrade, null);
		jPanel6.add(rnTF, null);
		jPanel6.add(psbTF, null);
		jPanel6.add(statTF, null);
		jPanel6.add(jLabel14, null);
		jPanel6.add(jLabel15, null);
		jPanel6.add(jLabel16, null);
		jPanel6.add(jLabel17, null);
		jPanel6.add(registB, null);
		jPanel6.add(NregistB, null);
		
		// JTbale ������Ʈ�� �Ӽ��� ����
		// JTbale�� �÷� ����
		// setPreferredWidth�� ���� ���� ��Ÿ��
		table.getColumnModel().getColumn(0).setPreferredWidth(30); // ���̵�
		table.getColumnModel().getColumn(1).setPreferredWidth(30); // �̸�
		table.getColumnModel().getColumn(2).setPreferredWidth(80); // �ֹι�ȣ
		table.getColumnModel().getColumn(3).setPreferredWidth(80); // �̸���
		table.getColumnModel().getColumn(4).setPreferredWidth(60); // �޴���
		table.getColumnModel().getColumn(5).setPreferredWidth(20); // ����
		table.getColumnModel().getColumn(6).setPreferredWidth(40); // �ּ�
		
		table.setShowHorizontalLines(false); // ���� ���� �Ⱥ��̰� ó��
		table.setShowVerticalLines(false); // ���� ���� �Ⱥ��̰� ó��
		table.setSelectionBackground(Color.orange);
		table.setSelectionForeground(Color.blue);
		table.setRowMargin(0);
		table.setIntercellSpacing(new Dimension(0,0));
		table.setRequestFocusEnabled(false); // Ư�� ���� ��Ŀ�� ���� �ȵǰ� ó��
		
		table.setSelectionMode(0); // 0:���ϼ���, 1:���߼���, -2:���þ���
		
		table.getTableHeader().setReorderingAllowed(false); // �������
		table.getTableHeader().setMaximumSize(new Dimension(110,0));
		table.getTableHeader().setMinimumSize(new Dimension(10,0));
		table.setAlignmentX(JTable.CENTER_ALIGNMENT); // ����
		table.setAlignmentY(JTable.CENTER_ALIGNMENT);
		//---------------------------------------------------------------
			
	}
	
	// File | Exit action performed - �޴� File�� Exit �޴��� Ŭ���� ���� ó��
	public void jMenuFileExit_actionPerformed(ActionEvent e){
		disconnProcess();
		System.exit(0);
	}
	
	// Help | About action performed - �޴��� About �޴��� Ŭ���� ���̾�α� â ����
	public void jMenuHelpAbout_actionPerformed(ActionEvent e){
		JdbcMainFrame_AboutBox dlg = new JdbcMainFrame_AboutBox(this);
		// ------------------���̾�α� â �߾ӿ� ��ġ---------------------
		Dimension dlgSize = dlg.getPreferredSize();
		Dimension frmSize = getSize();
		Point loc = getLocation();
		dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
		// ���̾� �α� â�� �߸� ��׶��� Ŭ���� �ȵǰ� ó��
		// ���̾�α� â�� �ݾƾ� ��׶��� ȭ�� Ŭ�� ����
		dlg.setModal(true); dlg.pack();
		dlg.setVisible(true);
	}
	
	// Statement ��ü ����
	Statement stmt;
	
	// sqlUpdate ������ ���� �޾Ƽ� Mysql�� �Ѱ��ִ� �޼ҵ�
	public boolean sqlUpdate(String sql){
		System.out.println("update SQL : " + sql);
		Statement stmt1 = null;
		try {
			stmt1 = conn.createStatement();
			int i = stmt.executeUpdate(sql);
			System.out.println(i + "���� ������ ������Ʈ ����");
			return true;
		}catch(Exception e){
			System.out.println("������ ������Ʈ ���� : " + e.getMessage());
			return false;
		}finally{
			try{
				stmt1.close();
			}catch(Exception e1){}
		}
	}
	
	// �Է� �̺�Ʈ �߰� �� Mysql�� ������ �Ѱ��ִ� �޼ҵ�
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ev) {
		Object ob = ev.getSource(); // �̺�Ʈ�� �߻��� ������Ʈ ������ Object������ ��´�.
		String s;
		if(ob == this.insertB) { // �Է¹�ư Ŭ����
			    s = "INSERT INTO member VALUES('"+this.idTF.getText().trim()+"','" +
					new String(this.pwdTF.getPassword()) + "','" +
					this.nameTF.getText().trim() + "','" +
					this.jumin1TF.getText().trim() + this.jumin2.getText().trim() + "','" +
					this.emailTF.getText().trim() + "','" +
					this.phoneTF.getText().trim() + "','" +
					(this.male.isSelected() ? "����" : "����") + "','" +
					this.addrTF.getText().trim() + "')";
				
			    if(sqlUpdate(s)){
			    	JOptionPane.showMessageDialog(this, "������ �߰� ����", "������ �Է¼���", JOptionPane.DEFAULT_OPTION);;
			    	sqlQuery("SELECT * FROM member");
			    }

		}
		// SelectDialog �˻� 
		else if(ob == this.selectB){
			this.sdialog.setVisible(true);
		}
		// reservB(���� ��ư Ŭ��)
		else if(ob == this.reservB) {
			String s1;
		    s = "INSERT INTO reserve VALUES('"+this.reservTF.getText().trim()+"','" +
				this.roomTF.getText().trim() + "','" +
				this.cusTF.getText().trim() + "','" +
				this.dateTF.getText().trim() + "')";
		    
		    // �����ư Ŭ���� ROOM���̺��� ������¸� TRUE�� �����ϱ� ���� ���ǹ�
			s1 = "UPDATE room SET state='TRUE' WHERE room_no='"+this.roomTF.getText().trim()+"'";
		    if(sqlUpdate(s)){
		    	JOptionPane.showMessageDialog(this, "������ �߰� ����", "������ �Է¼���", JOptionPane.DEFAULT_OPTION);;
		    	sqlQuery1("SELECT * FROM reserve");
		    }
		    // �����ư Ŭ���� ROOM���̺��� ������°� TRUE�� ���ϰԵȴ�.
		    if(sqlUpdate(s1)){
		    	JOptionPane.showMessageDialog(this, "������ ���� ����!", "������ ���� ����", JOptionPane.DEFAULT_OPTION);;
		    	sqlQuery2("SELECT * FROM room");
		    }
		}
		else if(ob == this.deleteB){
			String s1, s2;
			int row = table.getSelectedRow(); // ������ MEMBER���̺� ���õ� �� ���
			int row1 = table1.getSelectedRow(); // ROOM���̺��� ������¸� �����ϱ����� RSERVER���̺��� �༱��
			if(row < 0) { // JTable�� ���õ� ���� ���� ���
				JOptionPane.showMessageDialog(this, "������ ����� ������ �ּ���", "���ÿ���", JOptionPane.DEFAULT_OPTION);
				return;
			}
			if(row1 < 0) { // JTable�� ���õ� ���� ���� ���
				JOptionPane.showMessageDialog(this, "������ ����� ������ �ּ���", "���ÿ���", JOptionPane.DEFAULT_OPTION);
				return;
			}
			String key_id = (String)model.getValueAt(row, 0); // ����ȣ�� ��´�
			String key_room = (String)model1.getValueAt(row1, 1); // ����ȣ�� ��´�
			String sql = "DELETE FROM member WHERE id = '"+ key_id + "'"; // member ���̺��� �� ����
			// member ���̺��� ���� �����Ǹ� ����Ǿ��ִ��͵� ����
			s1 = "DELETE FROM reserve WHERE id = '"+ key_id + "'"; 
			// ������ִ��� �������� ROOM���̺����� ������°� �ٽ� FALSE�� ����Ǳ� ���� ���ǹ�
			s2 = "UPDATE room SET state='FALSE' WHERE room_no='"+ key_room + "'";
			if(sqlUpdate(sql)){
				JOptionPane.showMessageDialog(this, "������ ���� ���� �߾��!", "������ ���� ����", JOptionPane.DEFAULT_OPTION);
				sqlQuery("SELECT * FROM member");
			}
			else {
				JOptionPane.showMessageDialog(this, "������ ���� ����!", "����", JOptionPane.DEFAULT_OPTION);;
				return;
			}
			// MEMBER���̺��� �� ������ RESERVE���̺��� ����Ǿ��ִ� ���� ���� ����
			if(sqlUpdate(s1)){
				JOptionPane.showMessageDialog(this, "������ ���� ���� �߾��!", "������ ���� ����", JOptionPane.DEFAULT_OPTION);
				sqlQuery1("SELECT * FROM reserve");
			}
			// ������� ����
			if(sqlUpdate(s2)){
				JOptionPane.showMessageDialog(this, "������ ���� ���� �߾��!", "������ ���� ����", JOptionPane.DEFAULT_OPTION);
				sqlQuery2("SELECT * FROM room");
			}

		}
		// �������
		else if(ob == this.cancelB){
			int row1 = table1.getSelectedRow(); // ���õ� �� ���
			String s2; // ������¸� �����ϱ����� ���� 
			if(row1 < 0) { // JTable1�� ���õ� ���� ���� ���
				JOptionPane.showMessageDialog(this, "������ ����� ������ �ּ���", "���ÿ���", JOptionPane.DEFAULT_OPTION);
				return;
			}
			String key_id = (String)model1.getValueAt(row1, 0); // �����ȣ�� ��´�
			String sql = "DELETE FROM reserve WHERE rsv_no = '"+ key_id + "'";
			// ���� ��ҽ�  ROOM���̺��� ������¸� FALSE�� ����
			s2 = "UPDATE room SET state='FALSE' WHERE room_no='"+this.roomTF.getText().trim()+"'";
			if(sqlUpdate(sql)){
				JOptionPane.showMessageDialog(this, "������ ���� ���� �߾��!", "������ ���� ����", JOptionPane.DEFAULT_OPTION);
				sqlQuery1("SELECT * FROM reserve");
			}
			else {
				JOptionPane.showMessageDialog(this, "������ ���� ���� �߾��!", "������ ���� ����", JOptionPane.DEFAULT_OPTION);;
				return;
			}
			// ������� ����
			if(sqlUpdate(s2)){
				JOptionPane.showMessageDialog(this, "������ ���� ���� �߾��!", "������ ���� ����", JOptionPane.DEFAULT_OPTION);
				sqlQuery2("SELECT * FROM room");
			}
		}
		
		// ����(�н������ ���� �Ұ�)
		else if(ob == this.updateB){
			int row2 = table.getSelectedRow(); // ���õ� �� ���
			if(row2 < 0) { // JTable1�� ���õ� ���� ���� ���
				JOptionPane.showMessageDialog(this, "������ ����� ������ �ּ���", "���ÿ���", JOptionPane.DEFAULT_OPTION);
				return;
			}
			// Mysql�� Update������ where ���� ������ ���� ����
			String key_id = (String)model.getValueAt(row2, 0); // ����ȣ�� ��´�
			String sql = "UPDATE member SET addr='"+ this.addrTF.getText().trim() +"'"+"WHERE id='"+ key_id + "'"; // �ּ� ����
			String sql1 = "UPDATE member SET name='"+ this.nameTF.getText().trim() +"'"+"WHERE id='"+ key_id + "'"; // �̸� ����
			String sql2 = "UPDATE member SET email='"+ this.emailTF.getText().trim() +"'"+"WHERE id='"+ key_id + "'"; // �̸��� ����
			String sql3 = "UPDATE member SET phone='"+ this.phoneTF.getText().trim() +"'"+"WHERE id='"+ key_id + "'"; // �ڵ��� ��ȣ ����
			String sql4 = "UPDATE member SET idno='"+ this.jumin1TF.getText().trim() + this.jumin2.getText().trim() +"'"+"WHERE id='"+ key_id + "'"; // �ֹε�Ȥ��ȣ ����
			
			// sql
			if(sqlUpdate(sql)){
				sqlQuery("SELECT * FROM member");
			}
			else {
				JOptionPane.showMessageDialog(this, "������ ���� ���� �߾��!", "������ ���� ����", JOptionPane.DEFAULT_OPTION);;
				return;
			}
			// sql1
			if(sqlUpdate(sql1)){
				sqlQuery("SELECT * FROM member");
			}
			else {
				JOptionPane.showMessageDialog(this, "������ ���� ���� �߾��!", "������ ���� ����", JOptionPane.DEFAULT_OPTION);;
				return;
			}
			// sql2
			if(sqlUpdate(sql2)){
				sqlQuery("SELECT * FROM member");
			}
			else {
				JOptionPane.showMessageDialog(this, "������ ���� ���� �߾��!", "������ ���� ����", JOptionPane.DEFAULT_OPTION);;
				return;
			}
			// sql3
			if(sqlUpdate(sql3)){
				sqlQuery("SELECT * FROM member");
			}
			else {
				JOptionPane.showMessageDialog(this, "������ ���� ���� �߾��!", "������ ���� ����", JOptionPane.DEFAULT_OPTION);;
				return;
			}
			// sql4
			if(sqlUpdate(sql4)){
				sqlQuery("SELECT * FROM member");
			}
			else {
				JOptionPane.showMessageDialog(this, "������ ���� ���� �߾��!", "������ ���� ����", JOptionPane.DEFAULT_OPTION);;
				return;
			}
		}
		// ����
		else if(ob == this.registB){
			s = "INSERT INTO room VALUES('"+this.rnTF.getText().trim()+"','" +
					(this.Agrade.isSelected() ? "A" : "B") + "','" +
					this.psbTF.getText().trim() + "','" +
					this.statTF.getText().trim() + "')";
				
			    if(sqlUpdate(s)){
			    	JOptionPane.showMessageDialog(this, "������ �߰� ����", "������ �Է¼���", JOptionPane.DEFAULT_OPTION);;
			    	sqlQuery2("SELECT * FROM room");
			    }
		}
		// �����
		else if(ob == this.NregistB){
			int row2 = table2.getSelectedRow(); // ���õ� �� ���
			if(row2 < 0) { // JTable2�� ���õ� ���� ���� ���
				JOptionPane.showMessageDialog(this, "������ ����� ������ �ּ���", "���ÿ���", JOptionPane.DEFAULT_OPTION);
				return;
			}
			String key_id = (String)model2.getValueAt(row2, 0); // �����ȣ�� ��´�
			String sql = "DELETE FROM room WHERE room_no = '"+ key_id + "'";
			if(sqlUpdate(sql)){
				JOptionPane.showMessageDialog(this, "������ ���� ���� �߾��!", "������ ���� ����", JOptionPane.DEFAULT_OPTION);
				sqlQuery2("SELECT * FROM room");
			}
			else {
				JOptionPane.showMessageDialog(this, "������ ���� ���� �߾��!", "������ ���� ����", JOptionPane.DEFAULT_OPTION);;
				return;
			}
		}
	}
	
	// ù ��° member ���̺�
	public void sqlQuery(String sql) {
		System.out.println("query SQL : " + sql);
		Connection con = connProcess();
		
		try{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			model.setNumRows(0); // JTable�� ��µ� ������ �����͸� ������ û��
			while(rs.next()) { // ����¿��� Ŀ���� �̵����� ���鼭 �����͸� ��´�.
				String data[] = { // JTable�� ����ϱ� ���ؼ� 1���� �迭 ����
						rs.getString(1), // Select�� ����¿��� �ε��� 1�� �����͸� ��´�. // ����ȣ
						rs.getString(3), // �̸�
						rs.getString(4), // �ֹι�ȣ
						rs.getString(5), // �̸���
						rs.getString(6), // �޴���
						rs.getString(7), // ����
						rs.getString(8)}; // �ּ�
					model.addRow(data); // JTable�� 1���� �迭�� ���� �߰�	
			}
		}catch(Exception e){
			System.out.println("������ Select ���� : " + e.getMessage());
		}
	}
	
	// �ι�° reserve ���̺�
	public void sqlQuery1(String sql) {
		System.out.println("query SQL : " + sql);
		Connection con1 = connProcess();
		
		try{
			stmt = conn.createStatement();
			ResultSet rs1 = stmt.executeQuery(sql);
			model1.setNumRows(0); // JTable�� ��µ� ������ �����͸� ������ û��
			while(rs1.next()) { // ����¿��� Ŀ���� �̵����� ���鼭 �����͸� ��´�.
				String data1[] = { // JTable�� ����ϱ� ���ؼ� 1���� �迭 ����
						rs1.getString(1), // �����ȣ
						rs1.getString(2), // ���ȣ
						rs1.getString(3), // ����ȣ
						rs1.getString(4)}; // ���೯¥
					model1.addRow(data1); // JTable�� 1���� �迭�� ���� �߰�	
			}
		}catch(Exception e){
			System.out.println("������ Select ���� : " + e.getMessage());
		}
	}
	
	// ����° reserve ���̺�
	public void sqlQuery2(String sql) {
		System.out.println("query SQL : " + sql);
		Connection con2 = connProcess();
		
		try{
			stmt = conn.createStatement();
			ResultSet rs2 = stmt.executeQuery(sql);
			model2.setNumRows(0); // JTable�� ��µ� ������ �����͸� ������ û��
			while(rs2.next()) { // ����¿��� Ŀ���� �̵����� ���鼭 �����͸� ��´�.
				String data2[] = { // JTable�� ����ϱ� ���ؼ� 1���� �迭 ����
						rs2.getString(1), // ���ȣ
						rs2.getString(2), // ���
						rs2.getString(3), // ����ο�
						rs2.getString(4)}; // �������
					model2.addRow(data2); // JTable�� 1���� �迭�� ���� �߰�	
			}
		}catch(Exception e){
			System.out.println("������ Select ���� : " + e.getMessage());
		}
	}
	
	// MouseListener �̺�Ʈ ó��
	public void mousePressed(MouseEvent e) { // JTable���� ���콺 Ŭ����
		int row = table.getSelectedRow(); // ���õ� �� ���
		int row1 = table1.getSelectedRow(); // ���õ� �� ���
		int row2 = table2.getSelectedRow(); // ���õ� �� ���
		
		//--------------------1��° JTable------------------------- 
		if(row < 0) return;
		// ���õ� ���ȣ�� ���� ������ ���� ��� ȭ���� �ؽ�Ʈ ������Ʈ�� �� ����
		this.idTF.setText((String)model.getValueAt(row, 0));
		// ��й�ȣ�� ���� ���ϵ��� �Ϲݼ��ڷ� ����
		this.pwdTF.setText("12345678");
		this.nameTF.setText((String)model.getValueAt(row, 1));
		String temp = (String)(model.getValueAt(row, 2));
		this.jumin1TF.setText(temp.substring(0,6));
		this.jumin2.setText(temp.substring(6));
		this.emailTF.setText((String)model.getValueAt(row, 3));
		this.phoneTF.setText((String)model.getValueAt(row, 4));
		String temp1 = (String)model.getValueAt(row, 5);
		if(temp1.equals("����"))
			this.male.setSelected(true);
		else
			this.female.setSelected(true);
		this.addrTF.setText((String)model.getValueAt(row, 6));
		
		//--------------------2��° JTable------------------------- 
		if(row1 < 0) return;
		// ���õ� ���ȣ�� ���� ������ ���� ��� ȭ���� �ؽ�Ʈ ������Ʈ�� �� ����
		this.reservTF.setText((String)model1.getValueAt(row1, 0));
		this.roomTF.setText((String)model1.getValueAt(row1, 1));
		this.cusTF.setText((String)model1.getValueAt(row1, 2));
		this.dateTF.setText((String)model1.getValueAt(row1, 3));
		
		//--------------------3��° JTable------------------------- 
		if(row2 < 0) return;
		// ���õ� ���ȣ�� ���� ������ ���� ��� ȭ���� �ؽ�Ʈ ������Ʈ�� �� ����
		this.rnTF.setText((String)model2.getValueAt(row2, 0));
		String temp2 = (String)model2.getValueAt(row2, 1);
		if(temp2.equals("A"))
			this.Agrade.setSelected(true);
		else
			this.Bgrade.setSelected(true);
		this.psbTF.setText((String)model2.getValueAt(row2, 2));
		this.statTF.setText((String)model2.getValueAt(row2, 3));
		
	}
	
	// MouseListener ����� �޼ҵ� ��� ����
	public void mouseClicked(MouseEvent ev) {}
	public void mouseEntered(MouseEvent ev) {}
	public void mouseExited(MouseEvent ev) {}
	public void mouseReleased(MouseEvent ev) {}
	
	
	// ������ Ŭ�ο��� ������ Ŭ���� ���� �̺�Ʈ ó��
	protected void processWindowEvent(WindowEvent e){
		super.processWindowEvent(e);
		if(e.getID() == WindowEvent.WINDOW_CLOSING) {
			jMenuFileExit_actionPerformed(null);
		}
	}
	
	// DB���� ����
	public void disconnProcess() {
		try {
			if(this.conn != null) {this.conn.close(); }
		}catch(Exception e){}
		JOptionPane.showMessageDialog(this, "������ ������ �������ϴ�", "���� ����", JOptionPane.DEFAULT_OPTION);
		return;
	}
	
	// DB������ ���� �޼ҵ�
	public Connection connProcess() {
		String url = "jdbc:mysql://localhost/hotel";
		String user = "root";
		String passwd = "201363240";
		System.out.println("������ ���̽��� ������.....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("����̹� ���� ����");
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("�����ͺ��̽� ���� ����");
		}catch(ClassNotFoundException e1){
			System.out.println("������� : ����̹� �ε� ����");
			
		}catch (SQLException e2) {
			System.out.println("���ῡ �����Ͽ����ϴ�.");
	    }
		System.out.println("���� ����");
		return conn;
	}
	
} // end class