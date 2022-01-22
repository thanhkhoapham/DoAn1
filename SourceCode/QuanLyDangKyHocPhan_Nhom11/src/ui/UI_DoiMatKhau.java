package ui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.TaiKhoanDAO;
import entity.TaiKhoan;



public class UI_DoiMatKhau extends JFrame{
	private JPasswordField txtMatKhau;
	private JPasswordField txtMatKhauMoi, txtXacNhan;
	private JButton btnDoiMK;
	private TaiKhoanDAO taiKhoanDAO= new TaiKhoanDAO();

	public UI_DoiMatKhau(String uname) {
		setTitle("Đổi mật khẩu");
		setSize(370, 250);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		ImageIcon main = new ImageIcon("img/main_icon.png");
		setIconImage(main.getImage());

		Container cp = getContentPane();

		JPanel pnlTop, pnlBot;


		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("img/user.png");
		label.setIcon(icon);


		cp.add(pnlTop = new JPanel());
		pnlTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		pnlTop.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel lbDangNhap = new JLabel("Mật khẩu: ", JLabel.LEFT);
		JLabel lbMatKhau = new JLabel("Mật khẩu mới: ", JLabel.LEFT);
		JLabel lbXacNhan = new JLabel("Nhập lại mật khẩu mới: ", JLabel.LEFT);

		
		txtMatKhau = new JPasswordField(15);
		txtMatKhauMoi = new JPasswordField(15);
		txtXacNhan = new JPasswordField(15);

		c.insets = new Insets(0, 1, 0, 1);
		c.ipadx = 250;
		c.ipady = 5;
		c.fill = GridBagConstraints.BOTH;
		pnlTop.add(lbDangNhap, c);

		c.gridy = 1;
		c.ipadx = 25;
		pnlTop.add(txtMatKhau, c);

		c.gridy = 2;
		pnlTop.add(lbMatKhau, c);

		c.gridy = 3;
		pnlTop.add(txtMatKhauMoi, c);
		
		c.gridy = 4;
		pnlTop.add(lbXacNhan, c);
		
		c.gridy = 5;
		pnlTop.add(txtXacNhan, c);

		cp.add(pnlBot = new JPanel(), BorderLayout.SOUTH);
		pnlBot.setPreferredSize(new Dimension(0, 55));
		pnlBot.add(btnDoiMK = new JButton("Đổi mật khẩu"));
		btnDoiMK.setIcon(new ImageIcon("img/key.png"));


		getRootPane().setDefaultButton(btnDoiMK); // Dùng phím Enter
		
		btnDoiMK.addActionListener(e ->{
			char[] mk = txtMatKhau.getPassword();
			String matkhau = new String(mk);
			
			char[] mkm = txtMatKhauMoi.getPassword();
			String matkhaumoi = new String(mkm);
			
			char[] xnmk = txtXacNhan.getPassword();
			String xacnhanmk = new String(xnmk);
			
			System.out.println(matkhau +" "+matkhaumoi);
			
			TaiKhoan tkold = new TaiKhoan(uname, matkhau);
			TaiKhoan tknew = new TaiKhoan(uname, matkhaumoi);
			
//			System.out.println(uname);
//			System.out.println(taiKhoanDAO.dangNhap(tkold));
			
			if(matkhau.trim().equals("") || matkhaumoi.trim().equals("") || xacnhanmk.trim().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
			
			else if(taiKhoanDAO.dangNhap(tkold)>0) {
				if(matkhaumoi.equals(xacnhanmk)) {
//					System.out.println(tknew);
					taiKhoanDAO.doiMatKhau(tknew, uname);
					JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!!");
					this.dispose();
				}else {
					JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại không đúng!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Sai mật khẩu!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		});
	}
	
}

