package com.sette.clipping.main.metamodel.model;

import com.sette.clipping.main.models.GridCluster;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-09T10:19:19.827+0200")
@StaticMetamodel(GridCluster.class)
public class GridCluster_ {
	public static volatile SingularAttribute<GridCluster, String> id;
	public static volatile SingularAttribute<GridCluster, String> clusterId;
	public static volatile SingularAttribute<GridCluster, String> clusterUrl;
	public static volatile SingularAttribute<GridCluster, Date> timestamp;
}
