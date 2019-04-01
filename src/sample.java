


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.out;

public class sample extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String city = request.getParameter("cities");
        int length = Integer.parseInt(city);
        String numbers = request.getParameter("matrix");
        String[] splitText = numbers.split(" ");
        int[] mat = new int[splitText.length];
        for(int i = 0; i < splitText.length; i++)
        {
            mat[i] = Integer.parseInt(splitText[i]);

        }






        int[] abc=new int[100];

        PrintWriter out = response.getWriter();


        if (mat.length==length*length) {
            String[] args = new String[2];
            args[0] = city;
            args[1] = numbers;
            abc = TSPNearestNeighbour.main(args);
            out.println("<form style='box-sizing: border-box; width: 260px;  margin: 100px auto 0; box-shadow: 2px 2px 5px 1px rgba(0, 0, 0, 0.2); padding-bottom: 40px; border-radius: 3px;'>");
            out.println("<h1  style='box-sizing: border-box; padding: 20px;  height: 100px;width: 100%;font-size: 18px;background: #18aa8d;color: white; line-height: 150%;  border-radius: 3px 3px 0 0; box-shadow: 0 2px 5px 1px rgba(0, 0, 0, 0.2);'>Optimal route is </h1>");
           out.println("<label style='align:center;'>");

            for (int i=0;i<length;i++) {

                out.println("->"+abc[i]);
            }
            out.print("</label>");
                out.println("<form>");

        }
            else{
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal('Cities = "+length+" ','Enter proper cost matrix','info');");
            out.println("});");
            out.println("</script>");


            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.include(request, response);
        }


    }


}
















