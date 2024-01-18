package com.rdLessons.multiLayerErrorHandling.repository;

import com.rdLessons.multiLayerErrorHandling.repository.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public void save(User user) throws DataAccessException {
        // Veritabanına kaydet
        // Örnek: entityManager.persist(user);
        // Burada oluşabilecek veritabanı hataları veya bağlantı sorunları ele alınabilir.
    }
}
