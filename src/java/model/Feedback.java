package model;

import db.DBConnector;
import dto.FeedbackDTO;
import java.sql.SQLException;
import java.sql.Statement;


public class Feedback 
{
    public boolean isRegister(FeedbackDTO user)
    {
        String name=user.getName();
        String email=user.getEmail();
        String subject=user.getSubject();
        String message=user.getMessage();
        //System.out.println(email);
        
        Statement st=DBConnector.getStatement();
        try
        {
            String query = "Insert into newFeedback values('"+name+"','"+email+"','"+subject+"','"+message+"')"; 
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
