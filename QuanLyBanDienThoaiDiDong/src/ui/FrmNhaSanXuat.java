import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.Database;
import db.DbUtils;
import entity.DienThoai;
import entity.NhaSanXuat;
import helper.NSXhelper;;

public class FrmNhaSanXuat extends JFrame implements ActionListener{
 
	private JTextField txtMaNSX;
	private JTextField txtTenNSX;
	
	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnSua;
	private JButton btnXoa;
	private JLabel lblMauTin;
	private DefaultTableModel dataModel;
	private JTable table;
	private JButton btnXemDSDT;
	private NSXhelper nhaSanXuatHelper;
	private int tongSoMauTin;
	private int mauTinHienHanh;

	public FrmNhaSanXuat() {
		setTitle("Thông tin nhà sản xuất");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				DbUtils.close(Database.getConnection());
				System.exit(0);
			}
		});

		Box b, b1, b2, b3, b4, b5, b6, b7;
		//Dùng Box layout
		add(b = Box.createVerticalBox()); //Box theo chiều dọc
		b.add(Box.createVerticalStrut(10)); //Tạo khoảng cách theo chiều dọc
		b.add(b1 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); //b1 -> b7: Box theo chiều ngang
		b.add(b2 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b3 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b4 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b5 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b6 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b7 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 

		JLabel lblTieuDe, lblMaNSX, lblTenNX;
		b1.add(lblTieuDe = new JLabel("THÔNG TIN NHÀ SẢN XUẤT", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 26));

		b2.add(lblMaNSX = new JLabel("Mã nhà sản xuất: ", JLabel.RIGHT)); b2.add(txtMaNSX = new JTextField());
		b3.add(lblTenNX = new JLabel("Tên nhà sản xuất: ", JLabel.RIGHT)); b3.add(txtTenNSX = new JTextField());
		

		lblMaNSX.setPreferredSize(lblTenNX.getPreferredSize());
		

		b4.add(Box.createHorizontalStrut(70));
		
		
		b4.add(btnThem = new JButton("Thêm"));
		b4.add(btnLuu= new JButton("Lưu"));
		b4.add(btnSua = new JButton("Sửa"));
		b4.add(btnXoa = new JButton("Xóa"));

		String[] headers = {"Mã nhà sản xuất ", "Tên nhà sản xuất"};
		dataModel = new DefaultTableModel(headers , 0);
		JScrollPane scroll;
		b5.add(scroll = new JScrollPane(table = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách nhà sản xuất"));

		b6.add(Box.createHorizontalStrut(200));
		b6.add(btnXemDSDT = new JButton("Xem danh sách điện thoại của nhà sản xuất hiện tại"));
		btnXemDSDT.setForeground(Color.black);
		moKhoaTextfields(false);
		moKhoaControls(true);
		btnLuu.setEnabled(false);
		//Khi chương trình chạy, nạp toàn bộ danh sách lớp học lên bảng
		nhaSanXuatHelper = new NSXhelper();
		table.setRowHeight(25);
		for(NhaSanXuat nsx : nhaSanXuatHelper.getAllNhaSanXuat()){
			Object[] rowData = {nsx.getMaNSX(), nsx.getTenNSX()};
			dataModel.addRow(rowData);
		}
	}
	private void moKhoaControls(boolean b) {
		
		btnThem.setEnabled(b);
		btnLuu.setEnabled(b);
		btnSua.setEnabled(b);
		btnXoa.setEnabled(b);
		btnXemDSDT.setEnabled(b);
		}
	private void moKhoaTextfields(boolean b) {
		txtMaNSX.setEditable(b);
		txtTenNSX.setEditable(b);
	}
	private void xoaRongTextfields() {
		txtMaNSX.setText("");
		txtTenNSX.setText("");
		txtMaNSX.requestFocus();
	}
	
	private void napdulieuVaoTextfields() {
		int row = table.getSelectedRow();
		if(row >= 0){
			txtMaNSX.setText((String) table.getValueAt(row, 0));
			txtTenNSX.setText((String) table.getValueAt(row, 1));
			
		}
	}
	
	table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		
			napdulieuVaoTextfields();
		}
	});

		
	
	

		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXemDSDT.addActionListener(this);

	}
@Override
public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	if(o.equals(btnThem)){
		if(btnThem.getText().equalsIgnoreCase("Them")){
			moKhoaTextfields(true);
			moKhoaControls(false);
			btnLuu.setEnabled(true);
			btnThem.setEnabled(true);
			xoaRongTextfields();
			btnThem.setText("Huy");
		}
		else if(btnThem.getText().equalsIgnoreCase("Huy")){
			moKhoaTextfields(false);
			moKhoaControls(true);
			btnLuu.setEnabled(false);
			btnThem.setText("Them");
			napdulieuVaoTextfields();
			}

		}
	
	}

}
