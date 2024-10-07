package service;

import java.util.List;

public interface BaseService <T, U, E>{
   //lay ra DTO
    List<T> getAll();

    //0- that bai, 1: thanh cong;   (model -> entiry)
    void save(U u);

    //- ela entity
    void edit (E e);

    void deleteById(String id);

    E findById(String id);
}
