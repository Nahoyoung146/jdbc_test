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

	public NewStDTO selectOne(String inputid) {
		NewStDTO dto = null;
		String sql = "select * from newst where id='" + inputid + "'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				// System.out.println("존재하는 id : " + rs.getString("id"));
				dto = new NewStDTO();
				dto.setName(rs.getNString("name"));
				dto.setId(rs.getString("id"));
				dto.setAge(rs.getInt("age"));
			}
			// else {
			// System.out.println("존재하지 않는 id");
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public int insert(String id, String name, int age) {
		String sql = "insert into newst values(?,?,?)";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("동일한 아이디 입력시 문제 발생!!!!!");
			e.printStackTrace();
		}
		return result;
	}

	public int update(NewStDTO d) {
		int result = 0;
		String sql = "update newst set name=?,age=? where id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, d.getName());
			ps.setInt(2, d.getAge());
			ps.setString(3, d.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int delete(String id) {
		int result = 0;
		String sql = "delete from newst where id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}