package com.openlibrary.openlibrary.notification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.openlibrary.openlibrary.notification.entity.NotificationEntity;

@Service
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

    
    @Query(value ="SELECT * FROM NOTIFICATION_ENTITY WHERE NOTIFICATION_ENTITY.RECEIVER_PROFILE_FK = :userId", nativeQuery =true)
    List<NotificationEntity> findAllNotificaitonOfId(@Param("userId") long userId);
  
    @Query(value ="DELETE FROM NOTIFICATION_ENTITY WHERE NOTIFICATION_ENTITY.RECEIVER_PROFILE_FK = :userId", nativeQuery =true)
    List<NotificationEntity> deleteAllNotificaitonOfId(@Param("userId") long userId);
    
    @Query(value ="SELECT * FROM NOTIFICATION_ENTITY WHERE NOTIFICATION_ENTITY.SENDER_PROFILE_FK = :userId AND NOTIFICATION_ENTITY.BOOK_FK = :id", nativeQuery =true)
    NotificationEntity findSentNotificaitonOfId(@Param("userId") long userId, @Param("id") long id);
    
}