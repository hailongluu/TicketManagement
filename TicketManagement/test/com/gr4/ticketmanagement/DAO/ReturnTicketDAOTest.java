/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr4.ticketmanagement.DAO;

import com.gr4.ticketmanagement.entities.Bill;
import com.gr4.ticketmanagement.entities.*;
import com.mysql.jdbc.Connection;
//import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hailo
 */
public class ReturnTicketDAOTest {
    ReturnTicketDAO re = new ReturnTicketDAO();

    public ReturnTicketDAOTest() {
           
    }

    /**
     * Test of searchTicket method, of class ReturnTicketDAO.
     */
    @Test
    public void testSearchTicket() {
        
        System.out.println("searchTicket");
        int dataSearch = 102;            
        ArrayList<Bill> expResult = null;
        ArrayList<Bill> result = re.searchTicket(dataSearch);
        assertNull(result);
        
//        int dataSearch2 = 101;
//        result = re.searchTicket(dataSearch2);
//        assertNotNull(result);
//        assertEquals(result.size(), 1);
//        assertEquals(result.get(0).getId(), 1 );
        
         int dataSearch3 = 104;
        result = re.searchTicket(dataSearch3);
        assertNotNull(result);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getId(), 3 );
    }

    /**
     * Test of updateReturnTicket method, of class ReturnTicketDAO.
     */
    @Test
    public void testUpdateReturnTicket() {
        System.out.println("updateReturnTicket");
        Connection con = re.connector;
         Client client = new Client(1, "Nguyen Van A", "1@gmail.com", "nguyenvana", "123456", "00000");
        Employee employee = new Employee(1, "Hoang Van A", 26, "Seller", "hoangvana", "123456");
        Ticket ticket = new Ticket(101, new Seat(1, "A1", "eco"), new Schedule(1, null, null, null), 45000);
        ArrayList<Ticket> listTicket = new ArrayList<>();  
        listTicket.add(ticket);       
        Bill bill = new Bill(1, "penalty", client, listTicket,null, employee);
        
        
        try{
            con.setAutoCommit(false);            
            boolean expResult = true;
            boolean result = re.updateReturnTicket(bill);
            assertEquals(expResult, result);
            
            int dataSearch = bill.getListTickets().get(0).getId();
            ArrayList<Bill> listBill;
            listBill = re.searchTicket(dataSearch);
            assertNull(listBill);
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(ReturnTicketDAOTest.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        finally{
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

    
}
