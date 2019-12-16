/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homenya_customer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "cari_produk", urlPatterns = {"/cari_produk"})
public class cari_produk extends HttpServlet {

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
                            + "							<li><a href=\"./_home_cust\">Home</a></li><li><a href=\"./cari_produk\">Cari Produk</a></li>\n"
                            + "                                                     <li><a href=\"./keranjang_belanja\">Keranjang</a></li>\n"
                            + "							<li><a href=\"./logout2_\">Logout</a></li>\n"
                            + "						</ul>\n"
                            + "					</nav>\n"
                            + "\n"
                            + "				<!-- Main -->\n"
                            + "					<div id=\"main\">\n"
                            + "						<div class=\"inner\">\n"
                            + "							<header>\n"
                            + "								<h1>Cari barang apa, " + nama_user + "?</h1>\n"
                            + "								<p>Cari produk disini. Banyak macamnya lurr!</p>\n"
                            + "							</header><hr>\n"
                            + "                                                 <form method=\"POST\" action=\"./cari_produkResult\">"
                            + "                                                 <input type=\"text\" name=\"kata_kunci_pencarian\" required placeholder=\"Cari barang apa?\" />\n"
                            + "                                                 <input type=\"submit\" value=\"Cari\" class=\"primary\" />"
                            + "                                                 </form>"
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
