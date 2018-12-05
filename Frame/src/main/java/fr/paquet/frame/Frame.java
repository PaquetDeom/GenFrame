package fr.paquet.frame;

public class Frame {

	private String url = null;
	private String hight = null;
	private String weight = null;

	public Frame() {
		super();
	}

	public String getFrame() {

		String a = null;
		String b = null;

		if ((getHight() != null && !getHight().equals(""))
				&& (getWeight() != null && !getWeight().equals("") && (getUrl() != null && !getUrl().equals("")))) {

			b = "<iframe " + "frameborder=" + '"' + "0" + '"' + " allowtransparency=" + '"' + "true" + '"' + " height="
					+ '"' + getHight() + '"' + " src=" + '"' + getUrl() + '"' + " style=" + '"' + "border-width:0;"
					+ '"' + " widht=" + '"' + getWeight() + '"' + " xxx=" + '"' + '"' + "></iframe>";

			a = "<iframe " + " src=" + '"' + getUrl() + '"' + " width=" + '"' + getWeight() + '"' + " height=" + '"'
					+ getHight() + '"' + "></iframe>";

			return a;
		}

		return null;
	}

	private String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String getHight() {
		return hight;
	}

	public void setHight(String hight) {

		this.hight = hight;
	}

	private String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {

		this.weight = weight;
	}

}
