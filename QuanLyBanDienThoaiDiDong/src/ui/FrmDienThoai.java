package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;










import entity.DienThoai;
import entity.NhaSanXuat;

public class FrmDienThoai extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1554680235689968471L;
	
	private JTable table;
	private JScrollPane scroll;
	private NhaSanXuat nsx;
	private JTextField txtmaDT;
	private JTextField txttenDT;
	private JTextField txtNSX;
	private JTextField txtcauHinh;
	private JTextField txtGia;
	


	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnSua;
	private JButton btnXoa;
	
	private DefaultTableModel dataModel;

	public FrmDienThoai(){
		setTitle("Thong tin dien thoai");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Box b, b1,b2,b3,b4,b5,b6, b7;
		add(b = Box.createVerticalBox());
		b.add(Box.createVerticalStrut(10));b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));b.add(b7 = Box.createHorizontalBox());
		JLabel lblTieuDe;
		b1.add(lblTieuDe = new JLabel("THÔNG TIN ĐIỆN THOẠI", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Arila", Font.BOLD, 26) );
		JLabel lblmaDT;
		b2.add(lblmaDT = new JLabel("Mã điện thoại",JLabel.RIGHT));
		
		b2.add(txtmaDT = new JTextField());
		JLabel lbltenDT;
		b3.add(lbltenDT = new JLabel("Tên điện thoại",JLabel.RIGHT));
	
		b3.add(txttenDT= new JTextField());
		JLabel lblNSX;
		
		JLabel lblcauHinh;
		b4.add(lblcauHinh = new JLabel("Cấu hình",JLabel.RIGHT));
		
		b4.add(txtcauHinh = new JTextField());
		JLabel lblGia;
		b5.add(lblGia = new JLabel("Giá",JLabel.RIGHT));
		b5.add(txtGia= new JTextField());
		
		b6.add(Box.createHorizontalStrut(70));
		
		b6.add(btnThem = new JButton("Thêm"));
		
		b6.add(btnLuu = new JButton("Lưu"));
		b6.add(btnSua = new JButton("Sửa"));
	
		b6.add(btnXoa = new JButton("Xóa"));
		
		String[] tieude = {"Mã điện thoại", "Tên điện thoại", "Cấu hình", "Giá"};
		

		b7.add(scroll = new JScrollPane(table = new JTable(dataModel = new DefaultTableModel(tieude , 0))));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sach dien thoai"));
		

		lblmaDT.setPreferredSize(lbltenDT.getPreferredSize());
		lblcauHinh.setPreferredSize(lbltenDT.getPreferredSize());
		lblGia.setPreferredSize(lbltenDT.getPreferredSize());
	}
}