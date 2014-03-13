package aykutuysal.itjobboard.service;

import aykutuysal.itjobboard.model.Resume;

public interface ResumeService {
	
	public Long save(Resume resume);
	public void update(Resume resume);
	public Resume getById(Long id);
	
}
