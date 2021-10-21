package mtscarneiro.vlues.service.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Long id) {
        super("ID " + id + " doesn't exists!");
    }
}
