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
	public FrmDienThoai(NhaSanXuat nsx){
		this();
		this.nsx= nsx;
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách điện thoại của nhà sản xuất:  "+  nsx.getMaNSX()));
		table.setRowHeight(25);
		for(DienThoai dt : nsx.getDsDienThoai()){
			Object[] rowData = {dt.getMaDT(),dt.getTenDT(),dt.getCauHinh(),dt.getGia()};
			dataModel.addRow(rowData);
		}
		
		table.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
			napDuLieuTextfields();
			}
			
		});
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
		{
			Object o = e.getSource();
			if(o.equals(btnThem))
				{
				if(btnThem.getText().equalsIgnoreCase("Thêm"))
				{
					moKhoaTextfields(true);
					moKhoaControls(false);
					btnLuu.setEnabled(true);
					btnThem.setEnabled(true);
					xoaRongTextfields();
					btnThem.setText("Hủy");
				}
				else if(btnThem.getText().equalsIgnoreCase("Hủy"))
				{
					moKhoaTextfields(false);
					moKhoaControls(true);
					btnLuu.setEnabled(false);
					btnThem.setText("Thêm");
					napDuLieuTextfields();
				
				}
			}else if(o.equals(btnLuu)){
			if(btnThem.getText().equalsIgnoreCase("Hủy")){
					DienThoai dt = new DienThoai(txtmaDT.getText(), txttenDT.getText(),txtcauHinh.getText(),Integer.parseInt(txtGia.getText()),nsx);
				if(dt.create()){
					Object[] rowData = {txtmaDT.getText(), txttenDT.getText(),txtcauHinh.getText(),txtGia.getText()};
					dataModel.addRow(rowData);

					moKhoaTextfields(false);
					moKhoaControls(true);
					btnLuu.setEnabled(false);
					btnThem.setText("Thêm");		
				
				}
			}else if(o.equals(btnSua)){
				if(btnSua.getText().equalsIgnoreCase("Sửa")){
					moKhoaTextfields(true);
					txtmaDT.setEditable(false);
					moKhoaControls(false);
					btnLuu.setEnabled(true);
					btnSua.setEnabled(true);
					btnSua.setText("Hủy");
				}else if(btnSua.getText().equalsIgnoreCase("Hủy")){
					moKhoaTextfields(false);
					moKhoaControls(true);
					btnLuu.setEnabled(false);
					btnSua.setText("Sửa");
					napDuLieuTextfields();
				}
			}
		}
			
	}
	
		private void moKhoaControls(boolean b) {
			
			btnThem.setEnabled(b);
			btnLuu.setEnabled(b);
			btnSua.setEnabled(b);
			btnXoa.setEnabled(b);
			
		}
		
		private void moKhoaTextfields(boolean b) {
			txtmaDT.setEditable(b);
			txtcauHinh.setEditable(b);
			txttenDT.setEditable(b);
			txtGia.setEditable(b);
			
			
		}
		private void xoaRongTextfields() {
			txtmaDT.setText("");
			txttenDT.setText("");
			txtcauHinh.setText("");
			txtGia.setText("");
		
			txtmaDT.requestFocus();
		}
		protected void napDuLieuTextfields()
			{
				int row = table.getSelectedRow();
				if(row >= 0)
				{
					txtmaDT.setText(table.getValueAt(row, 0)+"");
					txttenDT.setText(table.getValueAt(row, 1)+"");
					txtcauHinh.setText(table.getValueAt(row, 2)+"");
					txtGia.setText(table.getValueAt(row, 3)+"");
			

				}
			
			}
		
}