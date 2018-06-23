/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr4.ticketmanagement.DAO;
import java.util.*;
import com.gr4.ticketmanagement.entities.Bill;
import com.gr4.ticketmanagement.entities.Client;
import com.gr4.ticketmanagement.entities.Employee;
import com.gr4.ticketmanagement.entities.Movie;
import com.gr4.ticketmanagement.entities.Room;
import com.gr4.ticketmanagement.entities.Schedule;
import com.gr4.ticketmanagement.entities.Seat;
import com.gr4.ticketmanagement.entities.ShowTime;
import com.gr4.ticketmanagement.entities.Theater;
import com.gr4.ticketmanagement.entities.Ticket;
import com.mysql.jdbc.Connection;
import java.security.interfaces.RSAKey;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import com.gr4.ticketmanagement.log.Loggable;
import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.PreparedStatement;

/**
 *
 * @author hailo
 */
import org.apache.logging.log4j.Logger;
public class ReturnTicketDAO{

    public static Connection connector;
    private Statement st;
    public ReturnTicketDAO() {
        try {            
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/ticketmanagement";
            String url2 = "jdbc:mysql://localhost:3306/ticketmanagement?autoReconnect=true&useSSL=false";
            String user ="root";
            String pass = "208197";
            
            Class.forName(driver);
            connector = (Connection) DriverManager.getConnection(url2,user,pass);
            st = connector.createStatement();            
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ReturnTicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
//            Logger.getLogger(ReturnTicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Bill> searchTicket(int dataSearch){   
        try {   
            ArrayList<Bill> listBill = new ArrayList<>();
            String sqlById="Select *\n" +
                            "From   tblmovie m, tblclient c,  tblemployee e, tblseat s, tblroom r,  tblshowtime sh, tblschedule sch, tblticket t, tblbill b, tblbillticket\n" +
                            "where b.clientid = c.id and b.employeeId = e.id and t.seatid = s.id and t.scheduleid = sch.id and sch.movieid = m.id and sch.showtimeid = sh.id and sch.roomid = r.id and  t.id= ? and tblbillticket.ticketid = t.id and tblbillticket.billid=b.id and t.id not in \n" +
                            "(select b1.ticketid \n" +
                            "from tblbillticket b1, tblbillticket b2\n" +
                            "where b1.ticketid=b2.ticketid and b1.billid <> b2.billid)";
            
            PreparedStatement ps=(PreparedStatement) connector.prepareStatement(sqlById);
            ps.setString(1, dataSearch+"");
            ResultSet rs = ps.executeQuery();
            
            Movie movie;
            Client client;
            Employee employee;
            Room room;
            Schedule schedule;
            Seat seat;
            ShowTime showTime;
            ArrayList<Seat> listSeat = new ArrayList<>();
            ArrayList<Ticket> listTicket = new ArrayList<>();
            try {
                
                while(rs.next()){
                    movie = new Movie(rs.getInt(1),rs.getString(2) , rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getDate(8));
                    System.out.println(movie.getName());
                    client = new Client(rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
                    
                    employee = new Employee(rs.getInt(15), rs.getString(16), rs.getInt(17), rs.getString(18), rs.getString(19), rs.getString(20));
                    
                    seat = new Seat(rs.getInt(21), rs.getString(22), rs.getString(23));
                    
                    listSeat.add(seat);
                    
                    room = new Room(rs.getInt(25), rs.getInt(26), listSeat);
                    System.out.println(room.getNumber());
                    showTime = new ShowTime(rs.getInt(28), rs.getDate(29), rs.getTime(30), rs.getTime(31));
                    schedule = new Schedule(rs.getInt(32), movie, room, showTime);
                    
                    listTicket.add(new Ticket(rs.getInt(36), seat, schedule, rs.getFloat(37)));
                    Bill bill = new Bill(rs.getInt(40), rs.getString(41), client, listTicket, rs.getTime(42), employee);
                    listBill.add(bill);
                    return listBill;
                }
                
            } catch (SQLException ex) {
//            Logger.getLogger(ReturnTicketDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        } catch (SQLException ex) {
              java.util.logging.Logger.getLogger(ReturnTicketDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
         return null;  
    }

    public boolean updateReturnTicket(Bill bill){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = sdf.format(date.getTime()); 
        int generatedKey = 0;
        try {
//            connector.setAutoCommit(false);
            // add bill to database
            
            try{
                String sql1 = "INSERT INTO tblbill ( billtype, billtime, clientid, employeeid) VALUES (?,?,?,?);";
                PreparedStatement ps1 = (PreparedStatement) connector.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
                ps1.setString(1, bill.getBillType());
                ps1.setString(2, time);
                ps1.setInt(3, bill.getBuyer().getId());
                ps1.setInt(4, bill.getEmployee().getId());
                ps1.execute();
                ResultSet rs = ps1.getGeneratedKeys();
                if (rs.next()) {
                    generatedKey = rs.getInt(1);
                    System.out.println(generatedKey);
                }
            }
            catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ReturnTicketDAO.class.getName()).log(Level.SEVERE, null, ex);
                connector.rollback();
            }
            
            // add vé phạt
        
            try{
                String sql2="INSERT INTO tblbillticket (ticketid, billid) VALUES (?,?);";
                PreparedStatement ps2 = (PreparedStatement) connector.prepareStatement(sql2);
                ps2.setInt(1, bill.getListTickets().get(0).getId());
                ps2.setInt(2, generatedKey);
                ps2.execute();
            } 
            catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ReturnTicketDAO.class.getName()).log(Level.SEVERE, null, ex);
                connector.rollback();
            }
//            connector.commit();
            return true;
        } catch (SQLException ex) {
            try {
                connector.rollback();
            } catch (SQLException ex1) {
                java.util.logging.Logger.getLogger(ReturnTicketDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            java.util.logging.Logger.getLogger(ReturnTicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;       
    }
}
