package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

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

import org.apache.xmlbeans.StringEnumAbstractBase.Table;

import entity.DienThoai;
import entity.NhaSanXuat;

public class FrmDienThoai extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1554680235689968471L;
	private JTable table;
	private JScrollPane croll;
	private NhaSanXuat nsx;
	private JTextField txtmaDT;
	private JTextField txttenDT;
	private JTextField txtNSX;
	private JTextField txtcauHinh;

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
		b1.add(lblTieuDe = new JLabel("THÔNG TIN ÐIÊòN THOAòI", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Arila", Font.BOLD, 26) );
		JLabel lblmaDT;
		b2.add(lblmaDT = new JLabel("MaÞ ðiêòn thoaòi",JLabel.RIGHT));
		
		b2.add(txtmaDT = new JTextField());
		JLabel lbltenDT;
		b3.add(lbltenDT = new JLabel("Tên ðiêòn thoaòi",JLabel.RIGHT));
	
		b3.add(txttenDT= new JTextField());
		JLabel lblNSX;
		b4.add(lblNSX = new JLabel("NhaÌ saÒn xuâìt",JLabel.RIGHT));
		
		b4.add(txtNSX = new JTextField());
		JLabel lblcauHinh;
		b5.add(lblcauHinh = new JLabel("Câìu hiÌnh",JLabel.RIGHT));
		
		b5.add(txtcauHinh = new JTextField());
		b6.add(Box.createHorizontalStrut(70));
		JButton btnThem;
		b6.add(btnThem = new JButton("Thêm"));
		JButton btnSua;
		b6.add(btnSua = new JButton("SýÒa"));
		JButton btnXoa;
		b6.add(btnXoa = new JButton("Xoìa"));
		String[] tieude = {"MaÞ Ðiêòn Thoaòi", "Tên Ðiêòn Thoaòi", "NhaÌ SaÒn Xuâìt", "Câìu hiÌnh"};
		
		DefaultTableModel dataModel;
		b7.add(croll = new JScrollPane(table = new JTable(dataModel = new DefaultTableModel(tieude , 0))) );
		croll.setBorder(BorderFactory.createTitledBorder("Danh saìch ðiêòn thoaòi"));
	}
	public FrmDienThoai(NhaSanXuat nsx){
		this();
		this.nsx = nsx;
		
		croll.setBorder(BorderFactory.createTitledBorder("Danh saìch ðiêòn thoaòi cuÒa nhaÌ saÒn xuâìt hiêòn taòi: " + nsx.getTenNSX()));
		for(DienThoai dt : nsx.getDsDienThoai()){
			Object[] rowData = {dt.getMaDT(), dt.getTenDT(), dt.getCauHinh()};
			DefaultTableModel dataModel = null;
			dataModel.addRow(rowData);
		}
		
		table.addMouseListener(new MouseAdapter() {
		
			
		});

	}
	protected void napDuLieuTextfields() {
		int row = table.getSelectedRow();
		if(row >= 0){
			txtmaDT.setText((String) table.getValueAt(row, 0));
			txttenDT.setText((String) table.getValueAt(row, 1));
			txtcauHinh.setText((String) table.getValueAt(row, 2));
		
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
