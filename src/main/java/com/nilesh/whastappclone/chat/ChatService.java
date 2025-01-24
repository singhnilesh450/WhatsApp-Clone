package com.nilesh.whastappclone.chat;


import com.nilesh.whastappclone.user.User;
import com.nilesh.whastappclone.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;
    private final ChatMapper chatMapper;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<ChatResponse> getChatsByReceiverId(Authentication authentication){
        final String userId = authentication.getName();
        return chatRepository.findChatsBySenderId(userId)
                .stream()
                .map(c-> chatMapper.toChatResponse(c,userId))
                .toList();

    }

    public String createChat(String senderId, String receiverId) {

        Optional<Chat> existingChat = chatRepository.findChatByReceiverAndSender(senderId, receiverId);
        if (existingChat.isPresent()) {
            return existingChat.get().getId();
        }

        User sender = userRepository.findByPublicId(senderId)
                .orElseThrow(() ->  new EntityNotFoundException("User with id " + senderId + " not found"));
        User receiver = userRepository.findByPublicId(receiverId)
                .orElseThrow(() ->  new EntityNotFoundException("User with id " + receiverId + " not found"));

        Chat chat = new Chat();
        chat.setSender(sender);
        chat.setRecipient(receiver);

        Chat savedChat = chatRepository.save(chat);
        return savedChat.getId();
    }
}
