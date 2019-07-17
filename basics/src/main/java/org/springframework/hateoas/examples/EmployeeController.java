
package org.springframework.hateoas.examples;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
class EmployeeController {

	private final EmployeeRepository repository;
	private final EmployeeRepresentationModelAssembler assembler;

	EmployeeController(EmployeeRepository repository, EmployeeRepresentationModelAssembler assembler) {

		this.repository = repository;
		this.assembler = assembler;
	}

	
	@GetMapping("/employees")
	public ResponseEntity<CollectionModel<EntityModel<Employee>>> findAll() {

		return ResponseEntity.ok( //
				this.assembler.toCollectionModel(this.repository.findAll()));

	}

	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EntityModel<Employee>> findOne(@PathVariable long id) {

		return this.repository.findById(id) //
				.map(this.assembler::toModel) //
				.map(ResponseEntity::ok) //
				.orElse(ResponseEntity.notFound().build());
	}

}
