package com.mycompany.fake;
import com.mycompany.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Класс, реализующий паттерн Singleton
 * Представляет собой InMemory-хранилище для получения информации о зарегистрированных пользователях
 */
public class FakeStorage {
    // переменная, которая хранит ссылку на единственный экземпляр объекта класса FakeStorage
    private static final FakeStorage storage;
    // статически инициализатор, создающий объект класса FakeStorage. Вызываеться один раз при загрузке класса в JVM
    static {
        storage = new FakeStorage();
    }
    // пполе-список, хранящее список пользователей системы
    private List<User> users;
    
    // приватный конструктор, выполняющий инициализацию списка
    private FakeStorage() {
        this.users = new ArrayList<>();
        User user = new User("Kirill", "222", LocalDate.parse("1975-02-02");
        User user1 = new User("Trofim", "222", LocalDate.parse("1985-02-02"));
        User user2 = new User("Valentina", "222", LocalDate.parse("1995-02-02"));
        
        users.add(user);
        users.add(user1);
        users.add(user2);
    }
    // метод, предоставляющий доступ к объекту класса
    public static FakeStorage storage() {
        return storage;
    }
    // метод. возвращающий список пользователей
    public List<User> users() {
        return users;
    }
    
    
}
