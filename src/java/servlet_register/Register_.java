/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_register;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import kelas_java.OBJ_customer;
import kelas_java.db_connection;

/**
 *
 * @author ASUS
 */
@MultipartConfig(location = "/.", fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(name = "Register_", urlPatterns = {"/Register_"})
public class Register_ extends HttpServlet {

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

        PrintWriter out = response.getWriter();
        try {
            InputStream inputStream;
            Part filePart;
            filePart = request.getPart("foto_ktp");
            inputStream = filePart.getInputStream();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = db_connection.connect_to_Db();

            OBJ_customer pengguna = new OBJ_customer();
            pengguna.setId_customer(request.getParameter("nik_"));
            pengguna.setEmail_customer(request.getParameter("email_"));
            pengguna.setPassword_customer(request.getParameter("password_"));
            pengguna.setNama_depan_customer(request.getParameter("nama_depan"));
            pengguna.setNama_belakang_customer(request.getParameter("nama_belakang"));
            pengguna.setNik_customer(request.getParameter("nik_"));
            pengguna.setNohp_customer(request.getParameter("noHp_"));
            pengguna.setAlamat_customer(request.getParameter("alamat_"));

            PreparedStatement ps = conn.prepareStatement("INSERT INTO tabel_customer VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, pengguna.getId_customer());
            ps.setString(2, pengguna.getEmail_customer());
            ps.setString(3, pengguna.getPassword_customer());
            ps.setString(4, pengguna.getNama_depan_customer());
            ps.setString(5, pengguna.getNama_belakang_customer());
            ps.setString(6, pengguna.getNik_customer());
            ps.setString(7, pengguna.getNohp_customer());
            ps.setString(8, pengguna.getAlamat_customer());
            ps.setBlob(9, inputStream);
            ps.setBlob(10, inputStream);
            ps.setString(11, "user");
            ps.executeUpdate();
            conn.close();

            try {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Berhasil Daftar');");
                out.println("location='./index.html';");
                out.println("</script>");

            } finally {
                out.close();
            }

        } catch (Exception ex) {
            Logger.getLogger(Register_.class.getName()).log(Level.SEVERE, null, ex);
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
