package managerservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.SQLException;

import utils.JDBCUtils;
import domain.Product;
import dao.ProductDao;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@SuppressWarnings("unchecked")
@MultipartConfig
@WebServlet(name = "AddProductServlet", value = "/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    JDBCUtils db = new JDBCUtils();
    private static final long serialVersionUID = 1L;
    private static ProductDao dao=new ProductDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Product product=new Product();
        boolean b= false;
        try {
            DiskFileItemFactory dfif=new DiskFileItemFactory();
            File f=new File("/temp");//文件缓存目录
            if(!f.exists()){
                f.mkdirs();
            }
            String path=request.getRealPath("/pictures");
            dfif.setRepository(new File(path));
            dfif.setSizeThreshold(1024*1024*10);
            ServletFileUpload upload=new ServletFileUpload(dfif);
            upload.setHeaderEncoding("utf-8");
            //System.out.print("go1");
            List<FileItem> items=upload.parseRequest(request);

            String pname = null;
            String pid=RandomStringUtils.randomNumeric(10);
            String pprice = null;
            String pallnum = null;
            int pprice1;
            int pallnum1;
           for (int i=0;i<items.size();i++){
               {
                   FileItem item=items.get(i);
                   if(item.isFormField()){
                       //接收的是非文件
                       String filedName=item.getFieldName();
                       if(filedName.equals("productname")){
                           pname=item.getString("utf-8");

                       }
                       if(filedName.equals("productprice")){
                           pprice=item.getString("utf-8");

                       }
                       if(filedName.equals("productallnum")){
                           pallnum=item.getString("utf-8");

                       }
                   }
                   else{
                       //System.out.print("go1");
                       String filedName=item.getFieldName();
                       //System.out.print(filedName.substring(filedName.lastIndexOf("."),filedName.length()));
                       //filedName=filedName.substring(filedName.lastIndexOf("\\")+1);
                       String houzhui=filedName.substring(filedName.length()-4);

                       String webpath="/pictures";//储存路径
                       String rename=pid+".jpg";
                       String filepath=getServletContext().getRealPath(webpath+filedName);
                       File dir=new File(webpath);
                       if (!dir.exists()) {
                           dir.mkdirs();
                       }
                       File file=new File(path,rename);
                       try {
                           //System.out.print("go2");
                           item.write(file);
                       } catch (Exception e) {
                           e.printStackTrace();
                       }
                   }
               }
               
           }
            request.setCharacterEncoding("utf-8");
            pprice1=Integer.parseInt(pprice);
            pallnum1=Integer.parseInt(pallnum);
            product.setPid(pid);
            product.setPname(pname);
            product.setPallnum(pallnum1);
            product.setPprice(pprice1);

            try {
            b = dao.insert(product);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        if(b) {
            request.setAttribute("message", "添加商品成功！");
            request.getRequestDispatcher("/admin/godworld.jsp").forward(request,response);
        }
        else {
            request.setAttribute("message", "添加失败");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
        doGet(request,response);
    }

}
