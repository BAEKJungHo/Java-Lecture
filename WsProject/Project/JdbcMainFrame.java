package DBProject;
// 실질적인 작업 창을 가지고 있는 클래스(JdbcMainFrame)

// SQL API를 사용하기 위함
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*; // 스윙보더 프로그래밍을 하기위함
import javax.swing.table.*; // JTable을 사용하기 위함
import javax.swing.text.*;

public class JdbcMainFrame extends JFrame implements ActionListener, MouseListener {
	// 데이터베이스 컨넥션 정보를 가지고 있는 객체변수 선언
	Connection conn = null;
	
	// Frame에서 입력한 결과를 표시해주는 아래쪽 JTable
	// JTable을 구성하기 위한 구성 데이터 및 컴포넌트 생성
	String data[][] = new String[0][5]; // 데이터 영역 결정
	String title[] = {"고객번호", "이름", "주민번호", "이메일", "휴대폰", "성별", "주소"}; // 타이틀
	
	String data1[][] = new String[0][5];
	String title1[] = {"예약번호", "방번호", "고객번호", "예약날짜"};
	
	String data2[][] = new String[0][5];
	String title2[] = {"방번호", "등급", "인원", "예약상태"};
	
	// JTable을 사용하면 데이터의 추가나 삭제가 있을경우 다시 만들어야 하기 때문에 DefaultTableModel 사용
	DefaultTableModel model = new DefaultTableModel(data, title) {  // 모델객체 설정
		public boolean isCellEditalbe(int r, int c) { // 셀 편집 불가능하게 처리
			return false;
		}
	};
	
	// JTable을 사용하면 데이터의 추가나 삭제가 있을경우 다시 만들어야 하기 때문에 DefaultTableModel 사용
	DefaultTableModel model1 = new DefaultTableModel(data1, title1) {  // 모델객체 설정
		public boolean isCellEditalbe(int r, int c) { // 셀 편집 불가능하게 처리
			return false;
		}
	};
	
	// JTable을 사용하면 데이터의 추가나 삭제가 있을경우 다시 만들어야 하기 때문에 DefaultTableModel 사용
	DefaultTableModel model2 = new DefaultTableModel(data2, title2) {  // 모델객체 설정
		public boolean isCellEditalbe(int r, int c) { // 셀 편집 불가능하게 처리
			return false;
		}
	};
	//-----------------------------------------------------------------
	
	// SelectDialog를 위한 멤버필드 추가
	SelectDialog sdialog = new SelectDialog(this, "검색창", false);
	
	// 컴포넌트 객체 생성
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
	private ButtonGroup buttonGroup2 = new ButtonGroup(); // 방의 등급 버튼 그룹
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
	private JPanel jPanel3 = new  JPanel(); // 1번째 테이블 패널
	private JPanel jPanel4 = new JPanel();
	private JPanel jPanel5 = new JPanel();
	private JPanel jPanel6 = new JPanel(); // 방의 정보를 입력받는 컴포넌트를 담는 패널
	private JPanel jPanel7 = new JPanel(); // 2번째 테이블 패널
	private JPanel jPanel8 = new JPanel(); // 3번째 테이블 패널
	
	private JButton insertB = new JButton(); // 입력버튼
	private JButton updateB = new JButton(); // 수정버튼
	private JButton deleteB = new JButton(); // 삭제버튼
	private JButton selectB = new JButton(); // 검색버튼
	private JButton reservB = new JButton(); // 예약버튼
	private JButton cancelB = new JButton(); // 예약 취소
	private JButton registB = new JButton(); // 방등록
	private JButton NregistB = new JButton(); // 방삭제
	
	private BorderLayout borderLayout1 = new BorderLayout(); // 1,2 번째 JTable에 적용
	private BorderLayout borderLayout2 = new BorderLayout(); // 3 번째 JTable에 적용
	
	private JScrollPane sp = new JScrollPane(); // 첫 번째 JTable에 부착할 스크롤팬
	private JScrollPane sp1 = new JScrollPane(); // 두 번째 JTable에 부착할 스크롤팬
	private JScrollPane sp2 = new JScrollPane(); // 세 번째 JTable에 부착할 스크롤팬
	
	// JTable 객체 생성
	private JTable table = new JTable(model);
	private JTable table1 = new JTable(model1);
	private JTable table2 = new JTable(model2);
	
	
	// 예약하는 예약관리 GUI구성
	private JLabel jLabel10 = new JLabel(); // 예약번호
	private JLabel jLabel11 = new JLabel(); // 고객번호
	private JLabel jLabel12 = new JLabel(); // 방번호
	private JLabel jLabel13 = new JLabel(); // 예약날짜
	
