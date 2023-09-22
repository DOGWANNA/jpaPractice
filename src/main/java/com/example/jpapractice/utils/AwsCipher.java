//package com.example.jpapractice.utils;
//
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.kms.AWSKMS;
//import com.amazonaws.services.kms.AWSKMSClientBuilder;
//import com.amazonaws.services.kms.model.DecryptRequest;
//import com.amazonaws.services.kms.model.EncryptRequest;
//import com.amazonaws.services.kms.model.EncryptResult;
//import com.amazonaws.services.kms.model.EncryptionAlgorithmSpec;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.codec.binary.Base64;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.nio.ByteBuffer;
//import java.nio.charset.StandardCharsets;
//
//@Slf4j
//@Component
//public class AwsCipher {
//
//    @Value("${aws.kms.keyId}")
//    private String KeyId;
//
//    public String encrypt(String plainText) {
//        try {
//            AWSKMS kmsClient = AWSKMSClientBuilder.standard()
//                    .withRegion(Regions.AP_NORTHEAST_2)
//                    .build();
//
//            EncryptRequest request = new EncryptRequest();
//            request.withKeyId(KeyId);
//            request.withPlaintext(ByteBuffer.wrap(plainText.getBytes(StandardCharsets.UTF_8)));
//            request.withEncryptionAlgorithm(EncryptionAlgorithmSpec.RSAES_OAEP_SHA_256);
//
//            EncryptResult result = kmsClient.encrypt(request);
//            ByteBuffer ciphertextBlob = result.getCiphertextBlob();
//
//            return new String(Base64.encodeBase64(ciphertextBlob.array()));
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            return null;
//        }
//    }
//
//    public String decrypt(String encryptedText) {
//        try {
//            AWSKMS kmsClient = AWSKMSClientBuilder.standard()
//                    .withRegion(Regions.AP_NORTHEAST_2)
//                    .build();
//
//            DecryptRequest request = new DecryptRequest();
//            request.withCiphertextBlob(ByteBuffer.wrap(Base64.decodeBase64(encryptedText)));
//            request.withKeyId(KeyId);
//            request.withEncryptionAlgorithm(EncryptionAlgorithmSpec.RSAES_OAEP_SHA_256);
//            ByteBuffer plainText = kmsClient.decrypt(request).getPlaintext();
//
//            return new String(plainText.array());
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            return null;
//        }
//    }
//}
