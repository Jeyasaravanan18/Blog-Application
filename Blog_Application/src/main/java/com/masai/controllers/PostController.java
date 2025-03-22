package com.masai.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.masai.exceptions.FileTypeNotValidException;
import com.masai.exceptions.ResourceNotFoundException;
import com.masai.modelRequestDto.PostRequestDto;
import com.masai.modelResponseDto.PostResponseDto;
import com.masai.payloads.ApiResponse;
import com.masai.payloads.AppConstants;
import com.masai.payloads.PageResponse;
import com.masai.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/blog/post")
@Tag(name = "Post Controller", description = "Handles blog posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private ObjectMapper objectMapper;

    @Operation(summary = "Create a new post")
    @PostMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<PostResponseDto> createPostHandler(
            @RequestParam String postRequestDto,
            @PathVariable("userId") Integer userId,
            @PathVariable("categoryId") Integer categoryId,
            @RequestParam MultipartFile image)
            throws ResourceNotFoundException, IOException, FileTypeNotValidException {
        
        PostRequestDto post = objectMapper.readValue(postRequestDto, PostRequestDto.class);
        PostResponseDto createPost = postService.createPost(post, userId, categoryId, image);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a post content")
    @PutMapping("/{postId}")
    public ResponseEntity<PostResponseDto> updatePostContentHandler(
            @Valid @RequestBody PostRequestDto postRequestDto,
            @PathVariable("postId") Integer postId) throws ResourceNotFoundException {
        
        PostResponseDto updatePost = postService.updatePostContent(postRequestDto, postId);
        return new ResponseEntity<>(updatePost, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete a post")
    @DeleteMapping("/{postId}")
    public ResponseEntity<ApiResponse> deletePostHandler(@PathVariable("postId") Integer postId) {
        ApiResponse deletePost = postService.deletePost(postId);
        return new ResponseEntity<>(deletePost, HttpStatus.OK);
    }

    @Operation(summary = "Get post by ID")
    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto> getPostsByIdHandler(@PathVariable("postId") Integer postId)
            throws ResourceNotFoundException {
        PostResponseDto postsById = postService.getPostsById(postId);
        return new ResponseEntity<>(postsById, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Get all posts")
    @GetMapping("/")
    public ResponseEntity<List<PostResponseDto>> getAllPostsHandler() {
        List<PostResponseDto> allPosts = postService.getAllPosts();
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @Operation(summary = "Get paginated posts")
    @GetMapping("/allposts")
    public ResponseEntity<PageResponse> getAllPostsByPageHandler(
            @RequestParam(defaultValue = AppConstants.PAGENUMBER) Integer pageNumber,
            @RequestParam(defaultValue = AppConstants.PAGESIZE) Integer pageSize) {
        
        PageResponse allPosts = postService.getAllPostsPagination(pageNumber, pageSize);
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @Operation(summary = "Get sorted paginated posts")
    @GetMapping("/allposts/sort")
    public ResponseEntity<PageResponse> getAllPostsByPageSortByHandler(
            @RequestParam(defaultValue = AppConstants.PAGENUMBER) Integer pageNumber,
            @RequestParam(defaultValue = AppConstants.PAGESIZE) Integer pageSize,
            @RequestParam(defaultValue = AppConstants.SORTBY) String sortBy,
            @RequestParam(defaultValue = AppConstants.SORTDIRECTION) String sortDirection) {
        
        PageResponse allPosts = postService.getAllPostsByPageSortBy(pageNumber, pageSize, sortBy, sortDirection);
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }
}
