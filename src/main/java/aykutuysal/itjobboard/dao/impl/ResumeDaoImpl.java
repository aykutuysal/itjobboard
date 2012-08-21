package aykutuysal.itjobboard.dao.impl;

import org.springframework.stereotype.Repository;

import aykutuysal.itjobboard.dao.ResumeDao;
import aykutuysal.itjobboard.model.Resume;

@Repository
public class ResumeDaoImpl extends GenericDaoImpl<Resume, Long> implements ResumeDao {

}
