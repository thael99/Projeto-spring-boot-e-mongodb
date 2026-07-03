package com.ttech.workshopmongo.resources;

import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttech.workshopmongo.domain.Post;
import com.ttech.workshopmongo.resources.util.URL;
import com.ttech.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	
	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity <Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping(value = "/titlesearch")
	public ResponseEntity <List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text){
		text = URL.decodePAram(text);
		List <Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	
}
