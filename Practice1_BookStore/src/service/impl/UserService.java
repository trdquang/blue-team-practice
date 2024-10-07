package service.impl;

import dto.UserDTO;
import entity.User;
import model.UserModel;
import service.IUserService;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {

    @Override
    public List<UserDTO> getAll() {
        return List.of();
    }

    @Override
    public void save(UserModel userModel) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public User findById(String id) {
        return null;
    }
}
