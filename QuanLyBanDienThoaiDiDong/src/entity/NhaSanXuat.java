/**
 * 
 */
package entity;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.DbUtils;


/**
 * @author Admin
 *
 */
public class NhaSanXuat {
	private String maNSX;
	private String tenNSX;
	private List<DienThoai>dsDienThoai;
	
	public NhaSanXuat(String ma,String ten){
		this.maNSX=ma;
		this.tenNSX=ten;
		dsDienThoai=new ArrayList<DienThoai>();
	}
	public NhaSanXuat(String ma)
	{
		this(ma,"ten nsx");
	}
	public NhaSanXuat()
	{
		this("mã nsx");
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNSX == null) ? 0 : maNSX.hashCode());
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
		} else if (!maNSX.equalsIgnoreCase(other.maNSX))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NhaSanXuat [maNSX=" + maNSX + ", tenNSX=" + tenNSX + "]";
	}
	public  boolean create(){
		Connection con=Database.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into NhaSanXuat values(?,?)");
			stmt.setString(1, maNSX);
			stmt.setString(2, tenNSX);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.close(stmt);
		}
		return n>0;
	}
	
	public  boolean update(){
		Connection con=Database.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("update NhaSanXuat"
					+"set tenNSX=?,"
					+"where maNSX=?");
			stmt.setString(1, tenNSX);
			stmt.setString(2, maNSX);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.close(stmt);
		}
		return n>0;
	}
	public  boolean delete(){
		Connection con=Database.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("delete from NhaSanXuat where maNSX=?");
			stmt.setString(1, maNSX);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.close(stmt);
		}
		return n>0;
	}
	public  void read(){
		Connection con=Database.getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=con.prepareStatement("select *from DienThoai where maNSX=?");
			stmt.setString(1, maNSX);
			rs=stmt.executeQuery();
			while(rs.next()){
				DienThoai dt=new DienThoai(rs.getString("MaDT"),rs.getString("TenDT"),rs.getString("CauHinh"),rs.getDouble("Gia"),this);
				dsDienThoai.add(dt);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.close(stmt);
		}
	}
	
	
}
