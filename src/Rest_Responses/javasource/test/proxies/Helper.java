// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package test.proxies;

public class Helper
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject helperMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "Test.Helper";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Status("Status"),
		Title("Title"),
		Detail("Detail"),
		CustomStatus("CustomStatus"),
		ContentType("ContentType"),
		Helper_HttpResponse("Test.Helper_HttpResponse");

		private java.lang.String metaName;

		MemberNames(java.lang.String s)
		{
			metaName = s;
		}

		@java.lang.Override
		public java.lang.String toString()
		{
			return metaName;
		}
	}

	public Helper(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "Test.Helper"));
	}

	protected Helper(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject helperMendixObject)
	{
		if (helperMendixObject == null)
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		if (!com.mendix.core.Core.isSubClassOf("Test.Helper", helperMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a Test.Helper");

		this.helperMendixObject = helperMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'Helper.load(IContext, IMendixIdentifier)' instead.
	 */
	@java.lang.Deprecated
	public static test.proxies.Helper initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return test.proxies.Helper.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 */
	public static test.proxies.Helper initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new test.proxies.Helper(context, mendixObject);
	}

	public static test.proxies.Helper load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return test.proxies.Helper.initialize(context, mendixObject);
	}

	/**
	 * Commit the changes made on this proxy object.
	 */
	public final void commit() throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Commit the changes made on this proxy object using the specified context.
	 */
	public final void commit(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Delete the object.
	 */
	public final void delete()
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}

	/**
	 * Delete the object using the specified context.
	 */
	public final void delete(com.mendix.systemwideinterfaces.core.IContext context)
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}
	/**
	 * Set value of Status
	 * @param status
	 */
	public final test.proxies.Status getStatus()
	{
		return getStatus(getContext());
	}

	/**
	 * @param context
	 * @return value of Status
	 */
	public final test.proxies.Status getStatus(com.mendix.systemwideinterfaces.core.IContext context)
	{
		Object obj = getMendixObject().getValue(context, MemberNames.Status.toString());
		if (obj == null)
			return null;

		return test.proxies.Status.valueOf((java.lang.String) obj);
	}

	/**
	 * Set value of Status
	 * @param status
	 */
	public final void setStatus(test.proxies.Status status)
	{
		setStatus(getContext(), status);
	}

	/**
	 * Set value of Status
	 * @param context
	 * @param status
	 */
	public final void setStatus(com.mendix.systemwideinterfaces.core.IContext context, test.proxies.Status status)
	{
		if (status != null)
			getMendixObject().setValue(context, MemberNames.Status.toString(), status.toString());
		else
			getMendixObject().setValue(context, MemberNames.Status.toString(), null);
	}

	/**
	 * @return value of Title
	 */
	public final java.lang.String getTitle()
	{
		return getTitle(getContext());
	}

	/**
	 * @param context
	 * @return value of Title
	 */
	public final java.lang.String getTitle(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Title.toString());
	}

	/**
	 * Set value of Title
	 * @param title
	 */
	public final void setTitle(java.lang.String title)
	{
		setTitle(getContext(), title);
	}

	/**
	 * Set value of Title
	 * @param context
	 * @param title
	 */
	public final void setTitle(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String title)
	{
		getMendixObject().setValue(context, MemberNames.Title.toString(), title);
	}

	/**
	 * @return value of Detail
	 */
	public final java.lang.String getDetail()
	{
		return getDetail(getContext());
	}

	/**
	 * @param context
	 * @return value of Detail
	 */
	public final java.lang.String getDetail(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Detail.toString());
	}

	/**
	 * Set value of Detail
	 * @param detail
	 */
	public final void setDetail(java.lang.String detail)
	{
		setDetail(getContext(), detail);
	}

	/**
	 * Set value of Detail
	 * @param context
	 * @param detail
	 */
	public final void setDetail(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String detail)
	{
		getMendixObject().setValue(context, MemberNames.Detail.toString(), detail);
	}

	/**
	 * @return value of CustomStatus
	 */
	public final java.lang.Integer getCustomStatus()
	{
		return getCustomStatus(getContext());
	}

	/**
	 * @param context
	 * @return value of CustomStatus
	 */
	public final java.lang.Integer getCustomStatus(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Integer) getMendixObject().getValue(context, MemberNames.CustomStatus.toString());
	}

	/**
	 * Set value of CustomStatus
	 * @param customstatus
	 */
	public final void setCustomStatus(java.lang.Integer customstatus)
	{
		setCustomStatus(getContext(), customstatus);
	}

	/**
	 * Set value of CustomStatus
	 * @param context
	 * @param customstatus
	 */
	public final void setCustomStatus(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Integer customstatus)
	{
		getMendixObject().setValue(context, MemberNames.CustomStatus.toString(), customstatus);
	}

	/**
	 * @return value of ContentType
	 */
	public final java.lang.String getContentType()
	{
		return getContentType(getContext());
	}

	/**
	 * @param context
	 * @return value of ContentType
	 */
	public final java.lang.String getContentType(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.ContentType.toString());
	}

	/**
	 * Set value of ContentType
	 * @param contenttype
	 */
	public final void setContentType(java.lang.String contenttype)
	{
		setContentType(getContext(), contenttype);
	}

	/**
	 * Set value of ContentType
	 * @param context
	 * @param contenttype
	 */
	public final void setContentType(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String contenttype)
	{
		getMendixObject().setValue(context, MemberNames.ContentType.toString(), contenttype);
	}

	/**
	 * @return value of Helper_HttpResponse
	 */
	public final system.proxies.HttpResponse getHelper_HttpResponse() throws com.mendix.core.CoreException
	{
		return getHelper_HttpResponse(getContext());
	}

	/**
	 * @param context
	 * @return value of Helper_HttpResponse
	 */
	public final system.proxies.HttpResponse getHelper_HttpResponse(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		system.proxies.HttpResponse result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.Helper_HttpResponse.toString());
		if (identifier != null)
			result = system.proxies.HttpResponse.load(context, identifier);
		return result;
	}

	/**
	 * Set value of Helper_HttpResponse
	 * @param helper_httpresponse
	 */
	public final void setHelper_HttpResponse(system.proxies.HttpResponse helper_httpresponse)
	{
		setHelper_HttpResponse(getContext(), helper_httpresponse);
	}

	/**
	 * Set value of Helper_HttpResponse
	 * @param context
	 * @param helper_httpresponse
	 */
	public final void setHelper_HttpResponse(com.mendix.systemwideinterfaces.core.IContext context, system.proxies.HttpResponse helper_httpresponse)
	{
		if (helper_httpresponse == null)
			getMendixObject().setValue(context, MemberNames.Helper_HttpResponse.toString(), null);
		else
			getMendixObject().setValue(context, MemberNames.Helper_HttpResponse.toString(), helper_httpresponse.getMendixObject().getId());
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return helperMendixObject;
	}

	/**
	 * @return the IContext instance of this proxy, or null if no IContext instance was specified at initialization.
	 */
	public final com.mendix.systemwideinterfaces.core.IContext getContext()
	{
		return context;
	}

	@java.lang.Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final test.proxies.Helper that = (test.proxies.Helper) obj;
			return getMendixObject().equals(that.getMendixObject());
		}
		return false;
	}

	@java.lang.Override
	public int hashCode()
	{
		return getMendixObject().hashCode();
	}

	/**
	 * @return String name of this class
	 */
	public static java.lang.String getType()
	{
		return "Test.Helper";
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@java.lang.Deprecated
	public java.lang.String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}
