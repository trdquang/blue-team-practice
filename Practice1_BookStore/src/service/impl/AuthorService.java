package service.impl;

import dto.AuthorDTO;
import dto.UserDTO;
import entity.Author;
import model.AuthorModel;
import model.UserModel;
import service.IAuthorService;
import util.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorService implements IAuthorService {
//    List<AuthorDTO> authorDTOS  = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);

    AuthorModel inputOne(){
        System.out.print("Name: ");
        String name = sc.nextLine();
        AuthorModel authorModel = new AuthorModel(name);

        return authorModel;
    }

    @Override
    public List<AuthorDTO> getAll() throws IOException {
        List<AuthorDTO> authors = new ArrayList<>();
        try {
            List<String> r = FileUtil.readFileBuffer("src/util/author.txt");
            for (int i= 0 ; i< r.size() ; i++){
                String[] obj = r.get(i).split(",");
                String a = obj[0];
                String b = obj[1];

                AuthorDTO authorDTO = new AuthorDTO(a,b);
                authors.add(authorDTO);
                return authors;
            }
        }catch (Exception e){

        }
//        return authorDTOS;
        return null;
    }

    @Override
    public void save(AuthorModel authorModel) {

    }

    @Override
    public void edit(AuthorDTO authorDTO) throws IOException {

    }


    @Override
    public void deleteById(String id) {

    }

    @Override
    public AuthorDTO findById(String id) throws IOException {
        return null;
    }

}
