package kr.or.swithme.recrustudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.swithme.recrustudy.dao.PostDao;
import kr.or.swithme.recrustudy.dao.StudyGroupDao;

@Service
public class StudyGroupServiceImpl implements StudyGroupService{
	@Autowired
	StudyGroupDao studyGroupDao;
	
	@Override
	@Transactional
	public void startStudy(Integer document) {
		studyGroupDao.start(document);
	}
}
