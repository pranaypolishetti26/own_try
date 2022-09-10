package com.example.demo;
import com.example.demo.Domain.Channel;
import com.example.demo.Domain.ReprocessRequest;
import com.example.demo.Domain.UserLogin;
import com.example.demo.Service.ChannelReprocessService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Service.ChannelReprocess;

@RestController
public class DemoController implements Dataops {
    @Autowired
    private UserService userService;
    @Autowired
    private ChannelReprocessService channelReprocessService;
    @Autowired(required = true)
    Channel channel;
    @Autowired
    ReprocessRequest reprocessRequest;

    @Override
    public ResponseEntity<?> findUser(String username) {
        return ResponseEntity.ok(userService.findUser(username));
    }
    @Override
    public ResponseEntity<?> userDetails(UserLogin userBody) {
        UserLogin user = userService.addUser(userBody);
        return ResponseEntity.ok(
                user == null ? ResponseEntity.ok("User already present") : user
        );
    }

    @Override
    public ResponseEntity<?> updatePassword(UserLogin user) {
        return ResponseEntity.ok(userService.updatePassword(user));
    }

    @Override
    public ResponseEntity<?> forgotPassword(UserLogin userBody) {
        return ResponseEntity.ok(userService.forgotPassword(userBody));
    }

    @Override
    public ResponseEntity<?> userLog(UserLogin userBody) {
        return ResponseEntity.ok(userService.loginUser(userBody));
    }

    @Override
    public ResponseEntity<?> getPosts(Channel channel) {
        return ResponseEntity.ok(channelReprocessService.getPosts(channel));
    }


    @Override
    public ResponseEntity<?> addPosts(ChannelReprocess channelReprocess) {
        channel.setChannelId(channelReprocess.getChannelId());
        reprocessRequest.setRchannel(channelReprocess.getRchannel());
        reprocessRequest.setStatus(channelReprocess.getStatus());
        return ResponseEntity.ok(channelReprocessService.addPosts(channel,reprocessRequest));
    }
}