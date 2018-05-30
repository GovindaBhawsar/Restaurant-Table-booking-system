package controller;

import dto.FeedbackDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Feedback;

public class TestFeedback extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("index.html");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String subject=request.getParameter("subject");
        String message=request.getParameter("message");
        FeedbackDTO user=new FeedbackDTO();
        user.setName(name);
        user.setEmail(email);
        user.setSubject(subject);
        user.setMessage(message);

        
        Feedback r1=new Feedback();
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
