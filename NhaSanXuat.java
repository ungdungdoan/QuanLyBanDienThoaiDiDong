package entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.databinding.types.soapencoding.Array;

public class NhaSanXuat {
	private String maNSX;
	private String tenNSX;
	private List<DienThoai> dsDienThoai;

	public NhaSanXuat(String maNSX, String tenNSX) {
		super();
		this.maNSX = maNSX;
		this.tenNSX = tenNSX;
		dsDienThoai = new ArrayList<DienThoai>();
	}
	public NhaSanXuat(String maNSX){
		this(maNSX, "TÍn nhaÃ sa“n xu‚Ït");
	}
	
	public NhaSanXuat(){
		this("Maﬁ nhaÃ sa“n xu‚Ït");
	}

	public String getMaNSX() {
		return maNSX;
	}

	public void setMaNSX(String maNSX) {
		this.maNSX = maNSX;
	}

	public String getTenNSX() {
		return tenNSX;
	}

	public void setTenNSX(String tenNSX) {
		this.tenNSX = tenNSX;
	}
	public List<DienThoai> getDsDienThoai() {
		return dsDienThoai;
	}
	@Override
	public String toString() {
		return "NhaSanXuat [tenNSX=" + tenNSX + "]";
	}
		
}
