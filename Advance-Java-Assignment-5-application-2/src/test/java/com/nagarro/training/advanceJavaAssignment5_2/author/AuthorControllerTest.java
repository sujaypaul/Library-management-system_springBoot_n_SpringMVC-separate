package com.nagarro.training.advanceJavaAssignment5_2.author;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;




class AuthorControllerTest {
	


    private AuthorRepository authorRepository = Mockito.mock(AuthorRepository.class);
    
    


    private AuthorController authorController;

    @Test
    void getAllAuthors_shouldReturnAuthorList() throws Exception {
    	
    	Iterable<Author> mockAuthors = Arrays.asList(
                new Author("Mark Twain"),
                new Author("Vaibhav")
                
        );
    	
        Mockito.when(authorRepository.findAll()).thenReturn(mockAuthors);
    	
    	AuthorController authorController = new AuthorController(authorRepository);



        // Act and Assert
        List<Author> authorList = authorController.getAllAuthors();
        
        Assertions.assertEquals("Mark Twain", authorList.get(0).getName());
        Assertions.assertEquals("Vaibhav", authorList.get(1).getName());

                
    }
}
