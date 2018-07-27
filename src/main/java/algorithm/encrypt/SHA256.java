package algorithm.encrypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Author Ares
 * @Date 2018/7/21 16:18
 * @Description:
 * @Version JDK 1.8
 */
public class SHA256
{
    public static void main(String[] args) {
        try {
            String secret = "Secret";
            String message = "Message";

            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);

            String hash = Base64.encodeBase64String(sha256_HMAC.doFinal(message.getBytes()));
            System.out.println(hash);
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }
}
