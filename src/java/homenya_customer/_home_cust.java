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
                            + "								<a href=\"index.html\" class=\"logo\">\n"
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
                            + "							<li><a href=\"./logout2_\">Logout</a></li>\n"
                            + "						</ul>\n"
                            + "					</nav>\n"
                            + "\n"
                            + "				<!-- Main -->\n"
                            + "					<div id=\"main\">\n"
                            + "						<div class=\"inner\">\n"
                            + "							<header>\n"
                            + "								<h1>Selamat datang "+nama_user+"</h1>\n"
                            + "								<p>Belanja Kerajinan Tangan Lokal kini tidak perlu ribet. Anda tinggal menunggu dirumah sembari minum kopi atau menonton Netflix. Pengrajin kami menerima request barang sesuai keiinginan hati para pembelinya, AYO PESAN SEKARANG!</p>\n"
                            + "							</header>\n"
                            + "							<section class=\"tiles\">\n"
                            + "								<article>\n"
                            + "									<span class=\"image\">\n"
                            + "                                                                            <img src=\"images/pic01ya.jpg\" alt=\"\" width=\"360\" height=\"460\"/>\n"
                            + "									</span>\n"
                            + "									<a href=\"generic.html\">\n"
                            + "										<h2>Gerabah Motif Bunga</h2>\n"
                            + "										<div class=\"content\">\n"
                            + "                                                                                    <p>Desain guci yang elegan membawa kesan mewah</p>\n"
                            + "										</div>\n"
                            + "									</a>\n"
                            + "								</article>\n"
                            + "								<article>\n"
                            + "									<span class=\"image\">\n"
                            + "										<img src=\"images/pic02ya.jpg\" alt=\"\" width=\"360\" height=\"460\"/>\n"
                            + "									</span>\n"
                            + "									<a href=\"generic.html\">\n"
                            + "										<h2>Gerabah Motif Kupu - Kupu</h2>\n"
                            + "										<div class=\"content\">\n"
                            + "											<p>Cocok untuk hiasan diruang tamu atau ruang keluarga</p>\n"
                            + "										</div>\n"
                            + "									</a>\n"
                            + "								</article>\n"
                            + "								<article>\n"
                            + "									<span class=\"image\">\n"
                            + "										<img src=\"images/pic03ya.jpg\" alt=\"\" width=\"360\" height=\"460\"/>\n"
                            + "									</span>\n"
                            + "									<a href=\"generic.html\">\n"
                            + "										<h2>Gerabah Motif Bunga Kupu</h2>\n"
                            + "										<div class=\"content\">\n"
                            + "											<p>Cocok untuk hiasan diruang tidur atau ruang keluarga</p>\n"
                            + "										</div>\n"
                            + "									</a>\n"
                            + "								</article>\n"
                            + "								<article>\n"
                            + "									<span class=\"image\">\n"
                            + "										<img src=\"images/pic04ya.jpg\" alt=\"\" width=\"360\" height=\"460\"/>\n"
                            + "									</span>\n"
                            + "									<a href=\"generic.html\">\n"
                            + "										<h2>Vas Bunga Motif Bunga Kupu</h2>\n"
                            + "										<div class=\"content\">\n"
                            + "											<p>Vas Bunga yang cocok untuk diruang makan atau diteras</p>\n"
                            + "										</div>\n"
                            + "									</a>\n"
                            + "								</article>\n"
                            + "								<article>\n"
                            + "									<span class=\"image\">\n"
                            + "										<img src=\"images/pic05ya.jpg\" alt=\"\" width=\"360\" height=\"460\"/>\n"
                            + "									</span>\n"
                            + "									<a href=\"generic.html\">\n"
                            + "										<h2>Gerabah Persegi Motif Bunga</h2>\n"
                            + "										<div class=\"content\">\n"
                            + "											<p>Cocok dijadikan tempat payung ataupun hiasan ruangan</p>\n"
                            + "										</div>\n"
                            + "									</a>\n"
                            + "								</article>\n"
                            + "								<article>\n"
                            + "									<span class=\"image\">\n"
                            + "										<img src=\"images/pic06ya.jpg\" alt=\"\" width=\"360\" height=\"460\"/>\n"
                            + "									</span>\n"
                            + "									<a href=\"generic.html\">\n"
                            + "										<h2>Vas Bunga Motif Geometri</h2>\n"
                            + "										<div class=\"content\">\n"
                            + "											<p>Vas Bunga ini cocok dijadikan hiasan ruang kantor</p>\n"
                            + "										</div>\n"
                            + "									</a>\n"
                            + "								</article>\n"
                            + "								<article class=\"style2\">\n"
                            + "									<span class=\"image\">\n"
                            + "										<img src=\"images/pic07.jpg\" alt=\"\" />\n"
                            + "									</span>\n"
                            + "									<a href=\"generic.html\">\n"
                            + "										<h2>Ipsum</h2>\n"
                            + "										<div class=\"content\">\n"
                            + "											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>\n"
                            + "										</div>\n"
                            + "									</a>\n"
                            + "								</article>\n"
                            + "								<article class=\"style3\">\n"
                            + "									<span class=\"image\">\n"
                            + "										<img src=\"images/pic08.jpg\" alt=\"\" />\n"
                            + "									</span>\n"
                            + "									<a href=\"generic.html\">\n"
                            + "										<h2>Dolor</h2>\n"
                            + "										<div class=\"content\">\n"
                            + "											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>\n"
                            + "										</div>\n"
                            + "									</a>\n"
                            + "								</article>\n"
                            + "								<article class=\"style1\">\n"
                            + "									<span class=\"image\">\n"
                            + "										<img src=\"images/pic09.jpg\" alt=\"\" />\n"
                            + "									</span>\n"
                            + "									<a href=\"generic.html\">\n"
                            + "										<h2>Nullam</h2>\n"
                            + "										<div class=\"content\">\n"
                            + "											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>\n"
                            + "										</div>\n"
                            + "									</a>\n"
                            + "								</article>\n"
                            + "								<article class=\"style5\">\n"
                            + "									<span class=\"image\">\n"
                            + "										<img src=\"images/pic10.jpg\" alt=\"\" />\n"
                            + "									</span>\n"
                            + "									<a href=\"generic.html\">\n"
                            + "										<h2>Ultricies</h2>\n"
                            + "										<div class=\"content\">\n"
                            + "											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>\n"
                            + "										</div>\n"
                            + "									</a>\n"
                            + "								</article>\n"
                            + "								<article class=\"style6\">\n"
                            + "									<span class=\"image\">\n"
                            + "										<img src=\"images/pic11.jpg\" alt=\"\" />\n"
                            + "									</span>\n"
                            + "									<a href=\"generic.html\">\n"
                            + "										<h2>Dictum</h2>\n"
                            + "										<div class=\"content\">\n"
                            + "											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>\n"
                            + "										</div>\n"
                            + "									</a>\n"
                            + "								</article>\n"
                            + "								<article class=\"style4\">\n"
                            + "									<span class=\"image\">\n"
                            + "										<img src=\"images/pic12.jpg\" alt=\"\" />\n"
                            + "									</span>\n"
                            + "									<a href=\"generic.html\">\n"
                            + "										<h2>Pretium</h2>\n"
                            + "										<div class=\"content\">\n"
                            + "											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>\n"
                            + "										</div>\n"
                            + "									</a>\n"
                            + "								</article>\n"
                            + "							</section>\n"
                            + "						</div>\n"
                            + "					</div>\n"
                            + "\n"
                            + "				<!-- Footer -->\n"
                            + "					<footer id=\"footer\">\n"
                            + "						<div class=\"inner\">\n"
                            + "							<section>\n"
                            + "								<h2>Get in touch</h2>\n"
                            + "								<form method=\"post\" action=\"#\">\n"
                            + "									<div class=\"fields\">\n"
                            + "										<div class=\"field half\">\n"
                            + "											<input type=\"text\" name=\"name\" id=\"name\" placeholder=\"Name\" />\n"
                            + "										</div>\n"
                            + "										<div class=\"field half\">\n"
                            + "											<input type=\"email\" name=\"email\" id=\"email\" placeholder=\"Email\" />\n"
                            + "										</div>\n"
                            + "										<div class=\"field\">\n"
                            + "											<textarea name=\"message\" id=\"message\" placeholder=\"Message\"></textarea>\n"
                            + "										</div>\n"
                            + "									</div>\n"
                            + "									<ul class=\"actions\">\n"
                            + "										<li><input type=\"submit\" value=\"Send\" class=\"primary\" /></li>\n"
                            + "									</ul>\n"
                            + "								</form>\n"
                            + "							</section>\n"
                            + "							<section>\n"
                            + "								<h2>Follow</h2>\n"
                            + "								<ul class=\"icons\">\n"
                            + "									<li><a href=\"#\" class=\"icon brands style2 fa-twitter\"><span class=\"label\">Twitter</span></a></li>\n"
                            + "									<li><a href=\"#\" class=\"icon brands style2 fa-facebook-f\"><span class=\"label\">Facebook</span></a></li>\n"
                            + "									<li><a href=\"#\" class=\"icon brands style2 fa-instagram\"><span class=\"label\">Instagram</span></a></li>\n"
                            + "									<li><a href=\"#\" class=\"icon brands style2 fa-dribbble\"><span class=\"label\">Dribbble</span></a></li>\n"
                            + "									<li><a href=\"#\" class=\"icon brands style2 fa-github\"><span class=\"label\">GitHub</span></a></li>\n"
                            + "									<li><a href=\"#\" class=\"icon brands style2 fa-500px\"><span class=\"label\">500px</span></a></li>\n"
                            + "									<li><a href=\"#\" class=\"icon solid style2 fa-phone\"><span class=\"label\">Phone</span></a></li>\n"
                            + "									<li><a href=\"#\" class=\"icon solid style2 fa-envelope\"><span class=\"label\">Email</span></a></li>\n"
                            + "								</ul>\n"
                            + "							</section>\n"
                            + "							<ul class=\"copyright\">\n"
                            + "								<li>&copy; Untitled. All rights reserved</li><li>Design: <a href=\"http://html5up.net\">HTML5 UP</a></li>\n"
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
