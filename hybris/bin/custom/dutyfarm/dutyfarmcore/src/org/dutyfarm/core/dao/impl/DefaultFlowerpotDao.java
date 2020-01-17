package org.dutyfarm.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import org.dutyfarm.core.dao.FlowerpotDao;

public class DefaultFlowerpotDao extends DefaultGenericDao implements FlowerpotDao {
    public DefaultFlowerpotDao(String typecode) {
        super(typecode);
    }
}
