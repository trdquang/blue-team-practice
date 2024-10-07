package service;

import java.util.List;

public interface BaseService <T, U, E>{
   //lay ra DTO
    List<T> getAll();

    //0- that bai, 1: thanh cong;   (model -> entiry)
    int save(U u);

    int edit (U u);

    int deleteById(String id);

    int findById(String id);
}
