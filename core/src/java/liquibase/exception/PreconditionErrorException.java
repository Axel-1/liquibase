package liquibase.exception;

import liquibase.DatabaseChangeLog;
import liquibase.preconditions.ErrorPrecondition;
import liquibase.preconditions.Precondition;

import java.util.ArrayList;
import java.util.List;

public class PreconditionErrorException extends Exception {

    private static final long serialVersionUID = 1L;
    private List<ErrorPrecondition> erroredPreconditions;

    public PreconditionErrorException(Exception cause, DatabaseChangeLog changeLog, Precondition precondition) {
        this(new ErrorPrecondition(cause, changeLog, precondition));
    }

    public PreconditionErrorException(ErrorPrecondition errorPrecondition) {
        super("Precondition Error");
        this.erroredPreconditions = new ArrayList<ErrorPrecondition>();
        erroredPreconditions.add(errorPrecondition);
    }

    public PreconditionErrorException(List<ErrorPrecondition> errorPreconditions) {
        super("Precondition Error");
        this.erroredPreconditions = errorPreconditions;
    }

    public List<ErrorPrecondition> getErrorPreconditions() {
        return erroredPreconditions;
    }
}
