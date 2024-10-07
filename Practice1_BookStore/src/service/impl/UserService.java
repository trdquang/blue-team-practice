package service.impl;

import dto.UserDTO;
import entity.User;
import jdk.jshell.execution.Util;
import mapper.UserMapper;
import model.UserModel;
import service.IUserService;
import util.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService implements IUserService {
    private Scanner sc = new Scanner(System.in);

    UserModel inputOne(){
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        UserModel userModel = new UserModel(name, pass, "");

        return userModel;
    }

    @Override
    public List<UserDTO> getAll() throws IOException {
        List<UserDTO> userDTOS = new ArrayList<>();
        try {
//            System.out.println(User.size);
            List<String> res = FileUtil.readFileBuffer("src/util/user.txt");
            for(int i = 0; i < res.size(); i++){
                String[] obj = res.get(i).split(",");

                String id = obj[0];
                String name = obj[1];
                String pass = obj[2];
                String roleId = obj[3];

                UserDTO userTmp = new UserDTO(id, name, pass, roleId);
                userDTOS.add(userTmp);
            }
//            System.out.println("Da den day");
            return userDTOS;

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    @Override
    public void save(UserModel userModel) {
        try{
            User user = UserMapper.toEntity(userModel);

            user.setId("user" + User.getSize());
            User.setSize(User.getSize() + 1);

            FileUtil.writeFile("src/util/user.txt", "\n" + user.toString(), true);


//            for(int i = 0; i < 10; i++){
//                user.setId("user" + User.getSize());
//                User.setSize(User.getSize() + 1);
//
//                FileUtil.writeFile("src/util/user.txt", "\n" + user.toString(), true);
//            }
        }catch (Exception e){

        }
    }

    @Override
    public void edit(UserDTO e) throws IOException {
        List<UserDTO> userDTOS = getAll();

        UserModel userModel = inputOne();

        String lineWrite = "";

        for(int i = 0; i < userDTOS.size(); i++){
            if(userDTOS.get(i).getId().equalsIgnoreCase(e.getId())){
                userDTOS.get(i).setName(userModel.getName());
                userDTOS.get(i).setPassword(userModel.getPassword());
//                break;
            }
            lineWrite +=  UserMapper.toEntity(userDTOS.get(i)).toString() + "\n";
        }
        FileUtil.writeFile("src/util/user.txt", lineWrite , false);


    }

    @Override
    public void deleteById(String id) throws IOException {

        List<UserDTO> userDTOS = getAll();
//        System.out.println("break");

        int pos = -1;
        for(int i = 0; i < userDTOS.size(); i++){
            if(userDTOS.get(i).getId().equalsIgnoreCase(id)){
                pos = i;
                break;
            }
        }
//        System.out.println("pos = " + pos);

        if(pos == -1){
            System.out.println("Không có id này");
        }else{
            userDTOS.remove(pos);
            System.out.println("đã xóa");
            String lineWrite = "";
            for(int i = 0; i < userDTOS.size(); i++){
                 lineWrite +=  UserMapper.toEntity(userDTOS.get(i)).toString() + "\n";
            }
            FileUtil.writeFile("src/util/user.txt", lineWrite , false);
        }
    }

    @Override
    public UserDTO findById(String id) throws IOException {
        List<UserDTO> userDTOS = getAll();
        int pos = -1;
        for(int i = 0; i < userDTOS.size(); i++){
            if(userDTOS.get(i).getId().equalsIgnoreCase(id)){
                pos = i;
                return userDTOS.get(i);
            }
        }
        return null;
    }
}
