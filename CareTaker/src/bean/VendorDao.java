package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VendorDao {
	private static Connection con=null;
	public static Connection getCon()
	{
		try
		{
			if(con==null)
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","1234");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public static boolean login(Vendor v) {
		boolean flag=false;
		try
		{
			con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from vendor where email=? and password=? and user_type=?");
			ps.setString(1, v.getEmail());
			ps.setString(2, v.getPassword());
			ps.setString(3, v.getUser_type());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	public static int save(Vendor v)
	{
		int r=0;
		try
		{
			con=getCon();
			PreparedStatement ps=con.prepareStatement("insert into vendor values(?,?,?,?,?,?)");
			ps.setString(1, v.getUser_type());
			ps.setString(2, v.getFname());
			ps.setString(3, v.getLname());
			ps.setString(4, v.getPassword());
			ps.setString(5, v.getEmail());
			ps.setString(6, v.getMobile());
			r=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return r;
	}

	public static Vendor search(Vendor v) {
		Vendor obj=null;
		try
		{
			con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from vendor where email=?");
			ps.setString(1, v.getEmail());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				obj=new Vendor();
				obj.setFname(rs.getString(2));
				obj.setLname(rs.getString(3));
				obj.setEmail(rs.getString(5));
				obj.setMobile(rs.getString(6));
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return obj;
		
	}
	

}
