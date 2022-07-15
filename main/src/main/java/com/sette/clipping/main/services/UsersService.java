package com.sette.clipping.main.services;

import com.sette.clipping.main.model.Users;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.UsersRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class UsersService /*implements UserDetailsService*/ {

    private final UsersRepository userRepository;

    public UsersService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    //private final PasswordEncoder passwordEncoder;


        
        public Users addUsers(Users users) {
            return userRepository.save(users);
        }
        
        public List<Users> findAllUsers() {
            return userRepository.findAll();
        }
        
        public void updateUsers(int id, Users users) {
            Users user = this.findUsers(id);
            if(!users.getUser_name().equals("")) {
                user.setUser_name(users.getUser_name());
            }
            if(!users.getUser_username().equals("")) {
                user.setUser_username(users.getUser_username());
            }
            if(!users.getUser_password().equals("")) {
                user.setUser_password(users.getUser_password());
            }
                user.setAllow_tenders(users.isAllow_tenders());
                user.setAllow_tags(users.isAllow_tags());
                user.setAllow_socials(users.isAllow_socials());
                user.setAllow_sales(users.isAllow_sales());
                user.setAllow_notifications(users.isAllow_notifications());
                user.setAllow_mediums(users.isAllow_mediums());
                user.setAllow_clips(users.isAllow_clips());
                user.setAllow_clients(users.isAllow_clients());
                user.setAllow_bankruptcies(users.isAllow_bankruptcies());
                user.setAllow_authors(users.isAllow_authors());
                user.setAllow_administrators(users.isAllow_administrators());
            userRepository.save(user);
        }
        
        public Users findUsers(int id) {
            return this.findAllUsers().stream().filter(t -> t.getUser_id()== id).findFirst().get();
     }
        
        public void deleteUsers(int id) {
            userRepository.deleteById(id);
        }



//    public Users register(Users user) {
//        //log.info("Saving new user: {}" + user);
//        user.setUser_password(passwordEncoder.encode(user.getUser_password()));
//        return userRepository.save(user);
//    }
//    @Override
//    public UserDetails loadUserByUsername(String user_username) throws UsernameNotFoundException {
//        Users user = userRepository.findByUsername(user_username);
//        if (user == null) {
//            //log.error("Username not found!");
//            throw new UsernameNotFoundException("Username not found");
//        } else {
//            //log.info("User found {}", username);
//        }
//        user.setUser_username(user_username);
//        return new org.springframework.security.core.userdetails.User(user.getUser_username(), user.getUser_password(), new ArrayList<>());
//    }
}
