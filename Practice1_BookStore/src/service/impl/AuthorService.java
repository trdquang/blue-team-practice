package service.impl;

import dto.AuthorDTO;
import dto.BookDTO;
import dto.UserDTO;
import entity.Author;
import entity.User;
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
import java.util.Set;

public class AuthorService implements IAuthorService {
    Scanner scanner = new Scanner(System.in);


    public AuthorService() throws IOException {

    }
    public List<BookDTO> showBooksByAuthor() {
        List<BookDTO> result = new ArrayList<>();
        try {
            BookServiceImplement bookServiceImplement = new BookServiceImplement();
            List<BookDTO> bookDTOS = bookServiceImplement.getAll();
            List<AuthorDTO> authorDTOS = getAll();

            for (AuthorDTO authorDTO : authorDTOS) {
                Integer authorId = Integer.parseInt(authorDTO.getId());
                for (BookDTO bookDTO : bookDTOS) {
                    Set<String> bookAuthorIds = bookDTO.getAuthorIds();

                    if (bookAuthorIds.contains(authorId)) {
                        System.out.println("Book: " + bookDTO.getName() + " belongs to Author: " + authorDTO.getName());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private String generateNewId() throws IOException {
        List<AuthorDTO> authorDTOS = getAll();
        int maxId = 0;

        for (AuthorDTO author : authorDTOS) {
            try {
                int currentId = Integer.parseInt(author.getId());
                if (currentId > maxId) {
                    maxId = currentId;
                }
            } catch (NumberFormatException e) {
//                System.out.println("ID không hợp lệ: " + author.getId());
            }
        }
        int newID = maxId +1 ;

        // Tăng lên 1 và tạo id mới
        return newID +"";
    }


    public AuthorDTO authorDTO(){
        System.out.println("nhap id");
        String id = scanner.next();
        System.out.println("nhập name");
        String name = scanner.next();
        AuthorDTO authorDTO = new AuthorDTO(id,name);
        return authorDTO;
    }
    public void saveFlowName() throws IOException {

        String id = generateNewId();
        System.out.println("nhập name");
//        String name = scanner.next();
        String name = scanner.nextLine();
        AuthorModel authorModel = new AuthorModel(id,name);
        save(authorModel);
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
    public void EditEntity(){
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
            FileUtil.writeFile(FilePath.AUTHOR_FILE_PATH, author.getId() + "," + author.getName() + "\n", true);
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
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < authorDTOS.size(); i++) {
                if(authorDTOS.get(i).getId().equals(e.getId())){
                    authorDTOS.get(i).setName(e.getName());
                    found = true;
                    break;
                }


            }
            if(found){
                for (AuthorDTO a: authorDTOS
                ) {
                    Author author = AuthorMapper.toAuthor1(a);
                    stringBuilder.append(author.getId())
                            .append(",")
                            .append(author.getName())
                            .append(System.lineSeparator())

                    ;
                }
                FileUtil.writeFile(FilePath.AUTHOR_FILE_PATH,stringBuilder.toString(),false);
                System.out.println("đã thay đổi ");
            }else {
                System.out.println("chưa thay đổi ");
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

            for (int i = 0; i < authorDTOS.size(); i++) {
                AuthorDTO authorDTO = authorDTOS.get(i);

                if (authorDTO.getId().equals(id)) {
                    authorDTOS.remove(i);
                    found = true;
                    break;
                }
            }


            if (found) {
                for (AuthorDTO a : authorDTOS) {
                    Author authorEntity = AuthorMapper.toAuthor1(a);
                    path.append(authorEntity.getId()).append(",").append(authorEntity.getName()).append("\n");
                }
                // Ghi lại nội dung vào file
                FileUtil.writeFile(FilePath.AUTHOR_FILE_PATH, path.toString(), false);
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

