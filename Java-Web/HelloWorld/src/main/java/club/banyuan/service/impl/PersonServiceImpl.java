package club.banyuan.service.impl;

import club.banyuan.dto.Person;
import club.banyuan.entity.PersonEntity;
import club.banyuan.mapper.PersonMapper;
import club.banyuan.service.PersonService;
import club.banyuan.utils.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private RedisUtil redisUtil;

    private static final String PERSON_ID_KEY = "person_id";

    @Override
    public int total() {
        return personMapper.total();
    }

    @Override
    public Person getById(Integer id) {
        String key = PERSON_ID_KEY + ":" + id;
        Person person = (Person) redisUtil.get(key);
        if(person == null) {
            PersonEntity personEntity = personMapper.getById(id);
            if(personEntity == null){
                return null;
            }
            person = new Person();
            BeanUtils.copyProperties(personEntity, person);
            redisUtil.set(key,person);
        }
        return person;
    }

    @Override
    public List<Person> getAll() {
        List<PersonEntity> personEntityList = personMapper.getAll();
        List<Person> list = new ArrayList<>();
        for (PersonEntity personEntity : personEntityList) {
            Person person = new Person();
            BeanUtils.copyProperties(personEntity, person);
            list.add(person);
        }
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(person.getName());
        personEntity.setAge(person.getAge());
        return personMapper.insert(personEntity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(Person person) {
        PersonEntity personEntity = personMapper.getById(person.getId());
        if(personEntity != null){
            String key = PERSON_ID_KEY + ":" +person.getId();
            if (person.getName() != null) {
                personEntity.setName(person.getName());
            }
            if (person.getAge() != null) {
                personEntity.setAge(person.getAge());
            }
            redisUtil.del(key);
            return personMapper.updateById(personEntity) > 0;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(Integer id) {
        PersonEntity personEntity = personMapper.getById(id);
        if(personEntity != null){
            return personMapper.deleteById(id) > 0;
        }
        return false;
    }
}
