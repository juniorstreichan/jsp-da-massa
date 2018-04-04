/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcom.controle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Junior.erdmann
 */
public class Controle extends HttpServlet {

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
            throws ServletException, IOException, InstantiationException {
        try {

            validarLogin(request, response);
        } catch (RuntimeException | SQLException e) {
            response.sendRedirect("fracasso.jsp");
            System.out.println(e.getStackTrace());
        } catch (ClassNotFoundException ex) {
            response.sendRedirect("fracasso.jsp");
            System.out.println(ex.getStackTrace());
        } catch (Exception ex) {
            response.sendRedirect("fracasso.jsp");
            System.out.println(ex.getStackTrace());
        }

    }

    private void validarLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemainternet", "root", "");
                PreparedStatement pst = con.prepareStatement("select * from usuario where login = ? and senha = ?")) {
            pst.setString(1, request.getParameter("login"));
            pst.setString(2, request.getParameter("senha"));
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                response.sendRedirect("sucesso.jsp");
            } else {
                response.sendRedirect("fracasso.jsp");

            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
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
