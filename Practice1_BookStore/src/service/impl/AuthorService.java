package service.impl;

import dto.AuthorDTO;
import dto.UserDTO;
import entity.Author;
import mapper.AuthorMapper;
import model.AuthorModel;
import model.UserModel;
import service.IAuthorService;
import util.FilePath;
import util.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorService implements IAuthorService {
    Scanner scanner = new Scanner(System.in);

    public AuthorDTO authorDTO(){
        System.out.println("nhap id");
        String id = scanner.next();
        System.out.println("nhập name");
        String name = scanner.next();
        AuthorDTO authorDTO = new AuthorDTO(id,name);
        return authorDTO;
    }
    public void  display(){
        try {
            List<AuthorDTO> authorDTOS = getAll();
            for (AuthorDTO a:authorDTOS){
                System.out.println(a.toString());
            }
        }catch (Exception e){

        }

    }
    public void tra(){
        edit(authorDTO());
    }


    @Override
    public List<AuthorDTO> getAll() throws IOException {
        List<AuthorDTO> authorDTOS  = new ArrayList<>();
        try {

            List<String> r = FileUtil.readFileBuffer(FilePath.AUTHOR_FILE_PATH);
            for (int i = 0 ; i< r.size() ; i++){
                String[] obj = r.get(i).split(",");
                String a = obj[0];
                String b = obj[1];

                AuthorDTO authorDTO = new AuthorDTO(a,b);
                authorDTOS.add(authorDTO);
            }
        }catch (Exception e){

        }
        return authorDTOS;


    }

    @Override
    public void save(AuthorModel authorModel) {
        try {
            Author author = AuthorMapper.toAuthor(authorModel);
//            String lineSeparator = System.lineSeparator(); // Sử dụng lineSeparator thay cho \n
            String lineSeparator = "";
            FileUtil.writeFile(FilePath.AUTHOR_FILE_PATH, lineSeparator + author.getId() + "," + author.getName() + "\n", true);
            System.out.println("Lưu thành công");
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
        }
    }


    @Override
    public void edit(AuthorDTO e) {
        try{
            List<AuthorDTO> authorDTOS = getAll();
            boolean found = false;
            String fileContent = null;
            for (int i = 0; i < authorDTOS.size(); i++) {
                AuthorDTO authorDTO = authorDTOS.get(i);
                if (authorDTO.getId().equals(e.getId())) {
                    authorDTO.setName(e.getName());
                    fileContent += AuthorMapper.toAuthor1(authorDTOS.get(i)).toString();
                    FileUtil.writeFile(FilePath.AUTHOR_FILE_PATH, fileContent.toString(), false);
                    found = true;
                    break;
                }


            }

            if (!found) {
                System.out.println("Không tìm thấy tác giả với ID: " + e.getId());
                return;
            }else {
                System.out.println("Cập nhật thành công");
            }





        }catch (Exception a){
            a.getMessage();
        }
    }

    @Override
    public void deleteById(String id) {
        try {
            List<AuthorDTO> authorDTOS = getAll();
            boolean found = false;
            StringBuilder path = new StringBuilder();

            // Duyệt qua danh sách để tìm và xóa phần tử
            for (int i = 0; i < authorDTOS.size(); i++) {
                AuthorDTO authorDTO = authorDTOS.get(i);

                if (authorDTO.getId().equals(id)) {
                    authorDTOS.remove(i); // Xóa tác giả nếu tìm thấy
                    found = true;
                    break;
                }
            }

            // Kiểm tra nếu tìm thấy tác giả cần xóa
            if (found) {
                // Tạo lại nội dung file sau khi xóa
                for (AuthorDTO a : authorDTOS) {
                    Author authorEntity = AuthorMapper.toAuthor1(a); // Chuyển từ DTO sang Entity
                    path.append(authorEntity.getId()).append(",").append(authorEntity.getName()).append("\n");
                }
                // Ghi lại nội dung vào file
                FileUtil.writeFile("D:\\text.txt", path.toString(), false);
                System.out.println("Đã xóa thành công tác giả với ID: " + id);
            } else {
                System.out.println("Không tìm thấy tác giả với ID: " + id);
            }

        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
        }
    }


    @Override
    public AuthorDTO findById(String id) {
        try {
            List<AuthorDTO> authorDTOS = getAll();
            for (int i = 0 ; i < authorDTOS.size() ; i++){
                AuthorDTO authorDTO = authorDTOS.get(i);
                if(authorDTO.getId().equals(id)){
                    System.out.println(authorDTOS);
                    return authorDTO;

                }

            }
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }
}
