# Socket.IO + SpringBoot
이 자료는 스프링부트로 Socket.io 사용하는 법을 적습니다.

공식문서 자료는 헷갈리는 부분이 있으며, Servlet으로 사용하는 예시입니다.

따라서 Spring에서 사용할 수 있도록 본 문서와 예제를 작성합니다.

먼저 [JavaScript Server](https://github.com/socketio/socket.io) 에서 이식된 [Java용 Socket.IO Server Library](https://github.com/trinopoty/socket.io-server-java) 설치하여 서버부터 만들어보겠습니다.

<br>

# 1. Socket.IO Server 설치

## 문서
- [공식문서](https://trinopoty.github.io/socket.io-server-java/)
- Spring으로 재해석한 문서는 [wiki](https://github.com/Sangyong-Jeon/SpringBoot_Socket.io/wiki)에 적었습니다.

## 설치법
`build.gradle`에 다음 코드를 추가합니다.
```java
implementation 'io.socket:socket.io-server:4.0.1'
```
만약 gradle이 아니라면 [mvnrepository](https://mvnrepository.com/artifact/io.socket/socket.io-server/4.0.1) 사이트에서 해당 의존성을 찾아 설치하십시오.
