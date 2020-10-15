package com.openlibrary.openlibrary.notification.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openlibrary.openlibrary.availablebooks.entity.AvailableBooksEntity;
import com.openlibrary.openlibrary.availablebooks.repository.AvailableBooksRepository;
import com.openlibrary.openlibrary.myprofile.entity.MyProfileEntity;
import com.openlibrary.openlibrary.myprofile.repository.MyProfileRepository;
import com.openlibrary.openlibrary.notification.DTO.CreateNotificationDTO;
import com.openlibrary.openlibrary.notification.DTO.NotificationDTO;
import com.openlibrary.openlibrary.notification.entity.NotificationEntity;
import com.openlibrary.openlibrary.notification.repository.NotificationRepository;



@Service
public class NotificationService {
    
    @Autowired
    NotificationRepository repository;
    @Autowired
    MyProfileRepository myProfileRepository;
    @Autowired
    AvailableBooksRepository availableBooksRepository;
    
public List<NotificationDTO> getAllNotification(long userId) throws Exception {
   List<NotificationEntity> notificationEntityList= repository.findAllNotificaitonOfId(userId);
   List<NotificationDTO> notificationDTOList =new ArrayList<NotificationDTO>();
   for(NotificationEntity entity: notificationEntityList) {
       NotificationDTO notificationDTO =new NotificationDTO(entity.getId(), entity.getNotification(), entity.getMyProfileEntity().getId(), entity.getSenderProfileEntity().getId(), entity.getAvailableBooksEntity().getId());
      notificationDTOList.add(notificationDTO);
   }
   return notificationDTOList;
}
 public void deleteNotification(long userId,long id) {
     Optional<NotificationEntity> notification =repository.findById(id);
     if(notification.isPresent()) {
        repository.deleteById(id);
     }
 }
 public void deleteAllNotification(long userId) {
          repository.deleteAllNotificaitonOfId(userId);
 }
 public NotificationEntity createNotification(CreateNotificationDTO notificationDTO) {
     MyProfileEntity myProfileEntity = myProfileRepository.findById(notificationDTO.getUserId()).get();
     MyProfileEntity senderProfileEntity =myProfileRepository.findById(notificationDTO.getSenderId()).get();
     AvailableBooksEntity availableBooksEntity =availableBooksRepository.findById(notificationDTO.getAvailableBooksId()).get();
     
     NotificationEntity notificationEntity =new NotificationEntity();
     
     notificationEntity.setNotification(notificationDTO.getNotification());
     notificationEntity.setMyProfileEntity(myProfileEntity);
     notificationEntity.setAvailableBooksEntity(availableBooksEntity);
     notificationEntity.setSenderProfileEntity(senderProfileEntity);
   
     
     myProfileEntity.getNotificationList().add(notificationEntity);
     
     
     myProfileRepository.save(myProfileEntity);
     myProfileRepository.save(senderProfileEntity);
     availableBooksRepository.save(availableBooksEntity);
     
     return notificationEntity;
 }
  public NotificationDTO findSentNotificaitonOfId( long userId,long id){
      NotificationEntity entity= repository.findSentNotificaitonOfId(userId, id);
  
     
          NotificationDTO notificationDTO =new NotificationDTO(entity.getId(), entity.getNotification(), entity.getMyProfileEntity().getId(), entity.getSenderProfileEntity().getId(), entity.getAvailableBooksEntity().getId());
    
     
      return notificationDTO;
  }
}
