package jpb.photoproject.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelper {

    public static <T> ResponseEntity<T> ok() {
        return new ResponseEntity<T>(HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> ok(final T body) {
        return new ResponseEntity<T>(body, HttpStatus.OK);
    }
}
