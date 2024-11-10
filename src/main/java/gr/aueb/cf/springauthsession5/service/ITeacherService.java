package gr.aueb.cf.springauthsession5.service;

import gr.aueb.cf.springauthsession5.dto.RegisterTeacherDTO;
import gr.aueb.cf.springauthsession5.model.Teacher;
import gr.aueb.cf.springauthsession5.service.exceptions.TeacherAlreadyExistsException;

import java.util.List;

public interface ITeacherService {
    Teacher registerTeacher(RegisterTeacherDTO dto) throws TeacherAlreadyExistsException;
    List<Teacher> findAllTeachers() throws Exception;
}
