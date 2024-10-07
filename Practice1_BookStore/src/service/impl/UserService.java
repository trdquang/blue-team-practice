package service.impl;

import dto.UserDTO;
import entity.User;
import model.UserModel;
import service.IUserService;
import util.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {


    @Override
    public List<UserDTO> getAll() throws IOException {
        List<UserDTO> userDTOS = new ArrayList<>();
        try {
            List<String> res = FileUtil.readFileBuffer("src/util/user.txt");
            for(int i = 1; i < res.size(); i++){
                String[] obj = res.get(i).split(",");

                String id = obj[0];
                String name = obj[1];
                String pass = obj[2];
                String roleId = obj[3];

                UserDTO userTmp = new UserDTO(id, name, pass, roleId);
                userDTOS.add(userTmp);
            }
            System.out.println("Da den day");
            return userDTOS;

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    @Override
    public void save(UserModel userModel) {

    }

    @Override
    public void edit(UserDTO e) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public UserDTO findById(String id) {
        return null;
    }
}
