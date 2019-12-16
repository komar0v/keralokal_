/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kelas_java.db_connection;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "Login_", urlPatterns = {"/Login_"})
public class Login_ extends HttpServlet {

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
        String uname = "";
        String pswd = "";
        String id_akun = "";
        String nama_user = "";
        String level_akun = "";
        String alamat_cust = "";
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = db_connection.connect_to_Db();

            String usrName = request.getParameter("email_");
            String passWd = request.getParameter("password_");

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tabel_customer WHERE email_cust=? AND password_cust=?");
            ps.setString(1, usrName);
            ps.setString(2, passWd);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id_akun = rs.getString("id_cust");
                uname = rs.getString("email_cust");
                pswd = rs.getString("password_cust");
                nama_user = rs.getString("namadepan_cust");
                level_akun = rs.getString("level_akun");
                alamat_cust = rs.getString("alamat_cust");
            }
            rs.close();

            PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM tabel_admin WHERE email_admin=? AND pass_admin=?");
            ps2.setString(1, usrName);
            ps2.setString(2, passWd);
            ResultSet rs2 = ps2.executeQuery();

            while (rs2.next()) {
                id_akun = rs2.getString("id_admin");
                uname = rs2.getString("email_admin");
                pswd = rs2.getString("pass_admin");
                nama_user = rs2.getString("nama_admin");
                level_akun = rs2.getString("level_akun");
            }
            rs2.close();

            PreparedStatement ps3 = conn.prepareStatement("SELECT * FROM tabel_toko WHERE email_toko=? AND password_toko=?");
            ps3.setString(1, usrName);
            ps3.setString(2, passWd);
            ResultSet rs3 = ps3.executeQuery();

            while (rs3.next()) {
                id_akun = rs3.getString("id_toko");
                uname = rs3.getString("email_toko");
                pswd = rs3.getString("password_toko");
                nama_user = rs3.getString("nama_toko");
                level_akun = rs3.getString("level_akun");
            }
            rs2.close();

            conn.close();

            if (uname.equals(usrName) && pswd.equals(passWd) && level_akun.equals("user")) {
                //get the old session and invalidate
                HttpSession oldSession = request.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }
                //generate a new session
                HttpSession newSession = request.getSession(true);

                //setting session to expiry in 5 mins
                newSession.setMaxInactiveInterval(5 * 60);

                Cookie namaUser = new Cookie("namaUser", nama_user);
                Cookie levelAkun = new Cookie("levelAkun", level_akun);
                Cookie idAkun = new Cookie("idAkun", id_akun);
                Cookie alamatCust = new Cookie("alamatCust", alamat_cust);
                response.addCookie(levelAkun);
                response.addCookie(namaUser);
                response.addCookie(idAkun);
                response.addCookie(alamatCust);
                response.sendRedirect("./_home_cust");
            } else if (uname.equals(usrName) && pswd.equals(passWd) && level_akun.equals("admin")) {
                //get the old session and invalidate
                HttpSession oldSession = request.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }
                //generate a new session
                HttpSession newSession = request.getSession(true);

                //setting session to expiry in 5 mins
                newSession.setMaxInactiveInterval(5 * 60);

                Cookie namaUser = new Cookie("namaUser", nama_user);
                Cookie levelAkun = new Cookie("levelAkun", level_akun);
                Cookie idAkun = new Cookie("idAkun", id_akun);
                response.addCookie(idAkun);
                response.addCookie(levelAkun);
                response.addCookie(namaUser);
                response.sendRedirect("./_home_admin");
            } else if (uname.equals(usrName) && pswd.equals(passWd) && level_akun.equals("seller")) {
                //get the old session and invalidate
                HttpSession oldSession = request.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }
                //generate a new session
                HttpSession newSession = request.getSession(true);

                //setting session to expiry in 5 mins
                newSession.setMaxInactiveInterval(5 * 60);

                Cookie namaUser = new Cookie("namaUser", nama_user);
                Cookie levelAkun = new Cookie("levelAkun", level_akun);
                Cookie idAkun = new Cookie("idAkun", id_akun);
                response.addCookie(idAkun);
                response.addCookie(levelAkun);
                response.addCookie(namaUser);
                response.sendRedirect("./_home_seller");
            } else {
//                RequestDispatcher rd = getServletContext().getRequestDispatcher("./index.html");

                out.println("<script type=\"text/javascript\">");
                out.println("alert('PASSWORD/USERNAME SALAH');");
                out.println("location='./halaman_login/index.html';");
                out.println("</script>");
//                rd.include(request, response);
            }

        } catch (Exception ex) {
            Logger.getLogger(Login_.class.getName()).log(Level.SEVERE, null, ex);
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
