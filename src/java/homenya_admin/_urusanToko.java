/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homenya_admin;

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
@WebServlet(name = "_urusanToko", urlPatterns = {"/_urusanToko"})
public class _urusanToko extends HttpServlet {

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
        String levelAkun = null;
        String idAkun = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("levelAkun")) {
                    levelAkun = cookie.getValue();
                }
                if (cookie.getName().equals("idAkun")) {
                    idAkun = cookie.getValue();
                }
            }
            if (levelAkun.equals("admin")) {
                try {
                    out.println("<!DOCTYPE html>\n"
                            + "<html lang=\"en\" >\n"
                            + "    <head>\n"
                            + "        <meta charset=\"UTF-8\">\n"
                            + "        <title>Admin Panel</title>\n"
                            + "        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css\">\n"
                            + "        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>\n"
                            + "        <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n"
                            + "        <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n"
                            + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n"
                            + "        <style type=\"text/css\">\n"
                            + "            @import \"https://designmodo.github.io/Flat-UI/dist/css/flat-ui.min.css\";\n"
                            + "            @import \"https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css\";\n"
                            + "            @import \"https://daneden.github.io/animate.css/animate.min.css\";\n"
                            + "            /*-------------------------------*/\n"
                            + "            /*           VARIABLES           */\n"
                            + "            /*-------------------------------*/\n"
                            + "            body {\n"
                            + "                position: relative;\n"
                            + "                overflow-x: hidden;\n"
                            + "            }\n"
                            + "            body,\n"
                            + "            html {\n"
                            + "                height: 100%;\n"
                            + "                background-color: white;\n"
                            + "            }\n"
                            + "            .nav .open > a {\n"
                            + "                background-color: transparent;\n"
                            + "            }\n"
                            + "            .nav .open > a:hover {\n"
                            + "                background-color: transparent;\n"
                            + "            }\n"
                            + "            .nav .open > a:focus {\n"
                            + "                background-color: transparent;\n"
                            + "            }\n"
                            + "            /*-------------------------------*/\n"
                            + "            /*           Wrappers            */\n"
                            + "            /*-------------------------------*/\n"
                            + "            #wrapper {\n"
                            + "                -moz-transition: all 0.5s ease;\n"
                            + "                -o-transition: all 0.5s ease;\n"
                            + "                -webkit-transition: all 0.5s ease;\n"
                            + "                padding-left: 0;\n"
                            + "                transition: all 0.5s ease;\n"
                            + "            }\n"
                            + "            #wrapper.toggled {\n"
                            + "                padding-left: 220px;\n"
                            + "            }\n"
                            + "            #wrapper.toggled #sidebar-wrapper {\n"
                            + "                width: 220px;\n"
                            + "            }\n"
                            + "            #wrapper.toggled #page-content-wrapper {\n"
                            + "                margin-right: -220px;\n"
                            + "                position: absolute;\n"
                            + "            }\n"
                            + "            #sidebar-wrapper {\n"
                            + "                -moz-transition: all 0.5s ease;\n"
                            + "                -o-transition: all 0.5s ease;\n"
                            + "                -webkit-transition: all 0.5s ease;\n"
                            + "                background: #1a1a1a;\n"
                            + "                height: 100%;\n"
                            + "                left: 220px;\n"
                            + "                margin-left: -220px;\n"
                            + "                overflow-x: hidden;\n"
                            + "                overflow-y: auto;\n"
                            + "                transition: all 0.5s ease;\n"
                            + "                width: 0;\n"
                            + "                z-index: 1000;\n"
                            + "            }\n"
                            + "            #sidebar-wrapper::-webkit-scrollbar {\n"
                            + "                display: none;\n"
                            + "            }\n"
                            + "            #page-content-wrapper {\n"
                            + "                padding-top: 70px;\n"
                            + "                width: 100%;\n"
                            + "            }\n"
                            + "            /*-------------------------------*/\n"
                            + "            /*     Sidebar nav styles        */\n"
                            + "            /*-------------------------------*/\n"
                            + "            .sidebar-nav {\n"
                            + "                list-style: none;\n"
                            + "                margin: 0;\n"
                            + "                padding: 0;\n"
                            + "                position: absolute;\n"
                            + "                top: 0;\n"
                            + "                width: 220px;\n"
                            + "            }\n"
                            + "            .sidebar-nav li {\n"
                            + "                display: inline-block;\n"
                            + "                line-height: 20px;\n"
                            + "                position: relative;\n"
                            + "                width: 100%;\n"
                            + "            }\n"
                            + "            .sidebar-nav li:before {\n"
                            + "                background-color: #F2849E;\n"
                            + "                content: '';\n"
                            + "                height: 100%;\n"
                            + "                left: 0;\n"
                            + "                position: absolute;\n"
                            + "                top: 0;\n"
                            + "                transition: width 0.2s ease-in;\n"
                            + "                width: 3px;\n"
                            + "                z-index: -1;\n"
                            + "            }\n"
                            + "            .sidebar-nav li:first-child a {\n"
                            + "                background-color: #F2849E;\n"
                            + "                color: #ffffff;\n"
                            + "            }\n"
                            + "            .sidebar-nav li:nth-child(2):before {\n"
                            + "                background-color: #F2849E;\n"
                            + "            }\n"
                            + "            .sidebar-nav li:nth-child(3):before {\n"
                            + "                background-color: #F2849E;\n"
                            + "            }\n"
                            + "            .sidebar-nav li:nth-child(4):before {\n"
                            + "                background-color: #F2849E;\n"
                            + "            }\n"
                            + "            .sidebar-nav li:nth-child(5):before {\n"
                            + "                background-color: #F2849E;\n"
                            + "            }\n"
                            + "            .sidebar-nav li:nth-child(6):before {\n"
                            + "                background-color: #F2849E;\n"
                            + "            }\n"
                            + "            .sidebar-nav li:nth-child(7):before {\n"
                            + "                background-color: #F2849E;\n"
                            + "            }\n"
                            + "            .sidebar-nav li:nth-child(8):before {\n"
                            + "                background-color: #F2849E;\n"
                            + "            }\n"
                            + "            .sidebar-nav li:nth-child(9):before {\n"
                            + "                background-color: #F2849E;\n"
                            + "            }\n"
                            + "            .sidebar-nav li:hover:before {\n"
                            + "                transition: width 0.2s ease-in;\n"
                            + "                width: 100%;\n"
                            + "            }\n"
                            + "            .sidebar-nav li a {\n"
                            + "                color: #dddddd;\n"
                            + "                display: block;\n"
                            + "                padding: 10px 15px 10px 30px;\n"
                            + "                text-decoration: none;\n"
                            + "            }\n"
                            + "            .sidebar-nav li.open:hover before {\n"
                            + "                transition: width 0.2s ease-in;\n"
                            + "                width: 100%;\n"
                            + "            }\n"
                            + "            .sidebar-nav .dropdown-menu {\n"
                            + "                background-color: #683E48;\n"
                            + "                border-radius: 0;\n"
                            + "                border: none;\n"
                            + "                box-shadow: none;\n"
                            + "                margin: 0;\n"
                            + "                padding: 0;\n"
                            + "                position: relative;\n"
                            + "                width: 100%;\n"
                            + "            }\n"
                            + "            .sidebar-nav li a:hover,\n"
                            + "            .sidebar-nav li a:active,\n"
                            + "            .sidebar-nav li a:focus,\n"
                            + "            .sidebar-nav li.open a:hover,\n"
                            + "            .sidebar-nav li.open a:active,\n"
                            + "            .sidebar-nav li.open a:focus {\n"
                            + "                background-color: transparent;\n"
                            + "                color: #ffffff;\n"
                            + "                text-decoration: none;\n"
                            + "            }\n"
                            + "            .sidebar-nav > .sidebar-brand {\n"
                            + "                font-size: 20px;\n"
                            + "                height: 65px;\n"
                            + "                line-height: 44px;\n"
                            + "            }\n"
                            + "            /*-------------------------------*/\n"
                            + "            /*       Hamburger-Cross         */\n"
                            + "            /*-------------------------------*/\n"
                            + "            .hamburger {\n"
                            + "                background: transparent;\n"
                            + "                border: none;\n"
                            + "                display: block;\n"
                            + "                height: 32px;\n"
                            + "                margin-left: 15px;\n"
                            + "                position: fixed;\n"
                            + "                top: 20px;\n"
                            + "                width: 32px;\n"
                            + "                z-index: 999;\n"
                            + "            }\n"
                            + "            .hamburger:hover {\n"
                            + "                outline: none;\n"
                            + "            }\n"
                            + "            .hamburger:focus {\n"
                            + "                outline: none;\n"
                            + "            }\n"
                            + "            .hamburger:active {\n"
                            + "                outline: none;\n"
                            + "            }\n"
                            + "            .hamburger.is-closed:before {\n"
                            + "                -webkit-transform: translate3d(0, 0, 0);\n"
                            + "                -webkit-transition: all 0.35s ease-in-out;\n"
                            + "                color: #ffffff;\n"
                            + "                content: '';\n"
                            + "                display: block;\n"
                            + "                font-size: 14px;\n"
                            + "                line-height: 32px;\n"
                            + "                opacity: 0;\n"
                            + "                text-align: center;\n"
                            + "                width: 100px;\n"
                            + "            }\n"
                            + "            .hamburger.is-closed:hover before {\n"
                            + "                -webkit-transform: translate3d(-100px, 0, 0);\n"
                            + "                -webkit-transition: all 0.35s ease-in-out;\n"
                            + "                display: block;\n"
                            + "                opacity: 1;\n"
                            + "            }\n"
                            + "            .hamburger.is-closed:hover .hamb-top {\n"
                            + "                -webkit-transition: all 0.35s ease-in-out;\n"
                            + "                top: 0;\n"
                            + "            }\n"
                            + "            .hamburger.is-closed:hover .hamb-bottom {\n"
                            + "                -webkit-transition: all 0.35s ease-in-out;\n"
                            + "                bottom: 0;\n"
                            + "            }\n"
                            + "            .hamburger.is-closed .hamb-top {\n"
                            + "                -webkit-transition: all 0.35s ease-in-out;\n"
                            + "                background-color: rgba(255, 255, 255, 0.7);\n"
                            + "                top: 5px;\n"
                            + "            }\n"
                            + "            .hamburger.is-closed .hamb-middle {\n"
                            + "                background-color: rgba(255, 255, 255, 0.7);\n"
                            + "                margin-top: -2px;\n"
                            + "                top: 50%;\n"
                            + "            }\n"
                            + "            .hamburger.is-closed .hamb-bottom {\n"
                            + "                -webkit-transition: all 0.35s ease-in-out;\n"
                            + "                background-color: rgba(255, 255, 255, 0.7);\n"
                            + "                bottom: 5px;\n"
                            + "            }\n"
                            + "            .hamburger.is-closed .hamb-top,\n"
                            + "            .hamburger.is-closed .hamb-middle,\n"
                            + "            .hamburger.is-closed .hamb-bottom,\n"
                            + "            .hamburger.is-open .hamb-top,\n"
                            + "            .hamburger.is-open .hamb-middle,\n"
                            + "            .hamburger.is-open .hamb-bottom {\n"
                            + "                height: 4px;\n"
                            + "                left: 0;\n"
                            + "                position: absolute;\n"
                            + "                width: 100%;\n"
                            + "            }\n"
                            + "            .hamburger.is-open .hamb-top {\n"
                            + "                -webkit-transform: rotate(45deg);\n"
                            + "                -webkit-transition: -webkit-transform 0.2s cubic-bezier(0.73, 1, 0.28, 0.08);\n"
                            + "                background-color: #fff;\n"
                            + "                margin-top: -2px;\n"
                            + "                top: 50%;\n"
                            + "            }\n"
                            + "            .hamburger.is-open .hamb-middle {\n"
                            + "                background-color: #fff;\n"
                            + "                display: none;\n"
                            + "            }\n"
                            + "            .hamburger.is-open .hamb-bottom {\n"
                            + "                -webkit-transform: rotate(-45deg);\n"
                            + "                -webkit-transition: -webkit-transform 0.2s cubic-bezier(0.73, 1, 0.28, 0.08);\n"
                            + "                background-color: #fff;\n"
                            + "                margin-top: -2px;\n"
                            + "                top: 50%;\n"
                            + "            }\n"
                            + "            .hamburger.is-open:before {\n"
                            + "                -webkit-transform: translate3d(0, 0, 0);\n"
                            + "                -webkit-transition: all 0.35s ease-in-out;\n"
                            + "                color: #ffffff;\n"
                            + "                content: '';\n"
                            + "                display: block;\n"
                            + "                font-size: 14px;\n"
                            + "                line-height: 32px;\n"
                            + "                opacity: 0;\n"
                            + "                text-align: center;\n"
                            + "                width: 100px;\n"
                            + "            }\n"
                            + "            .hamburger.is-open:hover before {\n"
                            + "                -webkit-transform: translate3d(-100px, 0, 0);\n"
                            + "                -webkit-transition: all 0.35s ease-in-out;\n"
                            + "                display: block;\n"
                            + "                opacity: 1;\n"
                            + "            }\n"
                            + "            /*-------------------------------*/\n"
                            + "            /*          Dark Overlay         */\n"
                            + "            /*-------------------------------*/\n"
                            + "            .overlay {\n"
                            + "                position: fixed;\n"
                            + "                display: none;\n"
                            + "                width: 100%;\n"
                            + "                height: 100%;\n"
                            + "                top: 0;\n"
                            + "                left: 0;\n"
                            + "                right: 0;\n"
                            + "                bottom: 0;\n"
                            + "                background-color: rgba(0, 0, 0, 0.4);\n"
                            + "                z-index: 1;\n"
                            + "            }\n"
                            + "            /* SOME DEMO STYLES - NOT REQUIRED */\n"
                            + "            body,\n"
                            + "            html {\n"
                            + "                background-color: #847676;\n"
                            + "            }\n"
                            + "            body h1,\n"
                            + "            body h2,\n"
                            + "            body h3,\n"
                            + "            body h4 {\n"
                            + "                color: rgba(255, 255, 255, 0.9);\n"
                            + "            }\n"
                            + "            body p,\n"
                            + "            body blockquote {\n"
                            + "                color: rgba(255, 255, 255, 0.7);\n"
                            + "            }\n"
                            + "            body a {\n"
                            + "                color: rgba(255, 255, 255, 0.8);\n"
                            + "                text-decoration: underline;\n"
                            + "            }\n"
                            + "            body a:hover {\n"
                            + "                color: #fff;\n"
                            + "            }\n"
                            + "        </style>\n"
                            + "\n"
                            + "    </head>\n"
                            + "    <body>\n"
                            + "        <!-- partial:index.partial.html -->\n"
                            + "        <div id=\"wrapper\">\n"
                            + "            <div class=\"overlay\"></div>\n"
                            + "\n"
                            + "            <!-- Sidebar -->\n"
                            + "            <nav class=\"navbar navbar-inverse navbar-fixed-top\" id=\"sidebar-wrapper\" role=\"navigation\">\n"
                            + "                <ul class=\"nav sidebar-nav\">\n"
                            + "                    <li class=\"sidebar-brand\">\n"
                            + "                        <a href=\"#\"><img src=\"images/logo.png\" alt=\"\" width=\"35\" height=\"35\"/>\n"
                            + "                            KERA LOKAL\n"
                            + "                        </a>\n"
                            + "                    </li>\n"
                            + "                    <li>\n"
                            + "                        <a href=\"./_home_admin\"><i class=\"fa fa-fw fa-home\"></i> Home</a>\n"
                            + "                    </li>\n"
                            + "\n                  <li>\n"
                            + "                    <a href=\"./view_urusanProduk\"><i class=\"fa fa-fw fa-sitemap\"></i>Manajemen Barang</a>\n"
                            + "                </li>\n"
                            + "                    <li class=\"dropdown\">\n"
                            + "                        <a href=\"#\" data-toggle=\"dropdown\"><i class=\"fa fa-fw fa-truck\"></i>Jasa Pengirim<span class=\"caret\"></span></a>\n"
                            + "                        <ul class=\"dropdown-menu\" role=\"menu\">\n"
                            + "                            <li class=\"dropdown-header\"> </li>\n"
                            + "                            <li><a href=\"./_urusanPengiriman\">Tambah Jasa Kirim</a></li>\n"
                            + "                            <li><a href=\"./view_urusanPengiriman\">Daftar Jasa Pengirim Tersedia</a></li>\n"
                            + "                        </ul>\n"
                            + "                    </li>\n"
                            + "\n"
                            + "                    <li class=\"dropdown\">\n"
                            + "                        <a href=\"#\" data-toggle=\"dropdown\"><i class=\"fa fa-fw fa-street-view\"></i>Toko<span class=\"caret\"></span></a>\n"
                            + "                        <ul class=\"dropdown-menu\" role=\"menu\">\n"
                            + "                            <li class=\"dropdown-header\"> </li>\n"
                            + "                            <li><a href=\"./_urusanToko\">Tambah Toko</a></li>\n"
                            + "                            <li><a href=\"./view_urusanToko\">Daftar Toko yang Tersedia</a></li>\n"
                            + "                        </ul>\n"
                            + "                    </li>\n"
                            + "\n"
                            + "                    <li class=\"dropdown\">\n"
                            + "                        <a href=\"#\" data-toggle=\"dropdown\"><i class=\"fa fa-fw fa-credit-card\"></i>Pembayaran<span class=\"caret\"></span></a>\n"
                            + "                        <ul class=\"dropdown-menu\" role=\"menu\">\n"
                            + "                            <li class=\"dropdown-header\"> </li>\n"
                            + "                            <li><a href=\"./_urusanPembayaran\">Tambah Metode Bayar</a></li>\n"
                            + "                            <li><a href=\"./view_urusanPembayaran\">Daftar Metode Tersedia</a></li>\n"
                            + "                        </ul>\n"
                            + "                    </li>\n"
                            + "\n"
                            + "                    <li>\n"
                            + "                        <a href=\"./_x_pengaturanakunAdmin?idAdmin_=" + idAkun + "\"><i class=\"fa fa-fw fa-cogs\"></i> Pengaturan Akun</a>\n"
                            + "                    </li>\n"
                            + "                    <li>\n"
                            + "                        <a href=\"./logout2_\"><i class=\"fa fa-fw fa-power-off\"></i> Logout</a>\n"
                            + "                    </li>\n"
                            + "                </ul>\n"
                            + "            </nav>\n"
                            + "            <!-- /#sidebar-wrapper -->\n"
                            + "\n"
                            + "            <!-- Page Content -->\n"
                            + "\n"
                            + "            <div id=\"page-content-wrapper\">\n"
                            + "                <button type=\"button\" class=\"hamburger is-closed animated fadeInLeft\" data-toggle=\"offcanvas\">\n"
                            + "                    <span class=\"hamb-top\"></span>\n"
                            + "                    <span class=\"hamb-middle\"></span>\n"
                            + "                    <span class=\"hamb-bottom\"></span>\n"
                            + "                </button>\n"
                            + "\n"
                            + "                <div class=\"container\">\n"
                            + "\n"
                            + "                    <div class=\"row\">\n"
                            + "                        <h2>Tambah Toko</h2>\n"
                            + "                        <form class=\"form\" enctype=\"multipart/form-data\" action=\"./simpan_urusanToko\" method=\"POST\" id=\"registrationForm\">\n"
                            + "\n"
                            + "                            <div class=\"form-group\">\n"
                            + "                                <div class=\"col-xs-6\">\n"
                            + "                                    <h4>Nama Toko</h4>\n"
                            + "                                    <input type=\"text\" class=\"form-control\" name=\"nama_toko\" id=\"nama_depan\" required>\n"
                            + "                                </div>\n"
                            + "                            </div>\n"
                            + "\n"
                            + "                            \n"
                            + "                            <div class=\"form-group\">\n"
                            + "                                <div class=\"col-xs-6\">\n"
                            + "                                    <h4>Nomer Telepon Toko</h4>\n"
                            + "                                    <input type=\"text\" class=\"form-control\" name=\"notel_toko\" id=\"no_hp\" required placeholder=\"kode area - nomor\">\n"
                            + "                                </div>\n"
                            + "                            </div>\n"
                            + "\n"
                            + "                            <div class=\"form-group\">\n"
                            + "                                <div class=\"col-xs-6\">\n"
                            + "                                    <h4>Alamat Toko Offline</h4>\n"
                            + "                                    <textarea rows=\"5\" type=\"text\" class=\"form-control\" name=\"alamat_toko\" required id=\"alamat\"> </textarea>\n"
                            + "                                </div>\n"
                            + "                            </div>\n"
                            + "\n"
                            + "                            <div class=\"form-group\">\n"
                            + "                                <div class=\"col-xs-6\">\n"
                            + "                                    <h4>Logo Toko</h4>\n"
                            + "                                    <input type=\"file\" class=\"custom-file-input\" id=\"logo_store\" name=\"logo_store\" required accept=\"image/*\"/>\n"
                            + "                                </div>\n"
                            + "                            </div>\n"
                            + ""
                            + "                            <div class=\"form-group\">\n"
                            + "                                <div class=\"col-xs-6\">\n"
                            + "                                    <hr><h4>E-Mail Toko</h4>\n"
                            + "                                    <input type=\"email\" class=\"form-control\" name=\"email_toko\" id=\"no_hp\" required placeholder=\"e@mail.com\">\n"
                            + "                                        <h4>Password Toko</h4>\n"
                            + "                                    <input type=\"password\" class=\"form-control\" name=\"password_toko\" id=\"no_hp\" required>\n"
                            + "                                 </div>\n"
                            + "                            </div>\n"
                            + ""
                            + "                            <div class=\"form-group\">\n"
                            + "                                <div class=\"col-xs-12\">\n"
                            + "                                    <br>\n"
                            + "                                    <button class=\"button icon solid\" type=\"submit\"><i class=\"glyphicon glyphicon-floppy-disk\"></i>Save</button>\n"
                            + "                                    <button class=\"button icon solid\" type=\"reset\"><i class=\"glyphicon glyphicon-repeat\"></i> Reset</button>\n"
                            + "                                </div>\n"
                            + "                            </div>\n"
                            + "                        </form>\n"
                            + "                        <div class=\"col-lg-8 col-lg-offset-2\">\n"
                            + "                            <!--<p>isi konten bisa disini3</p>-->\n"
                            + "                        </div>\n"
                            + "                    </div>\n"
                            + "                </div>\n"
                            + "            </div>\n"
                            + "            <!-- /#page-content-wrapper -->\n"
                            + "\n"
                            + "        </div>\n"
                            + "        <!-- /#wrapper -->\n"
                            + "        <!-- partial -->\n"
                            + "        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\n"
                            + "        <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>\n"
                            + "        <script>\n"
                            + "            $(document).ready(function () {\n"
                            + "                var trigger = $('.hamburger'),\n"
                            + "                        overlay = $('.overlay'),\n"
                            + "                        isClosed = false;\n"
                            + "\n"
                            + "                trigger.click(function () {\n"
                            + "                    hamburger_cross();\n"
                            + "                });\n"
                            + "\n"
                            + "                function hamburger_cross() {\n"
                            + "\n"
                            + "                    if (isClosed == true) {\n"
                            + "                        overlay.hide();\n"
                            + "                        trigger.removeClass('is-open');\n"
                            + "                        trigger.addClass('is-closed');\n"
                            + "                        isClosed = false;\n"
                            + "                    } else {\n"
                            + "                        overlay.show();\n"
                            + "                        trigger.removeClass('is-closed');\n"
                            + "                        trigger.addClass('is-open');\n"
                            + "                        isClosed = true;\n"
                            + "                    }\n"
                            + "                }\n"
                            + "\n"
                            + "                $('[data-toggle=\"offcanvas\"]').click(function () {\n"
                            + "                    $('#wrapper').toggleClass('toggled');\n"
                            + "                });\n"
                            + "            });\n"
                            + "        </script>\n"
                            + "\n"
                            + "    </body>\n"
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
