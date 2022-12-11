package sevlet;


import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class Download extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //    1.获取要下载的文件名
//        String downloadFileName = "3.png";


//    2.读取要下载的文件内容
//        ServletContext servletContext = getServletContext();

//        String mimeType = servletContext.getMimeType("/photo/" + downloadFileName);
//        System.out.println(mimeType);
//        resp.setContentType(mimeType);
//        resp.setHeader("Content-Disposition", "attachment; filename=2.png");
//        resp.setHeader("Content-Disposition", "attachment; fileName=3.png");
//        InputStream inputStream = servletContext.getResourceAsStream("/photo/" + downloadFileName);

//    3.再回传前，通过响应头告诉客户端返回的数据类型


//    4.还要告诉客户端收到的是数据是用于下载使用还是（使用响应头）

//    5.把下载的文件内容回传给客户端
//        ServletOutputStream outputStream = resp.getOutputStream();
//        IOUtils.copy(inputStream, outputStream);
//        获取要下载的文件名
        String downFileName = "3.png";


//        2.用servletContext去.一个输入流查找文件
        ServletContext servletContext = getServletContext();
//        3.通过响应头来告诉客户端这是一个什么数据类型的文件
        String mimeType = servletContext.getMimeType("/photo" + downFileName);
        System.out.println(mimeType);
        resp.setContentType(mimeType);
//        4.通过响应头告诉客户端这是用于下载的还是使用的
        resp.setHeader("Content-Disposition", "attachment; fileName=3.png");
        InputStream resourceAsStream = servletContext.getResourceAsStream("/photo/" + downFileName);


//        5.赋值给一个输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        IOUtils.copy(resourceAsStream, outputStream);



    }
}
