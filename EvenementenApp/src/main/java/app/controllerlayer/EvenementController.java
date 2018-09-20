package app.controllerlayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.models.EvenementModel;
import app.servicelayer.IEvenementService;

@RestController
public class EvenementController {
	
	@Autowired
	private IEvenementService iEvenementService;

	@GetMapping("/api/evenement/{id}")
	public Optional<EvenementModel> findById(@PathVariable Long id) {
		return this.iEvenementService.findById(id);
	}

	@PostMapping("/api/evenement")
	public EvenementModel create(@RequestBody EvenementModel evenement) {
		return this.iEvenementService.create(evenement);
	}

	@PutMapping("/api/evenement/{id}")
	public boolean update(@PathVariable Long id, @RequestBody EvenementModel evenement) {
		this.iEvenementService.update(evenement);
		return true;
	}

	@DeleteMapping("/api/evenement/{id}")
	public boolean delete(@PathVariable Long id) {
		Optional<EvenementModel> optional = this.iEvenementService.findById(id);
		if (optional.isPresent()) {
			this.iEvenementService.delete(optional.get());

			return true;
		}

		return false;
	}

}


