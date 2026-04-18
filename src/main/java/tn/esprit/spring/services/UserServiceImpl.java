package tn.esprit.spring.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private static final Logger log = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> retrieveAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User addUser(User u) {
        log.info("addUser() start");
        User user = null;
        try {
            user = userRepository.save(u);
            log.info("addUser() end");
        } catch (Exception e) {
            log.error("error in addUser() : " + e);
        }
        return user;
    }

    @Override
    public User updateUser(User u) {
        log.info("updateUser() start");
        User user = null;
        try {
            user = userRepository.save(u);
            log.info("updateUser() end");
        } catch (Exception e) {
            log.error("error in updateUser() : " + e);
        }
        return user;
    }

    @Override
    public void deleteUser(String id) {
        log.info("deleteUser() start");
        try {
            userRepository.deleteById(Long.parseLong(id));
            log.info("deleteUser() end");
        } catch (Exception e) {
            log.error("error in deleteUser() : " + e);
        }
    }

    @Override
    public User retrieveUser(String id) {
        return userRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
