package com.ASI.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "rerun:target/rerun.txt" ,
                "json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue = "com/ASI/step_definitions",
        dryRun = false,
        tags = "",
        publish = true

)
public class CukesRunner {



}
