package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao {
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
	public static int save(Service s) {
		int r=0,id=0;
		try
		{
			con=getCon();
			PreparedStatement ps=con.prepareStatement("select max(id) from vendor_service");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			id=rs.getInt(1);
			PreparedStatement ps1=con.prepareStatement("insert into vendor_service values(?,?,?,?,?,?)");
			ps1.setString(1, s.getEmail());
			ps1.setString(2, s.getService_type());
			ps1.setString(3, s.getService());
			ps1.setString(4, s.getCharges());
			ps1.setString(5, s.getWarranty());
			ps1.setInt(6, ++id);
			r=ps1.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return r;
	}
	public static List display(Vendor v) {
		List list=new ArrayList();
		try
		{
			con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from vendor_service where vendor_email=?");
			ps.setString(1, v.getEmail());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Service obj=new Service();
				obj.setEmail(rs.getString(1));
				obj.setService_type(rs.getString(2));
				obj.setService(rs.getString(3));
				obj.setCharges(rs.getString(4));
				obj.setWarranty(rs.getString(5));
				obj.setId(rs.getInt(6));
				list.add(obj);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public static int update(Service s) {
		int r=0;
		try
		{
			con=getCon();
			PreparedStatement ps=con.prepareStatement("update vendor_service set vendor_email=?,service_type=?,ervice=?,visit_charge=?,warranty=? where id=?");
			ps.setString(1, s.getEmail());
			ps.setString(2, s.getService_type());
			ps.setString(3, s.getService());
			ps.setString(4, s.getCharges());
			ps.setString(5, s.getWarranty());
			ps.setInt(6, s.getId());
			
			r=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return r;
	}
	public static int delete(Service s) {
		int r=0;
		try
		{
			con=getCon();
			
			PreparedStatement ps=con.prepareStatement("delete from vendor_service where id=?");
			ps.setInt(1, s.getId());
			r=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return r;
	}
	public static List displayAll() {
		List list=new ArrayList();
		try
		{
			con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from vendor_service");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Service obj=new Service();
				obj.setEmail(rs.getString(1));
				obj.setService_type(rs.getString(2));
				obj.setService(rs.getString(3));
				obj.setCharges(rs.getString(4));
				obj.setWarranty(rs.getString(5));
				obj.setId(rs.getInt(6));
				list.add(obj);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	

}
