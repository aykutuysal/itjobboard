package aykutuysal.jewel.api.v1;

public class AbstractApiController {

	private String apiVersion = "1.0";

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
	
}
