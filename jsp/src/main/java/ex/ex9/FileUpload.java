package ex.ex9;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/fileUpload")
public class FileUpload extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FileUpload() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uploadPath = request.getServletContext().getRealPath("upload"); //강사코드 C:\\workspace\\jsp\\target\\jsp-1.0-SNAPSHOT\\upload
//        String uploadPath = "C:\\workspace\\jsp\\src\\main\\webapp\\ex\\upload";
        System.out.println("upload 경로 : " + uploadPath);

        int size = 10*1024*1024; // 파일 최대 크기를 10MB로 지정합니다.
        String name = "", subject = "", systemName1="", systemName2="",
                origfileName1 = "", origfileName2 = "";

        try {
            /**
             * 업로드를 담당하는 부분입니다.
             * 1. 첫 번째 인자(request) : 폼에서 가져온 값을 얻기 위해 request 객체를 전달해 줍니다.
             * 2. 두 번째 인자(uploadPath) : 업로드될 파일의 위치 입니다.
             * 3. 세 번째 인자(size) : 업로드 할 크기이며 저장 크기보다 크면 Exception 발생합니다.
             * 4. 네 번째 인자("UTF-8") : 파일 이름이 한글인 경우 처리하는 부분입니다.
             * 5. 다섯 번째 인자 : 똑같은 파일을 업로드 할 경우 중복되지 않도록 자동으로 파일이름을 변환해주는 기능을 합니다.
             */
            MultipartRequest multi = new MultipartRequest(request,
                    uploadPath,
                    size,
                    "UTF-8",
                    new DefaultFileRenamePolicy());

            name = multi.getParameter("name");
            subject = multi.getParameter("subject");

            //name=fileName1의 input에서 올린 파일의 시스템상의 파일명을 얻어옵니다.
            //중복된 파일명의 경우 파일명 맨뒤에 숫자를 붙여 처리합니다.
            systemName1 = multi.getFilesystemName("fileName1"); //중복일경우 파일뒤에 숫자가 붙는데 그 숫자까지 붙은 파일명 표시

            //name=fileName1의 input에서 업로드한 원본 파일명을 얻어 옵니다.
            origfileName1 = multi.getOriginalFileName("fileName1"); // 중복파일이어도 원본 파일명 표시

            systemName2 = multi.getFilesystemName("fileName2");
            origfileName2 = multi.getOriginalFileName("fileName2");

            request.setAttribute("name", name);
            request.setAttribute("subject", subject);
            request.setAttribute("systemName1", systemName1);
            request.setAttribute("systemName2", systemName2);
            request.setAttribute("origfileName1", origfileName1);
            request.setAttribute("origfileName2", origfileName2);
            request.setAttribute("uploadPath", uploadPath);
            request.getRequestDispatcher("/ex/ex9/fileCheck.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("에러 입니다.");
        }
    }
}
