package rest_responses;

import java.util.List;

import com.mendix.core.Core;
import com.mendix.core.CoreException;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

import rest_responses.proxies.constants.Constants;
import system.proxies.HttpHeader;
import system.proxies.HttpResponse;

public class RESTResponseProvider {

	private HttpResponse _newHttpResponse;
	private IContext _context;
		
	public RESTResponseProvider(IContext context,HttpResponse httpResponse, Integer statusCode, String content, String reason ) throws CoreException{
	
		IMendixObject httpResponseMxObject;
		_context = context;
	
		if(httpResponse ==null) {
			httpResponseMxObject =  Core.instantiate(context, HttpResponse.getType());
		}
		else {
			httpResponseMxObject = httpResponse.getMendixObject();
		}
		
		_newHttpResponse = HttpResponse.initialize(context, httpResponseMxObject);
		
		setResponseAttributes(context, _newHttpResponse.getMendixObject(), statusCode, content, reason);
		setContentTypeHeader(statusCode, content);
	}
	
	public IMendixObject getResponse() {
		return _newHttpResponse.getMendixObject();
	}
	
	public void setOrOverrideHttpHeader(String key, String value) throws CoreException{
		
		// --- Input Validation ---
		if (this._newHttpResponse == null) {
			Core.getLogger(this.getClass().getName()).warn("HttpResponseObject is null. Cannot set header '" + key + "'.");
			return;
		}
		if (key == null || key.trim().isEmpty()) {
			Core.getLogger(this.getClass().getName()).warn("HeaderName is null or empty. Cannot set header for HttpResponseObject ID: " + this._newHttpResponse.getMendixObject().getId());
			return;
		}
		
		if (value == null || value.trim().isBlank()) {
			return;
		}

		Core.getLogger(this.getClass().getName()).trace(String.format(
			"Attempting to set HTTP header: '%s' = '%s' for HttpResponse ID: %d. ",
			key, value, this._newHttpResponse.getMendixObject().getId().toLong()
		));

		boolean headerFound = false;
		// 1. Retrieve all associated HttpHeader objects from the HttpResponseObject
		//    We use the association member name provided as a parameter.
		List<IMendixObject> associatedHeaders = Core.retrieveByPath(_context, this._newHttpResponse.getMendixObject(), HttpHeader.MemberNames.HttpHeaders.toString());

		for (IMendixObject header : associatedHeaders) {
			String currentHeaderName = header.getValue(_context, HttpHeader.MemberNames.Key.toString());
			// Check if the current header's name matches the one we want to set (case-insensitive)
			if (currentHeaderName != null && currentHeaderName.equalsIgnoreCase(key)) {
				// Header found, override its value
				header.setValue(_context, HttpHeader.MemberNames.Value.toString(), value);
				Core.commit(_context, header); // Commit the change to the existing header object
				headerFound = true;
				Core.getLogger(this.getClass().getName()).trace(String.format("Updated existing HTTP header: '%s' = '%s' for HttpResponse ID: %d", key, value, this._newHttpResponse.getMendixObject().getId().toLong()));
				break; // We found and updated it, no need to check other headers
			}
		}

		if (!headerFound) {
			// Header not found, create a new HttpHeader object
			IMendixObject newHeader = Core.instantiate(_context,HttpHeader.getType());
			newHeader.setValue(_context, HttpHeader.MemberNames.Key.toString(), key);
			newHeader.setValue(_context, HttpHeader.MemberNames.Value.toString(), value);

			// Associate the new header with the HttpResponse object
			// We use the association member name provided as a parameter for the reference on HttpHeader.
			newHeader.setValue(_context, HttpHeader.MemberNames.HttpHeaders.toString(), this._newHttpResponse.getMendixObject().getId());

			Core.commit(_context, newHeader); // Commit the newly created header object
			Core.getLogger(this.getClass().getName()).trace(String.format("Created new HTTP header: '%s' = '%s' for HttpResponse ID: %d", key, value, this._newHttpResponse.getMendixObject().getId().toLong()));
		}
    }
	
	private void setResponseAttributes(IContext context,IMendixObject mxObject, Integer statusCode, String content, String reason){
		
		mxObject.setValue(context, HttpResponse.MemberNames.StatusCode.toString(), statusCode);
		mxObject.setValue(context, HttpResponse.MemberNames.Content.toString(), content);
		mxObject.setValue(context, HttpResponse.MemberNames.HttpVersion.toString(), "1.1" );
		mxObject.setValue(context, HttpResponse.MemberNames.ReasonPhrase.toString(), reason );
	}
	
	private void setContentTypeHeader(Integer statusCode,  String body) throws CoreException
	{
		if(statusCode == 400 || statusCode == 500 || 
			rest_responses.proxies.constants.Constants.getEnableMendixErrorFormat()==false) {
			this.setOrOverrideHttpHeader("Content-type", "application/problem+json");
		}
		else if (statusCode != 204 && statusCode != 304 && body != null && !(body.isBlank())) {
			this.setOrOverrideHttpHeader("Content-type", "application/json");
		}
		
	}
}
