package club.banyuan.blog.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMapper {

    int deleteTagsByAid(Long aid);
    int savetags(@Param("tags") String[] tags);
    List<Long> getTagIdsByTagNames(@Param("tagNames") String[] tagName);
    int saveTags2ArticleTags(@Param("tagIds") List<Long> tagIds, @Param("aid") Long aid);
}
