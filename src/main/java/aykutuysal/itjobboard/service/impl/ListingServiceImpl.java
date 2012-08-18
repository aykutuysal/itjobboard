package aykutuysal.itjobboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aykutuysal.itjobboard.dao.ListingDao;
import aykutuysal.itjobboard.model.Listing;
import aykutuysal.itjobboard.service.ListingService;

@Service("listingService")
@Transactional
public class ListingServiceImpl implements ListingService {

	@Autowired
	private ListingDao listingDao;

	public Long save(Listing listing) {
		return listingDao.save(listing);
	}

	public void update(Listing listing) {
		listingDao.update(listing);
	}

	public Listing getById(Long id) {
		return listingDao.getById(id);
	}
}
