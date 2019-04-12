package test;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class SelectDialog extends JDialog implements ActionListener, ItemListener {
	//���̾�α� â�� ���� �θ� Ŭ���� ��ü ����
	JdbcMainFrame frame1;
	
	private JPanel panel1 = new JPanel();
	private JPanel jPanel1 = new JPanel();
	private JPanel nameP = new JPanel();
	private JButton ok = new JButton();
	private JButton cancel = new JButton();
	private ButtonGroup buttonGroup1 = new ButtonGroup();
	private JRadioButton searchNameR = new JRadioButton();
	private JRadioButton searchNumR = new JRadioButton();
	private JRadioButton searchGenderR = new JRadioButton();
	private JTextField nameTF = new JTextField();
	private JPanel numP = new JPanel();
	private JComboBox num = new JComboBox();
	private JPanel genderP = new JPanel();
	private ButtonGroup buttonGroup2 = new ButtonGroup();
	private JRadioButton male = new JRadioButton();
	private JRadioButton female = new JRadioButton();
	private TitledBorder titledBorder1;
	private JPanel cardP = new JPanel();
	private CardLayout cardLayout1 = new CardLayout();
	
	public SelectDialog(Frame frame, String title, boolean modal) {
		super(frame, title, modal);
		this.frame1 = (JdbcMainFrame)frame; // �߰�
		try {
			jbInit();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		// �̺�Ʈ �ڵ鷯 ���
		this.ok.addActionListener(this);
	}
	
	public SelectDialog() {
		this(null, "", false);
	}
	
	private void jbInit() throws Exception {
		titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(148, 145, 140)), "�˻�����");
		panel1.setLayout(null); // ��ġ������ ����
		jPanel1.setBorder(titledBorder1);
		jPanel1.setBounds(new Rectangle(6, 9, 203, 55));
		jPanel1.setLayout(null);
		nameP.setBorder(BorderFactory.createLineBorder(Color.black));
		nameP.setBounds(new Rectangle(-5, 0, 203, 47));
		nameP.setLayout(null);
		ok.setBounds(new Rectangle(10, 141, 93, 38));
		ok.setText("�˻�");
		cancel.setBounds(new Rectangle(108, 141, 94, 38));
		cancel.setText("���");
		searchNameR.setSelected(true);
		searchNameR.setText("�̸�");
		searchNameR.setBounds(new Rectangle(12, 22, 56, 26));
		searchNumR.setText("��ȣ");
		searchNumR.setBounds(new Rectangle(76, 22, 56, 29));
		searchGenderR.setText("����");
		searchGenderR.setBounds(new Rectangle(142, 22, 56, 27));
		nameTF.setBounds(new Rectangle(28, 11, 152, 24));
		numP.setLayout(null);
		numP.setBounds(new Rectangle(52, 127, 203, 47));
		numP.setBorder(BorderFactory.createLineBorder(Color.black));
		num.setBounds(new Rectangle(28, 12, 151, 22));
		
		genderP.setLayout(null);
		genderP.setBounds(new Rectangle(102, 181, 203, 47));
		genderP.setBorder(BorderFactory.createLineBorder(Color.black));
		male.setSelected(true);
		male.setText("����");
		male.setBounds(new Rectangle(33, 11, 52, 26));
		female.setText("����");
		female.setBounds(new Rectangle(109, 11, 57, 25));
		cardP.setBorder(BorderFactory.createLineBorder(Color.black));
		cardP.setBounds(new Rectangle(7, 75, 200, 50));
		cardP.setLayout(cardLayout1);
		
		getContentPane().add(panel1);
		jPanel1.add(searchNameR, null);
		jPanel1.add(searchNumR, null);
		jPanel1.add(searchGenderR, null);
		genderP.add(male, null);
		genderP.add(female, null);
		panel1.add(cancel, null);
		panel1.add(ok, null);
		panel1.add(cardP, null);
		panel1.add(jPanel1, null);
		buttonGroup1.add(searchNameR);
		buttonGroup1.add(searchNumR);
		buttonGroup1.add(searchGenderR);
		buttonGroup2.add(male);
		buttonGroup2.add(female);
		numP.add(num, null);
		nameP.add(nameTF, null);
		
		// CardLayout ��ü�� ������ ������Ʈ�� ���ļ� ��ġ
		cardP.add(nameP, "name");
		cardP.add(numP, "num");
		cardP.add(genderP, "gender");
		
		pack(); // �ݵ�� pack() �޼ҵ带 ȣ�� �� �� ���̾�α׸� �߾ӿ� ��ġ(setSize() �����)
		this.setSize(250, 250);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dialogSize = this.getSize();
		this.setLocation((screenSize.width - dialogSize.width) / 2, (screenSize.height - dialogSize.height) / 2);
		
		// �̺�Ʈ �ڵ鷯 ���
		this.searchNameR.addItemListener(this);
		this.searchNumR.addItemListener(this);
		this.searchGenderR.addItemListener(this);
	}
	
	// �˻� ������ Ŭ������ ��� �̺�Ʈ ó�� �ݹ� �޼ҵ� ����
	public void itemStateChanged(ItemEvent ev) { // ������ư�� Ŭ���Ǵ� ��� ȣ��
		Object ob = ev.getSource();
		if(ob == this.searchNameR) // �̸�
			this.cardLayout1.show(this.cardP, "name"); // ������ �ִ� �г��߿� "name"�̶� �̸��� ������ �ִ� �г��� ������
		else if(ob == this.searchNumR) // ��ȣ
			this.cardLayout1.show(this.cardP, "id");
		else if(ob == this.searchGenderR) // ����
			this.cardLayout1.show(this.cardP, "gender");
	}
	
	// ActionListener �ݹ� �޼ҵ� ����
	public void actionPerformed(ActionEvent ev) {
		Object ob = ev.getSource();
		if(ob == this.cancel){
			this.dispose();
		}
		else if(ob == this.ok) {
			String temp = "";
			if(this.searchNameR.isSelected() == true) {
				temp = this.nameTF.getText().trim();
				searchProcess("name", temp); // �ʵ��, ���� �������� �˻����ִ� �޼ҵ� ȣ��
			}
			else if(this.searchNumR.isSelected() == true) {
				temp = (String)this.num.getSelectedItem();
				searchProcess("id", temp);
			}
			else if(this.searchGenderR.isSelected() == true) {
				temp = this.male.isSelected() ? "����" : "����";
				searchProcess("gender", temp);
			}
		}
	}
	
	// Select�� ó�� �޼ҵ� ����
	public void searchProcess(String fieldName, String value) {
		String sql1 = "SELECT * FROM member";
		if(fieldName.equals("name")) {
			sql1 += " WHERE name like '%"+value+"%'";
		}
		else {
			sql1 += " WHERE "+fieldName+"='"+value+"'";
		}
		
		frame1.sqlQuery(sql1);
		this.dispose();
	}

}