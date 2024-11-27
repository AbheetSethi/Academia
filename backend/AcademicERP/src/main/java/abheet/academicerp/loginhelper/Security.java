package abheet.academicerp.loginhelper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Security {
    private final JWThelper jwThelper ;


    public boolean authenticate(String authHeader) {
        String token = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
        }
        if (!jwThelper.validateToken(token)){
            return false;
        }
        return true;
    }
}
