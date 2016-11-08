package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import db.Database;
import db.DbUtils;



public class NhaSanXuat {
	private String maNSX;
	private String tenNSX;
	private List<DienThoai> dsDienThoai;

	public NhaSanXuat(String maNSX, String tenNSX) {
		
		this.maNSX = maNSX;
		this.tenNSX = tenNSX;
		dsDienThoai = new ArrayList<DienThoai>();
	}
	public NhaSanXuat(String maNSX){
		this(maNSX, "Tên nhà sản xuất");
	}
	
	public NhaSanXuat(){
		this("Mã nhà sản xuất");
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNSX == null) ? 0 : maNSX.hashCode());
		result = prime * result + ((tenNSX == null) ? 0 : tenNSX.hashCode());
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
		NhaSanXuat other = (NhaSanXuat) obj;
		if (maNSX == null) {
			if (other.maNSX != null)
				return false;
		} else if (!maNSX.equals(other.maNSX))
			return false;
		if (tenNSX == null) {
			if (other.tenNSX != null)
				return false;
		} else if (!tenNSX.equals(other.tenNSX))
			return false;
		return true;
	}
	public boolean create() {
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NhaSanXuat values(?,?)");
			stmt.setString(1, maNSX);
			stmt.setString(2, tenNSX);
		
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(stmt);
		}
		return n > 0; 
	}
	public boolean update() {
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NhaSanXuat set TenNSX=? where MaNSX=?"); 
			
			stmt.setString(1, tenNSX);
			stmt.setString(2, maNSX);
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
			stmt = con.prepareStatement("delete from NhaSanXuat where MaNSX = ?");
			stmt.setString(1, maNSX);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(stmt);
		}
		return n > 0; 
	}	
	public void read(){
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs =null;
		
		try {
			stmt = con.prepareStatement("select *from DienThoai where MaNSX = ?");
			stmt.setString(1, maNSX);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				DienThoai dt = new DienThoai(rs.getString("maDT"), rs.getString("tenDT"), rs.getString("cauHinh"),rs.getInt("Gia"),this);
				dsDienThoai.add(dt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(stmt);
		}
		
	}
}