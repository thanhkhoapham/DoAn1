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

import dao.NhanVienDAO;
import entity.NhanVienPDT;
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

public class UI_NhanVienPDT extends JFrame{
	private NhanVienDAO nvDAO = new NhanVienDAO();
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
	
	public UI_NhanVienPDT(String uname) {
		Font font = new Font("Times New Roman ", Font.PLAIN,18);
		Font font2 = new Font("Times New Roman ", Font.PLAIN,16);
		
		frm_QuanLyLopHP pnlLopHP = new frm_QuanLyLopHP(uname);
		frm_HuyLopHocPhan pnlHuyLopHP = new frm_HuyLopHocPhan(uname);
		
		System.out.println(nvDAO.layThongTinNV(uname));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHeThong = new JMenu("H??? th???ng");
		mnHeThong.setFont(font);
		menuBar.add(mnHeThong);
		
		JMenuItem jmiTrangChu = new JMenuItem("Trang ch???", new ImageIcon("img/home.png"));
		jmiTrangChu.setFont(font2);
		mnHeThong.add(jmiTrangChu);
		
		JMenuItem jmiDoiMatKhau = new JMenuItem("?????i m???t kh???u", new ImageIcon("img/key.png"));
		jmiDoiMatKhau.setFont(font2);
		mnHeThong.add(jmiDoiMatKhau);
		
		JMenuItem jmiDangXuat = new JMenuItem("????ng xu???t", new ImageIcon("img/logout.png"));
		jmiDangXuat.setFont(font2);
		mnHeThong.add(jmiDangXuat);
		
		JMenuItem jmiThoat = new JMenuItem("Tho??t", new ImageIcon("img/exit.png"));
		jmiThoat.setFont(font2);
		mnHeThong.add(jmiThoat);
		
		JMenu mnSinhVien = new JMenu("Sinh vi??n");
		mnSinhVien.setFont(font);
		menuBar.add(mnSinhVien);
		
		JMenuItem jmiQuanLySV = new JMenuItem("Qu???n l??", new ImageIcon("img/capnhat.png"));
		jmiQuanLySV.setFont(font2);
		mnSinhVien.add(jmiQuanLySV);
		
		JMenuItem jmiTimKiemSV = new JMenuItem("T??m ki???m", new ImageIcon("img/timkiem.png"));
		jmiTimKiemSV.setFont(font2);
		mnSinhVien.add(jmiTimKiemSV);
		
		JMenu mnGiangVien = new JMenu("Gi???ng vi??n");
		mnGiangVien.setFont(font);
		menuBar.add(mnGiangVien);
		
		JMenuItem jmiQuanLyGV = new JMenuItem("Qu???n l??", new ImageIcon("img/capnhat.png"));
		jmiQuanLyGV.setFont(font2);
		mnGiangVien.add(jmiQuanLyGV);
		
		JMenuItem jmiTimKiemGV = new JMenuItem("T??m ki???m", new ImageIcon("img/timkiem.png"));
		jmiTimKiemGV.setFont(font2);
		mnGiangVien.add(jmiTimKiemGV);
		
		JMenu mnLopHocPhan = new JMenu("L???p h???c ph???n");
		mnLopHocPhan.setFont(font);
		menuBar.add(mnLopHocPhan);
		
		JMenuItem jmiQuanLyLHP = new JMenuItem("Qu???n l??", new ImageIcon("img/capnhat.png"));
		jmiQuanLyLHP.setFont(font2);
		mnLopHocPhan.add(jmiQuanLyLHP);
		
		JMenu mnHocPhan = new JMenu("H???c ph???n");
		mnHocPhan.setFont(font);
		menuBar.add(mnHocPhan);
		
		JMenuItem jmiQuanLyHP = new JMenuItem("Qu???n l??", new ImageIcon("img/capnhat.png"));
		jmiQuanLyHP.setFont(font2);
		mnHocPhan.add(jmiQuanLyHP);
		
		JMenuItem jmiTimKiemHP = new JMenuItem("T??m ki???m", new ImageIcon("img/timkiem.png"));
		jmiTimKiemHP.setFont(font2);
		mnHocPhan.add(jmiTimKiemHP);
		
		mnHeThong.setPreferredSize(new Dimension(150, 45));
		mnSinhVien.setPreferredSize(new Dimension(150, 45));
		mnGiangVien.setPreferredSize(new Dimension(150,45));
		mnLopHocPhan.setPreferredSize(new Dimension(160, 45));
		mnHocPhan.setPreferredSize(new Dimension(150, 45));
		
		mnHeThong.setIcon(new ImageIcon("img/system.png"));
		mnSinhVien.setIcon(new ImageIcon("img/student.png"));
		mnGiangVien.setIcon(new ImageIcon("img/teacher.png"));
		mnLopHocPhan.setIcon(new ImageIcon("img/lophocphan.png"));
		mnHocPhan.setIcon(new ImageIcon("img/hocphan.png"));
		
		jmiDoiMatKhau.setPreferredSize(new Dimension(180, 45));
		jmiDangXuat.setPreferredSize(new Dimension(180, 45));
		jmiThoat.setPreferredSize(new Dimension(180, 45));
		
		jmiQuanLySV.setPreferredSize(new Dimension(220, 45));
		jmiTimKiemSV.setPreferredSize(new Dimension(220, 45));
		
		jmiQuanLyGV.setPreferredSize(new Dimension(180, 45));
		jmiTimKiemGV.setPreferredSize(new Dimension(180, 45));
		
		jmiQuanLyLHP.setPreferredSize(new Dimension(180, 45));
		
		jmiQuanLyHP.setPreferredSize(new Dimension(180, 45));
		jmiTimKiemHP.setPreferredSize(new Dimension(180, 45));
		
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
		
		NhanVienPDT nv = nvDAO.layThongTinNV(uname);
		
		/*=====================================================================================
		 * H??? th???ng
		 */
		jmiTrangChu.addActionListener(e ->{
			setTitle("Xin ch??o, "+ nv.getTenNhanVien()+"!");
			tabbedPane.removeAll();
			tabbedPane.addTab("Trang ch???", new ImageIcon("img/home.png"), pnlMain, "Trang ch???");
		});
		
		jmiDoiMatKhau.addActionListener(e ->{
			new UI_DoiMatKhau(uname);
		});
		
		jmiDangXuat.addActionListener(e ->{
			if (JOptionPane.showConfirmDialog(this, "B???n c?? mu???n ????ng xu???t kh??ng?", "Ch?? ??", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				this.dispose();
				UI_DangNhap.main(null);
			}
		});
		
		jmiThoat.addActionListener(e ->{
			if (JOptionPane.showConfirmDialog(this, "B???n c?? mu???n tho??t kh??ng?", "Ch?? ??", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				System.exit(EXIT_ON_CLOSE);;
			}
		});
		
		/*======================================================================================
		 * Sinh vi??n
		 */
		jmiQuanLySV.addActionListener(e ->{
			setTitle("Qu???n l?? sinh vi??n");
			tabbedPane.removeAll();
			tabbedPane.addTab("Qu???n l?? sinh vi??n", new ImageIcon("img/add.png"), pnlSinhVien, "Qu???n l?? sinh vi??n");
		});
		
		jmiTimKiemSV.addActionListener(e ->{
			setTitle("T??m ki???m sinh vi??n");
			tabbedPane.removeAll();
			tabbedPane.addTab("T??m ki???m sinh vi??n", new ImageIcon("img/timkiem.png"), pnlTimKiemSV, "T??m ki???m sinh vi??n");
		});
		
		/*======================================================================================
		 * Gi???ng vi??n
		 */
		jmiQuanLyGV.addActionListener(e ->{
			setTitle("Qu???n l?? gi???ng vi??n");
			tabbedPane.removeAll();
			tabbedPane.addTab("Qu???n l?? gi???ng vi??n", new ImageIcon("img/add.png"), pnlQLGiangVien, "Qu???n l?? gi???ng vi??n");
		});
		
		jmiTimKiemGV.addActionListener(e ->{
			setTitle("Qu???n l?? gi???ng vi??n");
			tabbedPane.removeAll();
			tabbedPane.addTab("T??m ki???m gi???ng vi??n", new ImageIcon("img/timkiem.png"), pnlTKGiangVien, "T??m ki???m gi???ng vi??n");
		});
		
		/*======================================================================================
		 * L???p h???c ph???n
		 */
		jmiQuanLyLHP.addActionListener(e ->{
			setTitle("Qu???n l?? l???p h???c ph???n");
			tabbedPane.removeAll();
			tabbedPane.addTab("Qu???n l?? l???p h???c ph???n", new ImageIcon("img/add.png"), pnlLopHP, "Qu???n l?? l???p h???c ph???n");
			tabbedPane.addTab("H???y l???p h???c ph???n", new ImageIcon("img/delete.png"), pnlHuyLopHP, "H???y l???p h???c ph???n");
		});
		
		/*======================================================================================
		 * H???c ph???n
		 */
		jmiQuanLyHP.addActionListener(e ->{
			setTitle("Qu???n l?? h???c ph???n");
			tabbedPane.removeAll();
			tabbedPane.addTab("Qu???n l?? h???c ph???n", new ImageIcon("img/add.png"), pnlQLHocPhan, "Qu???n l?? h???c ph???n");
		});
		
		jmiTimKiemHP.addActionListener(e ->{
			setTitle("Qu???n l?? h???c ph???n");
			tabbedPane.removeAll();
			tabbedPane.addTab("T??m ki???m h???c ph???n", new ImageIcon("img/timkiem.png"), pnlTimKiemHocPhan, "T??m ki???m h???c ph???n");
		});
		
		//======================================================================================
		setTitle("Xin ch??o, "+ nv.getTenNhanVien()+"!");
		setSize(1350, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
        ImageIcon main = new ImageIcon("img/main_icon.png");
		setIconImage(main.getImage());
	
		tabbedPane.addTab("Trang ch???", new ImageIcon("img/home.png"), pnlMain, "Trang ch???");
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new UI_NhanVienPDT("tester"));
	}
}
