package ui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout.Alignment;

import dao.KetQuaHocTapDAO;
import dao.SinhVienDAO;
import entity.SinhVien;
import ui.form.frm_DangKyHocPhan;
import ui.form.frm_KetQuaHocTap;
import ui.form.frm_XemCacMonDangKy;
import ui.form.frm_XemLichHoc;

public class UI_SinhVien extends JFrame{
	private SinhVienDAO svDAO = new SinhVienDAO();
	private KetQuaHocTapDAO kqDAO = new KetQuaHocTapDAO();
	
	public UI_SinhVien(String uname) {
		Font font = new Font("Times New Roman ", Font.PLAIN,18);
		Font font2 = new Font("Times New Roman ", Font.PLAIN,16);
		
		frm_DangKyHocPhan pnlDangKyHP = new frm_DangKyHocPhan(uname);
		frm_XemCacMonDangKy pnlXemCacMonDangKy = new frm_XemCacMonDangKy(uname);
		frm_KetQuaHocTap pnlKQHT = new frm_KetQuaHocTap(uname);
		frm_XemLichHoc pnlLichHoc = new frm_XemLichHoc(uname);
		
		System.err.println(svDAO.layThongTinSV(uname));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHeThong = new JMenu("Hệ thống");
		mnHeThong.setFont(font);
		menuBar.add(mnHeThong);
		

		JMenuItem jmiTrangChu = new JMenuItem("Trang chủ", new ImageIcon("img/home.png"));
		jmiTrangChu.setFont(font2);
		mnHeThong.add(jmiTrangChu);
		
		JMenuItem jmiDoiMatKhau = new JMenuItem("Đổi mật khẩu", new ImageIcon("img/key.png"));
		jmiDoiMatKhau.setFont(font2);
		mnHeThong.add(jmiDoiMatKhau);
		
		JMenuItem jmiDangXuat = new JMenuItem("Đăng xuất", new ImageIcon("img/logout.png"));
		jmiDangXuat.setFont(font2);
		mnHeThong.add(jmiDangXuat);
		
		JMenuItem jmiThoat = new JMenuItem("Thoát", new ImageIcon("img/exit.png"));
		jmiThoat.setFont(font2);
		mnHeThong.add(jmiThoat);
		
		JMenu mnSinhVien = new JMenu("Sinh viên");
		mnSinhVien.setFont(font);
		menuBar.add(mnSinhVien);
		
		JMenuItem jmiDKHP = new JMenuItem("Đăng ký học phần", new ImageIcon("img/hocphan.png"));
//		jmDKHP.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_MASK));
		jmiDKHP.setFont(font2);
		mnSinhVien.add(jmiDKHP);
		
		JMenuItem jmiXemTKB = new JMenuItem("Xem thời khóa biểu", new ImageIcon("img/lichhoc.png"));
		jmiXemTKB.setFont(font2);
		mnSinhVien.add(jmiXemTKB);
		
		JMenuItem jmiXemKQHT = new JMenuItem("Xem kết quả học tập", new ImageIcon("img/kqht.png"));
		jmiXemKQHT.setFont(font2);
		mnSinhVien.add(jmiXemKQHT);
		
		mnHeThong.setPreferredSize(new Dimension(150, 45));
		mnSinhVien.setPreferredSize(new Dimension(150, 45));
		
		mnHeThong.setIcon(new ImageIcon("img/system.png"));
		mnSinhVien.setIcon(new ImageIcon("img/student.png"));
		
		jmiDoiMatKhau.setPreferredSize(new Dimension(180, 45));
		jmiDangXuat.setPreferredSize(new Dimension(180, 45));
		jmiThoat.setPreferredSize(new Dimension(180, 45));
		
		jmiDKHP.setPreferredSize(new Dimension(220, 45));
		jmiXemTKB.setPreferredSize(new Dimension(220, 45));
		jmiXemKQHT.setPreferredSize(new Dimension(220, 45));
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setFont(font);
		getContentPane().add(tabbedPane);
		
		JLabel lblMain = new JLabel();
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setIcon(new ImageIcon("img/trangChu03.png"));
		lblMain.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JPanel pnlMain = new JPanel();
		GroupLayout layout = new GroupLayout(pnlMain);
		pnlMain.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
				.addComponent(lblMain, GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap()));
		
		SinhVien sv = svDAO.layThongTinSV(uname);
		
		/*=====================================================================================
		 * Hệ thống
		 */
		jmiTrangChu.addActionListener(e ->{
			setTitle("Test");
			tabbedPane.removeAll();
			tabbedPane.addTab("Trang chủ", new ImageIcon("img/home.png"), pnlMain, "Trang chủ");
		});
		
		jmiDoiMatKhau.addActionListener(e ->{
			new UI_DoiMatKhau(uname);
		});
		
		jmiDangXuat.addActionListener(e ->{
			if (JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không?", "Chú ý", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				this.dispose();
				UI_DangNhap.main(null);
			}
		});
		
		jmiThoat.addActionListener(e ->{
			if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát không?", "Chú ý", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				System.exit(EXIT_ON_CLOSE);;
			}
		});
		
		/*======================================================================================
		 * Sinh viên
		 */		
		jmiDKHP.addActionListener(e ->{
			setTitle("Đăng ký học phần");
			tabbedPane.removeAll();
			tabbedPane.addTab("Đăng ký học phần", new ImageIcon("img/hocphan.png"), pnlDangKyHP, "Đăng ký học phần");
			tabbedPane.addTab("Xem các môn đã đăng ký", new ImageIcon("img/hocphan.png"), pnlXemCacMonDangKy, "Xem các môn đã đăng ký");
		});
		
		jmiXemTKB.addActionListener(e ->{
			setTitle("Xem thời khóa biểu");
			tabbedPane.removeAll();
			tabbedPane.addTab("Xem thời khóa biểu", new ImageIcon("img/lichhoc.png"), pnlLichHoc, "Xem thời khóa biểu");
		});
		
		jmiXemKQHT.addActionListener(e ->{
			setTitle("Kết quả học tập");
			tabbedPane.removeAll();
			tabbedPane.addTab("Kết quả học tập", new ImageIcon("img/kqht.png"), pnlKQHT, "Xem kết quả học tập");
//			pnlKQHT.loadTBKetQuaHT(sv.getMaSinhVien());
		});
		
		//======================================================================================
		setTitle("Xin chào, "+ sv.getTenSinhVien()+"!");
		setSize(1350, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
        ImageIcon main = new ImageIcon("img/main_icon.png");
		setIconImage(main.getImage());
	
		tabbedPane.addTab("Trang chủ", new ImageIcon("img/home.png"), pnlMain, "Trang chủ");     
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new UI_SinhVien("tester"));
	}
}
