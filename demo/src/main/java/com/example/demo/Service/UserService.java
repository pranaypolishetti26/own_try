package com.example.demo.Service;

import com.example.demo.EncryptionDecryption.EncryptDecrypt;
import com.example.demo.Repository.ChannelRepository;
import com.example.demo.Repository.ReprocessRequestRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Domain.UserLogin;
import com.example.demo.Utilities.Mail;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;
import java.sql.Timestamp;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final EncryptDecrypt encryptDecrypt;
    private final Mail mail;
    private String myKey = "Accolite";

    public UserService(UserRepository userRepository, ChannelRepository channelRepository, ReprocessRequestRepository reprocessRequestRepository, EncryptDecrypt encryptDecrypt, Mail mail) {
        this.userRepository = userRepository;
        this.encryptDecrypt = encryptDecrypt;
        this.mail = mail;
    }

    public UserLogin findUser(String username){
        Optional<UserLogin> OptionalUser = userRepository.findByUserName(username);
        if(OptionalUser.isPresent())
            return OptionalUser.get();
        else
            return new UserLogin();
    }
    public UserLogin addUser(UserLogin userBody){
        Optional<UserLogin> OptionalUser = userRepository.findByUserName(userBody.getUserName());
        if(!OptionalUser.isPresent())
        {
            UserLogin user = new UserLogin();
            user.setUsername(userBody.getUsername());
            user.setPassword(encryptDecrypt.encrypt(userBody.getPassword(), myKey));
            user.setUserEmail(userBody.getUserEmail());
            user.setTimeStamps(new Timestamp(new Date().getTime()));
            userRepository.save(user);
            return user;
        }
        return new UserLogin();
    }
    public String updatePassword(UserLogin userBody){
        Optional<UserLogin> user = userRepository.findByUserName(userBody.getUserName());
        if(user.isPresent()) {
            user.get().setTimeStamps(new Timestamp(new Date().getTime()));
            user.get().setPassword(encryptDecrypt.encrypt(userBody.getPassword(), myKey));
            userRepository.save(user.get());
            return "Password Changed Successfully!!";
        }
        return "Incorrect Username!!";
    }

    public String forgotPassword(UserLogin userBody){
        Optional<UserLogin> user = userRepository.findByUserName(userBody.getUserName());
        if(user.isPresent() && user.get().getUserEmail().equalsIgnoreCase(userBody.getUserEmail())) {
            Mail.sendMail(user.get().getUserEmail());
            return "Sent an Link!!";
        }
        return "Incorrect Username or Email!!";
    }

    public  String loginUser(UserLogin userBody) {
        Optional<UserLogin> user = userRepository.findByUserName(userBody.getUserName());
        if(user.isPresent())
        {
            if(encryptDecrypt.decrypt(user.get().getPassword(),myKey).equals(userBody.getPassword()))
            {
                user.get().setTimeStamps(new Timestamp(new Date().getTime()));
                userRepository.save(user.get());
                return "Login Success";
            }
            else{
                return "Incorrect password";
            }
        }
        return "Incorrect username";
    }
}









