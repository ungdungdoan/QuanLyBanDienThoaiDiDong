package entity;

import java.util.List;

public class DienThoai {
	private String maDT;
	private String tenDT;
	private NhaSanXuat NSX;
	private String cauHinh;
	
	public String getMaDT() {
		return maDT;
	}
	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}
	public String getTenDT() {
		return tenDT;
	}
	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}
	public NhaSanXuat getNSX() {
		return NSX;
	}
	public void setNSX(NhaSanXuat nSX) {
		NSX = nSX;
	}
	public String getCauHinh() {
		return cauHinh;
	}
	public void setCauHinh(String cauHinh) {
		this.cauHinh = cauHinh;
	}

	
	public DienThoai(String maDT, String tenDT, NhaSanXuat nSX, String cauHinh) {
		super();
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.NSX = nSX;
		this.cauHinh = cauHinh;
	}
	public DienThoai(String maDT){
		this(maDT,"",new NhaSanXuat(maDT),"");
	}
	public DienThoai() {
	
		this("MaÞ ðiêòn thoaòi");
	}
	@Override
	public String toString() {
		return "DienThoai [maDT=" + maDT + ", tenDT=" + tenDT + ", NSX=" + NSX + ", cauHinh=" + cauHinh + "]";
	}
	
	
	
}
