package ExceptionTest;

import javax.management.RuntimeMBeanException;

public class NameBoundsException extends RuntimeException {

    public NameBoundsException() {
    }

    public NameBoundsException(String message) {
        super(message);
    }

    public String toString() {
        return "NameBoundsException{}";
    }
}
