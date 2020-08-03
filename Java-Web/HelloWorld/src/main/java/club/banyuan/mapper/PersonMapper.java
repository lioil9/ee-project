package club.banyuan.mapper;


import club.banyuan.entity.PersonEntity;
import club.banyuan.entity.PersonEntity;

import java.util.List;

public interface PersonMapper {
    int total();
    PersonEntity getById(Integer id);
    List<PersonEntity> getAll();
    int insert(PersonEntity person);
    int updateById(PersonEntity person);
    int deleteById(Integer id);
}
