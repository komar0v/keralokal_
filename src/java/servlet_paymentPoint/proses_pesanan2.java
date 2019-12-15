/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_paymentPoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kelas_java.db_connection;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "proses_pesanan2", urlPatterns = {"/proses_pesanan2"})
public class proses_pesanan2 extends HttpServlet {


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
            String metodeBayar = request.getParameter("paymentSelect");
            String atasNama = request.getParameter("atas_nama");
            String idUser = request.getParameter("idnyaUser");
            String kodeUnik = request.getParameter("kodeUnik");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = db_connection.connect_to_Db();

            String idProduk_str = request.getParameter("idProduk_");
            int idProduk_int = Integer.parseInt(idProduk_str);

            PreparedStatement psDelete = conn.prepareStatement("INSERT INTO tabel_transaksi VALUES (?,?,?,?,?)");
            psDelete.setInt(1, idProduk_int);
            psDelete.executeUpdate();

            conn.close();
            try {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Berhasil menghapus produk');");
                out.println("location='./view_urusanProduk';");
                out.println("</script>");
            } finally {
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
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
