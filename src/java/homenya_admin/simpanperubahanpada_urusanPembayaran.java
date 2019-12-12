/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homenya_admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kelas_java.OBJ_metodepembayaran;
import kelas_java.db_connection;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "simpanperubahanpada_urusanPembayaran", urlPatterns = {"/simpanperubahanpada_urusanPembayaran"})
public class simpanperubahanpada_urusanPembayaran extends HttpServlet {


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
        
        OBJ_metodepembayaran paymnt = new OBJ_metodepembayaran();
        int idPayment = Integer.parseInt(request.getParameter("id_penyediajasabayar"));
        paymnt.setId_paymentMethod(idPayment);
        paymnt.setNama_paymentMethod(request.getParameter("nama_penyediajasabayar"));
        paymnt.setNotel_paymentMethod(request.getParameter("nohp_penyediajasabayar"));
        paymnt.setAlamatkantor_paymentMethod(request.getParameter("alamat_penyediajasabayar"));
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = db_connection.connect_to_Db();
            
            PreparedStatement prpEdit = conn.prepareStatement("UPDATE tabel_metodebayar SET nama_pymntmthd=?, notel_pymntmthd=?, alamatkantor_pymntmthd=? WHERE id_pymntmthd=?");
            prpEdit.setString(1, paymnt.getNama_paymentMethod());
            prpEdit.setString(2, paymnt.getNotel_paymentMethod());
            prpEdit.setString(3, paymnt.getAlamatkantor_paymentMethod());
            prpEdit.setInt(4, paymnt.getId_paymentMethod());
            prpEdit.executeUpdate();
            conn.close();
            
