package com.ncu.MovieApp.jpadata;

import com.ncu.MovieApp.jpadata.CustomerProfile;
import com.ncu.MovieApp.jpadata.CustomerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/customer") public class CustomerProfileController {

    @Autowired
    private CustomerProfileRepository customerRepo;

    @PostMapping
    public CustomerProfile addCustomer(@RequestBody CustomerProfile customerProfile) {
        return customerRepo.save(customerProfile);
    }

    @GetMapping("/{id}")
    public CustomerProfile getCustomer(@PathVariable Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerRepo.deleteById(id);
        return "Customer deleted.";
    }

    @GetMapping("/location/{location}")
    public List<CustomerProfile> getByLocation(@PathVariable String location) {
        return customerRepo.findByLocation(location);
    }

    @GetMapping("/search")
    public List<CustomerProfile> searchByName(@RequestParam String name) {
        return customerRepo.findByFullNameContaining(name);
    }

    @GetMapping
    public Page<CustomerProfile> getPaginatedCustomers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "fullName") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return customerRepo.findAll(pageable);
    }

    @GetMapping("/domain")
    public List<CustomerProfile> getByEmailDomain(@RequestParam String domain) {
        return customerRepo.findByEmailDomain(domain);
    }
}