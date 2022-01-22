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

import ui.form.frm_HuyLopHocPhan;
import ui.form.frm_QuanLyChuyenNganh;
import ui.form.frm_QuanLyGiangVien;
import ui.form.frm_QuanLyHocPhan;
import ui.form.frm_QuanLyKhoa;
import ui.form.frm_QuanLyLopHP;
import ui.form.frm_QuanLyNhanVienPDT;
import ui.form.frm_QuanLySinhVien;
import ui.form.frm_TimKiemGiangVien;
import ui.form.frm_TimKiemHocPhan;
import ui.form.frm_TimKiemNhanVienPDT;
import ui.form.frm_TimKiemSinhVien;

public class UI_QuanLy extends JFrame{
	private frm_QuanLyGiangVien pnlQLGiangVien = new frm_QuanLyGiangVien();
	private frm_QuanLySinhVien pnlSinhVien = new frm_QuanLySinhVien();
	private frm_TimKiemSinhVien pnlTimKiemSV = new frm_TimKiemSinhVien();
	private frm_QuanLyHocPhan pnlQLHocPhan = new frm_QuanLyHocPhan();
	private frm_QuanLyNhanVienPDT pnlQuanLyNhanVienPDT = new frm_QuanLyNhanVienPDT();
	private frm_TimKiemNhanVienPDT pnlTimKiemNV = new frm_TimKiemNhanVienPDT();
	private frm_QuanLyKhoa pnlQuanLyKhoa = new frm_QuanLyKhoa();
	private frm_QuanLyChuyenNganh pnlQuanLyChuyenNganh = new frm_QuanLyChuyenNganh();
	private frm_TimKiemGiangVien pnlTKGiangVien = new frm_TimKiemGiangVien();
	private frm_TimKiemHocPhan pnlTimKiemHocPhan = new frm_TimKiemHocPhan();
	
