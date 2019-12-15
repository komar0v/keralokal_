/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homenya_customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kelas_java.OBJ_metodepembayaran;
import kelas_java.db_connection;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "proses_pesanan", urlPatterns = {"/proses_pesanan"})
public class proses_pesanan extends HttpServlet {

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
        String bnykBarang[] = request.getParameterValues("fieldBanyakBarang");
        String namaBarang[] = request.getParameterValues("fieldNamaBarang");
        String totalHarga = request.getParameter("hargaTotal");
        System.out.println(totalHarga);

        Random rnd = new Random();
        String SALTCHARS = "ABCDEFGHIJKL1234567890MNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String kode_unik = salt.toString();

        String nama_user = null;
        String idAkun = null;
        String levelAkun = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("namaUser")) {
                    nama_user = cookie.getValue();
                }
                if (cookie.getName().equals("levelAkun")) {
                    levelAkun = cookie.getValue();
                }
                if (cookie.getName().equals("idAkun")) {
                    idAkun = cookie.getValue();
                }
            }
            if (levelAkun.equals("user")) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = db_connection.connect_to_Db();

                    PreparedStatement ps = conn.prepareStatement("SELECT id_pymntmthd, nama_pymntmthd FROM tabel_metodebayar");
                    ResultSet rs = ps.executeQuery();

                    ArrayList<OBJ_metodepembayaran> payment = new ArrayList<OBJ_metodepembayaran>();
                    int urutan = 0;
                    while (rs.next()) {

                        OBJ_metodepembayaran payment_list = new OBJ_metodepembayaran();
                        payment_list.setId_paymentMethod(rs.getInt("id_pymntmthd"));
                        payment_list.setNama_paymentMethod(rs.getString("nama_pymntmthd"));

                        payment.add(payment_list);
                    }
                    try {
                        out.println("<!DOCTYPE HTML>\n"
                                + "<html>\n"
                                + "	<head>\n"
                                + "		<title>Kera Lokal Home</title>\n"
                                + "		<meta charset=\"utf-8\" />\n"
                                + "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />\n"
                                + "		<link rel=\"stylesheet\" href=\"assets/css/main.css\" />\n"
                                + "		<noscript><link rel=\"stylesheet\" href=\"assets/css/noscript.css\" /></noscript>\n"
                                + "	</head>\n"
                                + "	<body class=\"is-preload\">\n"
                                + "		<!-- Wrapper -->\n"
                                + "			<div id=\"wrapper\">\n"
                                + "\n"
                                + "				<!-- Header -->\n"
                                + "					<header id=\"header\">\n"
                                + "						<div class=\"inner\">\n"
                                + "\n"
                                + "							<!-- Logo -->\n"
                                + "								<a href=\"./_home_cust\" class=\"logo\">\n"
                                + "									<span class=\"symbol\"><img src=\"images/logo.png\" alt=\"\" /></span><span class=\"title\">Kera          Lokal</span>\n"
                                + "								</a>\n"
                                + "\n"
                                + "							<!-- Nav -->\n"
                                + "								<nav>\n"
                                + "									<ul>\n"
                                + "										<li><a href=\"#menu\">Menu</a></li>\n"
                                + "									</ul>\n"
                                + "								</nav>\n"
                                + "\n"
                                + "						</div>\n"
                                + "					</header>\n"
                                + "\n"
                                + "				<!-- Menu -->\n"
                                + "					<nav id=\"menu\">\n"
                                + "						<h2>Menu</h2>\n"
                                + "						<ul>\n"
                                + "                                                     <li><a href=\"./_home_cust\">Home</a></li>\n"
                                + "                                                     <li><a href=\"./keranjang_belanja\">Keranjang</a></li>\n"
                                + "							<li><a href=\"./logout2_\">Logout</a></li>\n"
                                + "						</ul>\n"
                                + "					</nav>\n"
                                + "\n"
                                + "				<!-- Main -->\n"
                                + "					<div id=\"main\">\n"
                                + "						<div class=\"inner\">\n"
                                + "							<header>\n"
                                + "								<h1>Keranjang belanja " + nama_user + "</h1>\n"
                                + "								<p>Yuk proses orderan kamu biar segera dikirim ke alamat rumahmu.</p>\n"
                                + "							</header><hr>\n"
                                + "                                     <div class=\"table-wrapper\">"
                                + "                                     <table>"
                                + "                                    <thead>\n"
                                + "					<tr>\n"
                                + "					<th>Nama Item</th>\n"
                                + "					<th>Banyaknya</th>\n"
                                + "					</tr>\n"
                                + "					</thead>"
                                + "                                     <tbody>");

                        for (int i = 0; i < namaBarang.length; i++) {
                            out.println("<tr><td>" + namaBarang[i] + "</td><td> " + bnykBarang[i] + "</td></tr>");
                        }

                        out.println("                                    </tbody><tfoot>\n"
                                + "						<tr>\n"
                                + "						<td colspan=\"2\"></td>\n"
                                + "						<td><h3>TOTAL : Rp. <span class=\"total-cart\"></span></h3></td>\n"
                                + "						</tr>\n"
                                + "						</tfoot>"
                                + "                                      </table>"
                                + "</div>"
                                + "<center><h2>METODE PEMBAYARAN</h2><form method=\"POST\" action=\"./proses_pesanan2\">"
                                + "             <ul class=\"alt\">\n");
                        int urutanPayment = 0;
                        for (int i = 0; i < payment.size(); i++) {
                            urutanPayment = urutanPayment + 1;
                            out.println("<li>"
                                    + "      <div class=\"col-4 col-12-small\">\n"
                                    + "         <input type=\"radio\" id=\"pay_" + urutanPayment + "\" name=\"paymentSelect\" value=\"" + payment.get(i).getNama_paymentMethod() + "\">\n"
                                    + "		<label for=\"pay_" + urutanPayment + "\"><img src=\"./paymentLogo_loader?idMetodeBayar_=" + payment.get(i).getId_paymentMethod() + "\" width=\"220\" height=\"130\"/></label>\n"
                                    + "      </div>"
                                    + "</li>\n");
                        }
                        out.println("             </ul>"
                                + "     <input type=\"hidden\" name=\"idnyaUser\" value=\"" + idAkun + "\" />\n"
                                + "     <input type=\"hidden\" name=\"atas_nama\" value=\"" + nama_user + "\" />\n"
                                + "     <input type=\"hidden\" name=\"besarnya_transaksi\" value=\"" + totalHarga + "\" \n/>"
                                + "     <input type=\"hidden\" name=\"kodeUnik\" value=\"" + kode_unik + "\" \n/>"
                                + "     <button class=\"button icon solid\" type=\"submit\">BAYAR</button>\n"
                                + "						</form></center></div>\n"
                                + "					</div>\n"
                                + "\n"
                                + "				<!-- Footer -->\n"
                                + "					<footer id=\"footer\">\n"
                                + "						<div class=\"inner\">\n"
                                + "							<ul class=\"copyright\">\n"
                                + "								<li>&copy; Untitled. All rights reserved</li><li>Design: <a href=\"http://html5up.net\">HTML5 UP</a> x FRANSISCO DIAZ</li>\n"
                                + "							</ul>\n"
                                + "						</div>\n"
                                + "					</footer>\n"
                                + "\n"
                                + "			</div>\n"
                                + "\n"
                                + "		<!-- Scripts -->\n"
                                + "			<script src=\"assets/js/jquery.min.js\"></script>\n"
                                + "			<script src=\"assets/js/browser.min.js\"></script>\n"
                                + "			<script src=\"assets/js/breakpoints.min.js\"></script>\n"
                                + "			<script src=\"assets/js/util.js\"></script>\n"
                                + "			<script src=\"assets/js/main.js\"></script>\n"
                                + "                     <script src=\"assets/js/script_keranjang.js\"></script>"
                                + "\n"
                                + "	</body>\n"
                                + "</html>");
                    } finally {
                        out.close();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(_home_cust.class.getName()).log(Level.SEVERE, null, ex);
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
                            + "  <p>" + pesan_error + "</p>\n"
                            + "</div>\n"
                            + "<!-- partial -->\n"
                            + "  \n"
                            + "</body>\n"
                            + "</html>");
                }
            } else {
                PrintWriter output = response.getWriter();
                output.println("<script type=\"text/javascript\">");
                output.println("alert('BUKAN HAK KAU!');");
                output.println("location='./halaman_login/index.html';");
                output.println("</script>");
                output.close();
            }

        } else {
            response.sendRedirect("./index.html");
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
