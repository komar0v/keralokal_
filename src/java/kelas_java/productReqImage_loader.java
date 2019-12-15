/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas_java;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "productReqImage_loader", urlPatterns = {"/productReqImage_loader"})
public class productReqImage_loader extends HttpServlet {

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
            Connection conn = db_connection.connect_to_Db();

            PreparedStatement ps = conn.prepareStatement("SELECT desain_barang_request FROM tabel_kotak_masuk WHERE id_request=?");
            String id = request.getParameter("idProdukReq_");
            ps.setString(1, id);
            ResultSet rs1 = ps.executeQuery();
            String imgLen;
            if (rs1.next()) {
                imgLen = rs1.getString(1);
                int len = imgLen.length();
                byte[] rb = new byte[len];
                InputStream readImg = rs1.getBinaryStream(1);
                int index = readImg.read(rb, 0, len);
                System.out.println("index" + index);
                ps.close();
                response.reset();
                response.setContentType("image/jpg");
                response.getOutputStream().write(rb, 0, len);
                response.getOutputStream().flush();
            }
        } catch (Exception e) {
            Logger.getLogger(productReqImage_loader.class.getName()).log(Level.SEVERE, null, e);
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
