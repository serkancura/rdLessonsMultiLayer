package com.rdLessons.multiLayerErrorHandling.services;

import com.rdLessons.multiLayerErrorHandling.helpers.errorHandiling.ServiceException;
import com.rdLessons.multiLayerErrorHandling.repository.UserRepository;
import com.rdLessons.multiLayerErrorHandling.repository.model.User;
import jakarta.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) throws ValidationException, ServiceException {
        // Kullanıcı doğrulaması yap
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new ValidationException("Kullanıcı adı geçerli değil.");
        }

        try {
            userRepository.save(user);
        } catch (DataAccessException e) {
            throw new ServiceException("Veritabanına erişim hatası. Hata detayı: ",e);
        }
    }
}
