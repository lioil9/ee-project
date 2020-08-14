package club.banyuan.mall.dto;

import java.io.Serializable;

public class IndexCarouselDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String carouselUrl;
	private String redirectUrl;

	public String getCarouselUrl() {
		return carouselUrl;
	}

	public void setCarouselUrl(String carouselUrl) {
		this.carouselUrl = carouselUrl;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

}
