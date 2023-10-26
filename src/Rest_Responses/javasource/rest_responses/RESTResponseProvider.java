package rest_responses;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

import system.proxies.HttpHeader;
import system.proxies.HttpResponse;

public class RESTResponseProvider {

	private HttpResponse _newHttpResponse;
	private IContext _context;
		
	public RESTResponseProvider(IContext context,IMendixObject httpResponse, Integer statusCode, String content, String reason ) throws CoreException{
	
		IMendixObject httpResponseMxObject;
		_context = context;
	
		if(httpResponse ==null) {
			httpResponseMxObject =  Core.instantiate(context, HttpResponse.getType());
		}
		else {
			httpResponseMxObject = httpResponse;
		}
		
		_newHttpResponse = HttpResponse.initialize(context, httpResponseMxObject);
		
		setResponseAttributes(context, _newHttpResponse.getMendixObject(), statusCode, content, reason);
		setContentTypeHeader(statusCode);
	}
	
	public IMendixObject getResponse() {
		return _newHttpResponse.getMendixObject();
	}
	
	public void addHttpHeader(String key, String value) throws CoreException{
		
		IMendixObject mxObject = Core.instantiate(_context, HttpHeader.getType());
		mxObject.setValue(_context, HttpHeader.MemberNames.Key.toString(), key);
		mxObject.setValue(_context, HttpHeader.MemberNames.Value.toString(), value);
		Core.getLogger("REST_Responses").trace(String.format("Created new http header:%s %s",key,value));

		if(_newHttpResponse !=null) {
			HttpHeader newHttpHeader = HttpHeader.load(_context, mxObject.getId());
			newHttpHeader.setHttpHeaders(_context, _newHttpResponse );
		}		
	}
	
	private void setResponseAttributes(IContext context,IMendixObject mxObject, Integer statusCode, String content, String reason){
		
		mxObject.setValue(context, HttpResponse.MemberNames.StatusCode.toString(), statusCode);
		mxObject.setValue(context, HttpResponse.MemberNames.Content.toString(), content);
		mxObject.setValue(context, HttpResponse.MemberNames.HttpVersion.toString(), "1.1" );
		mxObject.setValue(context, HttpResponse.MemberNames.ReasonPhrase.toString(), reason );
	}
	
	private void setContentTypeHeader(Integer statusCode) throws CoreException
	{
		if(statusCode == 400 || statusCode == 500 || 
			rest_responses.proxies.constants.Constants.getEnableMendixErrorFormat()==false) {
			this.addHttpHeader("Content-type", "application/problem+json");
		}
		else if (statusCode != 204) {
			this.addHttpHeader("Content-type", "application/json");
		}
		
	}
}
