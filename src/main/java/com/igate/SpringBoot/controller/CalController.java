package com.igate.SpringBoot.controller;

import com.igate.SpringBoot.service.CalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/calculator")
public class CalController {

    @Autowired
    CalService calService;

    @GetMapping("/greet")
    public String sayHello(){

        return "Welcome to this project";
    }
    @GetMapping("/add/{first}/{second}")
    public double addition(@PathVariable("first") double firstnum,
                           @PathVariable("second") double secondnum){
        double res =  calService.add(firstnum,secondnum);
        return res;
    }

    @GetMapping("/add")
    public HttpEntity<?> add(@RequestParam("first") double firstnum,
                      @RequestParam("second") double secondnum){
        if(firstnum == 0 || secondnum == 0){
            return new ResponseEntity<>("INVALID INPUT", HttpStatus.BAD_REQUEST);
        }
        double res = calService.add(firstnum, secondnum);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/sub")
    public HttpEntity<?> subtraction(@RequestParam("first") double firstnum,
                                  @RequestParam("second") double secondnum){
        if(firstnum < secondnum){
            return new ResponseEntity<>("first number is less than second",HttpStatus.BAD_REQUEST);
        }
        double res = calService.sub(firstnum,secondnum);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/Mul/{first}/{second}")
    public HttpEntity<?> multiply(@PathVariable("first") double firstnum,
                                       @PathVariable("second") double secondnum){
        if(firstnum == 0 || secondnum == 0){
            return new ResponseEntity<>("Value is always 0, change number for better value",HttpStatus.OK);
        }
        double res = calService.multiply(firstnum,secondnum);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/divide")
    public HttpEntity<?> div(@RequestParam("first") double first,
                                @RequestParam("second") double second){
        if(second == 0){
            return new ResponseEntity<>("Division by Zero is undefined",HttpStatus.BAD_REQUEST);
        }
        double res = calService.div(first,second);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

}
