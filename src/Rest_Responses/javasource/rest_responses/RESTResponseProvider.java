package rest_responses;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

import system.proxies.HttpHeader;
import system.proxies.HttpResponse;

public class RESTResponseProvider {

	private IMendixObject _newHttpResponse;
	private IContext _context;
	
		
	public RESTResponseProvider(IContext context,IMendixObject httpResponse, Integer statusCode, String content, String reason ){
	
		_context = context;
		if(httpResponse ==null) {
			_newHttpResponse =  Core.instantiate(context, HttpResponse.getType());
		}
		else {
			_newHttpResponse = httpResponse;
		}
		
		setResponseAttributes(context, _newHttpResponse, statusCode, content, reason);
	}
	
	public IMendixObject getResponse() {
		return _newHttpResponse;
	}
	
	public void addHttpHeader(String key, String value) throws CoreException{
		
		IMendixObject mxObject = Core.instantiate(_context, HttpHeader.getType());
		mxObject.setValue(_context, HttpHeader.MemberNames.Key.toString(), key);
		mxObject.setValue(_context, HttpHeader.MemberNames.Value.toString(), value);
		
		HttpHeader newHttpHeader = HttpHeader.load(_context, mxObject.getId());
		newHttpHeader.setHttpHeaders(_context, HttpResponse.load(_context, _newHttpResponse.getId()));
		
	}
	
	
	private void setResponseAttributes(IContext context,IMendixObject mxObject, Integer statusCode, String content, String reason){
		
		mxObject.setValue(context, HttpResponse.MemberNames.StatusCode.toString(), statusCode);
		mxObject.setValue(context, HttpResponse.MemberNames.Content.toString(), content);
		mxObject.setValue(context, HttpResponse.MemberNames.HttpVersion.toString(), "1.1" );
		mxObject.setValue(context, HttpResponse.MemberNames.ReasonPhrase.toString(), reason );
		
	}
	
}
