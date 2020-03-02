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
import java.text.SimpleDateFormat;
import java.util.Date;
import net.sf.json.JSONObject;
/**
 * Servlet implementation class PostService
 */
@WebServlet("/PostService")
public class PostService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostService() {
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
		int rs = 0;
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now_date = formater.format(date);
		System.out.print("in Post"+now_date);
		String postname=request.getParameter("POSTNAME");
		String content= request.getParameter("CONTENT");
		boolean type = false;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();  
        Connection conn=null;
		JSONObject json = new JSONObject();
		
		try {
			conn=DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			String sql="insert into cumtb.post values(null,'"+postname+"','"+content+"','"+now_date+"',0,'0206');";
			rs = stmt.executeUpdate(sql);
			if(rs==1) type=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnection.Close(null, null, conn);
			json.put("msg", type);
			response.getWriter().write(json.toString());
			out.flush();
			out.close();
		}
	}
}
