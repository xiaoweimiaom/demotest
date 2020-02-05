package com.example.demotest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

public class Test2 {
    //private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);

/**

 * 失效时间： 1 天 =24*3600*1000 ms

 */

    public static final long EXPIRATION_TIME = 1 * 24 * 3600 * 1000;

/**

 * 私钥

 */

    public static final String SECRET = "http://www.bj9420.com/jwt";

/**

 * token 前缀

 */

    public static final String TOKEN_PREFIX = "Bearer ";

/**

 * Authorization header

 */

    public static final String HEADER_STRING = "Authorization";

/**

 * 保存的数据字段名称

 */

    public static final String USER_NAME = "userId";

    public static String generateToken(String userId) {

        HashMap<String, Object> map = new HashMap<>();

//可以将自定义相关的数据放入Map中

        map.put(USER_NAME, userId);

        String jwt = Jwts.builder()

                .setClaims(map)

                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))

                .signWith(SignatureAlgorithm.HS512, SECRET)

                .compact();

//jwt前面一般都会加Bearer

        return TOKEN_PREFIX + jwt;

    }

    public static HttpServletRequest validateTokenAndAddUserIdToHeader(HttpServletRequest request) {

        String token = request.getHeader(HEADER_STRING);

        //log.info("请求token:" + token);

        if (token != null) {

// 解析令牌token.

            try {

                Map<String, Object> body = Jwts.parser()

                        .setSigningKey(SECRET)

                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))

                        .getBody();

//遍历自定的相关数据，可以删除

                for (Map.Entry<String, Object> entry : body.entrySet()) {

                   // log.info("****JWT paser Key = " + entry.getKey() + ", Value = " + entry.getValue());

                }

                return new CustomHttpServletRequest(request, body);

            } catch (Exception e) {

                //log.info(e.getMessage());

                throw new TokenValidationException(e.getMessage());

            }

        } else {

            throw new TokenValidationException("The token is invalid!");

        }

    }

    public static class CustomHttpServletRequest extends HttpServletRequestWrapper {

        private Map<String, String> claims;

        public CustomHttpServletRequest(HttpServletRequest request, Map<String, ?> claims) {

            super(request);

            this.claims = new HashMap<>();

            claims.forEach((k, v) -> this.claims.put(k, String.valueOf(v)));

        }

        @Override

        public Enumeration<String> getHeaders(String name) {

            if (claims != null && claims.containsKey(name)) {

                return Collections.enumeration(Arrays.asList(claims.get(name)));

            }

            return super.getHeaders(name);

        }

        public Map<String, String> getClaims() {

            return claims;

        }

    }

    static class TokenValidationException extends RuntimeException {

        public TokenValidationException(String msg) {

            super(msg);

        }

    }
}
