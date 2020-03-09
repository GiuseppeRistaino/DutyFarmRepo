/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package org.dutyfarm.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.dutyfarm.constants.DutyfarmsmarteditConstants;
import org.apache.log4j.Logger;

@SuppressWarnings("PMD")
public class DutyfarmsmarteditManager extends GeneratedDutyfarmsmarteditManager
{
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger( DutyfarmsmarteditManager.class.getName() );
	
	public static final DutyfarmsmarteditManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (DutyfarmsmarteditManager) em.getExtension(DutyfarmsmarteditConstants.EXTENSIONNAME);
	}
	
}
