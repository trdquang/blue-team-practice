package service;

import java.io.IOException;
import java.util.List;

public interface BaseService <T, U>{
   //lay ra DTO
    List<T> getAll() throws IOException;

    //0- that bai, 1: thanh cong;   (model -> entiry)
    void save(U u) throws IOException;

    void edit (T t) throws IOException;

    void deleteById(String id) throws IOException;

    T findById(String id) throws IOException;
}
