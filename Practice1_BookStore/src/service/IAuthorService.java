package service;

import dto.AuthorDTO;
import model.AuthorModel;

import java.io.IOException;
import java.util.List;

public interface IAuthorService extends BaseService<AuthorDTO , AuthorModel> {
    @Override
    List<AuthorDTO> getAll() throws IOException;

    @Override
    void save(AuthorModel authorModel);

    @Override
    void edit(AuthorDTO e);

    @Override
    void deleteById(String id);

    @Override
    AuthorDTO findById(String id);
}
