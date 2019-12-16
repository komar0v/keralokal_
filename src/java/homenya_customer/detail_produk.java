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
@WebServlet(name = "detail_produk", urlPatterns = {"/detail_produk"})
public class detail_produk extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String nama_user = null;
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
            }
            if (levelAkun.equals("user")) {
                try {

                    String idToko = null;
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = db_connection.connect_to_Db();

                    PreparedStatement ps = conn.prepareStatement("SELECT nama_produk, keterangan_produk, inserted_date, stok_produk, harga_produk, jenis_produk, inserted_by FROM tabel_produk WHERE product_id=?");
                    ps.setString(1, request.getParameter("idProduk_"));
                    ResultSet rs = ps.executeQuery();
                    OBJ_produk dftr_produk = new OBJ_produk();

                    String tgl_masuk = null;
                    int stok = 0;
                    while (rs.next()) {
                        stok = rs.getInt("stok_produk");
                        tgl_masuk = rs.getString("inserted_date");

                        dftr_produk.setId_produk(request.getParameter("idProduk_"));
                        dftr_produk.setNama_produk(rs.getString("nama_produk"));
                        dftr_produk.setKeterangan_produk(rs.getString("keterangan_produk"));
                        dftr_produk.setJenis_produk(rs.getString("jenis_produk"));
                        dftr_produk.setHarga_produk(rs.getDouble("harga_produk"));
                        idToko = rs.getString("inserted_by");
                    }

                    PreparedStatement ps2 = conn.prepareStatement("SELECT nama_toko FROM tabel_toko WHERE id_toko=?");
                    ps2.setString(1, idToko);
                    ResultSet rs2 = ps2.executeQuery();
                    String nama_tokonya = null;

                    while (rs2.next()) {
                        nama_tokonya = rs2.getString("nama_toko");
                    }

                    try {
                        out.println("<!DOCTYPE HTML>\n"
                                + "<html>\n"
                                + "    <head>\n"
                                + "        <title>Produk " + dftr_produk.getNama_produk() + "</title>\n"
                                + "        <meta charset=\"utf-8\" />\n"
                                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />\n"
                                + "        <link rel=\"stylesheet\" href=\"assets/css/main.css\" />\n"
                                + "        <noscript><link rel=\"stylesheet\" href=\"assets/css/noscript.css\" /></noscript>\n"
                                + "        <style type=\"text/css\">\n"
                                + "            .container {\n"
                                + "                max-width: 1200px;\n"
                                + "                margin: 0 auto;\n"
                                + "                padding: 15px;\n"
                                + "                display: flex;\n"
                                + "            }\n"
                                + "            .right-column {\n"
                                + "                width: 55%;\n"
                                + "                margin-top: 60px;\n"
                                + "            }\n"
                                + "            .left-column {\n"
                                + "                width: 65%;\n"
                                + "                position: relative;\n"
                                + "            }\n"
                                + "            .product-description {\n"
                                + "                border-bottom: 1px solid #E1E8EE;\n"
                                + "                margin-bottom: 20px;\n"
                                + "            }\n"
                                + "            .product-description span {\n"
                                + "                font-size: 12px;\n"
                                + "                color: #358ED7;\n"
                                + "                letter-spacing: 1px;\n"
                                + "                text-transform: uppercase;\n"
                                + "                text-decoration: none;\n"
                                + "            }\n"
                                + "\n"
                                + "            .qty-input {\n"
                                + "                border: 1px solid black;\n"
                                + "                height: 40px;\n"
                                + "                position: relative;\n"
                                + "                width: 122px;\n"
                                + "            }\n"
                                + "            .qty-input i {\n"
                                + "                cursor: pointer;\n"
                                + "                font-family: serif;\n"
                                + "                height: 40px;\n"
                                + "                float: left;\n"
                                + "                line-height: 40px;\n"
                                + "                text-align: center;\n"
                                + "                -webkit-user-select: none;\n"
                                + "                -moz-user-select: none;\n"
                                + "                -ms-user-select: none;\n"
                                + "                user-select: none;\n"
                                + "                transition: all 150ms ease-out;\n"
                                + "                width: 33px;\n"
                                + "            }\n"
                                + "            .qty-input i:active {\n"
                                + "                background-color: #F1F1F1;\n"
                                + "                transition: none;\n"
                                + "            }\n"
                                + "            .qty-input input {\n"
                                + "                border: 0px solid;\n"
                                + "                float: left;\n"
                                + "                font-size: 24px;\n"
                                + "                height: 38px;\n"
                                + "                text-align: center;\n"
                                + "                outline: none;\n"
                                + "                width: 54px;\n"
                                + "            </style>\n"
                                + "\n"
                                + "        </head>\n"
                                + "        <body class=\"is-preload\">\n"
                                + "            <!-- Wrapper -->\n"
                                + "            <div id=\"wrapper\">\n"
                                + "\n"
                                + "                <!-- Header -->\n"
                                + "                <header id=\"header\">\n"
                                + "                    <div class=\"inner\">\n"
                                + "\n"
                                + "                        <!-- Logo -->\n"
                                + "                        <a href=\"./_home_cust\" class=\"logo\">\n"
                                + "                            <span class=\"symbol\"><img src=\"images/logo.png\" alt=\"\" /></span><span class=\"title\">Kera          Lokal</span>\n"
                                + "                        </a>\n"
                                + "\n"
                                + "                        <!-- Nav -->\n"
                                + "                        <nav>\n"
                                + "                            <ul>\n"
                                + "                                <li><a href=\"#menu\">Menu</a></li>\n"
                                + "                            </ul>\n"
                                + "                        </nav>\n"
                                + "\n"
                                + "                    </div>\n"
                                + "                </header>\n"
                                + "\n"
                                + "                <!-- Menu -->\n"
                                + "                <nav id=\"menu\">\n"
                                + "                    <h2>Menu</h2>\n"
                                + "                    <ul>\n"
                                + "                        <li><a href=\"./_home_cust\">Home</a><li><a href=\"./cari_produk\">Cari Produk</a></li></li>\n"
                                + "                        <li><a href=\"./keranjang_belanja\">Keranjang</a></li>\n"
                                + "                        <li><a href=\"./logout2_\">Logout</a></li>\n"
                                + "                    </ul>\n"
                                + "                </nav>\n"
                                + "\n"
                                + "                <!-- Main -->\n"
                                + "                <div id=\"main\">\n"
                                + "                    <div class=\"inner\">\n"
                                + "\n                   <div class=\"jumbotron\">\n"
                                + "                             <p>Produk oleh <a href=\"./lihat_toko?idToko_=" + idToko + "\">" + nama_tokonya + "</a> ditambahkan pada " + tgl_masuk + "</p>\n"
                                + "                     </div>"
                                + "                        <main class=\"container\">\n"
                                + "\n"
                                + "                            <div class=\"left-column\">\n"
                                + "                                <img src=\"./productImage_loader?idProduk_=" + dftr_produk.getId_produk() + "\" width=\"360\" height=\"460\" >\n"
                                + "                            </div>\n"
                                + "\n"
                                + "\n"
                                + "                            <!-- Right Column -->\n"
                                + "                            <div class=\"right-column\">\n"
                                + "\n"
                                + "                                <!-- Product Description -->\n"
                                + "                                <div class=\"product-description\">\n"
                                + "                                    <h1>" + dftr_produk.getNama_produk() + "</h1>\n"
                                + "                                    <p>" + dftr_produk.getKeterangan_produk() + "</p>\n"
                                + "                                    <h2>Rp. " + dftr_produk.getHarga_produk() + "</h2>"
                                + "                                </div>\n"
                                + "                                <form>\n"
                                + "                                    <div>\n"
                                + "                                        <h4> Stok : " + stok + "</h4>"
                                + "                                        <ul class=\"actions\">\n"
                                + "                                            <a onclick=\"masukkekeranjang()\" href=\"#\" data-name=\"" + dftr_produk.getNama_produk() + "\" data-price=\"" + dftr_produk.getHarga_produk() + "\" class=\"button primary add-to-cart btn btn-primary\">Masukkan ke Keranjang</a>"
                                + "                                        </ul>\n"
                                + "                                    </div>\n"
                                + "                                </form>\n"
                                + "                            </div>\n"
                                + "                        </main>\n"
                                + "\n"
                                + "                    </div>\n"
                                + "                </div>\n"
                                + "\n"
                                + "                <!-- Footer -->\n"
                                + "                <footer id=\"footer\">\n"
                                + "                    <div class=\"inner\">\n"
                                + "                        <ul class=\"copyright\">\n"
                                + "                            <li>&copy; Untitled. All rights reserved</li><li>Design: <a href=\"http://html5up.net\">HTML5 UP</a> and FRANSISCO DIAZ ATMARESTANTO</li>\n"
                                + "                        </ul>\n"
                                + "                    </div>\n"
                                + "                </footer>\n"
                                + "\n"
                                + "            </div>\n"
                                + "\n"
                                + "            <!-- Scripts -->\n"
                                + "            <script src=\"assets/js/jquery.min.js\"></script>\n"
                                + "            <script src=\"assets/js/browser.min.js\"></script>\n"
                                + "            <script src=\"assets/js/breakpoints.min.js\"></script>\n"
                                + "            <script src=\"assets/js/util.js\"></script>\n"
                                + "            <script src=\"assets/js/main.js\"></script>\n"
                                + "            <script src=\"assets/js/script_keranjang.js\"></script>"
                                + "            <script>\n"
                                + "                 function masukkekeranjang() {\n"
                                + "                 alert(\"Berhasil menambahkan item\");\n"
                                + "                                       }\n"
                                + "            </script>"
                                + "        </body>\n"
                                + "    </html>");
                    } finally {
                        out.close();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(detail_produk.class.getName()).log(Level.SEVERE, null, ex);
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
