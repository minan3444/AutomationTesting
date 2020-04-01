package MyTestRunner;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features="C:/Users/TOSHIBA/Desktop/AutomationTesting/Features/FunctionalendToendTesting.feature",
			glue="IBAR",
			//dryRun=true
			//monochrome=true,
			//format= {"pretty","html:test_output","json:json_output//cucumber.json"},
			//strict=false
			
			tags= {"@test"}
			
			)
	
	public class TestRunner	 {	

}
