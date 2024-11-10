package gr.aueb.cf.springauthsession5.service.exceptions;

import java.io.Serial;

public class TeacherAlreadyExistsException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public TeacherAlreadyExistsException(String username) {
        super("Teacher with username " + username + " already exists");
    }
}
