package controller;

/**
 *
 * @author Govinda
 */

import dto.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RegisterChecker;

public class TestRegister extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("index.html");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String state=request.getParameter("state");
        String reservationdate=request.getParameter("reservationdate");
        double phone=Double.parseDouble(request.getParameter("phone"));              
        String guestno=request.getParameter("guestno");
        String email=request.getParameter("email");
        String subject=request.getParameter("subject");
               
        System.out.println("phone"+phone);
        
        UserDTO user=new UserDTO();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setState(state);
        user.setReservationdate(reservationdate);
        user.setPhone(phone);
        user.setGuestno(guestno);
        user.setEmail(email);
        user.setSubject(subject);
        
        System.out.println(email);
        
        RegisterChecker r1=new RegisterChecker();
        boolean register=r1.isRegister(user);
        if(register)
        {
            //out.println("Register Successful");
            //HttpSession session=request.getSession(true);
            //session.setAttribute("username", username);
            response.sendRedirect("index.html");
        }
        else
        {
            // out.println("Register fail");
            response.sendRedirect("index.html");
        }
    }    
}
