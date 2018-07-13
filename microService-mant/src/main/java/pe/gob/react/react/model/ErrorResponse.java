package pe.gob.react.react.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="ErrorResponse", description="response data")
public class ErrorResponse {
	
	@ApiModelProperty(required=true, notes="The response message")
    private String responseMessage;

    public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }
	
    public String getResponseMessage() {
        return responseMessage;
    }
    
    @Override
	public String toString() {
		return " message: " + responseMessage;
	}

}