            try {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Perubahan berhasil disimpan!');");
                out.println("location='./view_urusanPembayaran';");
                out.println("</script>");
            } finally {
                out.close();
            }
        }
        catch(Exception ex){
            Logger.getLogger(simpan_urusanPengiriman.class.getName()).log(Level.SEVERE, null, ex);
            String pesan_error = ex.getMessage();
            out.println("<!DOCTYPE html>\n"
                    + "<html lang=\"en\" >\n"
                    + "<head>\n"
                    + "  <meta charset=\"UTF-8\">\n"
                    + "  <title>Error 500 alert - #CodePenChallenges</title>\n"
                    + "  <link href=\"https://fonts.googleapis.com/css?family=Inconsolata:400,700\" rel=\"stylesheet\"><link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css\">\n"
                    + "<style type=\"text/css\">\n"
                    + "html,\n"
                    + "body {\n"
                    + "  height: 100%;\n"
                    + "}\n"
                    + "body {\n"
                    + "  display: grid;\n"
                    + "  width: 100%;\n"
                    + "  font-family: Inconsolata, monospace;\n"
                    + "}\n"
                    + "body div#error {\n"
                    + "  position: relative;\n"
                    + "  margin: auto;\n"
                    + "  padding: 20px;\n"
                    + "  z-index: 2;\n"
                    + "}\n"
                    + "body div#error div#box {\n"
                    + "  position: absolute;\n"
                    + "  top: 0;\n"
                    + "  left: 0;\n"
                    + "  width: 100%;\n"
                    + "  height: 100%;\n"
                    + "  border: 1px solid #000;\n"
                    + "}\n"
                    + "body div#error div#box:before,\n"
                    + "body div#error div#box:after {\n"
                    + "  content: '';\n"
                    + "  position: absolute;\n"
                    + "  top: 0;\n"
                    + "  left: 0;\n"
                    + "  width: 100%;\n"
                    + "  height: 100%;\n"
                    + "  box-shadow: inset 0px 0px 0px 1px #000;\n"
                    + "  mix-blend-mode: multiply;\n"
                    + "  animation: dance 2s infinite steps(1);\n"
                    + "}\n"
                    + "body div#error div#box:before {\n"
                    + "  clip-path: polygon(0 0, 65% 0, 35% 100%, 0 100%);\n"
                    + "  box-shadow: inset 0px 0px 0px 1px currentColor;\n"
                    + "  color: #f0f;\n"
                    + "}\n"
                    + "body div#error div#box:after {\n"
                    + "  clip-path: polygon(65% 0, 100% 0, 100% 100%, 35% 100%);\n"
                    + "  animation-duration: 0.5s;\n"
                    + "  animation-direction: alternate;\n"
                    + "  box-shadow: inset 0px 0px 0px 1px currentColor;\n"
                    + "  color: #0ff;\n"
                    + "}\n"
                    + "body div#error h3 {\n"
                    + "  position: relative;\n"
                    + "  font-size: 5vw;\n"
                    + "  font-weight: 700;\n"
                    + "  text-transform: uppercase;\n"
                    + "  animation: blink 1.3s infinite steps(1);\n"
                    + "}\n"
                    + "body div#error h3:before,\n"
                    + "body div#error h3:after {\n"
                    + "  content: 'ERROR 500';\n"
                    + "  position: absolute;\n"
                    + "  top: -1px;\n"
                    + "  left: 0;\n"
                    + "  mix-blend-mode: soft-light;\n"
                    + "  animation: dance 2s infinite steps(2);\n"
                    + "}\n"
                    + "body div#error h3:before {\n"
                    + "  clip-path: polygon(0 0, 100% 0, 100% 50%, 0 50%);\n"
                    + "  color: #f0f;\n"
                    + "  animation: shiftright 2s steps(2) infinite;\n"
                    + "}\n"
                    + "body div#error h3:after {\n"
                    + "  clip-path: polygon(0 100%, 100% 100%, 100% 50%, 0 50%);\n"
                    + "  color: #0ff;\n"
                    + "  animation: shiftleft 2s steps(2) infinite;\n"
                    + "}\n"
                    + "body div#error p {\n"
                    + "  position: relative;\n"
                    + "  margin-bottom: 8px;\n"
                    + "}\n"
                    + "body div#error p span {\n"
                    + "  position: relative;\n"
                    + "  display: inline-block;\n"
                    + "  font-weight: bold;\n"
                    + "  color: #000;\n"
                    + "  animation: blink 3s steps(1) infinite;\n"
                    + "}\n"
                    + "body div#error p span:before,\n"
                    + "body div#error p span:after {\n"
                    + "  content: '}{|@#%_!';\n"
                    + "  position: absolute;\n"
                    + "  top: -1px;\n"
                    + "  left: 0;\n"
                    + "  mix-blend-mode: multiply;\n"
                    + "}\n"
                    + "body div#error p span:before {\n"
                    + "  clip-path: polygon(0 0, 100% 0, 100% 50%, 0 50%);\n"
                    + "  color: #f0f;\n"
                    + "  animation: shiftright 1.5s steps(2) infinite;\n"
                    + "}\n"
                    + "body div#error p span:after {\n"
                    + "  clip-path: polygon(0 100%, 100% 100%, 100% 50%, 0 50%);\n"
                    + "  color: #0ff;\n"
                    + "  animation: shiftleft 1.7s steps(2) infinite;\n"
                    + "}\n"
                    + "@-moz-keyframes dance {\n"
                    + "  0%, 84%, 94% {\n"
                    + "    transform: skew(0deg);\n"
                    + "  }\n"
                    + "  85% {\n"
                    + "    transform: skew(5deg);\n"
                    + "  }\n"
                    + "  90% {\n"
                    + "    transform: skew(-5deg);\n"
                    + "  }\n"
                    + "  98% {\n"
                    + "    transform: skew(3deg);\n"
                    + "  }\n"
                    + "}\n"
                    + "@-webkit-keyframes dance {\n"
                    + "  0%, 84%, 94% {\n"
                    + "    transform: skew(0deg);\n"
                    + "  }\n"
                    + "  85% {\n"
                    + "    transform: skew(5deg);\n"
                    + "  }\n"
                    + "  90% {\n"
                    + "    transform: skew(-5deg);\n"
                    + "  }\n"
                    + "  98% {\n"
                    + "    transform: skew(3deg);\n"
                    + "  }\n"
                    + "}\n"
                    + "@-o-keyframes dance {\n"
                    + "  0%, 84%, 94% {\n"
                    + "    transform: skew(0deg);\n"
                    + "  }\n"
                    + "  85% {\n"
                    + "    transform: skew(5deg);\n"
                    + "  }\n"
                    + "  90% {\n"
                    + "    transform: skew(-5deg);\n"
                    + "  }\n"
                    + "  98% {\n"
                    + "    transform: skew(3deg);\n"
                    + "  }\n"
                    + "}\n"
                    + "@keyframes dance {\n"
                    + "  0%, 84%, 94% {\n"
                    + "    transform: skew(0deg);\n"
                    + "  }\n"
                    + "  85% {\n"
                    + "    transform: skew(5deg);\n"
                    + "  }\n"
                    + "  90% {\n"
                    + "    transform: skew(-5deg);\n"
                    + "  }\n"
                    + "  98% {\n"
                    + "    transform: skew(3deg);\n"
                    + "  }\n"
                    + "}\n"
                    + "@-moz-keyframes shiftleft {\n"
                    + "  0%, 87%, 100% {\n"
                    + "    transform: translate(0, 0) skew(0deg);\n"
                    + "  }\n"
                    + "  84%, 90% {\n"
                    + "    transform: translate(-8px, 0) skew(20deg);\n"
                    + "  }\n"
                    + "}\n"
                    + "@-webkit-keyframes shiftleft {\n"
                    + "  0%, 87%, 100% {\n"
                    + "    transform: translate(0, 0) skew(0deg);\n"
                    + "  }\n"
                    + "  84%, 90% {\n"
                    + "    transform: translate(-8px, 0) skew(20deg);\n"
                    + "  }\n"
                    + "}\n"
                    + "@-o-keyframes shiftleft {\n"
                    + "  0%, 87%, 100% {\n"
                    + "    transform: translate(0, 0) skew(0deg);\n"
                    + "  }\n"
                    + "  84%, 90% {\n"
                    + "    transform: translate(-8px, 0) skew(20deg);\n"
                    + "  }\n"
                    + "}\n"
                    + "@keyframes shiftleft {\n"
                    + "  0%, 87%, 100% {\n"
                    + "    transform: translate(0, 0) skew(0deg);\n"
                    + "  }\n"
                    + "  84%, 90% {\n"
                    + "    transform: translate(-8px, 0) skew(20deg);\n"
                    + "  }\n"
                    + "}\n"
                    + "@-moz-keyframes shiftright {\n"
                    + "  0%, 87%, 100% {\n"
                    + "    transform: translate(0, 0) skew(0deg);\n"
                    + "  }\n"
                    + "  84%, 90% {\n"
                    + "    transform: translate(8px, 0) skew(20deg);\n"
                    + "  }\n"
                    + "}\n"
                    + "@-webkit-keyframes shiftright {\n"
                    + "  0%, 87%, 100% {\n"
                    + "    transform: translate(0, 0) skew(0deg);\n"
                    + "  }\n"
                    + "  84%, 90% {\n"
                    + "    transform: translate(8px, 0) skew(20deg);\n"
                    + "  }\n"
                    + "}\n"
                    + "@-o-keyframes shiftright {\n"
                    + "  0%, 87%, 100% {\n"
                    + "    transform: translate(0, 0) skew(0deg);\n"
                    + "  }\n"
                    + "  84%, 90% {\n"
                    + "    transform: translate(8px, 0) skew(20deg);\n"
                    + "  }\n"
                    + "}\n"
                    + "@keyframes shiftright {\n"
                    + "  0%, 87%, 100% {\n"
                    + "    transform: translate(0, 0) skew(0deg);\n"
                    + "  }\n"
                    + "  84%, 90% {\n"
                    + "    transform: translate(8px, 0) skew(20deg);\n"
                    + "  }\n"
                    + "}\n"
                    + "@-moz-keyframes blink {\n"
                    + "  0%, 50%, 85%, 100% {\n"
                    + "    color: #000;\n"
                    + "  }\n"
                    + "  87%, 95% {\n"
                    + "    color: transparent;\n"
                    + "  }\n"
                    + "}\n"
                    + "@-webkit-keyframes blink {\n"
                    + "  0%, 50%, 85%, 100% {\n"
                    + "    color: #000;\n"
                    + "  }\n"
                    + "  87%, 95% {\n"
                    + "    color: transparent;\n"
                    + "  }\n"
                    + "}\n"
                    + "@-o-keyframes blink {\n"
                    + "  0%, 50%, 85%, 100% {\n"
                    + "    color: #000;\n"
                    + "  }\n"
                    + "  87%, 95% {\n"
                    + "    color: transparent;\n"
                    + "  }\n"
                    + "}\n"
                    + "@keyframes blink {\n"
                    + "  0%, 50%, 85%, 100% {\n"
                    + "    color: #000;\n"
                    + "  }\n"
                    + "  87%, 95% {\n"
                    + "    color: transparent;\n"
                    + "  }\n"
                    + "}\n"
                    + "</style>\n"
                    + "\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<!-- partial:index.partial.html -->\n"
                    + "<div id=\"error\">\n"
                    + "  <div id=\"box\"></div>\n"
                    + "  <h3>ERROR 500</h3>\n"
                    + "  <p>Inter<span>nal Serv</span>er <span>Err0r*=@#!</span>234Z_</p>\n"
                    + "  <p>"+pesan_error+"</p>\n"
                    + "</div>\n"
                    + "<!-- partial -->\n"
                    + "  \n"
                    + "</body>\n"
                    + "</html>");
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
