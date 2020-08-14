package club.banyuan.mall.dto;

import java.io.Serializable;
import java.util.List;

public class IndexInfoDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<IndexCarouselDto> carousels;
	private List<IndexConfigGoodsDto> hotGoodses;
	private List<IndexConfigGoodsDto> newGoodses;
	private List<IndexConfigGoodsDto> recommendGoodses;

	public List<IndexCarouselDto> getCarousels() {
		return carousels;
	}

	public void setCarousels(List<IndexCarouselDto> carousels) {
		this.carousels = carousels;
	}

	public List<IndexConfigGoodsDto> getHotGoodses() {
		return hotGoodses;
	}

	public void setHotGoodses(List<IndexConfigGoodsDto> hotGoodses) {
		this.hotGoodses = hotGoodses;
	}

	public List<IndexConfigGoodsDto> getNewGoodses() {
		return newGoodses;
	}

	public void setNewGoodses(List<IndexConfigGoodsDto> newGoodses) {
		this.newGoodses = newGoodses;
	}

	public List<IndexConfigGoodsDto> getRecommendGoodses() {
		return recommendGoodses;
	}

	public void setRecommendGoodses(List<IndexConfigGoodsDto> recommendGoodses) {
		this.recommendGoodses = recommendGoodses;
	}

}
