package site.metacoding.red.web.dto.chat;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.socket.WebSocketSession;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import site.metacoding.red.domain.chat.ChatMessage;
import site.metacoding.red.service.ChatService;

@Getter
@Setter
public class ChatRoom {
    private String roomId;
    private String name;

    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }

    // 웹소켓 세션에 들어왔을 때, 클라이언트에게 메시지를 발송하는 구현체
    // private Set<WebSocketSession> sessions = new HashSet<>();

    // @Builder
    // public ChatRoom(String roomId, String name) {
    // this.roomId = roomId;
    // this.name = name;
    // }

    // public void handlerActions(WebSocketSession session, ChatMessage chatMessage,
    // ChatService chatService) {
    // if (chatMessage.getType().equals(ChatMessage.MessageType.ENTER)) {
    // sessions.add(session);
    // chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다.");
    // }
    // sendMessage(chatMessage, chatService);

    // }

    // private <T> void sendMessage(T message, ChatService chatService) {
    // sessions.parallelStream()
    // .forEach(session -> chatService.sendMessage(session, message));
    // }
}
