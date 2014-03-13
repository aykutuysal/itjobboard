package aykutuysal.jewel.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aykutuysal.jewel.dao.JewelryDao;
import aykutuysal.jewel.model.jewelry.Jewelry;
import aykutuysal.jewel.service.JewelryService;

@SuppressWarnings("unused")
@Service("jewelryService")
@Transactional
public class JewelryServiceImpl implements JewelryService {

	private static final Logger logger = Logger.getLogger(JewelryServiceImpl.class);

	@Autowired
	private JewelryDao jewelryDao;

	public Long save(Jewelry jewel) {
		return jewelryDao.save(jewel);
	}

	public Jewelry getById(Long id) {
		return jewelryDao.getById(id);
	}

	public Jewelry loadById(Long id) {
		return jewelryDao.loadById(id);
	}

	public void saveOrUpdate(Jewelry jewel) {
		jewelryDao.saveOrUpdate(jewel);
	}

	public List<Jewelry> loadAll() {
		return jewelryDao.loadAll();
	}

	public void delete(Long id) {
		jewelryDao.deleteById(id);
	}

}
