package club.banyuan.service;

import club.banyuan.dto.Person;

import java.util.List;

public interface PersonService {
    int total();
    Person getById(Integer id);
    List<Person> getAll();
    boolean insert(Person person);
    boolean updateById(Person person);
    boolean deleteById(Integer id);

}
