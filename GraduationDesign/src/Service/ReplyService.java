package Service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DBConnection;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Date;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ReplyService
 */
@WebServlet("/ReplyService")
public class ReplyService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rs = 0;
		System.out.print("in Reply");
		Date date = new Date();
		String account = request.getParameter("account");
		String postID = request.getParameter("POSTID");
		String content = request.getParameter("CONTENT");
		boolean type = false;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		JSONObject json = new JSONObject();

		try {
			conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into cumtb.post values('" + content + "','" + "','" + date.toString() + "','" + account
					+ "'," + postID + ");";
			rs = stmt.executeUpdate(sql);
			if (rs == 1)
				type = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.Close(null, null, conn);
			json.put("msg", type);
			response.getWriter().write(json.toString());
			out.flush();
			out.close();
		}
	}
}
