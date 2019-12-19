/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homenya_penjual;

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
@WebServlet(name = "seller_urusanProduk", urlPatterns = {"/seller_urusanProduk"})
public class seller_urusanProduk extends HttpServlet {

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
            if (levelAkun.equals("seller")) {
                try {
                    out.println("<!DOCTYPE html>\n"
                            + "<html lang=\"en\" >\n"
                            + "    <head>\n"
                            + "        <meta charset=\"UTF-8\">\n"
                            + "        <title>Dashboard Toko</title>\n"
                            + "        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css\">\n"
                            + "        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>\n"
                            + "        <style type=\"text/css\">\n"
                            + "            @import url('//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css');\n"
                            + "            @font-face {\n"
                            + "                font-family: 'Lato';\n"
                            + "                font-style: normal;\n"
                            + "                font-weight: 300;\n"
                            + "                src: local('Lato Light'), local('Lato-Light'), url(https://fonts.gstatic.com/s/lato/v16/S6u9w4BMUTPHh7USSwiPHA.ttf) format('truetype');\n"
                            + "            }\n"
                            + "            @font-face {\n"
                            + "                font-family: 'Lato';\n"
                            + "                font-style: normal;\n"
                            + "                font-weight: 400;\n"
                            + "                src: local('Lato Regular'), local('Lato-Regular'), url(https://fonts.gstatic.com/s/lato/v16/S6uyw4BMUTPHjx4wWw.ttf) format('truetype');\n"
                            + "            }\n"
                            + "            @font-face {\n"
                            + "                font-family: 'Lato';\n"
                            + "                font-style: normal;\n"
                            + "                font-weight: 700;\n"
                            + "                src: local('Lato Bold'), local('Lato-Bold'), url(https://fonts.gstatic.com/s/lato/v16/S6u9w4BMUTPHh6UVSwiPHA.ttf) format('truetype');\n"
                            + "            }\n"
                            + "            *,\n"
                            + "            *:before,\n"
                            + "            *:after {\n"
                            + "                -webkit-box-sizing: border-box;\n"
                            + "                -moz-box-sizing: border-box;\n"
                            + "                box-sizing: border-box;\n"
                            + "            }\n"
                            + "            body {\n"
                            + "                background: #f5f5f5;\n"
                            + "                padding: 0;\n"
                            + "                margin: 0;\n"
                            + "                font-family: 'Lato', sans-serif;\n"
                            + "            }\n"
                            + "            i.fa {\n"
                            + "                font-size: 16px;\n"
                            + "            }\n"
                            + "            p {\n"
                            + "                font-size: 16px;\n"
                            + "                line-height: 1.42857143;\n"
                            + "            }\n"
                            + "            .header {\n"
                            + "                position: fixed;\n"
                            + "                z-index: 10;\n"
                            + "                top: 0;\n"
                            + "                left: 0;\n"
                            + "                background: #F2849E;\n"
                            + "                width: 100%;\n"
                            + "                height: 50px;\n"
                            + "                line-height: 50px;\n"
                            + "                color: #fff;\n"
                            + "            }\n"
                            + "            .header .logo {\n"
                            + "                text-transform: uppercase;\n"
                            + "                letter-spacing: 1px;\n"
                            + "            }\n"
                            + "            .header #menu-action {\n"
                            + "                display: block;\n"
                            + "                float: left;\n"
                            + "                width: 60px;\n"
                            + "                height: 50px;\n"
                            + "                line-height: 50px;\n"
                            + "                margin-right: 15px;\n"
                            + "                color: #fff;\n"
                            + "                text-decoration: none;\n"
                            + "                text-align: center;\n"
                            + "                background: rgba(0, 0, 0, 0.15);\n"
                            + "                font-size: 13px;\n"
                            + "                text-transform: uppercase;\n"
                            + "                letter-spacing: 1px;\n"
                            + "                -webkit-transition: all 0.2s ease-in-out;\n"
                            + "                transition: all 0.2s ease-in-out;\n"
                            + "            }\n"
                            + "            .header #menu-action i {\n"
                            + "                display: inline-block;\n"
                            + "                margin: 0 5px;\n"
                            + "            }\n"
                            + "            .header #menu-action span {\n"
                            + "                width: 0px;\n"
                            + "                display: none;\n"
                            + "                overflow: hidden;\n"
                            + "                -webkit-transition: all 0.2s ease-in-out;\n"
                            + "                transition: all 0.2s ease-in-out;\n"
                            + "            }\n"
                            + "            .header #menu-action:hover {\n"
                            + "                background: rgba(0, 0, 0, 0.25);\n"
                            + "            }\n"
                            + "            .header #menu-action.active {\n"
                            + "                width: 250px;\n"
                            + "                -webkit-transition: all 0.2s ease-in-out;\n"
                            + "                transition: all 0.2s ease-in-out;\n"
                            + "            }\n"
                            + "            .header #menu-action.active span {\n"
                            + "                display: inline;\n"
                            + "                width: auto;\n"
                            + "                -webkit-transition: all 0.2s ease-in-out;\n"
                            + "                transition: all 0.2s ease-in-out;\n"
                            + "            }\n"
                            + "            .sidebar {\n"
                            + "                position: fixed;\n"
                            + "                z-index: 10;\n"
                            + "                left: 0;\n"
                            + "                top: 50px;\n"
                            + "                height: 100%;\n"
                            + "                width: 60px;\n"
                            + "                background: #fff;\n"
                            + "                border-right: 1px solid #ddd;\n"
                            + "                text-align: center;\n"
                            + "                -webkit-transition: all 0.2s ease-in-out;\n"
                            + "                transition: all 0.2s ease-in-out;\n"
                            + "            }\n"
                            + "            .sidebar:hover,\n"
                            + "            .sidebar.active,\n"
                            + "            .sidebar.hovered {\n"
                            + "                width: 250px;\n"
                            + "                -webkit-transition: all 0.2s ease-in-out;\n"
                            + "                transition: all 0.2s ease-in-out;\n"
                            + "            }\n"
                            + "            .sidebar ul {\n"
                            + "                list-style-type: none;\n"
                            + "                padding: 0;\n"
                            + "                margin: 0;\n"
                            + "            }\n"
                            + "            .sidebar ul li {\n"
                            + "                display: block;\n"
                            + "            }\n"
                            + "            .sidebar ul li a {\n"
                            + "                display: block;\n"
                            + "                position: relative;\n"
                            + "                white-space: nowrap;\n"
                            + "                overflow: hidden;\n"
                            + "                border-bottom: 1px solid #ddd;\n"
                            + "                color: #444;\n"
                            + "                text-align: left;\n"
                            + "            }\n"
                            + "            .sidebar ul li a i {\n"
                            + "                display: inline-block;\n"
                            + "                width: 60px;\n"
                            + "                height: 60px;\n"
                            + "                line-height: 60px;\n"
                            + "                text-align: center;\n"
                            + "                -webkit-animation-duration: 0.7s;\n"
                            + "                -moz-animation-duration: 0.7s;\n"
                            + "                -o-animation-duration: 0.7s;\n"
                            + "                animation-duration: 0.7s;\n"
                            + "                -webkit-animation-fill-mode: both;\n"
                            + "                -moz-animation-fill-mode: both;\n"
                            + "                -o-animation-fill-mode: both;\n"
                            + "                animation-fill-mode: both;\n"
                            + "            }\n"
                            + "            .sidebar ul li a span {\n"
                            + "                display: inline-block;\n"
                            + "                height: 60px;\n"
                            + "                line-height: 60px;\n"
                            + "            }\n"
                            + "            .sidebar ul li a:hover {\n"
                            + "                background-color: #eee;\n"
                            + "            }\n"
                            + "            .sidebar ul li a:hover i {\n"
                            + "                -webkit-animation-name: swing;\n"
                            + "                -moz-animation-name: swing;\n"
                            + "                -o-animation-name: swing;\n"
                            + "                animation-name: swing;\n"
                            + "            }\n"
                            + "            .main {\n"
                            + "                position: relative;\n"
                            + "                display: block;\n"
                            + "                top: 50px;\n"
                            + "                left: 0;\n"
                            + "                padding: 15px;\n"
                            + "                padding-left: 75px;\n"
                            + "                -webkit-transition: all 0.2s ease-in-out;\n"
                            + "                transition: all 0.2s ease-in-out;\n"
                            + "            }\n"
                            + "            .main.active {\n"
                            + "                padding-left: 275px;\n"
                            + "                -webkit-transition: all 0.2s ease-in-out;\n"
                            + "                transition: all 0.2s ease-in-out;\n"
                            + "            }\n"
                            + "            .main .jumbotron {\n"
                            + "                background-color: #fff;\n"
                            + "                padding: 30px !important;\n"
                            + "                border: 1px solid #dfe8f1;\n"
                            + "                -webkit-border-radius: 3px;\n"
                            + "                -moz-border-radius: 3px;\n"
                            + "                border-radius: 3px;\n"
                            + "            }\n"
                            + "            .main .jumbotron h1 {\n"
                            + "                font-size: 24px;\n"
                            + "                margin: 0;\n"
                            + "                padding: 0;\n"
                            + "                margin-bottom: 12px;\n"
                            + "            }\n"
                            + "            @-webkit-keyframes swing {\n"
                            + "                20% {\n"
                            + "                    -webkit-transform: rotate3d(0, 0, 1, 15deg);\n"
                            + "                    transform: rotate3d(0, 0, 1, 15deg);\n"
                            + "                }\n"
                            + "                40% {\n"
                            + "                    -webkit-transform: rotate3d(0, 0, 1, -10deg);\n"
                            + "                    transform: rotate3d(0, 0, 1, -10deg);\n"
                            + "                }\n"
                            + "                60% {\n"
                            + "                    -webkit-transform: rotate3d(0, 0, 1, 5deg);\n"
                            + "                    transform: rotate3d(0, 0, 1, 5deg);\n"
                            + "                }\n"
                            + "                80% {\n"
                            + "                    -webkit-transform: rotate3d(0, 0, 1, -5deg);\n"
                            + "                    transform: rotate3d(0, 0, 1, -5deg);\n"
                            + "                }\n"
                            + "                100% {\n"
                            + "                    -webkit-transform: rotate3d(0, 0, 1, 0deg);\n"
                            + "                    transform: rotate3d(0, 0, 1, 0deg);\n"
                            + "                }\n"
                            + "            }\n"
                            + "            @keyframes swing {\n"
                            + "                20% {\n"
                            + "                    -webkit-transform: rotate3d(0, 0, 1, 15deg);\n"
                            + "                    -ms-transform: rotate3d(0, 0, 1, 15deg);\n"
                            + "                    transform: rotate3d(0, 0, 1, 15deg);\n"
                            + "                }\n"
                            + "                40% {\n"
                            + "                    -webkit-transform: rotate3d(0, 0, 1, -10deg);\n"
                            + "                    -ms-transform: rotate3d(0, 0, 1, -10deg);\n"
                            + "                    transform: rotate3d(0, 0, 1, -10deg);\n"
                            + "                }\n"
                            + "                60% {\n"
                            + "                    -webkit-transform: rotate3d(0, 0, 1, 5deg);\n"
                            + "                    -ms-transform: rotate3d(0, 0, 1, 5deg);\n"
                            + "                    transform: rotate3d(0, 0, 1, 5deg);\n"
                            + "                }\n"
                            + "                80% {\n"
                            + "                    -webkit-transform: rotate3d(0, 0, 1, -5deg);\n"
                            + "                    -ms-transform: rotate3d(0, 0, 1, -5deg);\n"
                            + "                    transform: rotate3d(0, 0, 1, -5deg);\n"
                            + "                }\n"
                            + "                100% {\n"
                            + "                    -webkit-transform: rotate3d(0, 0, 1, 0deg);\n"
                            + "                    -ms-transform: rotate3d(0, 0, 1, 0deg);\n"
                            + "                    transform: rotate3d(0, 0, 1, 0deg);\n"
                            + "                }\n"
                            + "            }\n"
                            + "            .swing {\n"
                            + "                -webkit-transform-origin: top center;\n"
                            + "                -ms-transform-origin: top center;\n"
                            + "                transform-origin: top center;\n"
                            + "                -webkit-animation-name: swing;\n"
                            + "                animation-name: swing;\n"
                            + "            }\n"
                            + "            textarea {\n"
                            + "  resize: none;\n"
                            + "}"
                            + "        </style>\n"
                            + "\n"
                            + "    </head>\n"
                            + "    <body>\n"
                            + "        <!-- partial:index.partial.html -->\n"
                            + "        <div class=\"header\">\n"
                            + "            <a href=\"#\" id=\"menu-action\">\n"
                            + "                <i class=\"fa fa-bars\"></i>\n"
                            + "                <span>Close</span>\n"
                            + "            </a>\n"
                            + "            <div class=\"logo\">\n"
                            + "                <img src=\"images/logo.png\" alt=\"\" width=\"35\" height=\"35\"/>KERA LOKAL\n"
                            + "            </div>\n"
                            + "        </div>\n"
                            + "        <div class=\"sidebar\">\n"
                            + "            <ul>\n"
                            + "                <li><a href=\"./_home_seller\"><i class=\"fa fa-home\"></i><span>Home</span></a></li>\n"
                            + "                <li><a href=\"./seller_urusanProduk\"><i class=\"fa fa-sitemap\"></i><span>Manajemen Barang</span></a></li>\n"
                            + "                <li><a href=\"./seller_kotakMasuk\"><i class=\"fa fa-envelope\"></i><span>Inbox</span></a></li>\n"
                            + "                <li><a href=\"./seller_accountSetting?idToko_="+idAkun+"\"><i class=\"fa fa-wrench\"></i><span>Pengaturan Akun</span></a></li>\n"
                            + "                <li><a href=\"./logout2_\"><i class=\"fa fa-power-off\"></i><span>Logout</span></a></li>\n"
                            + "            </ul> \n"
                            + "        </div>\n"
                            + "\n"
                            + "        <!-- Content -->\n"
                            + "        <div class=\"main\">\n"
                            + "            <div class=\"hipsum\">\n"
                            + "                <div class=\"panel panel-default\">\n"
                            + "                <div class=\"panel-heading\">\n"
                            + "                    Product\n"
                            + "                </div>\n"
                            + "                <div class=\"panel-body\">\n"
                            + "                    <ul class=\"nav nav-tabs\">\n"
                            + "                        <li class=\"active\"><a href=\"#\" data-toggle=\"tab\">Tambah Produk</a>\n"
                            + "                        </li>\n"
                            + "                        <li class=\"\"><a href=\"./seller_viewProducts\" data-toggle=\"tab\">Lihat Daftar Produk</a>\n"
                            + "                        </li>\n"
                            + "                    </ul>\n"
                            + "\n"
                            + "                    <div class=\"tab-content\">\n"
                            + "                        <div class=\"tab-pane fade active in\" id=\"home\">\n"
                            + "                            <h2>Tambah Produk Toko</h2>\n"
                            + "                                    <form enctype=\"multipart/form-data\" action=\"./simpan_produkBaru\" method=\"POST\">\n"
                            + "                                        <div class=\"form-group\">\n"
                            + "                                            <label>Nama Produk</label>\n"
                            + "                                            <input name=\"namaProduk\"type=\"text\" class=\"form-control\" id=\"exampleInputEmail1\" required placeholder=\"cth : kaus kaki motif nazi\">\n"
                            + "                                        </div>\n"
                            + "                                        <div class=\"form-group\">\n"
                            + "                                            <label>Jenis Produk</label>\n"
                            + "                                            <input name=\"jenisProduk\"type=\"text\" class=\"form-control\" id=\"exampleInputEmail1\" required placeholder=\"cth : pakaian\">\n"
                            + "                                        </div>\n"
                            + "                                        <div class=\"form-group\">\n"
                            + "                                            <label >Keterangan Produk</label>\n"
                            + "                                            <textarea rows=\"5\" type=\"text\" class=\"form-control\" name=\"keteranganProduk\" required> </textarea>"
                            + "                                        </div>\n"
                            + "                                        <div class=\"form-inline\">\n"
                            + "                                            <label >Stok Produk</label>\n"
                            + "                                            <input name=\"stokProduk\"type=\"number\" min=\"1\" class=\"form-control\" required id=\"exampleInputEmail1\">"
                            + "                                        &nbsp;&nbsp;&nbsp;<label >Harga Produk&nbsp; Rp.</label>\n"
                            + "                                            <input name=\"hargaProduk\"type=\"number\" min=\"1000\" class=\"form-control\" required id=\"exampleInputEmail1\">"
                            + "                                        </div>\n"
                            + "                                        <div class=\"form-group\">\n"
                            + "                                            <label for=\"exampleInputFile\">Foto Produk</label>\n"
                            + "                                            <input type=\"file\" class=\"btn-primary btn-sm\" id=\"prod_img\" name=\"fotoProduk\" required accept=\"image/*\"/>\n"
                            + "                                            <p class=\"help-block\">Ukuran file foto max 3MB</p>\n"
                            + "                                        </div>\n"
                            + "                                        <input name=\"seller_id\" type=\"text\" hidden value=\"" + idAkun + "\">"
                            + "                                        <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n"
                            + "                                    </form>"
                            + "                        </div>\n"
                            + "                    </div>\n"
                            + "                </div>\n"
                            + "            </div>"
                            + "\n"
                            + "\n"
                            + "            </div>\n"
                            + "            "
                            + "        </div>\n"
                            + "        <!-- partial -->\n"
                            + "        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\n"
                            + "        <script>\n"
                            + "            $('#menu-action').click(function () {\n"
                            + "                $('.sidebar').toggleClass('active');\n"
                            + "                $('.main').toggleClass('active');\n"
                            + "                $(this).toggleClass('active');\n"
                            + "\n"
                            + "                if ($('.sidebar').hasClass('active')) {\n"
                            + "                    $(this).find('i').addClass('fa-close');\n"
                            + "                    $(this).find('i').removeClass('fa-bars');\n"
                            + "                } else {\n"
                            + "                    $(this).find('i').addClass('fa-bars');\n"
                            + "                    $(this).find('i').removeClass('fa-close');\n"
                            + "                }\n"
                            + "            });\n"
                            + "\n"
                            + "            // Add hover feedback on menu\n"
                            + "            $('#menu-action').hover(function () {\n"
                            + "                $('.sidebar').toggleClass('hovered');\n"
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
