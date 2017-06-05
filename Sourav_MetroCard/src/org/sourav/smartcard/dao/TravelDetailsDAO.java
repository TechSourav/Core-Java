package org.sourav.smartcard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.sourav.delhi.metrosmartcard.util.CardTrx;
import org.sourav.delhi.metrosmartcard.util.CustomerDetails;
import org.sourav.delhi.metrosmartcard.util.SmartCardDetails;

public class TravelDetailsDAO {

	private static TravelDetailsDAO jdbc;

	private TravelDetailsDAO() {

	}

	public static TravelDetailsDAO getInstance() {
		if (jdbc == null) {
			jdbc = new TravelDetailsDAO();
		}
		return jdbc;
	}
	
	private static Connection getConnection()throws ClassNotFoundException, SQLException  
    {  
          
        Connection con=null;  
        Class.forName("com.mysql.jdbc.Driver");  
        con= DriverManager.getConnection("jdbc:mysql://localhost:8080/", "sourav", "sourav");  
        return con;  
          
    }  
	
	
	public int insertSmartCardDtls(SmartCardDetails cardDtl,
			CustomerDetails custDtl, TimeZone time)
			throws SQLException {
		
		Calendar startTime=Calendar.getInstance(time);
		Connection c = null;

		PreparedStatement ps = null;

		int recordCounter = 0;

		try {

			c = this.getConnection();
			ps = c.prepareStatement("insert into T_Card_Transaction(cardNum,cardId,custName,StartTime,EndTime,FromStation,DestinationStation)values(?,?,?,?,?,?,?)");
			
			ps.setString(1, cardDtl.getCardNum());
			ps.setString(2, cardDtl.getScId());
			ps.setString(2, custDtl.getName());
			ps.setObject(2, startTime.getTime());
			ps.setString(2, null); // End time not to be stored during swipe In
			ps.setString(2, cardDtl.getStartStation());
			ps.setString(2, cardDtl.getEndStation());
			
			recordCounter = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (c != null) {
				c.close();
			}
		}
		return recordCounter;
	}
	
	public int updateEndTime(SmartCardDetails cardDtl,
			CardTrx trx, TimeZone time) throws SQLException  {  
		
        
		Calendar endTime=Calendar.getInstance(time);
		Connection c=null;  
        PreparedStatement ps=null;  
          
        int recordCounter=0;  
        try {  
                c=this.getConnection();  
                ps=c.prepareStatement(" update T_Card_Transaction set EndTime=?, DestinationStation=?, fare=?, balance=? where cardId='"+cardDtl.getScId()+"' ");  
                ps.setObject(1, endTime);  
                ps.setObject(1, trx.getDestination());
                ps.setObject(1, trx.getFare());
                ps.setObject(1, trx.getBalance());
                recordCounter=ps.executeUpdate();  
        } catch (Exception e) {  e.printStackTrace(); } finally{  
                
            if (ps!=null){  
                ps.close();  
            }if(c!=null){  
                c.close();  
            }   
         }  
       return recordCounter;  
    } 
	
