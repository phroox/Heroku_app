/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hora;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 *
 * @author viter
 */
@WebServlet("/alohora")
public class HoraServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Servlet HoraServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HoraServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String msg = "";
        
        //Calcula a hora
        
        Calendar cal = Calendar.getInstance();
	int hora = (cal.get(Calendar.HOUR_OF_DAY)-3);
        String msg = "a hora esta aqui" + hora;

            String lang2 = request.getParameter("lang2");

            if(lang2==null)
                lang2 = "pt";
            switch(lang2){
                case "pt":
                    msg = "São, " + hora;
                    break;
                case "en":
                    hora = hora+2;
                    msg = "enn São, " + (hora+2);
                    break;
                case "fr":
                    msg = "Bonjour, ";
                    break;
                case "it":
                    msg = "Buongiorno, ";
                    break;
                case "es":
                    msg = "¡buen día!, ";
                    break;    
            }


        
        
            msg = msg+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
