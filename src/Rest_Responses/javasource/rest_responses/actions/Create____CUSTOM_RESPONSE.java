// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package rest_responses.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import rest_responses.RESTResponseProvider;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * This action provides the option to set any HTTP status that is not covered by the other actions.
 */
public class Create____CUSTOM_RESPONSE extends CustomJavaAction<IMendixObject>
{
	private IMendixObject __HTTPResponse;
	private system.proxies.HttpResponse HTTPResponse;
	private java.lang.Long Code;
	private java.lang.String Content;
	private java.lang.String ContentType;

	public Create____CUSTOM_RESPONSE(IContext context, IMendixObject HTTPResponse, java.lang.Long Code, java.lang.String Content, java.lang.String ContentType)
	{
		super(context);
		this.__HTTPResponse = HTTPResponse;
		this.Code = Code;
		this.Content = Content;
		this.ContentType = ContentType;
	}

	@java.lang.Override
	public IMendixObject executeAction() throws Exception
	{
		this.HTTPResponse = this.__HTTPResponse == null ? null : system.proxies.HttpResponse.initialize(getContext(), __HTTPResponse);

		// BEGIN USER CODE
		
		if(this.Code>=100 && this.Code <=599) {

			RESTResponseProvider rp = new RESTResponseProvider(this.context(), __HTTPResponse, this.Code.intValue(), this.Content,  getReason(this.Code.intValue()));
			
			if(this.ContentType.isEmpty()) {
				this.ContentType = "application/json";
			}
			
			rp.addHttpHeader("Content-type", this.ContentType);
			return rp.getResponse();
		}
		else {
			throw new IllegalArgumentException("Argument value '"+this.Code.toString()+"' is invalid for Status code.");
		}
			
		
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "Create____CUSTOM_RESPONSE";
	}

	// BEGIN EXTRA CODE
	
	private String getReason(int Status) {
		String reason = "Unknown";
		
		switch (Status) {
			case 100:
				reason = "Continue";
				break;
			case 101:
				reason = "Switching Protocols";
				break;
			case 102:
				reason = "Processing";
				break;
			case 103:
				reason = "Early Hints";
				break;
				
			case 200:
				reason = "OK";
				break;
			case 201:
				reason = "Created";
				break;
			case 202:
				reason = "Accepted";
				break;
			case 203:
				reason = "Non-Authoritative Information";
				break;
			case 204:
				reason = "No Content";
				break;
			case 205:
				reason = "Reset Content";
				break;
			case 206:
				reason = "Partial Content";
				break;
			case 207:
				reason = "Multi-Status";
				break;
			case 208:
				reason = "Already Reported";
				break;
			case 226:
				reason = "IM Used";
				break;
				
			case 300:
				reason = "Multiple Choices";
				break;
			case 301:
				reason = "Moved Permanently";
				break;
			case 302:
				reason = "Found";
				break;
			case 303:
				reason = "See Other";
				break;
			case 304:
				reason = "Not Modified";
				break;
			case 305:
				reason = "Use Proxy";
				break;
			case 307:
				reason = "Temporary Redirect";
				break;	
			case 308:
				reason = "Permanent Redirect";
				break;
				
			case 400:
				reason = "Bad Request";
				break;
			case 401:
				reason = "Unauthorized";
				break;
			case 402:
				reason = "Payment Required";
				break;
			case 403:
				reason = "Forbidden";
				break;
			case 404:
				reason = "Not Found";
				break;
			case 405:
				reason = "Method Not Allowed";
				break;
			case 406:
				reason = "Not Acceptable";
				break;
			case 407:
				reason = "Proxy Authentication Required";
				break;
			case 408:
				reason = "Request Timeout";
				break;
			case 409:
				reason = "Conflict";
				break;
			case 410:
				reason = "Gone";
				break;
			case 411:
				reason = "Length Required";
				break;
			case 412:
				reason = "Precondition Failed";
				break;
			case 413:
				reason = "Payload Too Large";
				break;
			case 414:
				reason = "URI Too Long";
				break;
			case 415:
				reason = "Unsupported Media Type";
				break;
			case 416:
				reason = "Range Not Satisfiable";
				break;
			case 417:
				reason = "Length Required";
				break;
			case 418:
				reason = "I'm a teapot";
				break;
			case 421:
				reason = "Misdirected Request";
				break;
			case 425:
				reason = "Too Early";
				break;
			case 426:
				reason = "Upgrade Required";
				break;
			case 428:
				reason = "Precondition Required";
				break;
			case 429:
				reason = "Too Many Requests";
				break;
			case 451:
				reason = "Unavailable For Legal Reasons";
				break;
				
			case 500:
				reason = "Internal Server Error";
				break;
			case 501:
				reason = "Not Implemented";
				break;
			case 502:
				reason = "Bad Gateway";
				break;
			case 503:
				reason = "Service Unavailable";
				break;
			case 504:
				reason = "Gateway Timeout";
				break;

		}
		return reason;
	}
	
	// END EXTRA CODE
}
