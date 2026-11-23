package rest_responses;

import java.util.List;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import rest_responses.proxies.ValidationError;

public class SiemensErrorMessageProvider {

	private StringBuilder logMessage = new StringBuilder();
	private String jsonResponseMessage = "";
	
	public SiemensErrorMessageProvider (IContext context, Integer statusCode, String title, String detail, 
			String errorCode, String link, String correlationId, List<ValidationError> validationErrors, String logMessageDetails) {
		
		if(logMessageDetails != null && logMessageDetails.length() > 0) {
			String validationErrorsContent = null;
					
			if(validationErrors != null) {
				validationErrorsContent = rest_responses.proxies.microflows.Microflows.getValidationErrorsAsString(context, validationErrors);
			}
			
			logMessage.append(statusCode);
			logMessage.append(" - ");
			logMessage.append(title);
			logMessage.append(" - ");
			logMessage.append(logMessageDetails);
			logMessage.append(" (correlation ID:");
			logMessage.append(correlationId);
			logMessage.append(")");
			
			addLogLine("Validation errors: ", validationErrorsContent);
			
			Core.getLogger("RestResponses").error(logMessage.toString());
		}
				
		jsonResponseMessage = rest_responses.proxies.microflows.Microflows.getProblemResponseAsJSON_V2_0_0(context, title, detail, Integer.toUnsignedLong(statusCode), link, validationErrors, correlationId, errorCode);

	}
	
	private void addLogLine(String name, String text) {
		if(text != null && !text.isEmpty()) {
			logMessage.append(System.lineSeparator());
			logMessage.append("\t");
			logMessage.append(name);
			logMessage.append(text);
		}
	}
	
	
	public String getJSONResponseMessage() {
		return jsonResponseMessage.toString();
	}
}
