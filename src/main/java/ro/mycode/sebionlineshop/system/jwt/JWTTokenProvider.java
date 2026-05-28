//package ro.mycode.sebionlineshop.system.jwt;
//
//import io.jsonwebtoken.Jwts;
//import org.hibernate.annotations.Checks;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//import static io.jsonwebtoken.Claims.AUDIENCE;
//import static sun.security.x509.X509CertInfo.ISSUER;
//
//@Component
//public class JWTTokenProvider {
//
//    @Value("${application.jwt.secretKey}")
//    private String secretKey;
//
//    @Value("${application.jwt.tokenExpirationAfterDays:7}")
//    private long tokenExpirationAfterDays;
//
//    public String generateToken(UserDetails user){
//        String[] claims = getClaimsFromUser(user);
//        return Jwts.builder()
//                .issuer(ISSUER)
//                .audience().add(AUDIENCE).and()
//                .issuedAt(new Date())
//                .subject(user.getUsername())
//                .claim(AUTHORITIES, claims)
//                .expiration(new Date(System.currentTimeMillis() + tokenExpirationAfterDays * 24 * 60 * 60 * 1000))
//                .signWith(getSigningKey(),Jwts.SIG.HS512)
//                .compact();
//    }
//}
