package com.example.MortgageLoanCalculator.controller;

import com.example.MortgageLoanCalculator.Engine;
import com.example.MortgageLoanCalculator.model.Result;
import com.example.MortgageLoanCalculator.model.UserProfile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST API endpoint for approving a loan application.
 * */

@RestController
@RequestMapping(value = "loan/api")
public class LoanController {

    /*
    * consumes - methods expects the requested body in JSON format,
    * produces - type of data received, JSON as well
    * */
    @PostMapping(value = "/approveLoan", consumes = "application/json",
    produces = "application/json")
    public Result approveLoan (@RequestBody UserProfile userProfile) {
        /*
        * creating engine object,
        * calling engineStart to perform calculations
        * to determine whether the loan should
        * be approved or not and returning result
        * */
        Engine engine = new Engine();
        return engine.engineStart(userProfile);
    }
}
