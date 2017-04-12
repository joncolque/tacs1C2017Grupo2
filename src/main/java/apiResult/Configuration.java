package apiResult;

import java.util.List;

public class Configuration {
	
	private ImagesConfiguration images;
	
	public Configuration() {
		
	}
	
	public ImagesConfiguration getImages() {
		return images;
	}
	public void setImages(ImagesConfiguration images) {
		this.images = images;
	}
	public List<String> getChange_keys() {
		return change_keys;
	}
	public void setChange_keys(List<String> change_keys) {
		this.change_keys = change_keys;
	}
	private List<String> change_keys;

}
