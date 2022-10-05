package site.metacoding.red.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import site.metacoding.red.domain.chat.ChatMessage;
import site.metacoding.red.service.ChatService;
import site.metacoding.red.web.dto.chat.ChatRoom;

@RequiredArgsConstructor
@Component
@Slf4j
public class WebSocketHandler  extends TextWebSocketHandler{
	private final ObjectMapper objectMapper;
	private final ChatService chatService;
	
	@Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("{}", payload);
        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
        
        ChatRoom chatRoom = chatService.findRoomById(chatMessage.getRoomId());
        chatRoom.handlerActions(session, chatMessage, chatService);
    }

}
