package model;

import db.DBConnector;
import dto.UserDTO;
import java.sql.SQLException;
import java.sql.Statement;


public class RegisterChecker 
{
    public boolean isRegister(UserDTO user)
    {
        String firstname=user.getFirstname();
        String lastname=user.getLastname();
        String state=user.getState();
        String reservationdate=user.getReservationdate();
        double phone=user.getPhone();              
        String guestno=user.getGuestno();
        String email=user.getEmail();
        String subject=user.getSubject();
        //System.out.println(email);
        
        Statement st=DBConnector.getStatement();
        try
        {
            String query = "Insert into new values('"+firstname+"','"+lastname+"','"+state+"','"+reservationdate+"','"+phone+"','"+guestno+"','"+email+"','"+subject+"')"; 
            int i = st.executeUpdate(query);
            if(i>0)
            {
                System.out.println(i+" Record Inserted");
                return true;
            }
            else
            {
                System.out.println("Record Not Inseted");
                return false;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return false;
    }
}
