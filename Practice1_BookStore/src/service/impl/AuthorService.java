package service.impl;

import dto.AuthorDTO;
import entity.Author;
import model.AuthorModel;
import service.IAuthorService;
import util.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthorService implements IAuthorService {
    List<AuthorDTO> authorDTOS  = new ArrayList<>();
    @Override
    public List<AuthorDTO> getAll() throws IOException {
        try {
            List<String> r = FileUtil.readFileBuffer("D:\\CY\\blue-team-practice\\Practice1_BookStore\\src\\util");
            for (int i= 0 ; i< r.size() ; i++){
                String[] obj = r.get(i).split(",");
                String a = obj[0];
                String b = obj[1];

                AuthorDTO authorDTO = new AuthorDTO(a,b);
                authorDTOS.add(authorDTO);
                return authorDTOS;
            }
        }catch (Exception e){

        }
        return authorDTOS;

    }

    @Override
    public void save(AuthorModel authorModel) {

    }

    @Override
    public void edit(AuthorDTO e) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public AuthorDTO findById(String id) {
        return null;
    }
}