	public UI_QuanLy(String uname) {
		Font font = new Font("Times New Roman ", Font.PLAIN,18);
		Font font2 = new Font("Times New Roman ", Font.PLAIN,16);
		
		frm_QuanLyLopHP pnlLopHP = new frm_QuanLyLopHP(uname);
		frm_HuyLopHocPhan pnlHuyLopHP = new frm_HuyLopHocPhan(uname);
		
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
		
		JMenuItem jmiQuanLySV = new JMenuItem("Quản lý", new ImageIcon("img/capnhat.png"));
//		jmCapNhatSV.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		jmiQuanLySV.setFont(font2);
		mnSinhVien.add(jmiQuanLySV);
		
		JMenuItem jmiTimKiemSV = new JMenuItem("Tìm kiếm", new ImageIcon("img/timkiem.png"));
		jmiTimKiemSV.setFont(font2);
		mnSinhVien.add(jmiTimKiemSV);
		
		JMenu mnGiangVien = new JMenu("Giảng viên");
		mnGiangVien.setFont(font);
		menuBar.add(mnGiangVien);
		
		JMenuItem jmiQuanLyGV = new JMenuItem("Quản lý", new ImageIcon("img/capnhat.png"));
		jmiQuanLyGV.setFont(font2);
		mnGiangVien.add(jmiQuanLyGV);
		
		JMenuItem jmiTimKiemGV = new JMenuItem("Tìm kiếm", new ImageIcon("img/timkiem.png"));
		jmiTimKiemGV.setFont(font2);
		mnGiangVien.add(jmiTimKiemGV);
		
		JMenu mnNhanVien = new JMenu("Nhân viên PDT");
		mnNhanVien.setFont(font);
		menuBar.add(mnNhanVien);
		
		JMenuItem jmiQuanLyNV = new JMenuItem("Quản lý", new ImageIcon("img/capnhat.png"));
		jmiQuanLyNV.setFont(font2);
		mnNhanVien.add(jmiQuanLyNV);
		
		JMenuItem jmiTimKiemNV = new JMenuItem("Tìm kiếm", new ImageIcon("img/timkiem.png"));
		jmiTimKiemNV.setFont(font2);
		mnNhanVien.add(jmiTimKiemNV);
		
		JMenu mnLopHocPhan = new JMenu("Lớp học phần");
		mnLopHocPhan.setFont(font);
		menuBar.add(mnLopHocPhan);
		
		JMenuItem jmiQuanLyLHP = new JMenuItem("Quản lý", new ImageIcon("img/capnhat.png"));
		jmiQuanLyLHP.setFont(font2);
		mnLopHocPhan.add(jmiQuanLyLHP);
		
		JMenu mnHocPhan = new JMenu("Học phần");
		mnHocPhan.setFont(font);
		menuBar.add(mnHocPhan);
		
		JMenuItem jmiQuanLyHP = new JMenuItem("Quản lý", new ImageIcon("img/capnhat.png"));
		jmiQuanLyHP.setFont(font2);
		mnHocPhan.add(jmiQuanLyHP);
		
		JMenuItem jmiTimKiemHP = new JMenuItem("Tìm kiếm", new ImageIcon("img/timkiem.png"));
		jmiTimKiemHP.setFont(font2);
		mnHocPhan.add(jmiTimKiemHP);
		
		JMenu mnKhoa = new JMenu("Khoa");
		mnKhoa.setFont(font);
		menuBar.add(mnKhoa);
		
		JMenuItem jmiQuanLyKhoa = new JMenuItem("Quản lý", new ImageIcon("img/capnhat.png"));
		jmiQuanLyKhoa.setFont(font2);
		mnKhoa.add(jmiQuanLyKhoa);
		
		mnHeThong.setPreferredSize(new Dimension(150, 45));
		mnSinhVien.setPreferredSize(new Dimension(150, 45));
		mnGiangVien.setPreferredSize(new Dimension(150,45));
		mnNhanVien.setPreferredSize(new Dimension(170,45));
		mnLopHocPhan.setPreferredSize(new Dimension(160, 45));
		mnHocPhan.setPreferredSize(new Dimension(150, 45));
		mnKhoa.setPreferredSize(new Dimension(150, 45));
		
		mnHeThong.setIcon(new ImageIcon("img/system.png"));
		mnSinhVien.setIcon(new ImageIcon("img/student.png"));
		mnGiangVien.setIcon(new ImageIcon("img/teacher.png"));
		mnNhanVien.setIcon(new ImageIcon("img/nhanvien.png"));
		mnLopHocPhan.setIcon(new ImageIcon("img/lophocphan.png"));
		mnHocPhan.setIcon(new ImageIcon("img/hocphan.png"));
		mnKhoa.setIcon(new ImageIcon("img/khoa.png"));
		
		jmiDoiMatKhau.setPreferredSize(new Dimension(180, 45));
		jmiDangXuat.setPreferredSize(new Dimension(180, 45));
		jmiThoat.setPreferredSize(new Dimension(180, 45));
		
		jmiQuanLySV.setPreferredSize(new Dimension(220, 45));
		jmiTimKiemSV.setPreferredSize(new Dimension(220, 45));
		
		jmiQuanLyGV.setPreferredSize(new Dimension(180, 45));
		jmiTimKiemGV.setPreferredSize(new Dimension(180, 45));
		
		jmiQuanLyNV.setPreferredSize(new Dimension(180, 45));
		jmiTimKiemNV.setPreferredSize(new Dimension(180, 45));
		
		jmiQuanLyLHP.setPreferredSize(new Dimension(180, 45));
		
		jmiQuanLyHP.setPreferredSize(new Dimension(180, 45));
		jmiTimKiemHP.setPreferredSize(new Dimension(180, 45));
		
		jmiQuanLyKhoa.setPreferredSize(new Dimension(180, 45));
		
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
		
		/*=====================================================================================
		 * Hệ thống
		 */
		jmiTrangChu.addActionListener(e ->{
			setTitle("Xin chào, ADMIN!");
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
		jmiQuanLySV.addActionListener(e ->{
			setTitle("Quản lý sinh viên");
			tabbedPane.removeAll();
			tabbedPane.addTab("Quản lý sinh viên", new ImageIcon("img/add.png"), pnlSinhVien, "Quản lý sinh viên");
		});
		
		jmiTimKiemSV.addActionListener(e ->{
			setTitle("Tìm kiếm sinh viên");
			tabbedPane.removeAll();
			tabbedPane.addTab("Tìm kiếm sinh viên", new ImageIcon("img/timkiem.png"), pnlTimKiemSV, "Tìm kiếm sinh viên");
		});
		
		/*======================================================================================
		 * Giảng viên
		 */
		jmiQuanLyGV.addActionListener(e ->{
			setTitle("Quản lý giảng viên");
			tabbedPane.removeAll();
			tabbedPane.addTab("Quản lý giảng viên", new ImageIcon("img/add.png"), pnlQLGiangVien, "Quản lý giảng viên");
		});
		
		jmiTimKiemGV.addActionListener(e ->{
			setTitle("Quản lý giảng viên");
			tabbedPane.removeAll();
			tabbedPane.addTab("Tìm kiếm giảng viên", new ImageIcon("img/timkiem.png"), pnlTKGiangVien, "Tìm kiếm giảng viên");
		});
		
		/*======================================================================================
		 * Nhân viên phòng đào tạo
		 */
		jmiQuanLyNV.addActionListener(e ->{
			setTitle("Quản lý nhân viên");
			tabbedPane.removeAll();
			tabbedPane.addTab("Quản lý nhân viên", new ImageIcon("img/add.png"), pnlQuanLyNhanVienPDT, "Quản lý nhân viên");
		});
		
		jmiTimKiemNV.addActionListener(e ->{
			setTitle("Quản lý nhân viên");
			tabbedPane.removeAll();
			tabbedPane.addTab("Tìm kiếm nhân viên", new ImageIcon("img/timkiem.png"), pnlTimKiemNV, "Tìm kiếm nhân viên");
		});
		/*======================================================================================
		 * Lớp học phần
		 */
		jmiQuanLyLHP.addActionListener(e ->{
			setTitle("Quản lý lớp học phần");
			tabbedPane.removeAll();
			tabbedPane.addTab("Quản lý lớp học phần", new ImageIcon("img/add.png"), pnlLopHP, "Quản lý lớp học phần");
			tabbedPane.addTab("Hủy lớp học phần", new ImageIcon("img/delete.png"), pnlHuyLopHP, "Hủy lớp học phần");
		});
		/*======================================================================================
		 * Học phần
		 */
		jmiQuanLyHP.addActionListener(e ->{
			setTitle("Quản lý học phần");
			tabbedPane.removeAll();
			tabbedPane.addTab("Quản lý học phần", new ImageIcon("img/add.png"), pnlQLHocPhan, "Quản lý học phần");
		});
		
		jmiTimKiemHP.addActionListener(e ->{
			setTitle("Quản lý học phần");
			tabbedPane.removeAll();
			tabbedPane.addTab("Tìm kiếm học phần", new ImageIcon("img/timkiem.png"), pnlTimKiemHocPhan, "Tìm kiếm học phần");
		});

		/*======================================================================================
		 * Khoa
		 */
		jmiQuanLyKhoa.addActionListener(e ->{
			setTitle("Quản lý khoa");
			tabbedPane.removeAll();
			tabbedPane.addTab("Quản lý khoa", new ImageIcon("img/add.png"), pnlQuanLyKhoa, "Quản lý khoa");
			tabbedPane.addTab("Quản lý chuyên ngành", new ImageIcon("img/add.png"), pnlQuanLyChuyenNganh, "Quản lý chuyên ngành");
		});
		
		//======================================================================================
		setTitle("Xin chào, ADMIN!");
		setSize(1350, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
//		      setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon main = new ImageIcon("img/main_icon.png");
		setIconImage(main.getImage());
	
		tabbedPane.addTab("Trang chủ", new ImageIcon("img/home.png"), pnlMain, "Trang chủ");
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new UI_QuanLy("admin"));
	}
}
