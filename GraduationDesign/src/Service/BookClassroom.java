package Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DBConnection;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class BookClassroom
 */
@WebServlet("/BookClassroom")
public class BookClassroom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookClassroom() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in BookClassroom");
		String classNumber = request.getParameter("classNumber");
		int type = 0;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		JSONObject json = new JSONObject();
		int people = 0;
		try {
			conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from cumtb.classroom where roomnumber = "+classNumber;
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				people = rs.getInt(4);
				people++;
			}
			String people_update = people+"";
			sql = "update cumtb.classroom set presentpeople = "+people_update+"where roomnumber = "+classNumber;
			type = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.Close(null, null, conn);
			if(type==1) json.put("msg", "true");
			System.out.println(json.toString());
			response.getWriter().write(json.toString());
			out.flush();
			out.close();
		}
	}

}
