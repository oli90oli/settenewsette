package com.sette.clipping.main.metamodel.model;

import com.sette.clipping.main.model.Sales;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-30T14:03:28.787+0100")
@StaticMetamodel(Sales.class)
public class Sales_ {
	public static volatile SingularAttribute<Sales, String> id;
	public static volatile SingularAttribute<Sales, Date> datumNaProdazba;
	public static volatile SingularAttribute<Sales, Date> datumNaObjava;
	public static volatile SingularAttribute<Sales, String> vidNaProdazba;
	public static volatile SingularAttribute<Sales, String> doveritel;
	public static volatile SingularAttribute<Sales, String> dolznik;
	public static volatile SingularAttribute<Sales, String> mestoNaProdazba;
	public static volatile SingularAttribute<Sales, String> text;
	public static volatile SingularAttribute<Sales, String> image;
}
