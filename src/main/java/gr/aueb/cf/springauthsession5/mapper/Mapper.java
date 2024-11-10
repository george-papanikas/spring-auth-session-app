package gr.aueb.cf.springauthsession5.mapper;

import gr.aueb.cf.springauthsession5.dto.RegisterTeacherDTO;
import gr.aueb.cf.springauthsession5.model.Teacher;
import gr.aueb.cf.springauthsession5.model.User;

public class Mapper {

    private Mapper() {}

    public static Teacher extractTeacherFromRegisterTeacherDTO(RegisterTeacherDTO dto) {
        return new Teacher(dto.getFirstname(), dto.getLastname());
    }

    public static User extractUserFromRegisterTeacherDTO(RegisterTeacherDTO dto) {
        return User.NEW_TEACHER(dto.getUsername(), dto.getPassword());
    }
}
