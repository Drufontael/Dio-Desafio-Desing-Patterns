package Design_Patterns_Dio.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class Util {
    public static void copyNonNullProperties(Object source,Object target){
        BeanUtils.copyProperties(source,target,getNullPropertyName(source));
    }
    public static String[] getNullPropertyName(Object source){
        final BeanWrapper src=new BeanWrapperImpl(source);
        PropertyDescriptor[] pds=src.getPropertyDescriptors();
        Set<String> empty=new HashSet<>();
        for(PropertyDescriptor pd:pds){
            Object srcValue=src.getPropertyValue(pd.getName());
            if(srcValue==null){
                empty.add(pd.getName());
            }
        }
        String[] result=new String[empty.size()];
        return empty.toArray(result);
    }
    public static String valideCEP(String cep){
        while (cep.length()>8){
            cep=cep.replace("-","");
            cep=cep.replace(" ","");
        }
        for (char c:cep.toCharArray()){
            if(!Character.isDigit(c)) throw new RuntimeException("CEP invalido!");
        }
        return cep;
    }
}
