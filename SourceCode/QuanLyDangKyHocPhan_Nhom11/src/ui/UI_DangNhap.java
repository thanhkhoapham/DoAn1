package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import dao.TaiKhoanDAO;
import entity.TaiKhoan;

import javax.swing.JPasswordField;


public class UI_DangNhap extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8434066949541141856L;
	private JPanel contentPane;
	private JTextField txtDangNhap;
	private JButton btnThoat;
	private JButton btnDangNhap;
	private JPasswordField txtMatKhau;
	private TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
	private static final int TESTER = 0;
	private static final int ADMIN = 1;
	private static final int NHANVIEN = 2;
	private static final int SINHVIEN = 3;
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new UI_DangNhap());
	}
	
	public UI_DangNhap() {		
		
		setTitle("Đăng nhập tài khoản");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.15);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.CENTER);

		JPanel pnlNorth = new JPanel();
		splitPane.setLeftComponent(pnlNorth);
		pnlNorth.setLayout(new BorderLayout(0, 0));

		JLabel lblTieuDe = new JLabel("Đăng Nhập Tài Khoản");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlNorth.add(lblTieuDe, BorderLayout.CENTER);

		JPanel pnlCenter = new JPanel();
		splitPane.setRightComponent(pnlCenter);
		pnlCenter.setLayout(null);

		txtDangNhap = new JTextField();
		txtDangNhap.setHorizontalAlignment(SwingConstants.LEFT);
		txtDangNhap.setBounds(160, 40, 190, 20);
		pnlCenter.add(txtDangNhap);
		txtDangNhap.setColumns(10);

		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setIcon(new ImageIcon("img/login.png"));
		btnDangNhap.setBounds(66, 126, 132, 41);
		pnlCenter.add(btnDangNhap);

		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setBounds(69, 40, 85, 25);
		pnlCenter.add(lblNewLabel);

		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setBounds(68, 90, 77, 14);
		pnlCenter.add(lblMtKhu);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("img/user.png"));
		lblNewLabel_3.setBounds(21, 11, 46, 59);
		pnlCenter.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon("img/key.png"));
		lblNewLabel_3_1.setBounds(20, 64, 46, 59);
		pnlCenter.add(lblNewLabel_3_1);

		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("img/exit.png"));
		btnThoat.setBounds(215, 126, 131, 41);
		pnlCenter.add(btnThoat);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(160, 90, 190, 20);
		pnlCenter.add(txtMatKhau);
		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);
		
		getRootPane().setDefaultButton(btnDangNhap);
		ImageIcon main = new ImageIcon("img/main_icon.png");
		setIconImage(main.getImage());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o= e.getSource();
		try {
			if(o.equals(btnDangNhap)) {
				String user = txtDangNhap.getText().trim();
				char[] pw = txtMatKhau.getPassword();
				String password = new String(pw);
				
				TaiKhoan taiKhoan = new TaiKhoan(user, password);
				if (user.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
					txtDangNhap.requestFocus();
				}
				else {
					int loaiTK = taiKhoanDAO.dangNhap(taiKhoan);
					switch (loaiTK) {
					case TESTER: {
						this.dispose();
						new UI_test(taiKhoan.getTenDangNhap());	
						break;
					}
					case ADMIN: {
						this.dispose();
						new UI_QuanLy(taiKhoan.getTenDangNhap());
						break;
					}
					case NHANVIEN: {
						this.dispose();
						new UI_NhanVienPDT(taiKhoan.getTenDangNhap());
						break;
					}
					case SINHVIEN: {
						this.dispose();
						new UI_SinhVien(taiKhoan.getTenDangNhap());
					
						break;
					}
					default:
						JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
						txtDangNhap.requestFocus();
					}
				}
				
			}else if(o.equals(btnThoat)) {
				if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát không?", "Chú ý",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
}
