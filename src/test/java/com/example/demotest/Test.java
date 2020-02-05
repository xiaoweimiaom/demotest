package com.example.demotest;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Random;
import java.util.UUID;

public class Test {
    private static final String SECRET_CODE = "xiaoweimiao";

    public static void main(String[] args) {
//        Random random = new Random();
//        String s = UUID.randomUUID().toString();
//        System.out.println(s.replaceAll("-",""));
//        System.out.println(s);
//        String s1 = s.substring(0, 5);
//        System.out.println(s1);
//        String s2 = String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000));
//        System.out.println(s2);

        byte[] apiKeySecretBytes  = DatatypeConverter.parseBase64Binary(SECRET_CODE);
        for ( byte b :apiKeySecretBytes){
            System.out.print(b+" ");
        }
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        String str=signatureAlgorithm.getJcaName();
        SecretKeySpec secretKeySpec = new SecretKeySpec(apiKeySecretBytes, str);
        System.out.println(str);

    }
}
