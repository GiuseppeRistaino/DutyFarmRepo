/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package org.dutyfarm.storefront.web.wrappers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringUtils;


/**
 * RemoveEncodingHttpServletRequestWrapper removes encoding attributes such as languages and site name from the context
 * path of HttpServletRequest
 */
public class RemoveEncodingHttpServletRequestWrapper extends HttpServletRequestWrapper
{
	private final String pattern;

	public RemoveEncodingHttpServletRequestWrapper(final HttpServletRequest request, final String pattern)
	{
		super(request);
		this.pattern = pattern;
	}

	@Override
	public String getContextPath()
	{
		return StringUtils.remove(super.getContextPath(), pattern);
	}
}
