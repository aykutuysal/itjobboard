package aykutuysal.jewel.dao.impl;

import org.springframework.stereotype.Repository;

import aykutuysal.jewel.dao.JewelryDao;
import aykutuysal.jewel.model.jewelry.Jewelry;



@Repository
public class JewelryDaoImpl extends GenericDaoImpl<Jewelry, Long> implements JewelryDao {

}
