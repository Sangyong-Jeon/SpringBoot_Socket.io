package com.example.springboot.controller;

import io.socket.engineio.server.EngineIoServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 들어오는 HTTP 연결을 처리하기 위한 컨트롤러
@Controller
public class SocketController {

    private final EngineIoServer mEngineIoServer;

    public SocketController(EngineIoServer mEngineIoServer) {
        this.mEngineIoServer = mEngineIoServer;
    }

    @RequestMapping(value = "/socket.io/*")
    public void connect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        mEngineIoServer.handleRequest(request, response);
    }
}
