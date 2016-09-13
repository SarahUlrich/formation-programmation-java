package fr.lteconsulting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/customers" )
public class CustomerController
{
	@Autowired
	CustomerRepository customerRepository;

	@RequestMapping( method = RequestMethod.GET )
	public Collection<Customer> getAllCustomers()
	{
		List<Customer> all = new ArrayList<>();

		for( Customer c : customerRepository.findAll() )
			all.add( c );

		return all;
	}

	@RequestMapping( path = "/{id}", method = RequestMethod.GET )
	public Customer getCustomer( @PathVariable( "id" ) long id )
	{
		return customerRepository.findOne( id );
	}

	@PostMapping( consumes = "application/json" )
	public ResponseEntity<Customer> create( @RequestBody Customer customer )
	{
		customer = customerRepository.save( customer );

		return new ResponseEntity<Customer>( customer, HttpStatus.CREATED );
	}

	@PutMapping( consumes = "application/json" )
	public Customer update( @RequestBody Customer customer )
	{
		return customerRepository.save( customer );
	}

	@DeleteMapping( path = "/{id}" )
	public void delete( @PathVariable( "id" ) long id )
	{
		customerRepository.delete( id );
	}
}
