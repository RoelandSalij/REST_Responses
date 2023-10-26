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
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import rest_responses.RESTResponseProvider;

/**
 * The request has been accepted for further processing, which will be completed sometime later.
 */
public class Create_202_ACCEPTED extends CustomJavaAction<IMendixObject>
{
	private java.lang.String Content;
	private IMendixObject __HTTPResponse;
	private system.proxies.HttpResponse HTTPResponse;

	public Create_202_ACCEPTED(IContext context, java.lang.String Content, IMendixObject HTTPResponse)
	{
		super(context);
		this.Content = Content;
		this.__HTTPResponse = HTTPResponse;
	}

	@java.lang.Override
	public IMendixObject executeAction() throws Exception
	{
		this.HTTPResponse = this.__HTTPResponse == null ? null : system.proxies.HttpResponse.initialize(getContext(), __HTTPResponse);

		// BEGIN USER CODE
		RESTResponseProvider rp = new RESTResponseProvider(this.context(),__HTTPResponse, 202, this.Content, "Accepted");
		return rp.getResponse();
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "Create_202_ACCEPTED";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
