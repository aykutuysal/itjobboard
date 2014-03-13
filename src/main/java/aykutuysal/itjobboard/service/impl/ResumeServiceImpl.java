package aykutuysal.itjobboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aykutuysal.itjobboard.dao.ResumeDao;
import aykutuysal.itjobboard.model.Listing;
import aykutuysal.itjobboard.model.Resume;
import aykutuysal.itjobboard.service.ResumeService;

@Service("resumeService")
@Transactional
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeDao resumeDao;

	@Override
	public Long save(Resume resume) {
		return resumeDao.save(resume);
	}

	@Override
	public void update(Resume resume) {
		resumeDao.update(resume);
	}

	@Override
	public Resume getById(Long id) {
		return resumeDao.getById(id);
	}

}
