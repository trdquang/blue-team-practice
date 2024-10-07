package service;

import java.io.IOException;
import java.util.List;

public interface BaseService <T, U>{
   //lay ra DTO
    List<T> getAll() throws IOException;

    //0- that bai, 1: thanh cong;   (model -> entiry)
    void save(U u);

    //- e la entity
    void edit (T e);

    void deleteById(String id);

    T findById(String id);
}
