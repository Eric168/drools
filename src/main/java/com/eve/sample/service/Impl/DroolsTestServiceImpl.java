package com.eve.sample.service.Impl;

import com.sankuai.meituan.sample.model.Employ;
import com.sankuai.meituan.sample.service.DroolsTest;
import com.sankuai.meituan.sample.service.DroolsTestService;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


/**
 * This is a sample class to launch a rule.
 */
@Service(value="droolsTestService")
public class DroolsTestServiceImpl implements DroolsTestService {
	private static final Logger logger = LoggerFactory
            .getLogger(DroolsTest.class);

	@Override
	public Employ applyCheckByRule(Employ employ) {
		 Employ emp=new Employ();
		 
		 try{
 		   KieServices ks = KieServices.Factory.get();
    	       KieContainer kContainer = ks.getKieClasspathContainer();
        	   KieSession kSession = kContainer.newKieSession("ksession-rules-simple");

        	BeanUtils.copyProperties(employ, emp);

 	       kSession.insert(emp);
 	       kSession.startProcess("21");
 	       kSession.fireAllRules();
 	       logger.info("fireallrules total:"+emp.getTotalSalary());
 	       kSession.dispose();  
 	       logger.info("fireallrules total2:"+emp.getTotalSalary());	       
 	   }catch(Exception t){
 		   t.printStackTrace();
 		   return null;
 	   }
		return emp;
	}
}
