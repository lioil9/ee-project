package club.banyuan.mall.dto;

import java.io.Serializable;
import java.util.List;

public class IndexCategoryDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long categoryId;
	private Byte categoryLevel;
	private String categoryName;
	private List<SecondLevelCategoryDto> secondLevelCategoryVOS;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Byte getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(Byte categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<SecondLevelCategoryDto> getSecondLevelCategoryVOS() {
		return secondLevelCategoryVOS;
	}

	public void setSecondLevelCategoryVOS(List<SecondLevelCategoryDto> secondLevelCategoryVOS) {
		this.secondLevelCategoryVOS = secondLevelCategoryVOS;
	}

}
