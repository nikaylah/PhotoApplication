package com.photo.controller;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photo.model.Photo;
import com.photo.repository.PhotoRepository;
import com.photo.service.PhotoService;


@RestController
@RequestMapping("/api")
public class Photocontroller {

	@Autowired
	private PhotoService ps;
	@Autowired
	private PhotoRepository pr;
	
	@GetMapping("/test")
	public String testGet() {
		return "Hello World";
	}
	@GetMapping("/getAllPhotos")
	public List<Photo>getAllPhotos() {
		List<Photo> allPhotos = pr.findAll();
		return allPhotos;
	}
	
	@PostMapping("/addPhoto")
	public ResponseEntity<Photo> savePhoto(@RequestBody Photo photo) {
		Photo addphoto = ps.addPhoto(photo);
		return new ResponseEntity<Photo>(addphoto,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/getPhoto/{id}")
	public ResponseEntity<?> deletePhoto(@PathVariable int id) {
		pr.deleteById(id);
		return  new ResponseEntity<Integer>(id,HttpStatus.OK);
	}
	
	
	
}
