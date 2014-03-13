package aykutuysal.itjobboard.service;

import aykutuysal.itjobboard.model.Listing;

public interface ListingService {
	
	public Long save(Listing listing);
	public void update(Listing user);
	public Listing getById(Long id);
	
}
