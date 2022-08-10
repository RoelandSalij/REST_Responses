package rest_responses;

import java.util.List;
import java.util.UUID;

import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

import rest_responses.proxies.ValidationError;

public class ErrorMessageProvider {

	private StringBuilder logMessage = new StringBuilder();
	private String jsonResponseMessage = "";
	
	public ErrorMessageProvider (IContext context, String title, String detail, Integer statusCode, 
			String typeURI, List<ValidationError> validationErrors, String logMessageDetails) {
		
		String instance = UUID.randomUUID().toString();
		
		
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
			logMessage.append(" (instance:");
			logMessage.append(instance);
			logMessage.append(")");
			
			addLogLine("Validation errors: ", validationErrorsContent);
			
			Core.getLogger("ProblemJSONModule").error(logMessage.toString());
		}
				
		jsonResponseMessage = rest_responses.proxies.microflows.Microflows.getProblemResponseAsJSON(context, title, detail, Integer.toUnsignedLong(statusCode), typeURI, validationErrors, instance);
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
