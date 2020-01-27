package MyTestRunner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features="C:/Users/TOSHIBA/Desktop/Cucumber.Trendyol/AutomationTesting/Features/trendyol.feature",
			glue="MySteps"
			//dryRun=true
			//monochrome=true,
			//format= {"pretty","html:test_output","json:json_output//cucumber.json"},
			//strict=false
			
			//tags= {""}
			
			)
	
	public class TestRunner	 {	

}
