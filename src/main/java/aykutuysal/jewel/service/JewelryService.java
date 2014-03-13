package aykutuysal.jewel.service;

import java.util.List;

import aykutuysal.jewel.model.jewelry.Jewelry;

public interface JewelryService {
	public Long save(Jewelry jewel);
	public Jewelry getById(Long id);
	public Jewelry loadById(Long id);
	public void saveOrUpdate(Jewelry jewel);
	public List<Jewelry> loadAll();
	public void delete(Long id);
}
