package rest_responses;

import java.net.URI;
import java.util.List;

import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

import rest_responses.proxies.constants.Constants;

/**
 * Determines the base URL (scheme, host and path, without query string) that is used to build
 * pagination links.
 *
 * Resolution order:
 * 1. Scheme and host from the headers named by the HeaderName_ForwardedProto / HeaderName_ForwardedHost
 *    constants (default X-Forwarded-Proto / X-Forwarded-Host, API gateway), each
 *    falling back individually to the scheme / authority of the request URI when absent.
 * 2. The path of the request URI.
 * 3. If no HttpRequest is provided, the explicitly supplied fallback base URL.
 */
public final class BaseUrlResolver {

	private static final String DEFAULT_PROTO_HEADER = "X-Forwarded-Proto";
	private static final String DEFAULT_HOST_HEADER = "X-Forwarded-Host";

	private BaseUrlResolver() {
	}

	public static String resolve(IContext context, IMendixObject httpRequest, String fallbackBaseUrl) {
		if (httpRequest == null) {
			return fallbackBaseUrl;
		}

		String uriValue = httpRequest.getValue(context, system.proxies.HttpRequest.MemberNames.Uri.toString());
		if (uriValue == null || uriValue.isBlank()) {
			return fallbackBaseUrl;
		}

		URI uri;
		try {
			uri = URI.create(uriValue.trim());
		} catch (IllegalArgumentException e) {
			return fallbackBaseUrl;
		}

		String protoHeader = headerName(Constants.getHeaderName_ForwardedProto(), DEFAULT_PROTO_HEADER);
		String hostHeader = headerName(Constants.getHeaderName_ForwardedHost(), DEFAULT_HOST_HEADER);
		String proto = null;
		String host = null;
		List<IMendixObject> headers = Core.retrieveByPath(context, httpRequest, system.proxies.HttpHeader.MemberNames.HttpHeaders.toString());
		for (IMendixObject header : headers) {
			String key = header.getValue(context, system.proxies.HttpHeader.MemberNames.Key.toString());
			if (key == null) {
				continue;
			}
			if (protoHeader.equalsIgnoreCase(key)) {
				proto = firstValue(header.getValue(context, system.proxies.HttpHeader.MemberNames.Value.toString()));
			} else if (hostHeader.equalsIgnoreCase(key)) {
				host = firstValue(header.getValue(context, system.proxies.HttpHeader.MemberNames.Value.toString()));
			}
		}

		if (proto == null) {
			proto = uri.getScheme();
		}
		if (host == null) {
			host = uri.getRawAuthority();
		}
		if (proto == null || host == null) {
			return fallbackBaseUrl;
		}

		String path = uri.getRawPath() == null ? "" : uri.getRawPath();
		if (path.endsWith("/") && path.length() > 1) {
			path = path.substring(0, path.length() - 1);
		}
		return proto + "://" + host + path;
	}

	private static String headerName(String configured, String defaultName) {
		return configured == null || configured.isBlank() ? defaultName : configured.trim();
	}

	/** Headers may contain a comma-separated list when passing several proxies; the first is the client-facing one. */
	private static String firstValue(String value) {
		if (value == null) {
			return null;
		}
		String first = value.split(",")[0].trim();
		return first.isEmpty() ? null : first;
	}
}
