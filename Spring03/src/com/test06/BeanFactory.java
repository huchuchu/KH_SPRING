package com.test06;

public class BeanFactory {
   
   Object getBean(String beanName) {
      
      if(beanName.equals("Samsung")) {
         return new smasungTv();
      }else if(beanName.equals("Ig")) {
         return new IgTV();
      }
         return null;
   }

}