package org.dutyfarm.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.FertilizerVariantDao;
import org.dutyfarm.core.model.FertilizerVariantProductModel;

import java.util.List;

public class DefaultFertilizerVariantDao extends DefaultGenericDao<FertilizerVariantProductModel> implements FertilizerVariantDao {

    private static final Logger LOG = Logger.getLogger(DefaultFertilizerVariantDao.class);

    public DefaultFertilizerVariantDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<FertilizerVariantProductModel> findFertilizersByState(String state) {
        LOG.info("Invoke method findFertilizersByState in DefaultFertilizerVariantDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {f.pk} FROM {");
        queryStr.append("FertilizerVariantProduct AS f ");
        queryStr.append("JOIN StateEnum AS st ON {st.PK} = {f.state}");
        queryStr.append("} WHERE {st.code} = ?state");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        fsq.addQueryParameter("state", state);
        final SearchResult<FertilizerVariantProductModel> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }
}
