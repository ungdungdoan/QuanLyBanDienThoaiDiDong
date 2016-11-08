package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.management.MXBean;

import db.Database;
import db.DbUtils;

public class DienThoai {
	private String maDT;
	private String tenDT;
	private NhaSanXuat NSX;
	private String cauHinh;
	private int Gia;
	
	
	public String getMaDT() {
		return maDT;
	}
	
	public int getGia() {
		return Gia;
	}

	public void setGia(int gia) {
		Gia = gia;
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

	public DienThoai(String maDT, String tenDT, String cauHinh, int gia, NhaSanXuat nSX) {
		super();
		this.maDT = maDT;
		this.tenDT = tenDT;
		NSX = nSX;
		this.cauHinh = cauHinh;
		Gia = gia;
	}

	public DienThoai(String maDT){
		this(maDT,"","",0,new NhaSanXuat(maDT));
	}
	public DienThoai() {
	
		this("Mã điện thoại");
	}

	@Override
	public String toString() {
		return "DienThoai [maDT=" + maDT + ", tenDT=" + tenDT + ", NSX=" + NSX + ", cauHinh=" + cauHinh + ", Gia=" + Gia
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDT == null) ? 0 : maDT.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DienThoai other = (DienThoai) obj;
		if (maDT == null) {
			if (other.maDT != null)
				return false;
		} else if (!maDT.equals(other.maDT))
			return false;
		return true;
	}
	public boolean create()
	{
		Connection con = Database.getConnection();
		PreparedStatement stmt =null;
		int n =0;
		try {
			stmt=con.prepareStatement("insert into DienThoai values(?,?,?,?,?)");
			stmt.setString(1, maDT);
			stmt.setString(2, tenDT);
			stmt.setString(3, cauHinh);
			stmt.setInt(4, Gia);
			stmt.setString(5, NSX.getMaNSX());
					n= stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.close(stmt);
		}
		return n >0;
	}
	public boolean update() {
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update DienThoai set TenDT = ?, CauHinh = ?, Gia=? where MaDT = ?");
			stmt.setString(1, tenDT);
			stmt.setString(2, cauHinh);		
			stmt.setInt(3, Gia);
			stmt.setString(4, maDT);
		
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(stmt);
		}
		return n > 0;
	}
	public boolean delete() {
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from DienThoai where MaDT = ?");
			stmt.setString(1, maDT);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(stmt);
		}
		return n > 0;
	}
}