	private JTextField reservTF = new JTextField();
	private JTextField roomTF = new JTextField();
	private JTextField cusTF = new JTextField();
	private JTextField dateTF = new JTextField();
	
	// 방의 정보를 담고있는 GUI구성
	private JLabel jLabel14 = new JLabel(); // 방번호
	private JLabel jLabel15 = new JLabel(); // 등급
	private JLabel jLabel16 = new JLabel(); // 허용인원
	private JLabel jLabel17 = new JLabel(); // 예약 상태
	
	private JTextField rnTF = new JTextField();
	private JTextField psbTF = new JTextField();
	private JTextField statTF = new JTextField("FALSE"); // 예약상태, 기본등록 FALSE
	
	//-----------------------------------------------------------------
	
	//Construct the frame, 생성자
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
		
		// 이벤트 핸들러를 등록하는 소스
		this.insertB.addActionListener(this); // 입력	
		this.table.addMouseListener(this); // 테이블
		this.table1.addMouseListener(this); // 테이블1
		this.selectB.addActionListener(this); // 검색
		this.reservB.addActionListener(this); // 예약
		this.deleteB.addActionListener(this); // 삭제
		this.cancelB.addActionListener(this); // 예약취소
		this.updateB.addActionListener(this); // 수정
		this.registB.addActionListener(this); // 방등록
		this.NregistB.addActionListener(this); // 방삭제
		
	}
	
	// 3번째 테이블을 담고 있는 메소드
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
		
		table2.getColumnModel().getColumn(0).setPreferredWidth(30); // 방번호
		table2.getColumnModel().getColumn(1).setPreferredWidth(30); // 방등급
		table2.getColumnModel().getColumn(2).setPreferredWidth(30); // 허용인원
		table2.getColumnModel().getColumn(3).setPreferredWidth(50); // 허용인원

		table2.setShowHorizontalLines(false); // 수평 라인 안보이게 처리
		table2.setShowVerticalLines(false); // 수직 라인 안보이게 처리
		table2.setSelectionBackground(Color.orange);
		table2.setSelectionForeground(Color.blue);
		table2.setRowMargin(0);
		table2.setIntercellSpacing(new Dimension(0,0));
		table2.setRequestFocusEnabled(false); // 특정 셀에 포커스 설정 안되게 처리
		
		table2.setSelectionMode(0); // 0:단일선택, 1:다중선택, -2:선택안함
		
		table2.getTableHeader().setReorderingAllowed(false); // 헤더고정
		table2.getTableHeader().setMaximumSize(new Dimension(110,0));
		table2.getTableHeader().setMinimumSize(new Dimension(10,0));
		table2.setAlignmentX(JTable.CENTER_ALIGNMENT); // 정렬
		table2.setAlignmentY(JTable.CENTER_ALIGNMENT);
	}
	
	// 2번째 테이블을 담고 있는 메소드
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
		
		table1.getColumnModel().getColumn(0).setPreferredWidth(30); // 예약번호
		table1.getColumnModel().getColumn(1).setPreferredWidth(30); // 방번호
		table1.getColumnModel().getColumn(2).setPreferredWidth(80); // 고객번호
		table1.getColumnModel().getColumn(3).setPreferredWidth(80); // 예약날짜
		
		table1.setShowHorizontalLines(false); // 수평 라인 안보이게 처리
		table1.setShowVerticalLines(false); // 수직 라인 안보이게 처리
		table1.setSelectionBackground(Color.orange);
		table1.setSelectionForeground(Color.blue);
		table1.setRowMargin(0);
		table1.setIntercellSpacing(new Dimension(0,0));
		table1.setRequestFocusEnabled(false); // 특정 셀에 포커스 설정 안되게 처리
		
		table1.setSelectionMode(0); // 0:단일선택, 1:다중선택, -2:선택안함
		
		table1.getTableHeader().setReorderingAllowed(false); // 헤더고정
		table1.getTableHeader().setMaximumSize(new Dimension(110,0));
		table1.getTableHeader().setMinimumSize(new Dimension(10,0));
		table1.setAlignmentX(JTable.CENTER_ALIGNMENT); // 정렬
		table1.setAlignmentY(JTable.CENTER_ALIGNMENT);
	}
	
	// 첫 번째 테이블을 담고있는 메소드
	//Component initialization
	private void jbInit() throws Exception {
		
		contentPane = (JPanel)this.getContentPane();
		titledBorder1 = new TitledBorder("성별");
		contentPane.setLayout(null); // 배치관리자 제거
		this.setSize(new Dimension(1070, 600)); // 825, 595
		this.setTitle("호텔 고객/예약 관리 Program ");
		
		// 메뉴구성
		jMenuFile.setText("File");
		jMenuFileExit.setText("Exit");
		// 이벤트 처리
		jMenuFileExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuFileExit_actionPerformed(e);
			}
		});
		jMenuHelp.setText("Help");
		jMenuHelpAbout.setText("About");
		// 이벤트 처리
		jMenuHelpAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuHelpAbout_actionPerformed(e);
			}
		});
		
		//-------------------------------------------------------------
		// 컴포넌트 프레임에 배치 및 속성 지정
		jPanel1.setBackground(new Color(131, 158, 200));
		jPanel1.setBorder(BorderFactory.createRaisedBevelBorder());
		jPanel1.setBounds(new Rectangle(4, 4, 560, 235));
		jPanel1.setLayout(null); // 배치관리자 제거
		jLabel1.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel1.setText("고객번호");
		jLabel1.setBounds(new Rectangle(22, 21, 60, 18));
		
		// 입력창인 JTextField의 위치 설정
		idTF.setBounds(new Rectangle(76, 18, 78, 23));
		nameTF.setBounds(new Rectangle(75, 79, 80, 23));
		pwdTF.setBounds(new Rectangle(75, 49, 80, 23));
		jumin1TF.setBounds(new Rectangle(75, 108, 52, 23));
		jumin2.setBounds(new Rectangle(131, 108, 57, 23));
		emailTF.setBounds(new Rectangle(75, 137, 171, 23));
		phoneTF.setBounds(new Rectangle(75, 166, 169, 23));
		addrTF.setBounds(new Rectangle(75, 195, 472, 23));
		
		// JTextField 옆에 있는 JLabel 이름 설정 및 위치 설정
		jLabel2.setBounds(new Rectangle(21, 51, 55, 18));
		jLabel2.setText("비밀번호");
		jLabel2.setFont(new java.awt.Font("Monosapced", 0, 12));
		jLabel3.setBounds(new Rectangle(43, 82, 29, 18));
		jLabel3.setText("이름");
		jLabel3.setFont(new java.awt.Font("Monosapced", 0, 12));
		jLabel4.setBounds(new Rectangle(19, 108, 55, 18));
		jLabel4.setText("주민번호");
		jLabel4.setFont(new java.awt.Font("Monosapced", 0, 12));
		jLabel5.setBounds(new Rectangle(31, 140, 41, 18));
		jLabel5.setText("이메일");
		jLabel5.setFont(new java.awt.Font("Monosapced", 0, 12));
		jLabel6.setBounds(new Rectangle(7, 169, 60, 18));
		jLabel6.setText("휴대폰번호");
		jLabel6.setFont(new java.awt.Font("Monosapced", 0, 12));
		jLabel7.setBounds(new Rectangle(42, 197, 29, 18));
		jLabel7.setText("주소");
		jLabel7.setFont(new java.awt.Font("Monosapced", 0, 12));
		jPanel2.setBorder(titledBorder1);
		jPanel2.setOpaque(false);
		jPanel2.setBounds(new Rectangle(291, 8, 121, 58));
		jPanel2.setLayout(null);
		
		// 남자, 여자 라디오 버튼 위치 설정
		male.setOpaque(false);
		male.setText("남자");
		male.setBounds(new Rectangle(12, 24, 51, 18));
		
		female.setOpaque(false);
		female.setText("여자");
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
		insertB.setText("입       력");
		updateB.setText("수       정");
		updateB.setBounds(new Rectangle(6, 45, 88, 35));
		updateB.setOpaque(false);
		deleteB.setText("삭       제");
		deleteB.setBounds(new Rectangle(5, 84, 90, 35));
		deleteB.setOpaque(false);
		selectB.setText("검       색");
		selectB.setBounds(new Rectangle(6, 123, 89, 35));
		selectB.setOpaque(false);
		reservB.setText("예       약");
		reservB.setBounds(new Rectangle(40, 150, 90, 35));
		reservB.setOpaque(false);
		cancelB.setText("예약취소");
		cancelB.setBounds(new Rectangle(40, 190, 90, 35));
		cancelB.setOpaque(false);
		registB.setText("방등록");
		registB.setBounds(new Rectangle(55, 150, 110, 35));
		registB.setOpaque(false);
		NregistB.setText("방삭제");
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

		// 예약관리 패널
		jLabel10.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel10.setText("예약번호");
		jLabel10.setBounds(new Rectangle(10, 22, 55, 18));
		jLabel11.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel11.setText("방번호");
		jLabel11.setBounds(new Rectangle(10, 52, 55, 18));
		jLabel12.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel12.setText("고객번호");
		jLabel12.setBounds(new Rectangle(10, 82, 55, 18));
		jLabel13.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel13.setText("예약날짜");
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
		
		// 방의 정보 패널
		jPanel6.setBackground(new Color(131, 158, 200));
		jPanel6.setBorder(BorderFactory.createRaisedBevelBorder());
		jPanel6.setBounds(new Rectangle(830, 6, 220, 234));
		jPanel6.setLayout(null); // 배치관리자 제거
		
		Agrade.setOpaque(false);
		Agrade.setText("A");
		Agrade.setBounds(new Rectangle(75, 49, 51, 18));
		
		Bgrade.setOpaque(false);
		Bgrade.setText("B");
		Bgrade.setBounds(new Rectangle(110, 49, 51, 18));
		
		buttonGroup2.add(Agrade);
		buttonGroup2.add(Bgrade);
		
		jLabel14.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel14.setText("방번호");
		jLabel14.setBounds(new Rectangle(15, 22, 55, 18));
		jLabel15.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel15.setText("등급");
		jLabel15.setBounds(new Rectangle(15, 52, 55, 18));
		jLabel16.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel16.setText("허용인원");
		jLabel16.setBounds(new Rectangle(15, 82, 55, 18));
		jLabel17.setFont(new java.awt.Font("Monospaced", 0, 12));
		jLabel17.setText("예약상태");
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
		
		// JTbale 컴포넌트의 속성을 설정
		// JTbale의 컬럼 설정
		// setPreferredWidth는 가로 폭을 나타냄
		table.getColumnModel().getColumn(0).setPreferredWidth(30); // 아이디
		table.getColumnModel().getColumn(1).setPreferredWidth(30); // 이름
		table.getColumnModel().getColumn(2).setPreferredWidth(80); // 주민번호
		table.getColumnModel().getColumn(3).setPreferredWidth(80); // 이메일
		table.getColumnModel().getColumn(4).setPreferredWidth(60); // 휴대폰
		table.getColumnModel().getColumn(5).setPreferredWidth(20); // 성별
		table.getColumnModel().getColumn(6).setPreferredWidth(40); // 주소
		
		table.setShowHorizontalLines(false); // 수평 라인 안보이게 처리
		table.setShowVerticalLines(false); // 수직 라인 안보이게 처리
		table.setSelectionBackground(Color.orange);
		table.setSelectionForeground(Color.blue);
		table.setRowMargin(0);
		table.setIntercellSpacing(new Dimension(0,0));
		table.setRequestFocusEnabled(false); // 특정 셀에 포커스 설정 안되게 처리
		
		table.setSelectionMode(0); // 0:단일선택, 1:다중선택, -2:선택안함
		
		table.getTableHeader().setReorderingAllowed(false); // 헤더고정
		table.getTableHeader().setMaximumSize(new Dimension(110,0));
		table.getTableHeader().setMinimumSize(new Dimension(10,0));
		table.setAlignmentX(JTable.CENTER_ALIGNMENT); // 정렬
		table.setAlignmentY(JTable.CENTER_ALIGNMENT);
		//---------------------------------------------------------------
			
	}
	
	// File | Exit action performed - 메뉴 File의 Exit 메뉴를 클릭시 종료 처리
	public void jMenuFileExit_actionPerformed(ActionEvent e){
		disconnProcess();
		System.exit(0);
	}
	
	// Help | About action performed - 메뉴의 About 메뉴를 클릭시 다이얼로그 창 띄우기
	public void jMenuHelpAbout_actionPerformed(ActionEvent e){
		JdbcMainFrame_AboutBox dlg = new JdbcMainFrame_AboutBox(this);
		// ------------------다이얼로그 창 중앙에 배치---------------------
		Dimension dlgSize = dlg.getPreferredSize();
		Dimension frmSize = getSize();
		Point loc = getLocation();
		dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
		// 다이얼 로그 창이 뜨면 백그라운드 클릭이 안되게 처리
		// 다이얼로그 창을 닫아야 백그라운드 화면 클릭 가능
		dlg.setModal(true); dlg.pack();
		dlg.setVisible(true);
	}
	
	// Statement 객체 생성
	Statement stmt;
	
	// sqlUpdate 데이터 값을 받아서 Mysql에 넘겨주는 메소드
	public boolean sqlUpdate(String sql){
		System.out.println("update SQL : " + sql);
		Statement stmt1 = null;
		try {
			stmt1 = conn.createStatement();
			int i = stmt.executeUpdate(sql);
			System.out.println(i + "개의 데이터 업데이트 성공");
			return true;
		}catch(Exception e){
			System.out.println("데이터 업데이트 실패 : " + e.getMessage());
			return false;
		}finally{
			try{
				stmt1.close();
			}catch(Exception e1){}
		}
	}
	
	// 입력 이벤트 추가 및 Mysql로 데이터 넘겨주는 메소드
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ev) {
		Object ob = ev.getSource(); // 이벤트가 발생된 컴포넌트 정보를 Object형으로 얻는다.
		String s;
		if(ob == this.insertB) { // 입력버튼 클릭시
			    s = "INSERT INTO member VALUES('"+this.idTF.getText().trim()+"','" +
					new String(this.pwdTF.getPassword()) + "','" +
					this.nameTF.getText().trim() + "','" +
					this.jumin1TF.getText().trim() + this.jumin2.getText().trim() + "','" +
					this.emailTF.getText().trim() + "','" +
					this.phoneTF.getText().trim() + "','" +
					(this.male.isSelected() ? "남자" : "여자") + "','" +
					this.addrTF.getText().trim() + "')";
				
			    if(sqlUpdate(s)){
			    	JOptionPane.showMessageDialog(this, "데이터 추가 성공", "데이터 입력성공", JOptionPane.DEFAULT_OPTION);;
			    	sqlQuery("SELECT * FROM member");
			    }

		}
		// SelectDialog 검색 
		else if(ob == this.selectB){
			this.sdialog.setVisible(true);
		}
		// reservB(예약 버튼 클릭)
		else if(ob == this.reservB) {
			String s1;
		    s = "INSERT INTO reserve VALUES('"+this.reservTF.getText().trim()+"','" +
				this.roomTF.getText().trim() + "','" +
				this.cusTF.getText().trim() + "','" +
				this.dateTF.getText().trim() + "')";
		    
		    // 예약버튼 클릭시 ROOM테이블의 예약상태를 TRUE로 변경하기 위한 질의문
			s1 = "UPDATE room SET state='TRUE' WHERE room_no='"+this.roomTF.getText().trim()+"'";
		    if(sqlUpdate(s)){
		    	JOptionPane.showMessageDialog(this, "데이터 추가 성공", "데이터 입력성공", JOptionPane.DEFAULT_OPTION);;
		    	sqlQuery1("SELECT * FROM reserve");
		    }
		    // 예약버튼 클릭시 ROOM테이블의 예약상태가 TRUE로 변하게된다.
		    if(sqlUpdate(s1)){
		    	JOptionPane.showMessageDialog(this, "데이터 변경 성공!", "데이터 변경 성공", JOptionPane.DEFAULT_OPTION);;
		    	sqlQuery2("SELECT * FROM room");
		    }
		}
		else if(ob == this.deleteB){
			String s1, s2;
			int row = table.getSelectedRow(); // 삭제할 MEMBER테이블 선택된 행 얻기
			int row1 = table1.getSelectedRow(); // ROOM테이블의 예약상태를 변경하기위한 RSERVER테이블에서 행선택
			if(row < 0) { // JTable에 선택된 행이 없는 경우
				JOptionPane.showMessageDialog(this, "삭제할 대상을 선택해 주세요", "선택오류", JOptionPane.DEFAULT_OPTION);
				return;
			}
			if(row1 < 0) { // JTable에 선택된 행이 없는 경우
				JOptionPane.showMessageDialog(this, "삭제할 대상을 선택해 주세요", "선택오류", JOptionPane.DEFAULT_OPTION);
				return;
			}
			String key_id = (String)model.getValueAt(row, 0); // 고객번호를 얻는다
			String key_room = (String)model1.getValueAt(row1, 1); // 고객번호를 얻는다
			String sql = "DELETE FROM member WHERE id = '"+ key_id + "'"; // member 테이블의 행 삭제
			// member 테이블에서 고객이 삭제되면 예약되어있던것도 삭제
			s1 = "DELETE FROM reserve WHERE id = '"+ key_id + "'"; 
			// 예약되있던게 없어지면 ROOM테이블에서의 예약상태가 다시 FALSE로 변경되기 위한 질의문
			s2 = "UPDATE room SET state='FALSE' WHERE room_no='"+ key_room + "'";
			if(sqlUpdate(sql)){
				JOptionPane.showMessageDialog(this, "데이터 삭제 성공 했어요!", "데이터 삭제 성공", JOptionPane.DEFAULT_OPTION);
				sqlQuery("SELECT * FROM member");
			}
			else {
				JOptionPane.showMessageDialog(this, "데이터 삭제 실패!", "실패", JOptionPane.DEFAULT_OPTION);;
				return;
			}
			// MEMBER테이블에서 고객 삭제시 RESERVE테이블에서 예약되어있던 고객도 연쇄 삭제
			if(sqlUpdate(s1)){
				JOptionPane.showMessageDialog(this, "데이터 삭제 성공 했어요!", "데이터 삭제 성공", JOptionPane.DEFAULT_OPTION);
				sqlQuery1("SELECT * FROM reserve");
			}
			// 예약상태 변경
			if(sqlUpdate(s2)){
				JOptionPane.showMessageDialog(this, "데이터 변경 성공 했어요!", "데이터 변경 성공", JOptionPane.DEFAULT_OPTION);
				sqlQuery2("SELECT * FROM room");
			}

		}
		// 예약취소
		else if(ob == this.cancelB){
			int row1 = table1.getSelectedRow(); // 선택된 행 얻기
			String s2; // 예약상태를 변경하기위한 변수 
			if(row1 < 0) { // JTable1에 선택된 행이 없는 경우
				JOptionPane.showMessageDialog(this, "삭제할 대상을 선택해 주세요", "선택오류", JOptionPane.DEFAULT_OPTION);
				return;
			}
			String key_id = (String)model1.getValueAt(row1, 0); // 예약번호를 얻는다
			String sql = "DELETE FROM reserve WHERE rsv_no = '"+ key_id + "'";
			// 예약 취소시  ROOM테이블의 예약상태를 FALSE로 변경
			s2 = "UPDATE room SET state='FALSE' WHERE room_no='"+this.roomTF.getText().trim()+"'";
			if(sqlUpdate(sql)){
				JOptionPane.showMessageDialog(this, "데이터 삭제 성공 했어요!", "데이터 삭제 성공", JOptionPane.DEFAULT_OPTION);
				sqlQuery1("SELECT * FROM reserve");
			}
			else {
				JOptionPane.showMessageDialog(this, "데이터 삭제 실패 했어요!", "데이터 삭제 실패", JOptionPane.DEFAULT_OPTION);;
				return;
			}
			// 예약상태 변경
			if(sqlUpdate(s2)){
				JOptionPane.showMessageDialog(this, "데이터 변경 성공 했어요!", "데이터 변경 성공", JOptionPane.DEFAULT_OPTION);
				sqlQuery2("SELECT * FROM room");
			}
		}
		
		// 수정(패스워드는 수정 불가)
		else if(ob == this.updateB){
			int row2 = table.getSelectedRow(); // 선택된 행 얻기
			if(row2 < 0) { // JTable1에 선택된 행이 없는 경우
				JOptionPane.showMessageDialog(this, "수정할 대상을 선택해 주세요", "선택오류", JOptionPane.DEFAULT_OPTION);
				return;
			}
			// Mysql의 Update문에서 where 절을 수행할 값을 저장
			String key_id = (String)model.getValueAt(row2, 0); // 고객번호를 얻는다
			String sql = "UPDATE member SET addr='"+ this.addrTF.getText().trim() +"'"+"WHERE id='"+ key_id + "'"; // 주소 수정
			String sql1 = "UPDATE member SET name='"+ this.nameTF.getText().trim() +"'"+"WHERE id='"+ key_id + "'"; // 이름 수정
			String sql2 = "UPDATE member SET email='"+ this.emailTF.getText().trim() +"'"+"WHERE id='"+ key_id + "'"; // 이메일 수정
			String sql3 = "UPDATE member SET phone='"+ this.phoneTF.getText().trim() +"'"+"WHERE id='"+ key_id + "'"; // 핸드폰 번호 수정
			String sql4 = "UPDATE member SET idno='"+ this.jumin1TF.getText().trim() + this.jumin2.getText().trim() +"'"+"WHERE id='"+ key_id + "'"; // 주민등혹번호 수정
			
			// sql
			if(sqlUpdate(sql)){
				sqlQuery("SELECT * FROM member");
			}
			else {
				JOptionPane.showMessageDialog(this, "데이터 수정 실패 했어요!", "데이터 수정 실패", JOptionPane.DEFAULT_OPTION);;
				return;
			}
			// sql1
			if(sqlUpdate(sql1)){
				sqlQuery("SELECT * FROM member");
			}
			else {
				JOptionPane.showMessageDialog(this, "데이터 수정 실패 했어요!", "데이터 수정 실패", JOptionPane.DEFAULT_OPTION);;
				return;
			}
			// sql2
			if(sqlUpdate(sql2)){
				sqlQuery("SELECT * FROM member");
			}
			else {
				JOptionPane.showMessageDialog(this, "데이터 수정 실패 했어요!", "데이터 수정 실패", JOptionPane.DEFAULT_OPTION);;
				return;
			}
			// sql3
			if(sqlUpdate(sql3)){
				sqlQuery("SELECT * FROM member");
			}
			else {
				JOptionPane.showMessageDialog(this, "데이터 수정 실패 했어요!", "데이터 수정 실패", JOptionPane.DEFAULT_OPTION);;
				return;
			}
			// sql4
			if(sqlUpdate(sql4)){
				sqlQuery("SELECT * FROM member");
			}
			else {
				JOptionPane.showMessageDialog(this, "데이터 수정 실패 했어요!", "데이터 수정 실패", JOptionPane.DEFAULT_OPTION);;
				return;
			}
		}
		// 방등록
		else if(ob == this.registB){
			s = "INSERT INTO room VALUES('"+this.rnTF.getText().trim()+"','" +
					(this.Agrade.isSelected() ? "A" : "B") + "','" +
					this.psbTF.getText().trim() + "','" +
					this.statTF.getText().trim() + "')";
				
			    if(sqlUpdate(s)){
			    	JOptionPane.showMessageDialog(this, "데이터 추가 성공", "데이터 입력성공", JOptionPane.DEFAULT_OPTION);;
			    	sqlQuery2("SELECT * FROM room");
			    }
		}
		// 방삭제
		else if(ob == this.NregistB){
			int row2 = table2.getSelectedRow(); // 선택된 행 얻기
			if(row2 < 0) { // JTable2에 선택된 행이 없는 경우
				JOptionPane.showMessageDialog(this, "삭제할 대상을 선택해 주세요", "선택오류", JOptionPane.DEFAULT_OPTION);
				return;
			}
			String key_id = (String)model2.getValueAt(row2, 0); // 예약번호를 얻는다
			String sql = "DELETE FROM room WHERE room_no = '"+ key_id + "'";
			if(sqlUpdate(sql)){
				JOptionPane.showMessageDialog(this, "데이터 삭제 성공 했어요!", "데이터 삭제 성공", JOptionPane.DEFAULT_OPTION);
				sqlQuery2("SELECT * FROM room");
			}
			else {
				JOptionPane.showMessageDialog(this, "데이터 삭제 실패 했어요!", "데이터 삭제 실패", JOptionPane.DEFAULT_OPTION);;
				return;
			}
		}
	}
	
	// 첫 번째 member 테이블
	public void sqlQuery(String sql) {
		System.out.println("query SQL : " + sql);
		Connection con = connProcess();
		
		try{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			model.setNumRows(0); // JTable에 출력된 기존의 데이터를 깨끗이 청소
			while(rs.next()) { // 결과셋에서 커서를 이동시켜 가면서 데이터를 얻는다.
				String data[] = { // JTable에 출력하기 위해서 1차원 배열 생성
						rs.getString(1), // Select된 결과셋에서 인덱스 1의 데이터를 얻는다. // 고객번호
						rs.getString(3), // 이름
						rs.getString(4), // 주민번호
						rs.getString(5), // 이메일
						rs.getString(6), // 휴대폰
						rs.getString(7), // 성별
						rs.getString(8)}; // 주소
					model.addRow(data); // JTable에 1차원 배열의 값을 추가	
			}
		}catch(Exception e){
			System.out.println("데이터 Select 실패 : " + e.getMessage());
		}
	}
	
	// 두번째 reserve 테이블
	public void sqlQuery1(String sql) {
		System.out.println("query SQL : " + sql);
		Connection con1 = connProcess();
		
		try{
			stmt = conn.createStatement();
			ResultSet rs1 = stmt.executeQuery(sql);
			model1.setNumRows(0); // JTable에 출력된 기존의 데이터를 깨끗이 청소
			while(rs1.next()) { // 결과셋에서 커서를 이동시켜 가면서 데이터를 얻는다.
				String data1[] = { // JTable에 출력하기 위해서 1차원 배열 생성
						rs1.getString(1), // 예약번호
						rs1.getString(2), // 방번호
						rs1.getString(3), // 고객번호
						rs1.getString(4)}; // 예약날짜
					model1.addRow(data1); // JTable에 1차원 배열의 값을 추가	
			}
		}catch(Exception e){
			System.out.println("데이터 Select 실패 : " + e.getMessage());
		}
	}
	
	// 세번째 reserve 테이블
	public void sqlQuery2(String sql) {
		System.out.println("query SQL : " + sql);
		Connection con2 = connProcess();
		
		try{
			stmt = conn.createStatement();
			ResultSet rs2 = stmt.executeQuery(sql);
			model2.setNumRows(0); // JTable에 출력된 기존의 데이터를 깨끗이 청소
			while(rs2.next()) { // 결과셋에서 커서를 이동시켜 가면서 데이터를 얻는다.
				String data2[] = { // JTable에 출력하기 위해서 1차원 배열 생성
						rs2.getString(1), // 방번호
						rs2.getString(2), // 등급
						rs2.getString(3), // 허용인원
						rs2.getString(4)}; // 예약상태
					model2.addRow(data2); // JTable에 1차원 배열의 값을 추가	
			}
		}catch(Exception e){
			System.out.println("데이터 Select 실패 : " + e.getMessage());
		}
	}
	
	// MouseListener 이벤트 처리
	public void mousePressed(MouseEvent e) { // JTable에서 마우스 클릭시
		int row = table.getSelectedRow(); // 선택된 행 얻기
		int row1 = table1.getSelectedRow(); // 선택된 행 얻기
		int row2 = table2.getSelectedRow(); // 선택된 행 얻기
		
		//--------------------1번째 JTable------------------------- 
		if(row < 0) return;
		// 선택된 행번호와 열을 가지고 값을 얻어 화면의 텍스트 컴포넌트에 값 설정
		this.idTF.setText((String)model.getValueAt(row, 0));
		// 비밀번호는 수정 못하도록 일반숫자로 설정
		this.pwdTF.setText("12345678");
		this.nameTF.setText((String)model.getValueAt(row, 1));
		String temp = (String)(model.getValueAt(row, 2));
		this.jumin1TF.setText(temp.substring(0,6));
		this.jumin2.setText(temp.substring(6));
		this.emailTF.setText((String)model.getValueAt(row, 3));
		this.phoneTF.setText((String)model.getValueAt(row, 4));
		String temp1 = (String)model.getValueAt(row, 5);
		if(temp1.equals("남자"))
			this.male.setSelected(true);
		else
			this.female.setSelected(true);
		this.addrTF.setText((String)model.getValueAt(row, 6));
		
		//--------------------2번째 JTable------------------------- 
		if(row1 < 0) return;
		// 선택된 행번호와 열을 가지고 값을 얻어 화면의 텍스트 컴포넌트에 값 설정
		this.reservTF.setText((String)model1.getValueAt(row1, 0));
		this.roomTF.setText((String)model1.getValueAt(row1, 1));
		this.cusTF.setText((String)model1.getValueAt(row1, 2));
		this.dateTF.setText((String)model1.getValueAt(row1, 3));
		
		//--------------------3번째 JTable------------------------- 
		if(row2 < 0) return;
		// 선택된 행번호와 열을 가지고 값을 얻어 화면의 텍스트 컴포넌트에 값 설정
		this.rnTF.setText((String)model2.getValueAt(row2, 0));
		String temp2 = (String)model2.getValueAt(row2, 1);
		if(temp2.equals("A"))
			this.Agrade.setSelected(true);
		else
			this.Bgrade.setSelected(true);
		this.psbTF.setText((String)model2.getValueAt(row2, 2));
		this.statTF.setText((String)model2.getValueAt(row2, 3));
		
	}
	
	// MouseListener 선언된 메소드 모두 구현
	public void mouseClicked(MouseEvent ev) {}
	public void mouseEntered(MouseEvent ev) {}
	public void mouseExited(MouseEvent ev) {}
	public void mouseReleased(MouseEvent ev) {}
	
	
	// 윈도우 클로우즈 아이콘 클릭시 종료 이벤트 처리
	protected void processWindowEvent(WindowEvent e){
		super.processWindowEvent(e);
		if(e.getID() == WindowEvent.WINDOW_CLOSING) {
			jMenuFileExit_actionPerformed(null);
		}
	}
	
	// DB연결 끊기
	public void disconnProcess() {
		try {
			if(this.conn != null) {this.conn.close(); }
		}catch(Exception e){}
		JOptionPane.showMessageDialog(this, "서버와 연결을 끊었습니다", "끊기 성공", JOptionPane.DEFAULT_OPTION);
		return;
	}
	
	// DB접속을 위한 메소드
	public Connection connProcess() {
		String url = "jdbc:mysql://localhost/hotel";
		String user = "root";
		String passwd = "201363240";
		System.out.println("데이터 베이스와 연결중.....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 적재 성공");
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("데이터베이스 연결 성공");
		}catch(ClassNotFoundException e1){
			System.out.println("연결실패 : 드라이버 로딩 실패");
			
		}catch (SQLException e2) {
			System.out.println("연결에 실패하였습니다.");
	    }
		System.out.println("연결 성공");
		return conn;
	}
	
} // end class