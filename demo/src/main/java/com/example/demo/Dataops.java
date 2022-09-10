package com.example.demo;
import com.example.demo.Domain.Channel;
import com.example.demo.Domain.UserLogin;
import com.example.demo.Service.ChannelReprocess;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface Dataops {

    @GetMapping("/finduser")
    ResponseEntity<?> findUser(@RequestParam(value = "username") String username);

    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> userDetails(@RequestBody UserLogin user);

    @PutMapping(value = "/updatepassword",consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updatePassword(@RequestBody UserLogin user);

    @PutMapping(value = "/forgotpassword",consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> forgotPassword(@RequestBody UserLogin user);

    @PostMapping(value = "/login",consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> userLog(@RequestBody UserLogin user);

    @GetMapping(value = "/getposts",consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getPosts(@RequestBody Channel channel);

    @PostMapping(value = "/addposts",consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
          produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addPosts(@RequestBody ChannelReprocess channelReprocess);

}
