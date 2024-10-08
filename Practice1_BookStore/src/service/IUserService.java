package service;

import dto.UserDTO;
import entity.User;
import model.UserModel;

import java.io.IOException;

public interface IUserService extends BaseService <UserDTO, UserModel>{

    //
    UserModel inputOne();
    UserDTO login() throws IOException;
    void changePassword(String id) throws IOException;
}

