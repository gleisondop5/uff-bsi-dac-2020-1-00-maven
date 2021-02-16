/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String msg = "";
        String msg2 = "";
        
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                msg = "Alô, ";
                msg2 = saudacao(lang, msg2);
                break;
            case "en":
                msg = "Hello, ";
                msg2 = saudacao(lang, msg2);
                break;
            case "fr":
                msg = "Bonjour, ";
                msg2 = saudacao(lang, msg2);
                break;
            case "de":
                msg = "Hallo, ";
                msg2 = saudacao(lang, msg2);
                break;
        }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("<p>" + msg2 + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private String saudacao(String local, String msg2){
        ZoneId tz_SP = ZoneId.of("America/Sao_Paulo");
        ZoneId tz_NY = ZoneId.of("America/New_York");
        ZoneId tz_FR = ZoneId.of("Europe/Paris");
        ZoneId tz_DE = ZoneId.of("Europe/Berlin");

        ZonedDateTime agoraSP = ZonedDateTime.now(tz_SP);
        ZonedDateTime agoraNY = ZonedDateTime.now(tz_NY);
        ZonedDateTime agoraParis = ZonedDateTime.now(tz_FR);
        ZonedDateTime agoraBerlin = ZonedDateTime.now(tz_DE);

        int horaSP = agoraSP.getHour();
        int horaNY = agoraNY.getHour();
        int horaFR = agoraParis.getHour();
        int horaDE = agoraBerlin.getHour();
        
        switch(local){
            case "pt":
                if(horaSP>=6 && horaSP<12)msg2 = "Bom dia!";
                else if(horaSP>=12 && horaSP<18)msg2 = "Boa tarde!";
                else msg2 = "Boa noite";
                break;               
            case "en":
                if(horaNY>=6 && horaNY<12)msg2 = "Good morning!";
                else if(horaNY>=12 && horaNY<18)msg2 = "Good afternoon!";
                else msg2 = "Good night";
                break;
            case "fr":
                if(horaFR>=6 && horaFR<12)msg2 = "Bonjour!";
                else if(horaFR>=12 && horaFR<18)msg2 = "Bon après-midi!";
                else msg2 = "Bonne nuit";
                break;
            case "de":
                if(horaDE>=6 && horaDE<12)msg2 = "Guten Morgen!";
                else if(horaDE>=12 && horaDE<18)msg2 = "Guten Tag!";
                else msg2 = "Gute Nacht";
                break;       
        }
        return msg2;
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = "";
        String msg2 = "";
        
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                msg = "Alô, ";
                msg2 = saudacao(lang, msg2);
                break;
            case "en":
                msg = "Hello, ";
                msg2 = saudacao(lang, msg2);
                break;
            case "fr":
                msg = "Bonjour, ";
                msg2 = saudacao(lang, msg2);
                break;
            case "de":
                msg = "Hallo, ";
                msg2 = saudacao(lang, msg2);
                break;
        }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("<p>" + msg2 + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
