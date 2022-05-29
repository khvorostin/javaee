package com.khvorostin.javaee.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ProductsServlet", urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Выставляем кодировку, так как по умолчанию ответ будет отдан в ISO-8859-1
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        String title = "Список из 10 продуктов";

        List< Product > products = Arrays.asList(
                new Product(1L, "Огниво \"Следопыт\" большое", 289.00),
                new Product(2L, "Проволока цинковая Ц1с ГОСТ 13073-77", 450.00),
                new Product(3L, "Тактический нож Mtech M-A1044GS", 1200.00),
                new Product(4L, "Компас SILVA COMPASS EXPEDITION", 3190.00),
                new Product(5L, "Ручной фонарь LED LENSER Solidline ST6R", 7710.00),
                new Product(6L, "АКВАТАБС, Таблетки для обеззараживания воды, 500мг. на 150л. воды (6 табл.* 3 уп)", 583.00),
                new Product(7L, "Армейский набор хозяйственных принадлежностей", 450.00),
                new Product(8L, "Тетрадь Rite in the Rain (3 шт.)", 1370.00),
                new Product(9L, "Термоодеяло/покрывало походное туристическое, 160*210 см (6 шт.)", 998.00),
                new Product(10L, "Grillkoff Сухое горючее (10 табл.)", 300.00)
        );

        out.println("<!DOCTYPE html>\n" +
                "<html lang='en'>\n" +
                "  <head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                "    <meta http-equiv='X-UA-Compatible' content='ie=edge'>\n" +
                "    <title>" + title + "</title>\n" +
                "    <link rel='stylesheet' href='style.css'>\n" +
                "  </head>\n" +
                "  <body>");

        out.println("<h1>" + title + "</h1>");
        for (Product item : products) {
            out.println("<li><a href='/?item=" + item.getId() + "'>" + item.getTitle() + "</a> (" + item.getCost() + "руб.)</li>");
        }

        out.println("  </body>\n</html>");
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
