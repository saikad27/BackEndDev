package org.sai;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Lazy;

@Lazy
@Component
public class SampleBean {
    SampleBean(){
        System.out.println("SampleBean instance created!");
    }
}
