import org.apache.commons.lang3.RandomStringUtils;

public class Randomizer {

    public String generateEmail(){
        String randomEmail = "autotest" + RandomStringUtils.random(6, false, true) + "@mailinator.com";
        System.out.println("email  "+ randomEmail);
        return randomEmail;
    }

    public String generatePass(){
        String randomPass = RandomStringUtils.random(8, true, true);
        System.out.println("pass  "+ randomPass);
        return randomPass;
    }
}
