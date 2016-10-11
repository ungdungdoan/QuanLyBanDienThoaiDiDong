package helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.DbUtils;
import entity.NhaSanXuat;;

public class NSXhelper {
	public List<NhaSanXuat> getAllNhaSanXuat() {
		List<NhaSanXuat> dsnhaSanXuat = new ArrayList<NhaSanXuat>();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("Select *from NhaSanXuat");
			rs = stmt.executeQuery();
			while(rs.next()){
				dsnhaSanXuat.add(new NhaSanXuat(rs.getString("MaNSX"), rs.getString("TenNSX")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(rs, stmt);
		}
		return dsnhaSanXuat;
	}
}
