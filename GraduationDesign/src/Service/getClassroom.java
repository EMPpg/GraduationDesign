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
import java.util.ArrayList;
import java.util.HashMap;
import com.google.gson.Gson;
/**
 * Servlet implementation class BookClassroom
 */
@WebServlet("/BookClassroom")
public class getClassroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getClassroom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in getClassroom");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();  
        Connection conn=null;
		ArrayList<HashMap<String,Object>> jsonList = new ArrayList<HashMap<String,Object>>();
		try {
			conn=DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			String sql="select * from cumtb.classroom";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				HashMap<String,Object> prMap = new HashMap<String,Object>();
				prMap.put("classNumber", rs.getInt(1));
				prMap.put("Floor", rs.getInt(2));
				prMap.put("MaximumPeople", rs.getInt(3));
				prMap.put("PeoplepPresent", rs.getInt(4));
				jsonList.add(prMap);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnection.Close(null, null, conn);
			Gson gson = new Gson();
			String jsonString = gson.toJson(jsonList);
			response.getWriter().write(jsonString);
			System.out.println(jsonString);
			out.flush();
			out.close();
		}
	}

}
