package sevlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("图片加载进来啦");
//        ServletInputStream inputStream = req.getInputStream();
//        byte[] bytes = new byte[10000];
//        int reads= inputStream.read(bytes);
//        System.out.println(new String(bytes, 0, reads));


        if (ServletFileUpload.isMultipartContent(req)) {
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        System.out.println("表单项的name属性值" + fileItem.getFieldName());
                        System.out.println("表单项的value属性值" + fileItem.getString("UTF-8"));

                    } else {
                        System.out.println("表单项的name属性值" + fileItem.getFieldName());
                        System.out.println("上传的文件名" + fileItem.getName());
                        fileItem.write(new File("d:\\" + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
}
