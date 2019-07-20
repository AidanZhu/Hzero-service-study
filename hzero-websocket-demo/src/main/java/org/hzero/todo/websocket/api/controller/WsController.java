package org.hzero.todo.websocket.api.controller;

import org.hzero.websocket.helper.OnlineUserHelper;
import org.hzero.websocket.helper.SocketSendHelper;
import org.hzero.websocket.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/ws")
public class WsController {
    @Autowired
    private SocketSendHelper socketSendHelper;

    @Autowired
    private OnlineUserHelper userHelper;

    @GetMapping(value = "/all")
    public void sendMessageToAll(@RequestParam @NotEmpty String key, @RequestParam @NotEmpty String message) {
        socketSendHelper.sendToAll(key, message);
    }

    @GetMapping(value = "/list")
    public List<UserVO> getUserList() {
        return userHelper.getUser();
    }

}
