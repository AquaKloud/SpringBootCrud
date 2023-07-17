package com.example.demo.registration;

import com.sun.xml.bind.v2.TODO;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.stereotype.Service;

import javax.persistence.SequenceGenerator;
import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {
    //    TODO: Regex to validate email
        return true;
    }
}
