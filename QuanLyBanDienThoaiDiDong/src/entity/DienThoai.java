/**
 * 
 */
package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.Database;
import db.DbUtils;


/**
 * @author Admin
 *
 */
public class DienThoai {
	private String MaDT;
	private String TenDT;
	private String CauHinh;
	private double Gia;
	private NhaSanXuat nsx;
	
	public DienThoai(String maDT,String tenDT,String ch, double gia,NhaSanXuat nsx){
		this.MaDT=maDT;
		this.TenDT=tenDT;
		this.CauHinh=ch;
		this.Gia=gia;
		this.nsx=nsx;
	}
	public DienThoai(String maDT){
		this(maDT,"tenDT","CauHinh",0,new NhaSanXuat());
	}
	public DienThoai()
	{
		this("M� DT");
	}
	public String getMaDT() {
		return MaDT;
	}
	public void setMaDT(String maDT) {
		MaDT = maDT;
	}
	public String getTenDT() {
		return TenDT;
	}
	public void setTenDT(String tenDT) {
		TenDT = tenDT;
	}
	public String getCauHinh() {
		return CauHinh;
	}
	public void setCauHinh(String cauHinh) {
		CauHinh = cauHinh;
	}
	public double getGia() {
		return Gia;
	}
	public void setGia(double gia) {
		Gia = gia;
	}
	public NhaSanXuat getNsx() {
		return nsx;
	}
	public void setNsx(NhaSanXuat nsx) {
		this.nsx = nsx;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MaDT == null) ? 0 : MaDT.hashCode());
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
		if (MaDT == null) {
			if (other.MaDT != null)
				return false;
		} else if (!MaDT.equalsIgnoreCase(other.MaDT))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DienThoai [MaDT=" + MaDT + ", TenDT=" + TenDT + ", CauHinh=" + CauHinh + ", Gia=" + Gia + ", nsx=" + nsx
				+ "]";
	}
	public  boolean create(){
		Connection con=Database.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into DienThoai values(?,?,?,?,?)");
			stmt.setString(1, MaDT);
			stmt.setString(2, TenDT);
			stmt.setString(3, CauHinh);
			stmt.setDouble(4, Gia);
			stmt.setString(5, nsx.getMaNSX());
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
			stmt=con.prepareStatement("update DienThoai set tenDT=?,CauHinh=?,Gia=? where maDT=?");
			stmt.setString(1, TenDT);
			stmt.setString(2, CauHinh);
			stmt.setDouble(3, Gia);
			stmt.setString(4, MaDT);
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
			stmt=con.prepareStatement("delete from DienThoai where maDT=?");
			stmt.setString(1, MaDT);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.close(stmt);
		}
		return n>0;
	}
	
}

