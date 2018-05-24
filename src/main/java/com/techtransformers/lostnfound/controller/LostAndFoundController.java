package com.techtransformers.lostnfound.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techtransformers.lostnfound.constants.LostAndFoundConstants;
import com.techtransformers.lostnfound.entity.LostAndFoundEntity;
import com.techtransformers.lostnfound.exceptions.LostAndFoundItemException;
import com.techtransformers.lostnfound.model.LostAndFound;
import com.techtransformers.lostnfound.processor.LostAndFoundProcessor;
import com.techtransformers.lostnfound.response.LostAndFoundItemResponse;
import com.techtransformers.lostnfound.service.LostAndFoundService;

@RestController
public class LostAndFoundController {

	@Autowired
	private LostAndFoundService lostAndFoundService;
	
	@CrossOrigin(origins = {"http://192.168.0.116:8080","*"},
            maxAge = 4800, allowCredentials = "false") 
	@RequestMapping(value = "/report/lostandfound", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<LostAndFoundItemResponse> insertLostAndFoundItem(@RequestBody LostAndFound lostAndFoundItem)
			throws LostAndFoundItemException {

		LostAndFoundItemResponse lostAndFoundItemResponse = new LostAndFoundItemResponse();

		if (!StringUtils.isBlank(lostAndFoundItem.getData().getEmail())) {
			LostAndFoundEntity lostAndFoundItemEntity = LostAndFoundProcessor.convertLostItemBeanToEntity(lostAndFoundItem);
			Integer lostAndFoundItemId = lostAndFoundService.insertLostAndFoundItem(lostAndFoundItemEntity);

			if (null != lostAndFoundItemId) {
				lostAndFoundItemResponse.setCode(HttpStatus.OK.value());
				lostAndFoundItemResponse.setMessage(LostAndFoundConstants.REGISTERED_SUCCESS);
			} else {
				throw new LostAndFoundItemException(LostAndFoundConstants.TRY_AGAIN);
			}

		} else {
			throw new LostAndFoundItemException(LostAndFoundConstants.TRY_AGAIN);
		}
		return new ResponseEntity<LostAndFoundItemResponse>(lostAndFoundItemResponse, HttpStatus.OK);
	}

	@ExceptionHandler(LostAndFoundItemException.class)
	public ResponseEntity<LostAndFoundItemResponse> exceptionHandler(Exception exception) {
		LostAndFoundItemResponse error = new LostAndFoundItemResponse();
		error.setCode(Integer.valueOf(HttpStatus.PRECONDITION_FAILED.value()));
		error.setMessage(exception.getMessage());
		return new ResponseEntity<LostAndFoundItemResponse>(error, HttpStatus.OK);
	}

}
