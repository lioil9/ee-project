package club.banyuan.mall.dto;

import java.io.Serializable;
import java.util.List;

public class SecondLevelCategoryDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long categoryId;
	private Long parentId;
	private Byte categoryLevel;
	private String categoryName;
	private List<ThirdLevelCategoryDto> thirdLevelCategoryVOS;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

	public List<ThirdLevelCategoryDto> getThirdLevelCategoryVOS() {
		return thirdLevelCategoryVOS;
	}

	public void setThirdLevelCategoryVOS(List<ThirdLevelCategoryDto> thirdLevelCategoryVOS) {
		this.thirdLevelCategoryVOS = thirdLevelCategoryVOS;
	}

}
