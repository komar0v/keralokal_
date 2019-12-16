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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
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
            String nilaiTx = request.getParameter("besarnya_transaksi");

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date();
            String tx_time = formatter.format(date);

            Random rnd = new Random();
            int number = rnd.nextInt(996969);

            String trxID = (String.format("%06d", number));

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = db_connection.connect_to_Db();

            PreparedStatement transaction_ = conn.prepareStatement("INSERT INTO tabel_transaksi VALUES (?,?,?,?,?,?)");
            transaction_.setString(1, trxID);
            transaction_.setString(2, idUser);
            transaction_.setString(3, atasNama);
            transaction_.setString(4, nilaiTx);
            transaction_.setString(5, "unpayed");
            transaction_.setString(6, tx_time);
            transaction_.executeUpdate();

            conn.close();
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
                        + "								<h1>Proses Pembayaran " + atasNama + "</h1>\n"
                        + "								<p>Selesaikan pembayaran Anda.</p>\n"
                        + "							</header><hr>\n"
                        + "      <center>  "
                        + "          <h1>Total Rp. " + nilaiTx + "</h1>"
                        + "   <h3>payment code</h3>"
                        + "   <h2>" + kodeUnik + "</h2>"
                                + "<h4>Bayar di "+metodeBayar+"</h4></center>"
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
