package be.pvgroup.tpetool.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.pvgroup.tpetool.model.Coefficient;
import be.pvgroup.tpetool.repositories.CoefficientRepository;
import be.pvgroup.tpetool.service.coefficients.CoefficientServiceImpl;

@RestController
@RequestMapping("/api/admin/coefficient")
public class CoefficientsController {

	Logger logger = LoggerFactory.getLogger(CoefficientsController.class);

	@Autowired
	private CoefficientRepository coefficientRepository;

	@Autowired
	private CoefficientServiceImpl coefficientService;

	@GetMapping("")
	@CrossOrigin
	public List<Coefficient> getAll() {

		return coefficientRepository.findAll();
	}

	@PostMapping("")
	@CrossOrigin
	public Coefficient createOrder(@RequestBody Coefficient coefficient) {
		coefficientService.updateCoefficient(coefficient);
		coefficientService.loadCoefficients();
		return coefficient;
	}
}
