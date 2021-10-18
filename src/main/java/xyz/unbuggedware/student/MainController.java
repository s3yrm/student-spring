package xyz.unbuggedware.student;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/student")
public class MainController {
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewStudent (@RequestParam String name, @RequestParam String email) {
		Student std = new Student();
		std.setName(name);
		std.setEmail(email);
		studentRepository.save(std);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody Optional<Student> getStudent(@PathVariable(value = "id") Integer stdId) {
		return studentRepository.findById(stdId);
	}
}
