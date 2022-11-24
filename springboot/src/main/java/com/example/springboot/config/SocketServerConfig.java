package com.example.springboot.config;

import io.socket.engineio.server.EngineIoServer;
import io.socket.socketio.server.SocketIoNamespace;
import io.socket.socketio.server.SocketIoServer;
import io.socket.socketio.server.SocketIoSocket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

// EngineIoServer를 설정하는 클래스 파일
@Configuration
public class SocketServerConfig {

    @Bean
    public EngineIoServer engineIoServer() {
        EngineIoServer engineIoServer = new EngineIoServer();
        SocketIoServer socketIoServer = new SocketIoServer(engineIoServer);

        // 네임스페이스 생성
        SocketIoNamespace namespace = socketIoServer.namespace("/");

        // new connections를 수신하기 위해 connection 이벤트 연결
        namespace.on("connection", args -> {
            SocketIoSocket socket = (SocketIoSocket) args[0];

            // "message" 이벤트 연결
            socket.on("message", args1 -> {
                // Arugments from client available in 'args1'
                System.out.println("message : " + Arrays.toString(args1));
            });

            // "message" 이벤트를 'bar arg' 와 1 이라는 인수를 보냄
            socket.send("message", "bar arg", 1);
        });

        // 'bar arg' 인수가 있는 'message' 이벤트를 'room' 방에 방송
        namespace.broadcast("room", "message", "bar arg");

        return engineIoServer;
    }
}