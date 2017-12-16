package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.interceptors.AddUserInterceptor;
import com.infoshareacademy.searchengine.repository.UsersRepository;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UsersRepositoryDaoBean implements UsersRepositoryDao, UsersRepositoryDaoRemote {

//    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    @Override
    @Interceptors(AddUserInterceptor.class)
    public void addUser(User user) {
    //    entityManager.persist(new Car());
    //    entityManager.find(Car.class, 1);
        UsersRepository.getRepository().add(user);
    }

    @Override
    public User getUserById(int id) {
        List<User> userList = UsersRepository.getRepository();
        for(User user : userList) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        List<User> userList = UsersRepository.getRepository();
        for(User user : userList) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsersList() {
        return UsersRepository.getRepository();
    }

    @Override
    public List<String> getUsersNames() {
        List<User> userList = UsersRepository.getRepository();
        List<String> names = new ArrayList<>();
        for(User user : userList) {
            names.add(user.getName());
        }
        return names;
    }
}