	public  List<SmartCardDetails> getListOfCardDetails(String name) throws SQLException  
    { 
	  ArrayList<SmartCardDetails> cardList=new ArrayList<SmartCardDetails>();
	  SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
      Connection con = null;  
      PreparedStatement ps = null;  
      ResultSet rs = null;  
                
              try {  
                    
                      con=this.getConnection();  
                      ps=con.prepareStatement("select * from T_Card_Transaction");  
                      rs=ps.executeQuery();  
                      
                      while (rs.next()) {  
                    	  SmartCardDetails cardDtl= new SmartCardDetails();
                    	  cardDtl.setCardNum(rs.getString("cardNum"));
                    	  cardDtl.setScId(rs.getString("cardId"));
                    	  cardDtl.getCustomerDtl().setName(rs.getString("custName"));
                    	  cardDtl.setStartTime(formatter.parse(rs.getString("StartTime")));
                    	  cardDtl.setEndTime(formatter.parse(rs.getString("EndTime")));
                    	  cardDtl.setStartStation(rs.getString("FromStation"));           
                    	  cardDtl.setEndStation(rs.getString("DestinationStation"));
                    	  cardList.add(cardDtl);
                    	} 
                     
              
        } catch (Exception e) { System.out.println(e);}  
        finally{  
                  if(rs!=null){  
                      rs.close();  
                  }if (ps!=null){  
                    ps.close();  
                }if(con!=null){  
                    con.close();  
                }   
              }
              return cardList;
    }  
	
	
	public  List<CardTrx> getListOfCardDetailsFromCardTrx(SmartCardDetails name) throws SQLException  
    { 
	  ArrayList<CardTrx> cardList=new ArrayList<CardTrx>();
	  SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
      Connection con = null;  
      PreparedStatement ps = null;  
      ResultSet rs = null;  
                
              try {  
                    
                      con=this.getConnection();  
                      ps=con.prepareStatement("select * from T_Card_Transaction");  
                      rs=ps.executeQuery();  
                      
                      while (rs.next()) {  
                    	  SmartCardDetails cardDtl= new SmartCardDetails();
                    	  CardTrx cardtrx = new CardTrx();
                    	  cardDtl.setCardNum(rs.getString("cardNum"));
                    	  cardDtl.setScId(rs.getString("cardId"));
                    	  cardDtl.getCustomerDtl().setName(rs.getString("custName"));
                    	  cardDtl.setStartTime(formatter.parse(rs.getString("StartTime")));
                    	  cardDtl.setEndTime(formatter.parse(rs.getString("EndTime")));
                    	  cardDtl.setStartStation(rs.getString("FromStation"));           
                    	  cardDtl.setEndStation(rs.getString("DestinationStation"));
                    	  cardtrx.setCard(cardDtl);
                    	  cardtrx.setBalance(rs.getDouble("balance"));
                    	  cardtrx.setDestination(rs.getString("DestinationStation"));
                    	  cardtrx.setFare(rs.getDouble("fare"));
                    	  cardtrx.setId(rs.getLong("cardId"));
                    	  
                    	  cardList.add(cardtrx);
                    	} 
                     
              
        } catch (Exception e) { System.out.println(e);}  
        finally{  
                  if(rs!=null){  
                      rs.close();  
                  }if (ps!=null){  
                    ps.close();  
                }if(con!=null){  
                    con.close();  
                }   
              }
              return cardList;
    }  
	
	
	
	public  SmartCardDetails getSmartCardDetailsByCardNum(SmartCardDetails cardDtls) throws SQLException  
    { 
	  //ArrayList<SmartCardDetails> cardList=new ArrayList<SmartCardDetails>();
	  SmartCardDetails cardDtl= new SmartCardDetails();
	  SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
      Connection con = null;  
      PreparedStatement ps = null;  
      ResultSet rs = null;  
                
              try {  
                    
                      con=this.getConnection();  
                      ps=con.prepareStatement("select * from T_Card_Transaction where cardNum=?");  
                      ps.setString(1, cardDtls.getCardNum());  
                      rs=ps.executeQuery();  
                      
                      while (rs.next()) {  
                    	  
                    	  cardDtl.setCardNum(rs.getString("cardNum"));
                    	  cardDtl.setScId(rs.getString("cardId"));
                    	  cardDtl.getCustomerDtl().setName(rs.getString("custName"));
                    	  cardDtl.setStartTime(formatter.parse(rs.getString("StartTime")));
                    	  cardDtl.setEndTime(formatter.parse(rs.getString("EndTime")));
                    	  cardDtl.setStartStation(rs.getString("FromStation"));           
                    	  cardDtl.setEndStation(rs.getString("DestinationStation"));
                    	  
                    	} 
                     
              
        } catch (Exception e) { System.out.println(e);}  
        finally{  
                  if(rs!=null){  
                      rs.close();  
                  }if (ps!=null){  
                    ps.close();  
                }if(con!=null){  
                    con.close();  
                }   
              }
    return cardDtl;
    }
	
	public  CustomerDetails getCustomerDetailsByCard(SmartCardDetails cardDtls) throws SQLException  
    { 
	  
	  CustomerDetails cust= new CustomerDetails();
	  
      Connection con = null;  
      PreparedStatement ps = null;  
      ResultSet rs = null;  
                
              try {  
                    
                      con=this.getConnection();  
                      ps=con.prepareStatement("select custName,custId from T_Customer_SmartCard_Master_Data where cardNum=?");  
                      ps.setString(1, cardDtls.getCardNum());  
                      rs=ps.executeQuery();  
                      
                      while (rs.next()) {  
                    	  
                    	  cust.setName(rs.getString("custName"));
                    	  cust.setName(rs.getString("custId"));
                    	} 
                     
              
        } catch (Exception e) { System.out.println(e);}  
        finally{  
                  if(rs!=null){  
                      rs.close();  
                  }if (ps!=null){  
                    ps.close();  
                }if(con!=null){  
                    con.close();  
                }   
              }
     return cust;
    }
	
	

}
