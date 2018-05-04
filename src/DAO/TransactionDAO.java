package DAO;

import java.sql.SQLException;

public class TransactionDAO extends AbstractDAO  {
	
	public void getTransbyZipcode(int zip,int month , int year){
		//order by day desc
        try {
            getConnection();
            ps = conn.prepareStatement(query.getDisplayCustTransByZip());
            ps.setInt(1,zip);
            ps.setInt(2,month);
            ps.setInt(3,year);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("TRANSACTION_ID")+": "+rs.getString("MONTH")+"/"
                        +rs.getString("DAY")+"/"+rs.getString("YEAR"));
            }
            closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
	}
	
	public void getNumAndTotalByType(String type){
		try {
                getConnection();
                ps = conn.prepareStatement(query.getDisplayNumAndTotalByType());
                ps.setString(1, type);
                rs = ps.executeQuery();
                while(rs.next()){
                    System.out.println(rs.getInt("Number")+", "+rs.getDouble("Total"));
                }
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

	}
	
	public void getNumAndTotalByState(String state){
        try {
            getConnection();
            ps = conn.prepareStatement(query.getDisplayNumAndTotalByState());
            ps.setString(1, state);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("Number")+", "+rs.getDouble("Total"));
            }
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
}
