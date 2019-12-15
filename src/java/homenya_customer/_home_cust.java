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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kelas_java.OBJ_produk;
import kelas_java.db_connection;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "_home_cust", urlPatterns = {"/_home_cust"})
public class _home_cust extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String nama_user = null;
        String sessionID = null;
        String levelAkun = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("namaUser")) {
                    nama_user = cookie.getValue();
                }
                if (cookie.getName().equals("JSESSIONID")) {
                    sessionID = cookie.getValue();
                }
                if (cookie.getName().equals("levelAkun")) {
                    levelAkun = cookie.getValue();
                }
            }
            if (levelAkun.equals("user")) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = db_connection.connect_to_Db();

                    PreparedStatement ps = conn.prepareStatement("SELECT product_id, nama_produk, jenis_produk, harga_produk FROM tabel_produk");
                    ResultSet rs = ps.executeQuery();

                    ArrayList<OBJ_produk> products = new ArrayList<OBJ_produk>();
                    while (rs.next()) {
                        int prodId_int = rs.getInt("product_id");
                        String prodId_str = Integer.toString(prodId_int);
                        OBJ_produk dftr_produk = new OBJ_produk();
                        dftr_produk.setId_produk(prodId_str);
                        dftr_produk.setNama_produk(rs.getString("nama_produk"));
                        dftr_produk.setJenis_produk(rs.getString("jenis_produk"));
                        dftr_produk.setHarga_produk(rs.getDouble("harga_produk"));

                        products.add(dftr_produk);
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
                                + "							<li><a href=\"./_home_cust\">Home</a></li>\n"
                                + "                                                     <li><a href=\"./keranjang_belanja\">Keranjang</a></li>\n"
                                + "							<li><a href=\"./logout2_\">Logout</a></li>\n"
                                + "						</ul>\n"
                                + "					</nav>\n"
                                + "\n"
                                + "				<!-- Main -->\n"
                                + "					<div id=\"main\">\n"
                                + "						<div class=\"inner\">\n"
                                + "							<header>\n"
                                + "								<h1>Selamat datang " + nama_user + "</h1>\n"
                                + "								<p>Belanja Kerajinan Tangan Lokal kini tidak perlu ribet. Anda tinggal menunggu dirumah sembari minum kopi atau menonton Netflix. Pengrajin kami menerima request barang sesuai keiinginan hati para pembelinya, AYO PESAN SEKARANG!</p>\n"
                                + "							</header>\n"
                                + "							<section class=\"tiles\">\n");

                        for (int i = 0; i < products.size(); i++) {
                            out.println("                                                       <article>\n"
                                    + "									<span class=\"image\">\n"
                                    + "                                                                            <img src=\"./productImage_loader?idProduk_=" + products.get(i).getId_produk() + "\" alt=\"\" width=\"360\" height=\"460\"/>\n"
                                    + "									</span>\n"
                                    + "									<a href=\"./detail_produk?idProduk_=" + products.get(i).getId_produk() + "\">\n"
                                    + "										<h2>" + products.get(i).getNama_produk() + "</h2>\n"
                                    + "										<div class=\"content\">\n"
                                    + "                                                                                    <p>" + products.get(i).getJenis_produk() + "</p>\n"
                                    + "                                                                                    <h3>Rp. " + products.get(i).getHarga_produk() + "</h3>"
                                    + "										</div>\n"
                                    + "									</a>\n"
                                    + "								</article>");
                        }

                        out.println("							</section>\n"
                                + "						</div>\n"
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
