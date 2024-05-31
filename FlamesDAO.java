import java.sql.*;
public class FlamesDAO {
    static String name;
    static String par_name;

    FlamesDAO(StringBuilder a, StringBuilder b){
        name=new String(a);
        par_name=new String(b);
    }
    public int total_records() throws SQLException{
        Connection con=dbconnection.getConnection();
        Statement st=con.createStatement();
        String query="select count(id) from flameResult;";
        ResultSet rs= st.executeQuery(query);
        rs.next();
        return rs.getInt(1);
    }
    public  void add_result(String result)throws SQLException{
        Connection con=dbconnection.getConnection();
   
        String query="insert into flameResult values(?,?,?,?);";
        PreparedStatement pst=con.prepareStatement(query);
        
        int count=total_records();
        pst.setInt(1, count+1);
        pst.setString(2, name);
        pst.setString(3, par_name);
        pst.setString(4, result);
        pst.executeUpdate();
    }

    public void display() throws SQLException{
        Connection con=dbconnection.getConnection();
        Statement st=con.createStatement();
        String query ="select * from flameResult order by id";
        ResultSet rs=st.executeQuery(query);
        //System.out.println("id   ||   name   ||   P_name   ||   Result");
        while(rs.next()){
            System.out.println(rs.getInt(1)+"   "+"    "+rs.getString(2)+"   "+"    "+rs.getString(3)+"   "+"   "+rs.getString(4));
        }
    }
    
}
