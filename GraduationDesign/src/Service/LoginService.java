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
 * Servlet implementation class service
 */
@WebServlet("/service")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginService() {
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
		System.out.println("in Login");
		String ID= request.getParameter("ID");
		String PW= request.getParameter("PW");
		boolean type = false;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();  
        Connection conn=null;
		JSONObject json = new JSONObject();
		
		try {
			conn=DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			String sql="select * from cumtb.student where Account = "+ID+" and Password = "+PW;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				type=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnection.Close(null, null, conn);
			json.put("msg", type);
			System.out.println(json.toString());
			response.getWriter().write(json.toString());
			out.flush();
			out.close();
		}
	}

}
