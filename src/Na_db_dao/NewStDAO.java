package Na_db_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Na_db_common.DBConnect;
import Na_db_dto.NewStDTO;

public class NewStDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public NewStDAO() {
		con = DBConnect.getConnect2();
	}

	public void getList() {
		String sql = "select * from newst";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<NewStDTO> getList2() {
		String sql = "select * from newst";
		ArrayList<NewStDTO> list = new ArrayList<NewStDTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("id"));
				NewStDTO dto = new NewStDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));

				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}