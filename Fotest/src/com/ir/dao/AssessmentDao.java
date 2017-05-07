package com.ir.dao;

import java.util.List;

import com.ir.bean.common.IntStringBean;
import com.ir.form.AssessmentAnswerCriteria;
import com.ir.model.AssessmentQuestion_old;
import com.ir.model.AssessmentQuestions;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.trainee.TraineeAssessmentEvaluation;

public interface AssessmentDao {
	
	public List<AssessmentQuestions> getAssessmentQuestions( int moduleId);
	public String saveAssessment(List<AssessmentAnswerCriteria> answerCriterias);
	public List<CourseType> courseTypes();
	public List<CourseName> courseNames();
	public List<IntStringBean> getTrainingPartners(int assessorId);
	public List<AssessmentQuestions> getAssessmentAnswers(int modulecode, List<Integer> questions);
	public int saveTraineeAssessmentEvaluation(TraineeAssessmentEvaluation traineeAssessmentEvaluation);
	public int getElegibilityForAssessment(int moduleid);
	public List<CourseType> courseTypeList();
	public List searchAssessorCalendar(String data);
	public List viewAssessmentAgencyCalendar(String data);
	public List searchAssessorTraineesForResults(String data);
	public String updateTraineeAssessmentResult(String data);
	public String updateTraineeAssessmentResultOnline(Integer userID,String result,String comment);
	
	public List searchDataAssessmentAgency(String data);
	
	public List editMAA(String data);
	
	public String updateMAA(String data);
}
