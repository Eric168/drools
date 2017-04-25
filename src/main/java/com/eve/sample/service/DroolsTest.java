package com.eve.sample.service;

import com.sankuai.meituan.sample.model.Employ;
import com.sankuai.meituan.sample.model.Worker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {
	@Autowired
	private static DroolsTestService droolsTestService;

	private static final Logger logger = LoggerFactory
            .getLogger(DroolsTest.class);
    public static final void main(String[] args) {
        try {
        	FileSystemXmlApplicationContext ctx =  new FileSystemXmlApplicationContext("//Users/wangfeng/work/project/saas.demo/saas.demo-drools/src/main/resources/spring/spring-ruleResources.xml");

        	droolsTestService=(DroolsTestService) ctx.getBean("droolsTestService");
        	Employ emp=new Employ();
        	
        	Date startdate=new Date();
        	logger.info("startdate:"+startdate);
        	emp.setEducationInfo("master");
  	        emp.setResume("tech");
  	        emp.setBonus("good");
  	        emp.setAwardPunish("award");
  	        List<Worker> workerList=new ArrayList<Worker>();
  	        Worker woker1=new Worker();
  	        woker1.setJob("gongren");
  	        woker1.setSex("nan");
  	        
  	        Worker woker2=new Worker();
  	        woker2.setJob("xuesheng");
	        woker2.setSex("nv");
	        
	        Worker woker3=new Worker();
  	        woker3.setJob("gongren");
	        woker3.setSex("nv");
	        
	        workerList.add(woker1);
	        workerList.add(woker2);
	        workerList.add(woker3);
	        
  	        emp.setWorkerList(workerList);
			emp.getBonus();
  	        
  	        Employ emp2=droolsTestService.applyCheckByRule(emp);

        } catch (Throwable t) {
            t.printStackTrace();
        }

  }  
}
